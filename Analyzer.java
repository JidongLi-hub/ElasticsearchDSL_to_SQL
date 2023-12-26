import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.io.StringReader;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
// pair之内用@@分割   pair之间用##分割  列表元素之间用||分割  命令结点后用填充/在头部共占占6个字符

public class Analyzer  {    //转换器对象
    private static class Transfer extends DSLtoSQLBaseListener {
        StringBuilder SELECT = new StringBuilder();     //SQL子句
        StringBuilder FROM = new StringBuilder();
        StringBuilder WHERE = new StringBuilder();
        StringBuilder GROUP_BY = new StringBuilder();
        StringBuilder HAVING = new StringBuilder();
        StringBuilder ORDER_BY = new StringBuilder();
        StringBuilder CREATETABLE = new StringBuilder();
        StringBuilder ALTER = new StringBuilder();
        StringBuilder INSERT = new StringBuilder();
        StringBuilder UPDATE = new StringBuilder();
        StringBuilder DELETE = new StringBuilder();
        final StringBuilder EMPTY = new StringBuilder();
        String method;      //请求方式
        String arg = "";    //请求命令参数
        ParseTreeProperty<StringBuilder> values = new ParseTreeProperty<>();    //存放各个结点处理结果的哈希表结构及对应存入获取函数
        void setValue(ParseTree node, StringBuilder value){values.put(node, value);}
        StringBuilder getValue(ParseTree node){return values.get(node);}

        /*退出Header结点，确定请求方式和动作*/
        public void exitHeader(DSLtoSQLParser.HeaderContext ctx){
            method = ctx.METHOD().getText();
            switch(method){     //通过请求方式确定要执行的动作：建表，修改表，插入和删除数据，查询
                case "PUT":     //PUT用于创建索引和修改索引
                    if(arg.equals("_mapping"))
                        ALTER.append(getValue(ctx.getChild(1)));
                    else if(arg.equals(""))
                        CREATETABLE.append(getValue(ctx.getChild(1)));
                    break;
                case "POST":    //POST用于增加、删除和修改文档数据
                    FROM.append(getValue(ctx.getChild(1)));
                    break;
                case "GET":     //GET用于查询文档数据
                    SELECT.append("*");
                    FROM.append(getValue(ctx.getChild(1)));     //获取索引名
            }
        }

        //Address结点确定索引名称和请求参数
        public void exitAddress(DSLtoSQLParser.AddressContext ctx){
            StringBuilder index = new StringBuilder(ctx.NAME(0).getText());
            if(!ctx.ARG().isEmpty()) arg = ctx.ARG(0).getText();
            setValue(ctx, index);
        }

        //Mappings结点确定要创建表的数据项类型
        public void exitMappings(DSLtoSQLParser.MappingsContext ctx){
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            String MTYPE;
            for (String son:sons)
            {
                MTYPE = son.substring(0,6); //根据前六个字符判断是否含有字段属性内容
                if(MTYPE.equals("PROP//"))
                {
                    if(arg.equals("")) {
                        CREATETABLE.append("\n(");
                        CREATETABLE.append(son.substring(6));
                        CREATETABLE.append(")");
                    }
                    else if(arg.equals("_mapping")){
                        ALTER.append("\n").append(son.substring(6));
                    }
                }
            }
        }

        /*本结点确定建表的数据项的类型，并将其对应到SQL支持的类型*/
        public void exitProperties(DSLtoSQLParser.PropertiesContext ctx){
            final String MTYPE = "PROP//";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            StringBuilder properties = new StringBuilder();
            String [] pair;
            for(String son:sons)
            {
                pair = son.split("@@"); //将各个字段做分割单独处理
                if(arg.equals("_mapping"))
                    properties.append("ADD ").append(pair[0]);
                else
                    properties.append(pair[0]);
                switch(pair[1])     //将字段类型对应到SQL类型
                {
                    case "boolean":
                        properties.append(" BOOLEAN");break;
                    case "date":
                        properties.append(" DATE");break;
                    case "text":
                        properties.append(" VALCHAR(255)");break;
                    case "integer":
                        properties.append(" INT");break;
                    case "float":
                        properties.append(" FLOAT");
                }
                if(arg.equals("")) properties.append(",");
                properties.append("\n");
            }
            if(arg.equals(""))
                properties.delete(properties.length()-2,properties.length());
            else
                properties.delete(properties.length()-1,properties.length());
            properties.insert(0,MTYPE); //加入首部标识
            setValue(ctx, properties);  //标注信息
        }

        /*此结点获取字段的类型*/
        public void exitType(DSLtoSQLParser.TypeContext ctx){
            StringBuilder type = new StringBuilder(getValue(ctx.getChild(2)).toString().replace("'",""));
            setValue(ctx, type);
        }
        /*获取字符串的值并加上单引号*/
        public void exitString(DSLtoSQLParser.StringContext ctx){
            StringBuilder S = new StringBuilder();
            S.append("'").append(ctx.STRING().getText()).append("'");
            setValue(ctx, S);
        }
        /*获取数字的值*/
        public void exitNumber(DSLtoSQLParser.NumberContext ctx){
            StringBuilder Num = new StringBuilder();
            Num.append(ctx.NUMBER().getText());
            setValue(ctx, Num);
        }
        /*获取bool类型的值*/
        public void exitAtom(DSLtoSQLParser.AtomContext ctx){
            StringBuilder atom = new StringBuilder();
            switch (ctx.getText()){
                case "true": atom.append(true);break;
                case "false": atom.append(false);break;
                case "null": atom.append("null");break;
            }
            setValue(ctx, atom);
        }

        /*此结点获取一个对象的值并标注在自身上*/
        public void exitObjectValue(DSLtoSQLParser.ObjectValueContext ctx){
            setValue(ctx, getValue(ctx.getChild(0)));
        }
        /*获取列表元素的值并标注在自身上*/
        public void exitArrayValue(DSLtoSQLParser.ArrayValueContext ctx){
            setValue(ctx, getValue(ctx.getChild(0)));
        }
        /*普通键值对，将键和值以@@连接，并标注*/
        public void exitNormalPair(DSLtoSQLParser.NormalPairContext ctx){
            StringBuilder pair = new StringBuilder();
            pair.append(String.format("%s@@%s",ctx.getChild(0).getText().replace("\"",""),getValue(ctx.getChild(2)).toString().replace("\"","")));
            setValue(ctx, pair);
        }

        /*一个对象中包含多个键值对，此结点将所有键值对用##连接，然后标注*/
        public void exitAnObject(DSLtoSQLParser.AnObjectContext ctx){
            StringBuilder objects = new StringBuilder();
            int i;
            for(i=1;i<ctx.getChildCount()-2;i=i+2)
            {
                objects.append(String.format("%s##",getValue(ctx.getChild(i))));
            }
            objects.append(getValue(ctx.getChild(i)));
            setValue(ctx, objects);
        }
        /*空对象不做处理*/
        public void exitEmptyObject(DSLtoSQLParser.EmptyObjectContext ctx) {
            setValue(ctx, EMPTY);
        }

        /*此结点包含多个列表项，将各个列表项用||连接，然后标注*/
        public void exitAnArray(DSLtoSQLParser.AnArrayContext ctx) {
            StringBuilder array = new StringBuilder();
            int i;
            for(i=1;i<ctx.getChildCount()-2;i=i+2)
            {
                array.append(String.format("%s||",getValue(ctx.getChild(i)).toString().replace("\"", "")));
            }
            array.append(getValue(ctx.getChild(i)).toString().replace("\"", ""));
            setValue(ctx, array);
        }

        /*空列表不做处理*/
        public void exitEmptyArray(DSLtoSQLParser.EmptyArrayContext ctx) {
            setValue(ctx, EMPTY);
        }

        /*matchall查询*/
        public void exitMatchAll(DSLtoSQLParser.MatchAllContext ctx){
            final String QTYPE = "MATCHA";  //加入头部类型标识
            setValue(ctx, new StringBuilder(QTYPE));
        }

        /*term查询*/
        public void exitTerm(DSLtoSQLParser.TermContext ctx) {
            final String QTYPE = "TERM//";  //加入头部类型标识
            StringBuilder term = new StringBuilder();
            //将其中的键值对翻译为为A=B
            term.append(getValue(ctx.getChild(2)).toString().replace("@@","="));
            term.insert(0,QTYPE);
            setValue(ctx, term);
        }

        public void exitTerms(DSLtoSQLParser.TermsContext ctx) {
            final String QTYPE = "TERMS/";
            String[] pair = getValue(ctx.getChild(2)).toString().split("@@");
            pair[1] = pair[1].replace("||", ",");
            StringBuilder terms = new StringBuilder(pair[1]);//将其中的列表翻译为 col IN (v1,v2,,,)
            terms.insert(0, " IN (");
            terms.insert(0, pair[0]);
            terms.append(")");
            terms.insert(0, QTYPE);
            setValue(ctx, terms);
        }

        /*range范围查询*/
        public void exitRange(DSLtoSQLParser.RangeContext ctx){
            final String QTYPE = "RANGE/";
            String [] pair = getValue(ctx.getChild(2)).toString().split("@@");
            StringBuilder range = new StringBuilder();
            if (pair[1].contains("<=")&&pair[1].contains(">="))     //同时含有>=,<=翻译为BETWEEN a AND b
            {
                String [] comps = pair[1].split("##");
                range.append(pair[0]).append(" BETWEEN ");
                if(comps[0].contains(">=")) {
                    range.append(comps[0].replace(">=",""));
                    range.append(" AND ");
                    range.append(comps[1].replace("<=",""));
                }
                else {
                    range.append(comps[1].replace(">=",""));
                    range.append(" AND ");
                    range.append(comps[0].replace("<=",""));
                }
            }
            else if(pair[1].contains("##"))     //普通的比较表达式之间翻译为 用AND相连
            {
                String [] comps = pair[1].split("##");
                range.append(pair[0]).append(comps[0]).append(" AND ").append(pair[0]).append(comps[1]);
            }
            else {
                range.append(pair[0]).append(pair[1]);
            }
            range.insert(0, QTYPE);
            setValue(ctx, range);
        }

        public void exitLt(DSLtoSQLParser.LtContext ctx){//翻译lt为<
            StringBuilder lt = new StringBuilder("<");
            lt.append(getValue(ctx.getChild(2)));
            setValue(ctx, lt);
        }
        public void exitLte(DSLtoSQLParser.LteContext ctx){//翻译lte为<=
            StringBuilder lte = new StringBuilder("<=");
            lte.append(getValue(ctx.getChild(2)));
            setValue(ctx, lte);
        }
        public void exitGt(DSLtoSQLParser.GtContext ctx){//翻译gt为>
            StringBuilder gt = new StringBuilder(">");
            gt.append(getValue(ctx.getChild(2)));
            setValue(ctx, gt);
        }
        public void exitGte(DSLtoSQLParser.GteContext ctx){//翻译gte为>=
            StringBuilder gte = new StringBuilder(">=");
            gte.append(getValue(ctx.getChild(2)));
            setValue(ctx, gte);
        }

        /*match查询，将要查询的字段做分词，再查询分词后的结果*/
        public void exitMatch(DSLtoSQLParser.MatchContext ctx)  {
            final String QTYPE = "MATCH/";  //查询类型头部标识
            String match_name = getValue(ctx.getChild(2)).toString().split("@@")[0];
            String [] sons = getValue(ctx.getChild(2)).substring(match_name.length()+2).split("##");
            String [] fields;
            StringBuilder match = new StringBuilder();
            for(String son:sons)
            {
                fields = son.split("@@");
                switch(fields[0]){
                    case "query":
                        //先做分词，然后拼接
                        ArrayList<String> AnalyzeredQuery= new ArrayList<>();
                        try {
                            AnalyzeredQuery = IKAnalyzer(fields[1]);    //使用IK分词器
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (String Query:AnalyzeredQuery) {    //获得分词的结果，将match查询翻译为 col LIKES '%v1%' OR col LIKES '%v2%'
                            match.append(String.format("%s LIKE '%%%s%%'", match_name, Query));
                            match.append(" OR ");
                        }
                    case "operator":    //如果指定了operater参数，且为and 则将上述翻译结果改为AND相连(默认OR相连)
                        if(fields[1].equals("'and'"))
                            match = new StringBuilder(match.toString().replace("OR", "AND"));
                    default:
                }
            }
            match.delete(match.length()-4,match.length());
            match.insert(0,QTYPE);
            setValue(ctx, match);
        }

        /*filter条件，在翻译时与must做相同处理*/
        public void exitFilter(DSLtoSQLParser.FilterContext ctx){
            final String BTYPE = "FILTER";
            String [] sons = getValue(ctx.getChild(2)).toString().split("\\|\\|");
            int i;
            StringBuilder filter = new StringBuilder();
            for(i=0;i< sons.length-1;i++)
            {
                filter.append(sons[i].substring(6));
                filter.append(" AND ");
            }
            filter.append(sons[i].substring(6));
            filter.insert(0,BTYPE);
            setValue(ctx, filter);
        }
        /*should条件，翻译为各个子条件之间用OR相连*/
        public void exitShould(DSLtoSQLParser.ShouldContext ctx){
            final String BTYPE = "SHOULD";
            String s = getValue(ctx.getChild(2)).toString();
            String [] sons = s.split("\\|\\|");
            int i;
            StringBuilder should = new StringBuilder();
            for(i=0;i< sons.length-1;i++)
            {
                should.append(sons[i].substring(6));
                should.append(" OR ");
            }
            should.append(sons[i].substring(6));
            should.insert(0, BTYPE);
            setValue(ctx, should);
        }
        /*must_not条件，翻译为各个子条件之间用AND相连*/
        public void exitMustNot(DSLtoSQLParser.MustNotContext ctx){
            final String BTYPE = "MUSTN/";
            String [] sons = getValue(ctx.getChild(2)).toString().split("\\|\\|");
            int i;
            StringBuilder mustnot = new StringBuilder();
            for(i=0;i< sons.length-1;i++)
            {
                mustnot.append(sons[i].substring(6));
                mustnot.append(" AND ");
            }
            mustnot.append(sons[i].substring(6));
            mustnot.insert(0,BTYPE);
            setValue(ctx, mustnot);
        }
        /*must条件，翻译为各个子条件之间用AND相连*/
        public void exitMust(DSLtoSQLParser.MustContext ctx){
            final String BTYPE = "MUST//";
            String[] sons = getValue(ctx.getChild(2)).toString().split("\\|\\|");
            int i;
            StringBuilder must = new StringBuilder();
            for(i=0;i< sons.length-1;i++)
            {
                must.append(sons[i].substring(6));
                must.append(" AND ");
            }
            must.append(sons[i].substring(6));
            must.insert(0,BTYPE);
            setValue(ctx, must);
        }
        /*bool查询*/
        public void exitBool(DSLtoSQLParser.BoolContext ctx){
            final String QTYPE = "BOOL//";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            StringBuilder bool = new StringBuilder();
            int i;
            String BTYPE;
            for(i=0;i< sons.length-1;i++)
            {
                BTYPE = sons[i].substring(0,6);
                if(BTYPE.equals("MUSTN/"))  //处理must_not条件，翻译为NOT (con1 AND con2,,,)
                {
                    bool.append("NOT (").append(sons[i].substring(6)).append(") \n      AND ");
                }
                else    //处理must，should，filter条件
                {
                    if(sons[i].contains("AND") || sons[i].contains("OR"))
                        bool.append("(").append(sons[i].substring(6)).append(") \n      AND ");
                    else
                        bool.append(sons[i].substring(6)).append("\n      AND ");
                }
            }
            if(sons[i].contains("AND") || sons[i].contains("OR"))
                bool.append("(").append(sons[i].substring(6)).append(")");
            else
                bool.append(sons[i].substring(6));
            bool.insert(0, QTYPE);
            setValue(ctx, bool);
        }

        /*Query结点有两种含义，可能是query查询，也可能是query参数用于传参给更高级命令*/
        public void exitQuery(DSLtoSQLParser.QueryContext ctx) {
            StringBuilder query = getValue(ctx.getChild(2));
            if (query.length() <= 6)  //query用于传参而非查询
            {
                StringBuilder pair = new StringBuilder();
                pair.append(String.format("%s@@%s",ctx.getChild(0).getText().replace("\"",""),getValue(ctx.getChild(2)).toString().replace("\"","")));
                setValue(ctx, pair);
                return;
            }
            final String QUERY = "QUERY/";  //query用于查询语句
           String type = query.substring(0,6);
           switch(type){    //处理六类query查询
               case "TERM//":
               case "TERMS/":
               case "RANGE/":
               case "MATCHA":
               case "BOOL//":
               case "MATCH/":
                   query.delete(0,6);
                   query.insert(0, QUERY);
                   setValue(ctx, query);
                   break;
               default:
                   StringBuilder pair = new StringBuilder();
                   pair.append(String.format("%s@@%s",ctx.getChild(0).getText().replace("\"",""),getValue(ctx.getChild(2)).toString().replace("\"","")));
                   setValue(ctx, pair);
           }
        }
        /*处理includes参数*/
        public void exitIncludes(DSLtoSQLParser.IncludesContext ctx){
            final String STYPE = "INCL//";
            StringBuilder includes = getValue(ctx.getChild(2));//收集数据项名称
            includes.insert(0,STYPE);
            setValue(ctx, includes);
        }
        /*处理exclude参数*/
        public void exitExcludes(DSLtoSQLParser.ExcludesContext ctx){
            final String STYPE = "EXCL//";
            StringBuilder excludes = getValue(ctx.getChild(2));//收集数据项名称
            excludes.insert(0,STYPE);
            setValue(ctx, excludes);
        }

        /*_source参数指定查询结果中显示哪些数据项*/
        public void exitSource(DSLtoSQLParser.SourceContext ctx){
            final String TYPE = "SOURCE";
            StringBuilder source = new StringBuilder();
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            if(sons.length==2)
                sons[0] = sons[0].contains("INCL//")?sons[0]:sons[1];
            if(sons[0].contains("INCL//"))//有includes，则select子句中查询includes包含的项
            {
                source.append(sons[0].substring(6).replace("||",",").replace("'","").replace("\"",""));
            }
            else if(sons[0].contains("EXCL//"))//只有excludes，则select子句中翻译为 SELECT * EXCEPT(col1,col2,,,)
            {
                source.append("*\nEXCEPT ").append(sons[0].substring(6).replace("||",",").replace("'","").replace("\"",""));
            }
            source.insert(0,TYPE);
            setValue(ctx,source);
        }

        /*数据聚合*/
        public void exitAggs(DSLtoSQLParser.AggsContext ctx)
        {
            final String TYPE = "AGGS//";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            String [] fields;
            StringBuilder aggs = new StringBuilder();
            String ATYPE;
            for(String son:sons){
                fields = son.split("@@");
                ATYPE = fields[1].substring(0,6);
                switch(ATYPE){  //处理五类聚合，翻译为agg AS NewName
                    case "AVG///":
                    case"SUM///":
                    case"MAX///":
                    case"MIN///":
                    case"VALUEC":
                        aggs.append(String.format("%s AS %s",fields[1].substring(6),fields[0]));
                        aggs.append(", ");
                        break;
                    default:
                }
            }
            aggs.delete(aggs.length()-2,aggs.length());
            aggs.insert(0, TYPE);
            setValue(ctx, aggs);
        }
        /*平均值聚合函数*/
        public void exitAvg(DSLtoSQLParser.AvgContext ctx)
        {
            final String ATYPE = "AVG///";
            StringBuilder son = getValue(ctx.getChild(2));
            String [] fields = son.toString().split("@@"); //翻译为AVG(col)
            StringBuilder avg = new StringBuilder(String.format("AVG(%s)",fields[1].replace("'","")));
            avg.insert(0, ATYPE);
            setValue(ctx, avg);
        }
        /*求和聚合函数*/
        public void exitSum(DSLtoSQLParser.SumContext ctx)
        {
            final String ATYPE = "SUM///";
            StringBuilder son = getValue(ctx.getChild(2));
            String [] fields = son.toString().split("@@");//翻译为SUM(col)
            StringBuilder sum = new StringBuilder(String.format("SUM(%s)",fields[1].replace("'","")));
            sum.insert(0, ATYPE);
            setValue(ctx, sum);
        }
        /*最大值聚合函数*/
        public void exitMax(DSLtoSQLParser.MaxContext ctx)
        {
            final String ATYPE = "MAX///";
            StringBuilder son = getValue(ctx.getChild(2));
            String [] fields = son.toString().split("@@");//翻译为MAX(col)
            StringBuilder max = new StringBuilder(String.format("MAX(%s)",fields[1].replace("'","")));
            max.insert(0, ATYPE);
            setValue(ctx, max);
        }
        /*最小值聚合函数*/
        public void exitMin(DSLtoSQLParser.MinContext ctx)
        {
            final String ATYPE = "MIN///";
            StringBuilder son = getValue(ctx.getChild(2));
            String [] fields = son.toString().split("@@");//翻译为MIN(col)
            StringBuilder min = new StringBuilder(String.format("MIN(%s)",fields[1].replace("'","")));
            min.insert(0, ATYPE);
            setValue(ctx, min);
        }
        /*计数聚合函数*/
        public void exitValueCount(DSLtoSQLParser.ValueCountContext ctx)
        {
            final String ATYPE = "VALUEC";
            StringBuilder son = getValue(ctx.getChild(2));
            String [] fields = son.toString().split("@@");//翻译为COUNT(DISTINCT col)
            StringBuilder value_count = new StringBuilder(String.format("COUNT(DISTINCT %s)",fields[1].replace("'","")));
            value_count.insert(0, ATYPE);
            setValue(ctx, value_count);
        }
        /*sort参数用于结果排序*/
        public void exitSort(DSLtoSQLParser.SortContext ctx)
        {
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            StringBuilder ASC = new StringBuilder(" ");
            StringBuilder DESC = new StringBuilder(" ");
            String [] temp;
            for(String volumn:sons)
            {
                temp = volumn.split("@@");
                if(temp[1].equals("'asc'"))
                    ASC.append(temp[0]).append(",");
                else if(temp[1].equals("'desc'"))
                    DESC.append(temp[0]).append(",");
            }
            if(ASC.length()>1) {
                ASC.deleteCharAt(ASC.length() - 1);
                ASC.append(" ASC");
            }
            if(DESC.length()>1){
                DESC.deleteCharAt(DESC.length()-1);
                DESC.append(" DESC");
            }
            ASC.append(DESC).insert(0,"SORT//");
            setValue(ctx, ASC);
        }

        /*获取排序方式asc或desc*/
        public void exitOrder(DSLtoSQLParser.OrderContext ctx)
        {
            StringBuilder order = getValue(ctx.getChild(2));
            setValue(ctx, order);
        }

        /*建表CREATE语句*/
        public void exitCreate(DSLtoSQLParser.CreateContext ctx){
            final String BTYPE = "create";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            String [] temppair;
            StringBuilder create = new StringBuilder();
            for(String son:sons)
            {
                temppair = son.split("@@");
                if(temppair[0].equals("_id"))
                    create.append("id").append("@@").append(temppair[1].replace("'",""));
            }
            create.insert(0, BTYPE);
            setValue(ctx, create);
        }
        //更新文档update
        public void exitUpdate(DSLtoSQLParser.UpdateContext ctx){
            final String BTYPE = "update";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            String [] temppair;
            StringBuilder update = new StringBuilder();
            for(String son:sons)
            {
                temppair = son.split("@@");
                if(temppair[0].equals("_id"))
                    update.append("id").append("@@").append(temppair[1].replace("'",""));
            }
            update.insert(0, BTYPE);
            setValue(ctx, update);
        }
        //删除文档delete
        public void exitDelete(DSLtoSQLParser.DeleteContext ctx){
            final String BTYPE = "delete";
            String [] sons = getValue(ctx.getChild(2)).toString().split("##");
            String [] temppair;
            StringBuilder delete = new StringBuilder();
            for(String son:sons)
            {
                temppair = son.split("@@");
                if(temppair[0].equals("_id"))
                    delete.append("id").append("@@").append(temppair[1].replace("'",""));
            }
            delete.insert(0, BTYPE);
            setValue(ctx, delete);
        }

        public void exitDoc(DSLtoSQLParser.DocContext ctx){
            setValue(ctx, getValue(ctx.getChild(2)));
        }

        //查询体结点，含有查询的所有信息
        public void exitBody(DSLtoSQLParser.BodyContext ctx) {
            if(arg.equals("_bulk")) //处理_bulk命令
            {
                StringBuilder bulk;
                String BTYPE;
                StringBuilder columes = new StringBuilder();
                StringBuilder values = new StringBuilder();
                StringBuilder sets = new StringBuilder();
                StringBuilder where = new StringBuilder();
                boolean tagc=false;
                for(int i=0;i<ctx.getChildCount();i++)
                {
                    bulk = getValue(ctx.getChild(i));
                    BTYPE = bulk.substring(0,6);
                    String [] pairs;
                    String [] pair;
                    pair = bulk.substring(6).split("@@");
                    switch(BTYPE){
                        case "create"://翻译建表语句
                            if(tagc)
                                values.append("\n(");
                            else {
                                columes.append("(");
                                values.append("(");
                            }
                            if(pair.length>1)
                            {
                                if(!tagc)
                                    columes.append(pair[0]).append(",");
                                values.append(pair[1]).append(",");
                            }
                            pairs = getValue(ctx.getChild(++i)).toString().split("##");
                            for(String p:pairs)
                            {
                                pair = p.split("@@");
                                if(!tagc)
                                    columes.append(pair[0]).append(",");
                                values.append(pair[1]).append(",");
                            }
                            if(!tagc) {
                                columes.delete(columes.length() - 1, columes.length());
                                columes.append(")");
                            }
                            values.delete(values.length() - 1, values.length());
                            values.append(")");
                            tagc = true;
                            break;
                        case "update"://翻译更新文档语句
                            pairs = getValue(ctx.getChild(++i)).toString().split("##");
                            for(String p:pairs)
                                sets.append(p.replace("@@","=")).append(",");
                            sets.delete(sets.length()-1,sets.length());
                            sets.append("\nWHERE ").append(pair[0]).append("=").append(pair[1]);
                            break;
                        case "delete"://翻译删除文档语句
                            if(pair.length>1)
                                where.append(pair[0]).append("=").append(pair[1]).append(" OR ");
                    }
                }
                if(columes.length()>0)//将翻译结果写入最终的SQL子句中保存
                    INSERT.append(columes).append("\nVALUES ").append(values);
                if(where.length()>0)
                {
                    where.delete(where.length()-4,where.length());
                    DELETE.append("\n").append("WHERE ").append(where);
                }
                if(sets.length()>0){
                    UPDATE.append(sets);
                }

            }
            else {//处理处理建表，增，删，改之外的查询语句
                String[] sons = getValue(ctx.getChild(0)).toString().split("##");
                if (sons[0].equals("") || sons[0].equals("null")) return;
                for (String son : sons) {
                    String action = son.substring(0, 6);
                    switch (action) {
                        case "QUERY/":  //将query参数的翻译结果存入WHERE子句
                            WHERE.append(son.substring(6));
                            break;
                        case "SOURCE":  //将_source参数的翻译结果存入SELECT子句
                            SELECT = new StringBuilder(son.substring(6));
                            break;
                        case "SORT//":  //将sort参数的翻译结果存入ORDER_BY子句
                            ORDER_BY.append(son.substring(6));
                            break;
                        case "AGGS//":  //将aggs参数的翻译结果存入SELECT子句
                            if (SELECT.length() > 0)
                                SELECT.append(',').append(son.substring(6));
                            else
                                SELECT.append(son.substring(6));
                            break;
                        default:
                    }
                }
            }
        }
    }

    private static ArrayList<String> IKAnalyzer(String text) throws IOException{  //使用IK分词器进行分词
        //创建分词对象
        org.apache.lucene.analysis.Analyzer anal=new IKAnalyzer(true);
        StringReader reader=new StringReader(text);
        //分词
        TokenStream ts=anal.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        ArrayList<String> result = new ArrayList<>();
        while(ts.incrementToken()){
            result.add(term.toString());
        }
        reader.close();
        return result;
    }

    private static String ProduceSQL(Transfer converter)
    {
        /**根据解析结果组装SQL语句**/
        StringBuilder SQL = new StringBuilder();
        switch(converter.method){
            case "GET": //GET用于查询文档数据
                SQL.append("SELECT ").append(converter.SELECT);
                SQL.append("\nFROM ").append(converter.FROM);
                if(converter.WHERE.length()>0){
                    SQL.append("\nWHERE ").append(converter.WHERE);
                }
                if(converter.GROUP_BY.length()>0) {
                    SQL.append("\nGROUP BY ").append(converter.GROUP_BY);
                    SQL.append("\nHAVING ").append(converter.HAVING);
                }
                if(converter.ORDER_BY.length()>0){
                    SQL.append("\nORDER BY").append(converter.ORDER_BY);
                }
                break;
            case "PUT": //PUT用于创建索引和修改索引
                if(converter.CREATETABLE.length()>0||converter.arg.equals(""))
                    SQL.append("CREATE TABLE ").append(converter.CREATETABLE);
                else if(converter.ALTER.length()>0)
                    SQL.append("ALTER TABLE ").append(converter.ALTER);
                break;
            case "POST":  //POST用于增加、删除和修改文档数据
                if(converter.arg.equals("_bulk"))
                {
                    if(converter.INSERT.length()>0)
                    {
                        SQL.append("INSERT\nINTO ").append(converter.FROM);
                        SQL.append(converter.INSERT);
                    }
                    else if(converter.UPDATE.length()>0)
                    {
                        SQL.append("UPDATE ").append(converter.FROM).append("\nSET ");
                        SQL.append(converter.UPDATE);
                    }
                    else if(converter.DELETE.length()>0)
                    {
                        SQL.append("DELETE\nFROM ").append(converter.FROM);
                        SQL.append(converter.DELETE);
                    }
                }
        }
        SQL.append(";");
        return SQL.toString();
    }

    public String DSLtoSQL (InputStream dsl) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(dsl);
        DSLtoSQLLexer lexer = new DSLtoSQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DSLtoSQLParser parser = new DSLtoSQLParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.dsl();

        ParseTreeWalker walker = new ParseTreeWalker();
        Transfer converter = new Transfer();
        walker.walk(converter, tree);
        return ProduceSQL(converter);
    }
}
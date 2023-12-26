grammar DSLtoSQL;
import Lexer;

dsl : header body EOF;  //DSL查询程序
header : METHOD address;    //查询头：包含请求方式和地址
//address :  PROTOCOL HOST PORT ('/' NAME)+ ;
address :  ('/')?NAME('/' NAME)* ('/'ARG)*; //请求地址
body : object+      //查询体
     ;
object : '{' pair (',' pair)* '}'   #AnObject//基本对象
       | '{' '}'   #EmptyObject
       ;
pair :  MAPPINGS ':' value  #Mappings
     |  PROPERTIES ':' value #Properties
     |  TYPE ':' value      #Type
     |  CREATE ':' value    #Create
     |  UPDATE ':' value    #Update
     |  DOC ':' value       #Doc
     |  DELETE ':' value    #Delete
     |  QUERY ':' value     #Query      //Query查询
     |  MATCHALL ':' value  #MatchAll
     |  BOOL ':' value      #Bool
     |  MUST ':' value      #Must
     |  MUSTNOT ':' value   #MustNot
     |  SHOULD ':' value    #Should
     |  FILTER ':' value    #Filter
     |  MATCH ':' value     #Match
     |  MULTIMATCH ':' value #MultiMatch
     |  TERM ':' value      #Term
     |  TERMS ':' value     #Terms
     |  RANGE ':' value     #Range
     |  GT ':' value        #Gt
     |  GTE ':' value       #Gte
     |  LT ':' value        #Lt
     |  LTE ':' value       #Lte
     |  SOURCE ':' value    #Source     //指定字段
     |  EXCLUDES ':' value  #Excludes
     |  INCLUDES ':' value  #Includes
     |  AGGS ':' value      #Aggs       //聚合
     |  AVG ':' value       #Avg
     |  SUM ':' value       #Sum
     |  MAX ':' value       #Max
     |  MIN ':' value       #Min
     |  VALUE_COUNT ':' value #ValueCount
     |  SORT ':' value      #Sort       //结果排序
     |  ORDER ':' value     #Order
     |  STRING ':' value    #NormalPair //键值对
     ;
array : '[' value (',' value)* ']'    #AnArray//值列表
      | '[' ']'     #EmptyArray
      ;
value : STRING      #String  //值
      | NUMBER      #Number
      | object      #ObjectValue/* 递归  */
      | array       #ArrayValue/* 递归  */
      | 'true'      #Atom
      | 'false'     #Atom
      | 'null'      #Atom
      ;
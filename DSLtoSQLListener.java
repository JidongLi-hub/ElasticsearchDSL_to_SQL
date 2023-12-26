// Generated from DSLtoSQL.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSLtoSQLParser}.
 */
public interface DSLtoSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSLtoSQLParser#dsl}.
	 * @param ctx the parse tree
	 */
	void enterDsl(DSLtoSQLParser.DslContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLtoSQLParser#dsl}.
	 * @param ctx the parse tree
	 */
	void exitDsl(DSLtoSQLParser.DslContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLtoSQLParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(DSLtoSQLParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLtoSQLParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(DSLtoSQLParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLtoSQLParser#address}.
	 * @param ctx the parse tree
	 */
	void enterAddress(DSLtoSQLParser.AddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLtoSQLParser#address}.
	 * @param ctx the parse tree
	 */
	void exitAddress(DSLtoSQLParser.AddressContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLtoSQLParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(DSLtoSQLParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLtoSQLParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(DSLtoSQLParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnObject}
	 * labeled alternative in {@link DSLtoSQLParser#object}.
	 * @param ctx the parse tree
	 */
	void enterAnObject(DSLtoSQLParser.AnObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnObject}
	 * labeled alternative in {@link DSLtoSQLParser#object}.
	 * @param ctx the parse tree
	 */
	void exitAnObject(DSLtoSQLParser.AnObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link DSLtoSQLParser#object}.
	 * @param ctx the parse tree
	 */
	void enterEmptyObject(DSLtoSQLParser.EmptyObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link DSLtoSQLParser#object}.
	 * @param ctx the parse tree
	 */
	void exitEmptyObject(DSLtoSQLParser.EmptyObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mappings}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMappings(DSLtoSQLParser.MappingsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mappings}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMappings(DSLtoSQLParser.MappingsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Properties}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterProperties(DSLtoSQLParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Properties}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitProperties(DSLtoSQLParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Type}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterType(DSLtoSQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Type}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitType(DSLtoSQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Create}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterCreate(DSLtoSQLParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Create}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitCreate(DSLtoSQLParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Update}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(DSLtoSQLParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Update}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(DSLtoSQLParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Doc}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterDoc(DSLtoSQLParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Doc}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitDoc(DSLtoSQLParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Delete}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterDelete(DSLtoSQLParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Delete}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitDelete(DSLtoSQLParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Query}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterQuery(DSLtoSQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Query}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitQuery(DSLtoSQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatchAll}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMatchAll(DSLtoSQLParser.MatchAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatchAll}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMatchAll(DSLtoSQLParser.MatchAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterBool(DSLtoSQLParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitBool(DSLtoSQLParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Must}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMust(DSLtoSQLParser.MustContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Must}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMust(DSLtoSQLParser.MustContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MustNot}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMustNot(DSLtoSQLParser.MustNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MustNot}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMustNot(DSLtoSQLParser.MustNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Should}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterShould(DSLtoSQLParser.ShouldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Should}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitShould(DSLtoSQLParser.ShouldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterFilter(DSLtoSQLParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitFilter(DSLtoSQLParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Match}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMatch(DSLtoSQLParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMatch(DSLtoSQLParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiMatch}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMultiMatch(DSLtoSQLParser.MultiMatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiMatch}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMultiMatch(DSLtoSQLParser.MultiMatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterTerm(DSLtoSQLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitTerm(DSLtoSQLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Terms}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterTerms(DSLtoSQLParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Terms}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitTerms(DSLtoSQLParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Range}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterRange(DSLtoSQLParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Range}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitRange(DSLtoSQLParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gt}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterGt(DSLtoSQLParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gt}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitGt(DSLtoSQLParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gte}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterGte(DSLtoSQLParser.GteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gte}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitGte(DSLtoSQLParser.GteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterLt(DSLtoSQLParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitLt(DSLtoSQLParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lte}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterLte(DSLtoSQLParser.LteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lte}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitLte(DSLtoSQLParser.LteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Source}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterSource(DSLtoSQLParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Source}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitSource(DSLtoSQLParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Excludes}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterExcludes(DSLtoSQLParser.ExcludesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Excludes}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitExcludes(DSLtoSQLParser.ExcludesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Includes}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(DSLtoSQLParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Includes}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(DSLtoSQLParser.IncludesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Aggs}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterAggs(DSLtoSQLParser.AggsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Aggs}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitAggs(DSLtoSQLParser.AggsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Avg}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterAvg(DSLtoSQLParser.AvgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Avg}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitAvg(DSLtoSQLParser.AvgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterSum(DSLtoSQLParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitSum(DSLtoSQLParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Max}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMax(DSLtoSQLParser.MaxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Max}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMax(DSLtoSQLParser.MaxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Min}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterMin(DSLtoSQLParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitMin(DSLtoSQLParser.MinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueCount}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterValueCount(DSLtoSQLParser.ValueCountContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueCount}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitValueCount(DSLtoSQLParser.ValueCountContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sort}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterSort(DSLtoSQLParser.SortContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sort}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitSort(DSLtoSQLParser.SortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Order}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterOrder(DSLtoSQLParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Order}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitOrder(DSLtoSQLParser.OrderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalPair}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterNormalPair(DSLtoSQLParser.NormalPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalPair}
	 * labeled alternative in {@link DSLtoSQLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitNormalPair(DSLtoSQLParser.NormalPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnArray}
	 * labeled alternative in {@link DSLtoSQLParser#array}.
	 * @param ctx the parse tree
	 */
	void enterAnArray(DSLtoSQLParser.AnArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnArray}
	 * labeled alternative in {@link DSLtoSQLParser#array}.
	 * @param ctx the parse tree
	 */
	void exitAnArray(DSLtoSQLParser.AnArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link DSLtoSQLParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(DSLtoSQLParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link DSLtoSQLParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(DSLtoSQLParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterString(DSLtoSQLParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitString(DSLtoSQLParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DSLtoSQLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DSLtoSQLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterObjectValue(DSLtoSQLParser.ObjectValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectValue}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitObjectValue(DSLtoSQLParser.ObjectValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(DSLtoSQLParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(DSLtoSQLParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterAtom(DSLtoSQLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link DSLtoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitAtom(DSLtoSQLParser.AtomContext ctx);
}
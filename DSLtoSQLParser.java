// Generated from DSLtoSQL.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DSLtoSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, METHOD=11, WHITESPACE=12, ARG=13, NAME=14, MAPPINGS=15, PROPERTIES=16, 
		TYPE=17, INDEX=18, CREATE=19, UPDATE=20, DELETE=21, DOC=22, QUERY=23, 
		BOOL=24, MUST=25, MUSTNOT=26, SHOULD=27, FILTER=28, MATCHALL=29, MATCH=30, 
		MULTIMATCH=31, TERM=32, TERMS=33, RANGE=34, GT=35, GTE=36, LT=37, LTE=38, 
		SOURCE=39, EXCLUDES=40, INCLUDES=41, AGGS=42, AVG=43, SUM=44, MAX=45, 
		MIN=46, VALUE_COUNT=47, SORT=48, ORDER=49, STRING=50, NUMBER=51;
	public static final int
		RULE_dsl = 0, RULE_header = 1, RULE_address = 2, RULE_body = 3, RULE_object = 4, 
		RULE_pair = 5, RULE_array = 6, RULE_value = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"dsl", "header", "address", "body", "object", "pair", "array", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'{'", "','", "'}'", "':'", "'['", "']'", "'true'", "'false'", 
			"'null'", null, null, null, null, "'\"mappings\"'", "'\"properties\"'", 
			"'\"type\"'", "'\"index\"'", "'\"create\"'", "'\"update\"'", "'\"delete\"'", 
			"'\"doc\"'", "'\"query\"'", "'\"bool\"'", "'\"must\"'", "'\"must_not\"'", 
			"'\"should\"'", "'\"filter\"'", "'\"match_all\"'", "'\"match\"'", "'\"multimatch\"'", 
			"'\"term\"'", "'\"terms\"'", "'\"range\"'", "'\"gt\"'", "'\"gte\"'", 
			"'\"lt\"'", "'\"lte\"'", "'\"_source\"'", "'\"excludes\"'", "'\"includes\"'", 
			"'\"aggs\"'", "'\"avg\"'", "'\"sum\"'", "'\"max\"'", "'\"min\"'", "'\"value_count\"'", 
			"'\"sort\"'", "'\"order\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "METHOD", 
			"WHITESPACE", "ARG", "NAME", "MAPPINGS", "PROPERTIES", "TYPE", "INDEX", 
			"CREATE", "UPDATE", "DELETE", "DOC", "QUERY", "BOOL", "MUST", "MUSTNOT", 
			"SHOULD", "FILTER", "MATCHALL", "MATCH", "MULTIMATCH", "TERM", "TERMS", 
			"RANGE", "GT", "GTE", "LT", "LTE", "SOURCE", "EXCLUDES", "INCLUDES", 
			"AGGS", "AVG", "SUM", "MAX", "MIN", "VALUE_COUNT", "SORT", "ORDER", "STRING", 
			"NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DSLtoSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DSLtoSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DslContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DSLtoSQLParser.EOF, 0); }
		public DslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dsl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterDsl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitDsl(this);
		}
	}

	public final DslContext dsl() throws RecognitionException {
		DslContext _localctx = new DslContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dsl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			header();
			setState(17);
			body();
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(DSLtoSQLParser.METHOD, 0); }
		public AddressContext address() {
			return getRuleContext(AddressContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(METHOD);
			setState(21);
			address();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddressContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(DSLtoSQLParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(DSLtoSQLParser.NAME, i);
		}
		public List<TerminalNode> ARG() { return getTokens(DSLtoSQLParser.ARG); }
		public TerminalNode ARG(int i) {
			return getToken(DSLtoSQLParser.ARG, i);
		}
		public AddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAddress(this);
		}
	}

	public final AddressContext address() throws RecognitionException {
		AddressContext _localctx = new AddressContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_address);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(23);
				match(T__0);
				}
			}

			setState(26);
			match(NAME);
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27);
					match(T__0);
					setState(28);
					match(NAME);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(34);
				match(T__0);
				setState(35);
				match(ARG);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				object();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectContext extends ParserRuleContext {
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	 
		public ObjectContext() { }
		public void copyFrom(ObjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnObjectContext extends ObjectContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public AnObjectContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAnObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAnObject(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyObjectContext extends ObjectContext {
		public EmptyObjectContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterEmptyObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitEmptyObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_object);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AnObjectContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(T__1);
				setState(47);
				pair();
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(48);
					match(T__2);
					setState(49);
					pair();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new EmptyObjectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__1);
				setState(58);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
	 
		public PairContext() { }
		public void copyFrom(PairContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeleteContext extends PairContext {
		public TerminalNode DELETE() { return getToken(DSLtoSQLParser.DELETE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DeleteContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitDelete(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShouldContext extends PairContext {
		public TerminalNode SHOULD() { return getToken(DSLtoSQLParser.SHOULD, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ShouldContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterShould(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitShould(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends PairContext {
		public TerminalNode QUERY() { return getToken(DSLtoSQLParser.QUERY, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public QueryContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitQuery(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MaxContext extends PairContext {
		public TerminalNode MAX() { return getToken(DSLtoSQLParser.MAX, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MaxContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMax(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertiesContext extends PairContext {
		public TerminalNode PROPERTIES() { return getToken(DSLtoSQLParser.PROPERTIES, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PropertiesContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitProperties(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UpdateContext extends PairContext {
		public TerminalNode UPDATE() { return getToken(DSLtoSQLParser.UPDATE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public UpdateContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitUpdate(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExcludesContext extends PairContext {
		public TerminalNode EXCLUDES() { return getToken(DSLtoSQLParser.EXCLUDES, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExcludesContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterExcludes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitExcludes(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MustContext extends PairContext {
		public TerminalNode MUST() { return getToken(DSLtoSQLParser.MUST, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MustContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMust(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMust(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GtContext extends PairContext {
		public TerminalNode GT() { return getToken(DSLtoSQLParser.GT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GtContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitGt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SourceContext extends PairContext {
		public TerminalNode SOURCE() { return getToken(DSLtoSQLParser.SOURCE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SourceContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitSource(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchContext extends PairContext {
		public TerminalNode MATCH() { return getToken(DSLtoSQLParser.MATCH, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MatchContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMatch(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncludesContext extends PairContext {
		public TerminalNode INCLUDES() { return getToken(DSLtoSQLParser.INCLUDES, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IncludesContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterIncludes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitIncludes(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends PairContext {
		public TerminalNode BOOL() { return getToken(DSLtoSQLParser.BOOL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BoolContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitBool(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CreateContext extends PairContext {
		public TerminalNode CREATE() { return getToken(DSLtoSQLParser.CREATE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CreateContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitCreate(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DocContext extends PairContext {
		public TerminalNode DOC() { return getToken(DSLtoSQLParser.DOC, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DocContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitDoc(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SortContext extends PairContext {
		public TerminalNode SORT() { return getToken(DSLtoSQLParser.SORT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SortContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitSort(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MustNotContext extends PairContext {
		public TerminalNode MUSTNOT() { return getToken(DSLtoSQLParser.MUSTNOT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MustNotContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMustNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMustNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrderContext extends PairContext {
		public TerminalNode ORDER() { return getToken(DSLtoSQLParser.ORDER, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OrderContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitOrder(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermsContext extends PairContext {
		public TerminalNode TERMS() { return getToken(DSLtoSQLParser.TERMS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermsContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitTerms(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtContext extends PairContext {
		public TerminalNode LT() { return getToken(DSLtoSQLParser.LT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LtContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitLt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumContext extends PairContext {
		public TerminalNode SUM() { return getToken(DSLtoSQLParser.SUM, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SumContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitSum(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiMatchContext extends PairContext {
		public TerminalNode MULTIMATCH() { return getToken(DSLtoSQLParser.MULTIMATCH, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MultiMatchContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMultiMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMultiMatch(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends PairContext {
		public TerminalNode TERM() { return getToken(DSLtoSQLParser.TERM, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TermContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitTerm(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends PairContext {
		public TerminalNode RANGE() { return getToken(DSLtoSQLParser.RANGE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public RangeContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitRange(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AggsContext extends PairContext {
		public TerminalNode AGGS() { return getToken(DSLtoSQLParser.AGGS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AggsContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAggs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAggs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchAllContext extends PairContext {
		public TerminalNode MATCHALL() { return getToken(DSLtoSQLParser.MATCHALL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MatchAllContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMatchAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMatchAll(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueCountContext extends PairContext {
		public TerminalNode VALUE_COUNT() { return getToken(DSLtoSQLParser.VALUE_COUNT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueCountContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterValueCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitValueCount(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends PairContext {
		public TerminalNode TYPE() { return getToken(DSLtoSQLParser.TYPE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TypeContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitType(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AvgContext extends PairContext {
		public TerminalNode AVG() { return getToken(DSLtoSQLParser.AVG, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AvgContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAvg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAvg(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinContext extends PairContext {
		public TerminalNode MIN() { return getToken(DSLtoSQLParser.MIN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MinContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MappingsContext extends PairContext {
		public TerminalNode MAPPINGS() { return getToken(DSLtoSQLParser.MAPPINGS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MappingsContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterMappings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitMappings(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterContext extends PairContext {
		public TerminalNode FILTER() { return getToken(DSLtoSQLParser.FILTER, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FilterContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalPairContext extends PairContext {
		public TerminalNode STRING() { return getToken(DSLtoSQLParser.STRING, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NormalPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterNormalPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitNormalPair(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GteContext extends PairContext {
		public TerminalNode GTE() { return getToken(DSLtoSQLParser.GTE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GteContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitGte(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LteContext extends PairContext {
		public TerminalNode LTE() { return getToken(DSLtoSQLParser.LTE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LteContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitLte(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pair);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAPPINGS:
				_localctx = new MappingsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(MAPPINGS);
				setState(62);
				match(T__4);
				setState(63);
				value();
				}
				break;
			case PROPERTIES:
				_localctx = new PropertiesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(PROPERTIES);
				setState(65);
				match(T__4);
				setState(66);
				value();
				}
				break;
			case TYPE:
				_localctx = new TypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(TYPE);
				setState(68);
				match(T__4);
				setState(69);
				value();
				}
				break;
			case CREATE:
				_localctx = new CreateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(CREATE);
				setState(71);
				match(T__4);
				setState(72);
				value();
				}
				break;
			case UPDATE:
				_localctx = new UpdateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				match(UPDATE);
				setState(74);
				match(T__4);
				setState(75);
				value();
				}
				break;
			case DOC:
				_localctx = new DocContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				match(DOC);
				setState(77);
				match(T__4);
				setState(78);
				value();
				}
				break;
			case DELETE:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				match(DELETE);
				setState(80);
				match(T__4);
				setState(81);
				value();
				}
				break;
			case QUERY:
				_localctx = new QueryContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				match(QUERY);
				setState(83);
				match(T__4);
				setState(84);
				value();
				}
				break;
			case MATCHALL:
				_localctx = new MatchAllContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(85);
				match(MATCHALL);
				setState(86);
				match(T__4);
				setState(87);
				value();
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(88);
				match(BOOL);
				setState(89);
				match(T__4);
				setState(90);
				value();
				}
				break;
			case MUST:
				_localctx = new MustContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(91);
				match(MUST);
				setState(92);
				match(T__4);
				setState(93);
				value();
				}
				break;
			case MUSTNOT:
				_localctx = new MustNotContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(94);
				match(MUSTNOT);
				setState(95);
				match(T__4);
				setState(96);
				value();
				}
				break;
			case SHOULD:
				_localctx = new ShouldContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(97);
				match(SHOULD);
				setState(98);
				match(T__4);
				setState(99);
				value();
				}
				break;
			case FILTER:
				_localctx = new FilterContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(100);
				match(FILTER);
				setState(101);
				match(T__4);
				setState(102);
				value();
				}
				break;
			case MATCH:
				_localctx = new MatchContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(103);
				match(MATCH);
				setState(104);
				match(T__4);
				setState(105);
				value();
				}
				break;
			case MULTIMATCH:
				_localctx = new MultiMatchContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(106);
				match(MULTIMATCH);
				setState(107);
				match(T__4);
				setState(108);
				value();
				}
				break;
			case TERM:
				_localctx = new TermContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(109);
				match(TERM);
				setState(110);
				match(T__4);
				setState(111);
				value();
				}
				break;
			case TERMS:
				_localctx = new TermsContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(112);
				match(TERMS);
				setState(113);
				match(T__4);
				setState(114);
				value();
				}
				break;
			case RANGE:
				_localctx = new RangeContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(115);
				match(RANGE);
				setState(116);
				match(T__4);
				setState(117);
				value();
				}
				break;
			case GT:
				_localctx = new GtContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(118);
				match(GT);
				setState(119);
				match(T__4);
				setState(120);
				value();
				}
				break;
			case GTE:
				_localctx = new GteContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(121);
				match(GTE);
				setState(122);
				match(T__4);
				setState(123);
				value();
				}
				break;
			case LT:
				_localctx = new LtContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(124);
				match(LT);
				setState(125);
				match(T__4);
				setState(126);
				value();
				}
				break;
			case LTE:
				_localctx = new LteContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(127);
				match(LTE);
				setState(128);
				match(T__4);
				setState(129);
				value();
				}
				break;
			case SOURCE:
				_localctx = new SourceContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(130);
				match(SOURCE);
				setState(131);
				match(T__4);
				setState(132);
				value();
				}
				break;
			case EXCLUDES:
				_localctx = new ExcludesContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(133);
				match(EXCLUDES);
				setState(134);
				match(T__4);
				setState(135);
				value();
				}
				break;
			case INCLUDES:
				_localctx = new IncludesContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(136);
				match(INCLUDES);
				setState(137);
				match(T__4);
				setState(138);
				value();
				}
				break;
			case AGGS:
				_localctx = new AggsContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(139);
				match(AGGS);
				setState(140);
				match(T__4);
				setState(141);
				value();
				}
				break;
			case AVG:
				_localctx = new AvgContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(142);
				match(AVG);
				setState(143);
				match(T__4);
				setState(144);
				value();
				}
				break;
			case SUM:
				_localctx = new SumContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(145);
				match(SUM);
				setState(146);
				match(T__4);
				setState(147);
				value();
				}
				break;
			case MAX:
				_localctx = new MaxContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(148);
				match(MAX);
				setState(149);
				match(T__4);
				setState(150);
				value();
				}
				break;
			case MIN:
				_localctx = new MinContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(151);
				match(MIN);
				setState(152);
				match(T__4);
				setState(153);
				value();
				}
				break;
			case VALUE_COUNT:
				_localctx = new ValueCountContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(154);
				match(VALUE_COUNT);
				setState(155);
				match(T__4);
				setState(156);
				value();
				}
				break;
			case SORT:
				_localctx = new SortContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(157);
				match(SORT);
				setState(158);
				match(T__4);
				setState(159);
				value();
				}
				break;
			case ORDER:
				_localctx = new OrderContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(160);
				match(ORDER);
				setState(161);
				match(T__4);
				setState(162);
				value();
				}
				break;
			case STRING:
				_localctx = new NormalPairContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(163);
				match(STRING);
				setState(164);
				match(T__4);
				setState(165);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	 
		public ArrayContext() { }
		public void copyFrom(ArrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyArrayContext extends ArrayContext {
		public EmptyArrayContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterEmptyArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitEmptyArray(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnArrayContext extends ArrayContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public AnArrayContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAnArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAnArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_array);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AnArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(T__5);
				setState(169);
				value();
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(170);
					match(T__2);
					setState(171);
					value();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new EmptyArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__5);
				setState(180);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectValueContext extends ValueContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitObjectValue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(DSLtoSQLParser.NUMBER, 0); }
		public NumberContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(DSLtoSQLParser.STRING, 0); }
		public StringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueContext extends ValueContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitArrayValue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ValueContext {
		public AtomContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLtoSQLListener ) ((DSLtoSQLListener)listener).exitAtom(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(NUMBER);
				}
				break;
			case T__1:
				_localctx = new ObjectValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				object();
				}
				break;
			case T__5:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				array();
				}
				break;
			case T__7:
				_localctx = new AtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new AtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new AtomContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(189);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0003\u0002\u0019\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u001e\b\u0002\n\u0002\f\u0002!\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0001\u0003"+
		"\u0004\u0003+\b\u0003\u000b\u0003\f\u0003,\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u00043\b\u0004\n\u0004\f\u00046\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004<\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00a7\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00ad\b\u0006\n\u0006\f\u0006"+
		"\u00b0\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00b6\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00bf\b\u0007\u0001\u0007\u0000\u0000"+
		"\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000\u00e8\u0000\u0010\u0001"+
		"\u0000\u0000\u0000\u0002\u0014\u0001\u0000\u0000\u0000\u0004\u0018\u0001"+
		"\u0000\u0000\u0000\u0006*\u0001\u0000\u0000\u0000\b;\u0001\u0000\u0000"+
		"\u0000\n\u00a6\u0001\u0000\u0000\u0000\f\u00b5\u0001\u0000\u0000\u0000"+
		"\u000e\u00be\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000"+
		"\u0011\u0012\u0003\u0006\u0003\u0000\u0012\u0013\u0005\u0000\u0000\u0001"+
		"\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u000b\u0000\u0000"+
		"\u0015\u0016\u0003\u0004\u0002\u0000\u0016\u0003\u0001\u0000\u0000\u0000"+
		"\u0017\u0019\u0005\u0001\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000"+
		"\u001a\u001f\u0005\u000e\u0000\u0000\u001b\u001c\u0005\u0001\u0000\u0000"+
		"\u001c\u001e\u0005\u000e\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000"+
		"\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 &\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000\"#\u0005\u0001\u0000\u0000#%\u0005\r\u0000\u0000$\"\u0001"+
		"\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000)+\u0003\b\u0004\u0000*)\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0007"+
		"\u0001\u0000\u0000\u0000./\u0005\u0002\u0000\u0000/4\u0003\n\u0005\u0000"+
		"01\u0005\u0003\u0000\u000013\u0003\n\u0005\u000020\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005\u0004"+
		"\u0000\u00008<\u0001\u0000\u0000\u00009:\u0005\u0002\u0000\u0000:<\u0005"+
		"\u0004\u0000\u0000;.\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<\t\u0001\u0000\u0000\u0000=>\u0005\u000f\u0000\u0000>?\u0005\u0005\u0000"+
		"\u0000?\u00a7\u0003\u000e\u0007\u0000@A\u0005\u0010\u0000\u0000AB\u0005"+
		"\u0005\u0000\u0000B\u00a7\u0003\u000e\u0007\u0000CD\u0005\u0011\u0000"+
		"\u0000DE\u0005\u0005\u0000\u0000E\u00a7\u0003\u000e\u0007\u0000FG\u0005"+
		"\u0013\u0000\u0000GH\u0005\u0005\u0000\u0000H\u00a7\u0003\u000e\u0007"+
		"\u0000IJ\u0005\u0014\u0000\u0000JK\u0005\u0005\u0000\u0000K\u00a7\u0003"+
		"\u000e\u0007\u0000LM\u0005\u0016\u0000\u0000MN\u0005\u0005\u0000\u0000"+
		"N\u00a7\u0003\u000e\u0007\u0000OP\u0005\u0015\u0000\u0000PQ\u0005\u0005"+
		"\u0000\u0000Q\u00a7\u0003\u000e\u0007\u0000RS\u0005\u0017\u0000\u0000"+
		"ST\u0005\u0005\u0000\u0000T\u00a7\u0003\u000e\u0007\u0000UV\u0005\u001d"+
		"\u0000\u0000VW\u0005\u0005\u0000\u0000W\u00a7\u0003\u000e\u0007\u0000"+
		"XY\u0005\u0018\u0000\u0000YZ\u0005\u0005\u0000\u0000Z\u00a7\u0003\u000e"+
		"\u0007\u0000[\\\u0005\u0019\u0000\u0000\\]\u0005\u0005\u0000\u0000]\u00a7"+
		"\u0003\u000e\u0007\u0000^_\u0005\u001a\u0000\u0000_`\u0005\u0005\u0000"+
		"\u0000`\u00a7\u0003\u000e\u0007\u0000ab\u0005\u001b\u0000\u0000bc\u0005"+
		"\u0005\u0000\u0000c\u00a7\u0003\u000e\u0007\u0000de\u0005\u001c\u0000"+
		"\u0000ef\u0005\u0005\u0000\u0000f\u00a7\u0003\u000e\u0007\u0000gh\u0005"+
		"\u001e\u0000\u0000hi\u0005\u0005\u0000\u0000i\u00a7\u0003\u000e\u0007"+
		"\u0000jk\u0005\u001f\u0000\u0000kl\u0005\u0005\u0000\u0000l\u00a7\u0003"+
		"\u000e\u0007\u0000mn\u0005 \u0000\u0000no\u0005\u0005\u0000\u0000o\u00a7"+
		"\u0003\u000e\u0007\u0000pq\u0005!\u0000\u0000qr\u0005\u0005\u0000\u0000"+
		"r\u00a7\u0003\u000e\u0007\u0000st\u0005\"\u0000\u0000tu\u0005\u0005\u0000"+
		"\u0000u\u00a7\u0003\u000e\u0007\u0000vw\u0005#\u0000\u0000wx\u0005\u0005"+
		"\u0000\u0000x\u00a7\u0003\u000e\u0007\u0000yz\u0005$\u0000\u0000z{\u0005"+
		"\u0005\u0000\u0000{\u00a7\u0003\u000e\u0007\u0000|}\u0005%\u0000\u0000"+
		"}~\u0005\u0005\u0000\u0000~\u00a7\u0003\u000e\u0007\u0000\u007f\u0080"+
		"\u0005&\u0000\u0000\u0080\u0081\u0005\u0005\u0000\u0000\u0081\u00a7\u0003"+
		"\u000e\u0007\u0000\u0082\u0083\u0005\'\u0000\u0000\u0083\u0084\u0005\u0005"+
		"\u0000\u0000\u0084\u00a7\u0003\u000e\u0007\u0000\u0085\u0086\u0005(\u0000"+
		"\u0000\u0086\u0087\u0005\u0005\u0000\u0000\u0087\u00a7\u0003\u000e\u0007"+
		"\u0000\u0088\u0089\u0005)\u0000\u0000\u0089\u008a\u0005\u0005\u0000\u0000"+
		"\u008a\u00a7\u0003\u000e\u0007\u0000\u008b\u008c\u0005*\u0000\u0000\u008c"+
		"\u008d\u0005\u0005\u0000\u0000\u008d\u00a7\u0003\u000e\u0007\u0000\u008e"+
		"\u008f\u0005+\u0000\u0000\u008f\u0090\u0005\u0005\u0000\u0000\u0090\u00a7"+
		"\u0003\u000e\u0007\u0000\u0091\u0092\u0005,\u0000\u0000\u0092\u0093\u0005"+
		"\u0005\u0000\u0000\u0093\u00a7\u0003\u000e\u0007\u0000\u0094\u0095\u0005"+
		"-\u0000\u0000\u0095\u0096\u0005\u0005\u0000\u0000\u0096\u00a7\u0003\u000e"+
		"\u0007\u0000\u0097\u0098\u0005.\u0000\u0000\u0098\u0099\u0005\u0005\u0000"+
		"\u0000\u0099\u00a7\u0003\u000e\u0007\u0000\u009a\u009b\u0005/\u0000\u0000"+
		"\u009b\u009c\u0005\u0005\u0000\u0000\u009c\u00a7\u0003\u000e\u0007\u0000"+
		"\u009d\u009e\u00050\u0000\u0000\u009e\u009f\u0005\u0005\u0000\u0000\u009f"+
		"\u00a7\u0003\u000e\u0007\u0000\u00a0\u00a1\u00051\u0000\u0000\u00a1\u00a2"+
		"\u0005\u0005\u0000\u0000\u00a2\u00a7\u0003\u000e\u0007\u0000\u00a3\u00a4"+
		"\u00052\u0000\u0000\u00a4\u00a5\u0005\u0005\u0000\u0000\u00a5\u00a7\u0003"+
		"\u000e\u0007\u0000\u00a6=\u0001\u0000\u0000\u0000\u00a6@\u0001\u0000\u0000"+
		"\u0000\u00a6C\u0001\u0000\u0000\u0000\u00a6F\u0001\u0000\u0000\u0000\u00a6"+
		"I\u0001\u0000\u0000\u0000\u00a6L\u0001\u0000\u0000\u0000\u00a6O\u0001"+
		"\u0000\u0000\u0000\u00a6R\u0001\u0000\u0000\u0000\u00a6U\u0001\u0000\u0000"+
		"\u0000\u00a6X\u0001\u0000\u0000\u0000\u00a6[\u0001\u0000\u0000\u0000\u00a6"+
		"^\u0001\u0000\u0000\u0000\u00a6a\u0001\u0000\u0000\u0000\u00a6d\u0001"+
		"\u0000\u0000\u0000\u00a6g\u0001\u0000\u0000\u0000\u00a6j\u0001\u0000\u0000"+
		"\u0000\u00a6m\u0001\u0000\u0000\u0000\u00a6p\u0001\u0000\u0000\u0000\u00a6"+
		"s\u0001\u0000\u0000\u0000\u00a6v\u0001\u0000\u0000\u0000\u00a6y\u0001"+
		"\u0000\u0000\u0000\u00a6|\u0001\u0000\u0000\u0000\u00a6\u007f\u0001\u0000"+
		"\u0000\u0000\u00a6\u0082\u0001\u0000\u0000\u0000\u00a6\u0085\u0001\u0000"+
		"\u0000\u0000\u00a6\u0088\u0001\u0000\u0000\u0000\u00a6\u008b\u0001\u0000"+
		"\u0000\u0000\u00a6\u008e\u0001\u0000\u0000\u0000\u00a6\u0091\u0001\u0000"+
		"\u0000\u0000\u00a6\u0094\u0001\u0000\u0000\u0000\u00a6\u0097\u0001\u0000"+
		"\u0000\u0000\u00a6\u009a\u0001\u0000\u0000\u0000\u00a6\u009d\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a0\u0001\u0000\u0000\u0000\u00a6\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a7\u000b\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0006"+
		"\u0000\u0000\u00a9\u00ae\u0003\u000e\u0007\u0000\u00aa\u00ab\u0005\u0003"+
		"\u0000\u0000\u00ab\u00ad\u0003\u000e\u0007\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0007"+
		"\u0000\u0000\u00b2\u00b6\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0006"+
		"\u0000\u0000\u00b4\u00b6\u0005\u0007\u0000\u0000\u00b5\u00a8\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\r\u0001\u0000\u0000"+
		"\u0000\u00b7\u00bf\u00052\u0000\u0000\u00b8\u00bf\u00053\u0000\u0000\u00b9"+
		"\u00bf\u0003\b\u0004\u0000\u00ba\u00bf\u0003\f\u0006\u0000\u00bb\u00bf"+
		"\u0005\b\u0000\u0000\u00bc\u00bf\u0005\t\u0000\u0000\u00bd\u00bf\u0005"+
		"\n\u0000\u0000\u00be\u00b7\u0001\u0000\u0000\u0000\u00be\u00b8\u0001\u0000"+
		"\u0000\u0000\u00be\u00b9\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000"+
		"\u0000\u0000\u00be\u00bb\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000"+
		"\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u000f\u0001\u0000"+
		"\u0000\u0000\n\u0018\u001f&,4;\u00a6\u00ae\u00b5\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
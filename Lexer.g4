lexer grammar Lexer;

METHOD : 'GET'    //请求方式
       | 'POST'
       | 'PUT'
       | 'DELETE'
       ;
WHITESPACE : [ \t\n\r]+ ->skip;     //跳过空白符
//PROTOCOL : 'http''s'?'://';
//HOST :  NUMBER'.'NUMBER'.'NUMBER'.'NUMBER;   //请求主机
//PORT : ':'NUMBER;    //请求端口
ARG : '_'[a-z]+;
NAME : [_a-zA-Z]+;   //查询名称字段，待修改
MAPPINGS : '"mappings"';
PROPERTIES : '"properties"';
TYPE : '"type"';
INDEX : '"index"';
CREATE : '"create"';
UPDATE : '"update"';
DELETE : '"delete"';
DOC : '"doc"';
QUERY : '"query"';
BOOL : '"bool"';
MUST : '"must"';
MUSTNOT : '"must_not"';
SHOULD : '"should"';
FILTER : '"filter"';
MATCHALL : '"match_all"';
MATCH : '"match"';
MULTIMATCH : '"multimatch"';
TERM : '"term"';
TERMS : '"terms"';
RANGE : '"range"';
GT : '"gt"';
GTE : '"gte"';
LT : '"lt"';
LTE : '"lte"';
SOURCE : '"_source"';
EXCLUDES : '"excludes"';
INCLUDES : '"includes"';
AGGS : '"aggs"';
AVG : '"avg"';
SUM : '"sum"';
MAX : '"max"';
MIN : '"min"';
VALUE_COUNT : '"value_count"';
SORT : '"sort"';
ORDER : '"order"';
STRING :  '"' (ESC | ~["\\])* '"' ;     //字符串，支持转义字符
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
NUMBER  //数字
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // 整数，除零以外，不能以零开头
fragment EXP :   [Ee] [+\-]? INT ; // 科学计数法exp
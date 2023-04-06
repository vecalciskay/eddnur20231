grammar expr;
prog:	expr1 EOF ;
expr1:	expr1 ('*'|'/') expr1
    |	expr1 ('+'|'-') expr1
    |	INT
    |	'(' expr1 ')'
    ;
NEWLINE : [\r\n]+ -> skip;
INT     : [0-9]+ ;

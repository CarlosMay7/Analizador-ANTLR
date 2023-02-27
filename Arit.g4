grammar Arit;
prog:   (expr NEWLINE)* ;
expr:   ('+'|'-') ' ' expr ' ' term | term;
term:	 ('*'|'/') ' ' term ' ' valor | valor;
valor:  ('^') ' ' valor ' ' factor | factor;
factor: '('expr')'| DEC | INT ;

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
DEC     : [0-9]+'.'[0-9]+;
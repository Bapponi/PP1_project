
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"findAndReplace" 	{ return new_symbol(sym.FINDANDREPLACE, yytext()); }
"namespace"			{ return new_symbol(sym.NAMESPACE, yytext()); }
"continue" 			{ return new_symbol(sym.CONTINUE, yytext()); }
"findAny" 			{ return new_symbol(sym.FINDANY, yytext()); }
"foreach" 			{ return new_symbol(sym.FOREACH, yytext()); }
"program"   		{ return new_symbol(sym.PROG, yytext()); }
"extends" 			{ return new_symbol(sym.EXTENDS, yytext()); }
"return" 			{ return new_symbol(sym.RETURN, yytext()); }
"static" 			{ return new_symbol(sym.STATIC, yytext()); }
"print" 			{ return new_symbol(sym.PRINT, yytext()); }
"break" 			{ return new_symbol(sym.BREAK, yytext()); }
"class" 			{ return new_symbol(sym.CLASS, yytext()); }
"const" 			{ return new_symbol(sym.CONST, yytext()); }
"while" 			{ return new_symbol(sym.WHILE, yytext()); }
"else" 				{ return new_symbol(sym.ELSE, yytext()); }
"read" 				{ return new_symbol(sym.READ, yytext()); }
"void" 				{ return new_symbol(sym.VOID, yytext()); }
"for" 				{ return new_symbol(sym.FOR, yytext()); }
"new" 				{ return new_symbol(sym.NEW, yytext()); }
"if" 				{ return new_symbol(sym.IF, yytext()); }

"=>" 		{ return new_symbol(sym.IMPL, yytext()); }
"==" 		{ return new_symbol(sym.EQV, yytext()); }
"!=" 		{ return new_symbol(sym.NOEQV, yytext()); }
">=" 		{ return new_symbol(sym.MOREEQV, yytext()); }
"<=" 		{ return new_symbol(sym.LESSEQV, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }
"++" 		{ return new_symbol(sym.INC, yytext()); }
"--" 		{ return new_symbol(sym.DEC, yytext()); }
"##" 		{ return new_symbol(sym.HASHHASH, yytext()); }

"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
"*" 		{ return new_symbol(sym.MUL, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }
">" 		{ return new_symbol(sym.MORE, yytext()); }
"<" 		{ return new_symbol(sym.LESS, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }

"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"[" 		{ return new_symbol(sym.LBRACKET, yytext()); }
"]" 		{ return new_symbol(sym.RBRACKET, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

'[a-zA-Z0-9_]'			{ return new_symbol(sym.CHAR, yytext()); }
"true"					{ return new_symbol(sym.BOOL, yytext()); }
"false"					{ return new_symbol(sym.BOOL, yytext()); }
[0-9]+  				{ return new_symbol(sym.NUMBER, Integer.valueOf(yytext())); }
[a-zA-Z][a-zA-Z0-9_]*("::"[a-zA-Z][a-zA-Z0-9_]*)* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") na liniji "+(yyline+1)+" u koloni "+(yycolumn)); }

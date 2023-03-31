/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.  Here the lexer is driven by the simple Java test
 * program in ./PascalLexerTest.java, q.v.  See 330 Lecture Notes 2 and the
 * Assignment 2 writeup for further discussion.
 *
 */


import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{


Symbol symbol(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

Symbol symbol(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

void illegal(int line, long col) {
    System.out.format("Found ILLEGAL character " + yytext() + " at position " + line+1 + " at column number " + col);
  }

%}


/*-*
 * PATTERN DEFINITIONS:

 */
digit = [0-9]
characters = [A-Za-z]
newline = \\
char = [^\\\n\t\"\']|\\.
id = {characters}[{characters}|{digit}]*
Tab = \\t
whitespace = [ \n\r\t]
comments =  \\\\.*\n?

multiple_comments    = \\\*(.|{whitespace})*\*\\
str = {char}*
charlit = \'{char}\'
Stringlit = \"{str}\"
intlit = {digit}+
floatlit = {intlit}\.{intlit}

%%

/**
 * Implement patterns as regex here
 */



 "("    {return symbol(sym.open_round, "("); }
 ")"    {return symbol(sym.closeround, ")"); }
 "["    {return symbol(sym.opensquare, "["); }
 "]"    {return symbol(sym.closesquare, "]"); }
 "{"    {return symbol(sym.opencurly, "{"); }
 "}"    {return symbol(sym.closecurly,"}"); }

";"     {return symbol(sym.semicolon,";"); }
"?"     {return symbol(sym.questions,"?"); }
":"     {return symbol(sym.colon,":"); }
","     {return symbol(sym.comma,","); }

"++"    {return symbol(sym.incre,"++"); }
"--"    {return symbol(sym.decre,"--"); }
"~"     {return symbol(sym.Not,"~");}
"*"     {return symbol(sym.Multiply,"*");}
"/"     {return symbol(sym.Divide,"/");}
"+"     {return symbol(sym.Add,"+");}
"-"     {return symbol(sym.Subtract,"-");}
"<"     {return symbol(sym.lessthan,"<");}
">"     {return symbol(sym.greaterthan,">");}
"<="    {return symbol(sym.lessthanequalto,"<=");}
">="    {return symbol(sym.greaterthanequalto,">=");}
"=="    {return symbol(sym.doubleequalto,"==");}
"<>"    {return symbol(sym.negate,"<>");}
"&&"    {return symbol(sym.And,"&&");}
"||"    {return symbol(sym.Or,"||");}
"="     {return symbol(sym.equalto,"="); }

char           { return symbol(sym.Char, yytext()); }

true           { return symbol(sym.True, yytext()); }
false           { return symbol(sym.False, yytext()); }

 int        {return  symbol(sym.INT,"int"); }
 float      {return symbol(sym.Float,"float"); }
 bool       {return symbol(sym.Bool,"bool"); }

 

 if         {return symbol(sym.If,"if"); }
 else       {return symbol(sym.Else,"else"); }
 while      {return symbol(sym.While,"while"); }
 return     {return symbol(sym.Return,"return"); }
 print      {return symbol(sym.Print,"print"); }
 printline  {return symbol(sym.Printline,"printline"); }
 class      {return symbol(sym.cls,"class"); }
 void       {return symbol(sym.Void,"void");}
 final      {return symbol(sym.Final,"final");}


{charlit}           { return symbol(sym.charlit, yytext()); }
{Stringlit}	    { return symbol(sym.Strlit, yytext()); }
{intlit}   { return symbol(sym.INTLIT, yytext()); }
{floatlit}	    { return symbol(sym.Floatlit, yytext()); }




{id}                { return symbol(sym.ID,yytext()); }
{whitespace}    { /* Ignore whitespace. */ }
{comments}          {return symbol(sym.comments, yytext());}
{multiple_comments}  {return symbol(sym.multiple_comments, yytext());}

.               { System.out.println("Illegal char, " + yytext() +
                   " line: " + yyline + ", column: " + yychar); } 
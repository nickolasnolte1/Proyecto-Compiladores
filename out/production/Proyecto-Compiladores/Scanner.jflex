%%

%class GeneratedLexer
%implements java_cup.runtime.Scanner
%function next_token

%type java_cup.runtime.Symbol
%scanerror LexicalException
%unicode

%{
import java_cup.runtime.Symbol;
import [your_package].sym; // Replace [your_package] with your package name

public int currentCol = 1;
public int currentRow = 1;

private Symbol symbol(int type, int row, int col, Object value) {
    return new Symbol(type, row, col, value);
}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = [0-9]

%%

/* Lexer rules */
\n { currentRow++; currentCol = 1; }
{WhiteSpace} { currentCol++; }

// Numbers
[0-9]+ {
    currentCol += yytext().length();
    return symbol(sym.NUM, currentRow, currentCol, Integer.parseInt(yytext()));
}

// Hexadecimal numbers
0x[0-9a-fA-F]+ {
    currentCol += yytext().length();
    return symbol(sym.HEXA, currentRow, currentCol, yytext());
}

// Identifiers and keywords
{Identifier} {
    String lexeme = yytext();
    currentCol += lexeme.length();
    switch (lexeme) {
        case "class": return symbol(sym.CLASS, currentRow, currentCol, lexeme);
        case "while": return symbol(sym.WHILE, currentRow, currentCol, lexeme);
        case "int": return symbol(sym.INT, currentRow, currentCol, lexeme);
        case "if": return symbol(sym.IF, currentRow, currentCol, lexeme);
        case "else": return symbol(sym.ELSE, currentRow, currentCol, lexeme);
        case "break": return symbol(sym.BREAK, currentRow, currentCol, lexeme);
        case "boolean": return symbol(sym.BOOLEAN, currentRow, currentCol, lexeme);
        case "void": return symbol(sym.VOID, currentRow, currentCol, lexeme);
        case "for": return symbol(sym.FOR, currentRow, currentCol, lexeme);
        case "return": return symbol(sym.RETURN, currentRow, currentCol, lexeme);
        case "true": return symbol(sym.TRUE, currentRow, currentCol, lexeme);
        case "false": return symbol(sym.FALSE, currentRow, currentCol, lexeme);
        case "continue": return symbol(sym.CONTINUE, currentRow, currentCol, lexeme);
        case "callout": return symbol(sym.CALLOUT, currentRow, currentCol, lexeme);
        // Add other keywords as necessary
        default: return symbol(sym.ID, currentRow, currentCol, lexeme);
    }
}

// String literals
\"[^\"]*\" {
    currentCol += yytext().length();
    return symbol(sym.STRING, currentRow, currentCol, yytext());
}

// Single characters
[a-zA-Z] {
    currentCol++;
    return symbol(sym.CHAR, currentRow, currentCol, yytext());
}

// Operators and punctuation
"+" { return symbol(sym.SUMA, currentRow, currentCol, null); }
"-" { return symbol(sym.RESTA, currentRow, currentCol, null); }
"*" { return symbol(sym.MULTI, currentRow, currentCol, null); }
"/" { return symbol(sym.DIV, currentRow, currentCol, null); }
"%" { return symbol(sym.MOD, currentRow, currentCol, null); }
"=" { return symbol(sym.ASIG, currentRow, currentCol, null); }
"==" { return symbol(sym.EQUALS, currentRow, currentCol, null); }
"!=" { return symbol(sym.NOTEQUALS, currentRow, currentCol, null); }
"<" { return symbol(sym.LESSTHAN, currentRow, currentCol, null); }
"<=" { return symbol(sym.LESSEQUALS, currentRow, currentCol, null); }
">" { return symbol(sym.MORETHAN, currentRow, currentCol, null); }
">=" { return symbol(sym.MOREEQUALS, currentRow, currentCol, null); }
"&&" { return symbol(sym.AND, currentRow, currentCol, null); }
"||" { return symbol(sym.OR, currentRow, currentCol, null); }
"!" { return symbol(sym.NOT, currentRow, currentCol, null); }
";" { return symbol(sym.PUNTOCOMA, currentRow, currentCol, null); }
"," { return symbol(sym.COMA, currentRow, currentCol, null); }
"(" { return symbol(sym.PIZ, currentRow, currentCol, null); }
")" { return symbol(sym.PDER, currentRow, currentCol, null); }
"{" { return symbol(sym.LIZ, currentRow, currentCol, null); }
"}" { return symbol(sym.LDER, currentRow, currentCol, null); }
"[" { return symbol(sym.CIZ, currentRow, currentCol, null); }
"]" { return symbol(sym.CDER, currentRow, currentCol, null); }
"+=" { return symbol(sym.SUMEQUAL, currentRow, currentCol, null); }
"-=" { return symbol(sym.MINUSEQUAL, currentRow, currentCol, null); }
"*=" { return symbol(sym.MULTEQUAL, currentRow, currentCol, null); }
"/=" { return symbol(sym.DIVEQUAL, currentRow, currentCol, null); }

// Comments (assuming single-line comments)
"//"(.)*\n? {
    currentCol += yytext().length();
    return symbol(sym.SCOMMENT, currentRow, currentCol, yytext());
}

/* Error fallback */
[^] {
    currentCol++;
    return symbol(sym.ERROR, currentRow, currentCol, yytext());
}

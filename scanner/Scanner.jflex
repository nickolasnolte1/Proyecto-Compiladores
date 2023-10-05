%%

/* The class will be called GeneratedLexer */
%class GeneratedLexer

/* The yylex() method will return an instance of Token */
%type Token

/* The yylex() method will throw a LexicalException */
%scanerror LexicalException

%unicode

/* Code in the next section is copied into the generated lexer class.
 */
%{
private int currentRow = 1;
private int currentCol = 1;

private boolean isKeyword(String text) {
    String[] keywords = {"class", "while", "int", "if", "else", "break", "boolean", "void", "for", "return", "true", "false", "continue", "callout"};
    for (String keyword : keywords) {
        if (keyword.equals(text)) {
            return true;
        }
    }
    return false;
}

private int getKeywordTokenType(String keyword) {
    // Define mappings from keywords to token types here
    switch (keyword) {
        case "class":
            return Token.tag=CLASS;
        case "while":
            return Token.WHILE;
        case "int":
            return Token.INT;
        case "if":
            return Token.IF;
        case "else":
            return Token.ELSE;
        case "break":
            return Token.BREAK;
        case "boolean":
            return Token.BOOLEAN;
        case "void":
            return Token.VOID;
        case "for":
            return Token.FOR;
        case "return":
            return Token.RETURN;
        case "true":
            return Token.TRUE;
        case "false":
            return Token.FALSE;
        case "continue":
            return Token.CONTINUE;
        case "callout":
            return Token.CALLOUT;
        default:
            return 0; // Return 0 for unrecognized keywords
    }
}
%}

/* Here we define some macros, which are abbreviations for regular expressions.
 */

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

/* NOT VALID ASSIGNMENT IDENTIFIERS!!!! CHANGE ME!!!! */
Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = [0-9]

%%

/* Now we define keywords in our grammar
 * When the input string matches the regex on the left, the action on the right
 * is performed. The action is Java code. The regex matches the longest match by
 * default. The lexer starts in the <YYINITIAL> state.
 */
\n {
    currentRow++;
    currentCol = 1;
}
[-+]?[0-9]+                   { 
    return new Token(Token.NUM, currentRow, currentCol, Integer.parseInt(yytext())); 
}
0x[0-9a-fA-F]+                { 
    return new Token(Token.HEXA, currentRow, currentCol, yytext()); 
}
[a-zA-Z]                      { 
    return new Token(Token.CHAR, currentRow, currentCol, yytext()); 
}
\"[^\"]*\"                    {
    return new Token(Token.STRING, currentRow, currentCol, yytext()); 
}
[0-9][a-zA-Z0-9_]*            {
    return new Token(Token.ERROR, currentRow, currentCol, yytext());
}

[a-zA-Z_][a-zA-Z0-9_]* {
    // Check if the matched text is a keyword or a variable
    String lexeme = yytext();
    if (isKeyword(lexeme)) {
        return new Token(getKeywordTokenType(lexeme), currentRow, currentCol, lexeme);
    } else {
        return new Token(Token.ID, currentRow, currentCol, lexeme);
    }
}

<YYINITIAL> {

    /* whitespace */
    {WhiteSpace}                   { }

    /* Operadores y delimitadores */
    "+"                           { 
        return new Token(Token.SUMA, currentRow, currentCol, yytext()); 
    }
    "-"                           { 
        return new Token(Token.RESTA, currentRow, currentCol, yytext()); 
    }
    "*"                           { 
        return new Token(Token.MULTI, currentRow, currentCol, yytext()); 
    }
    "/"                           { 
        return new Token(Token.DIV, currentRow, currentCol, yytext()); 
    }
    "%"                           { 
        return new Token(Token.MOD, currentRow, currentCol, yytext()); 
    }
    "="                           { 
        return new Token(Token.ASIG, currentRow, currentCol, yytext()); 
    }
    "=="                          { 
        return new Token(Token.EQUALS, currentRow, currentCol, yytext()); 
    }
    "!="                          { 
        return new Token(Token.NOTEQUALS, currentRow, currentCol, yytext()); 
    }
    "<"                           { 
        return new Token(Token.LESSTHAN, currentRow, currentCol, yytext()); 
    }
    "<="                          { 
        return new Token(Token.LESSEQUALS, currentRow, currentCol, yytext()); 
    }
    ">"                           { 
        return new Token(Token.MORETHAN, currentRow, currentCol, yytext()); 
    }
    ">="                          { 
        return new Token(Token.MOREEQUALS, currentRow, currentCol, yytext()); 
    }
    "&&"                          { 
        return new Token(Token.AND, currentRow, currentCol, yytext()); 
    }
    "||"                          { 
        return new Token(Token.OR, currentRow, currentCol, yytext()); 
    }
    "!"                           { 
        return new Token(Token.NOT, currentRow, currentCol, yytext()); 
    }
    ";"                           { 
        return new Token(Token.PUNTOCOMA, currentRow, currentCol, yytext()); 
    }
    ","                           { 
        return new Token(Token.COMA, currentRow, currentCol, yytext()); 
    }
    "("                           { 
        return new Token(Token.PIZ, currentRow, currentCol, yytext()); 
    }
    ")"                           { 
        return new Token(Token.PDER, currentRow, currentCol, yytext()); 
    }
    "{"                           { 
        return new Token(Token.LIZ, currentRow, currentCol, yytext()); 
    }
    "}"                           { 
        return new Token(Token.LDER, currentRow, currentCol, yytext()); 
    }
    "["                           { 
        return new Token(Token.CIZ, currentRow, currentCol, yytext()); 
    }
    "]"                           {
        return new Token(Token.CDER, currentRow, currentCol, yytext()); 
    }
    "+="                          { 
        return new Token(Token.SUMEQUAL, currentRow, currentCol, yytext()); 
    }
    "-="                          { 
        return new Token(Token.MINUSEQUAL, currentRow, currentCol, yytext()); 
    }
    "*="                          { 
        return new Token(Token.MULTEQUAL, currentRow, currentCol, yytext()); 
    }
    "/="                          { 
        return new Token(Token.DIVEQUAL, currentRow, currentCol, yytext()); 
    }
    "//"(.)*\n?                   { 
        return new Token(Token.SCOMMENT, currentRow, currentCol, yytext()); 
    }

}

/* error fallback */
[^]                             { 
    return new Token(Token.ERROR, currentRow, currentCol, yytext()); 
}

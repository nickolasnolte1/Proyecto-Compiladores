
%%

%class GeneratedLexer
%implements java_cup.runtime.Scanner
%type java_cup.runtime.Symbol
%function next_token
%unicode
%scanerror LexicalException

%{
private static final Set<String> keywords = new HashSet<>();
private static final Map<String, TokenType> keywordToTokenType = new HashMap<>();

static {
    keywords.add("class");
    keywords.add("while");
    keywords.add("int");
    keywords.add("if");
    keywords.add("else");
    keywords.add("break");
    keywords.add("boolean");
    keywords.add("void");
    keywords.add("for");
    keywords.add("return");
    keywords.add("true");
    keywords.add("false");
    keywords.add("continue");
    keywords.add("callout");

    keywordToTokenType.put("class", TokenType.CLASS);
    keywordToTokenType.put("while", TokenType.WHILE);
    keywordToTokenType.put("int", TokenType.INT);
    // ... other keywords
}

public enum TokenType {
        ID, NUM, CLASS, INT, BOOLEAN, VOID, IF, ELSE, WHILE, FOR, RETURN, TRUE, FALSE,
        BREAK, CONTINUE, SUMA, RESTA, MULTI, DIV, MOD, ASIG, EQUALS, NOTEQUALS,
        LESSTHAN, MORETHAN, LESSEQUALS, MOREEQUALS, AND, OR, NOT, PIZ, PDER, CIZ,
        CDER, LIZ, LDER, PUNTOCOMA, COMA, SCOMMENT, STRING, CHAR, SUMEQUAL, MINUSEQUAL,
        MULTEQUAL, DIVEQUAL, CALLOUT, HEXA, ERROR
}

public int currentCol = 1;
public int currentRow = 1;

private boolean isKeyword(String text) {
    return keywords.contains(text);
}

private Symbol symbol(TokenType type, Object value) {
    return new Symbol(type.ordinal(), currentRow, currentCol, value);
}

private Symbol symbol(TokenType type) {
    return symbol(type, null);
}

private int getKeywordTokenType(String keyword) {
    return keywordToTokenType.getOrDefault(keyword, TokenType.ID).ordinal();
}
%}

LineTerminator =
|
|

WhiteSpace     = {LineTerminator} | [ 	]
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = [0-9]

%%

<YYINITIAL> {

 { currentRow++; currentCol = 0; }
    {WhiteSpace} { currentCol++; }
    /* Operadores y delimitadores */
      "+"                           {
                                        currentCol++;
                                        return new Token(TokenType.SUMA, currentRow, currentCol, yytext());
                                    }
      "-"                           {
                                        currentCol++;
                                        return new Token(TokenType.RESTA, currentRow, currentCol, yytext());
                                    }
      "*"                           {
                                        currentCol++;
                                        return new Token(TokenType.MULTI, currentRow, currentCol, yytext());
                                    }
      "/"                           {
                                        currentCol++;
                                        return new Token(TokenType.DIV, currentRow, currentCol, yytext());
                                    }
      "%"                           {
                                        currentCol++;
                                        return new Token(TokenType.MOD, currentRow, currentCol, yytext());
                                    }
      "="                           {
                                        currentCol++;
                                        return new Token(TokenType.ASIG, currentRow, currentCol, yytext());
                                    }
      "=="                          {
                                        currentCol++;
                                        return new Token(TokenType.EQUALS, currentRow, currentCol, yytext());
                                    }
      "!="                          {
                                        currentCol++;
                                        return new Token(TokenType.NOTEQUALS, currentRow, currentCol, yytext());
                                    }
      "<"                           {
                                        currentCol++;
                                        return new Token(TokenType.LESSTHAN, currentRow, currentCol, yytext());
                                    }
      "<="                          {
                                        currentCol++;
                                        return new Token(TokenType.LESSEQUALS, currentRow, currentCol, yytext());
                                    }
      ">"                           {
                                        currentCol++;
                                        return new Token(TokenType.MORETHAN, currentRow, currentCol, yytext());
                                    }
      ">="                          {
                                        currentCol++;
                                        return new Token(TokenType.MOREEQUALS, currentRow, currentCol, yytext());
                                    }
      "&&"                          {
                                        currentCol++;
                                        return new Token(TokenType.AND, currentRow, currentCol, yytext());
                                    }
      "||"                          {
                                        currentCol++;
                                        return new Token(TokenType.OR, currentRow, currentCol, yytext());
                                    }
      "!"                           {
                                        currentCol++;
                                        return new Token(TokenType.NOT, currentRow, currentCol, yytext());
                                    }
      ";"                           {
                                        currentCol++;
                                        return new Token(TokenType.PUNTOCOMA, currentRow, currentCol, yytext());
                                    }
      ","                           {
                                        currentCol++;
                                        return new Token(TokenType.COMA, currentRow, currentCol, yytext());
                                    }
      "("                           {
                                        currentCol++;
                                        return new Token(TokenType.PIZ, currentRow, currentCol, yytext());
                                    }
      ")"                           {
                                        currentCol++;
                                        return new Token(TokenType.PDER, currentRow, currentCol, yytext());
                                    }
      "{"                           {

                                        return new Token(TokenType.LIZ, currentRow, currentCol, yytext());
                                    }
      "}"                           {
                                        currentCol++;
                                        return new Token(TokenType.LDER, currentRow, currentCol, yytext());
                                    }
      "["                           {
                                        currentCol++;
                                        return new Token(TokenType.CIZ, currentRow, currentCol, yytext());
                                    }
      "]"                           {
                                        currentCol++;
                                        return new Token(TokenType.CDER, currentRow, currentCol, yytext());
                                    }
      "+="                          {
                                        currentCol++;
                                        return new Token(TokenType.SUMEQUAL, currentRow, currentCol, yytext());
                                    }
      "-="                          {
                                        currentCol++;
                                        return new Token(TokenType.MINUSEQUAL, currentRow, currentCol, yytext());
                                    }
      "*="                          {
                                        currentCol++;
                                        return new Token(TokenType.MULTEQUAL, currentRow, currentCol, yytext());
                                    }
      "/="                          {
                                        currentCol++;
                                        return new Token(TokenType.DIVEQUAL, currentRow, currentCol, yytext());
                                    }
      "//"(.)*\n?                   {
                                        currentCol++;
                                        return new Token(TokenType.SCOMMENT, currentRow, currentCol, yytext());
                                    }
    [a-zA-Z_][a-zA-Z0-9_]* {
        String lexeme = yytext();
        currentCol += lexeme.length();
        if (isKeyword(lexeme)) {
            return symbol(TokenType.valueOf(lexeme.toUpperCase()));
        } else {
            return symbol(TokenType.ID, lexeme);
        }
    }
    "." {
        currentCol++;
        return symbol(TokenType.DOT);
    }
    [^] {
        currentCol++;
        return new Symbol(sym.ERROR, currentRow, currentCol, yytext());
    }
}
%%

/* The class will be called GeneratedLexer */
%class GeneratedLexer
%implements java_cup.runtime.Scanner

%type java_cup.runtime.Symbol

/* The yylex() method will return an instance of Token */
%type Token

/* The yylex() method will throw a LexicalException */
%scanerror LexicalException

%unicode

/* Code in the next section is copied into the generated lexer class.
 */
  %{
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java_cup.runtime.Symbol;
private static final Set<String> keywords = new HashSet<>();

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
    }

    private boolean isKeyword(String text) {
        return keywords.contains(text);
    }

In this code, I've used a static initializer block to initialize the keywords set with the keywords you provided. The isKeyword method checks if the input text is present in the set using the contains method, which is an efficient way to determine membership in a set. The code works the same way as your original code but with improved efficiency for keyword lookup.







public enum TokenType {
        ID, NUM, CLASS, INT, BOOLEAN, VOID, IF, ELSE, WHILE, FOR, RETURN, TRUE, FALSE,
        BREAK, CONTINUE, SUMA, RESTA, MULTI, DIV, MOD, ASIG, EQUALS, NOTEQUALS,
        LESSTHAN, MORETHAN, LESSEQUALS, MOREEQUALS, AND, OR, NOT, PIZ, PDER, CIZ,
        CDER, LIZ, LDER, PUNTOCOMA, COMA, SCOMMENT, STRING, CHAR, SUMEQUAL, MINUSEQUAL,
        MULTEQUAL, DIVEQUAL, CALLOUT, HEXA, ERROR
}

public int currentCol;
public int currentRow;

private static final Map<String, Integer> keywordToTokenType = new HashMap<>();
    static {
        keywordToTokenType.put("if", TokenType.IF);
        keywordToTokenType.put("while", TokenType.WHILE);
        keywordToTokenType.put("int", TokenType.INT);
        keywordToTokenType.put("class", TokenType.CLASS);
        keywordToTokenType.put("boolean", TokenType.BOOLEAN);
        keywordToTokenType.put("void", TokenType.VOID);
        keywordToTokenType.put("else", TokenType.ELSE);
        keywordToTokenType.put("for", TokenType.FOR);
        keywordToTokenType.put("return", TokenType.RETURN);
        keywordToTokenType.put("true", TokenType.TRUE);
        keywordToTokenType.put("false", TokenType.FALSE);
        keywordToTokenType.put("break", TokenType.BREAK);
        keywordToTokenType.put("continue", TokenType.CONTINUE);
        keywordToTokenType.put("callout", TokenType.CALLOUT);
    }

    private TokenType getKeywordTokenType(String keyword) {
        return keywordToTokenType.getOrDefault(keyword, TokenType.ID);
    }
%}

/* Here we define some macros, which are abbriviations for regular expressions.
 */

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

/* NOT VALID ASSIGNEMNT IDENTIFIERS!!!! CHANGE ME!!!! */
Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = [0-9]


%%

/* Now we define keywords in our grammar
 * When the input string matches the regex on the left the action on the right
 * is performed. The action is java code. The regex matches longest match by
 * default. The lexer starts in the <YYINITIAL> state.
 */
  \n {
    currentRow++;
    currentCol = 1;
  }
  [-+]?[0-9]+                   {
                                    currentCol++;
                                    return new Token(TokenType.NUM, currentRow, currentCol, Integer.parseInt(yytext()));
                                }
  0x[0-9a-fA-F]+                {
                                    currentCol++;
                                    return new Token(TokenType.HEXA, currentRow, currentCol, yytext());
                                }
  [a-zA-Z]                      {
                                    currentCol++;
                                    return new Token(TokenType.CHAR, currentRow, currentCol, yytext());
                                }
  \"[^\"]*\"                    {
                                    currentCol++;
                                    return new Token(TokenType.STRING, currentRow, currentCol, yytext());
                                }


  [a-zA-Z_][a-zA-Z0-9_]* {
    // Check if the matched text is a keyword or a variable
    String lexeme = yytext();
    if (isKeyword(lexeme)) {
        currentCol++;
        return new Token(getKeywordTokenType(lexeme), currentRow, currentCol,lexeme);
    } else {
        currentCol++;
        return new Token(TokenType.ID, currentRow, currentCol,lexeme);
    }
}
<YYINITIAL> {

  /* whitespace */
  {WhiteSpace}                   { currentCol++; }

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

}

/* error fallback */
[^]                             {
                                    currentCol++;
                                    return new Token(TokenType.ERROR, currentRow, currentCol, yytext());
                                }
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
private boolean isKeyword(String text) {
    String[] keywords = {"class", "while", "int", "if", "else", "break", "boolean", "void", "for", "return", "true", "false", "continue","callout"};
    for (String keyword : keywords) {
        if (keyword.equals(text)) {
            return true;
        }
    }
    return false;
}

public enum TokenType {
        ID, NUM, CLASS, INT, BOOLEAN, VOID, IF, ELSE, WHILE, FOR, RETURN, TRUE, FALSE,
        BREAK, CONTINUE, SUMA, RESTA, MULTI, DIV, MOD, ASIG, EQUALS, NOTEQUALS,
        LESSTHAN, MORETHAN, LESSEQUALS, MOREEQUALS, AND, OR, NOT, PIZ, PDER, CIZ,
        CDER, LIZ, LDER, PUNTOCOMA, COMA, SCOMMENT, STRING, CHAR, SUMEQUAL, MINUSEQUAL,
        MULTEQUAL, DIVEQUAL, CALLOUT, HEXA, ERROR
}

public int currentCol;
public int currentRow;

private int getKeywordTokenType(String keyword) {
     // Define mappings from keywords to token types here
    if (keyword.equals("if")) {
        return TokenType.IF;
    } else if (keyword.equals("while")) {
        return TokenType.WHILE;
    } else if (keyword.equals("int")) {
        return TokenType.INT;
    } else if (keyword.equals("class")) {
        return TokenType.CLASS;
    } else if (keyword.equals("boolean")) {
        return TokenType.BOOLEAN;
    } else if (keyword.equals("void")) {
        return TokenType.VOID;
    } else if (keyword.equals("else")) {
        return TokenType.ELSE;
    } else if (keyword.equals("for")) {
        return TokenType.FOR;
    } else if (keyword.equals("return")) {
        return TokenType.RETURN;
    } else if (keyword.equals("true")) {
        return TokenType.TRUE;
    } else if (keyword.equals("false")) {
        return TokenType.FALSE;
    } else if (keyword.equals("break")) {
        return TokenType.BREAK;
    } else if (keyword.equals("continue")) {
        return TokenType.CONTINUE;
    } else if (keyword.equals("if")) {
        return TokenType.IF;
    } else if (keyword.equals("callout")) {
        return TokenType.CALLOUT;
    }    

    return 0; //return null for unrecognized keywords
    
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

/* Now we define keywords in our grammer
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
  [0-9][a-zA-Z0-9_]*            {
                                    currentCol++;  
                                    return new Token(TokenType.ERROR, currentRow, currentCol, yytext());
                                }

  [a-zA-Z_][a-zA-Z0-9_]* {
    // Check if the matched text is a keyword or a variable
    String lexeme = yytext();
    if (isKeyword(lexeme)) {
        currentCol++;  
        return new Token(getKeywordTokenType(lexeme), currentRow, currentCol,lexeme);
    } else {
        currentCol++;  
        return new Token(Token.ID, currentRow, currentCol,lexeme);
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
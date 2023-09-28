%%

%class Scanner
%type Token
%cup

%{
  
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = [0-9]

%state STRING

%%

<YYINITIAL> {
  /* Identificadores */
  {Identifier}                   { return new Token(sym.ID, yytext()); }
  /* Utiliza un macro para reconocer enteros */
  {DecIntegerLiteral}            { return new Token(sym.INT, Integer.parseInt(yytext())); }

  /* Espacios en blanco */
  {WhiteSpace}                   { /* Ignorar */ }
}

/* Manejo de errores */
[^]                              { throw new LexicalException("Carácter no válido <" +
                                                    yytext() + ">"); }

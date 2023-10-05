enum TokenType {
    ID, NUM, CLASS, INT, BOOLEAN, VOID, IF, ELSE, WHILE, FOR, RETURN, TRUE, FALSE,
    BREAK, CONTINUE, SUMA, RESTA, MULTI, DIV, MOD, ASIG, EQUALS, NOTEQUALS,
    LESSTHAN, MORETHAN, LESSEQUALS, MOREEQUALS, AND, OR, NOT, PIZ, PDER, CIZ,
    CDER, LIZ, LDER, PUNTOCOMA, COMA, SCOMMENT, STRING, CHAR, SUMEQUAL, MINUSEQUAL,
    MULTEQUAL, DIVEQUAL, CALLOUT, HEXA, ERROR
}

class Token {
    TokenType tag;
    int row;
    int col;
    Object value;

    Token(TokenType t, int row, int col, Object v) {
        this.tag = t;
        this.row = row;
        this.col = col;
        this.value = v;
    }

    public String displayToken() {
        return "\nToken TAG: " + this.tag + "\nValue: " + this.value + "\nFound in line " + this.row + " column " + this.col + "\n";
    }

    public String displayErrors() {
        return "\nValue: " + this.value + "\nError found in line " + this.row + " column " + this.col + "\n";
    }
}



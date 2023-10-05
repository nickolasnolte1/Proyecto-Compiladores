public class Token {


    public GeneratedLexer.TokenType tag;
    private int row;
    private int col;
    private Object value;
    public String targetToken;

    // public Token(GeneratedLexer.TokenType tag, int row, int col, Object value) {
    //     this.tag = tag;
    //     this.row = row;
    //     this.col = col;
    //     this.value = value;
    // }

    public Token(GeneratedLexer.TokenType id, int currentRow, int currentCol, String lexeme) {
        this.tag = id;
        this.row = currentRow;
        this.col = currentCol;
        this.value = lexeme;
    }


    public String displayToken() {
        return "\nToken TAG: " + this.tag + "\nValue: " + this.value + "\nFound in line " + this.row + " column " + this.col + "\n";
    }

    public String displayErrors() {
        return "\nValue: " + this.value + "\nError found in line " + this.row + " column " + this.col + "\n";
    }
}



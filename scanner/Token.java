public class Token {


    public GeneratedLexer.TokenType tag;
    private int row;
    private int col;
    private Object value;
    public String targetToken;

    public Token(GeneratedLexer.TokenType id, int currentRow, int currentCol, String lexeme) {
        this.tag = id;
        this.row = currentRow;
        this.col = currentCol;
        this.value = lexeme;
    }


    public String displayToken() {
        StringBuilder sb = new StringBuilder();
        sb.append("Token Information:\n");
        sb.append("Tag: ").append(this.tag).append("\n");
        sb.append("Value: ").append(this.value).append("\n");
        sb.append("Location: Line ").append(this.row).append(", Column ").append(this.col).append("\n");
        return sb.toString();
    }

    public String displayErrors() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error Information:\n");
        sb.append("Value: ").append(this.value).append("\n");
        sb.append("Location: Line ").append(this.row).append(", Column ").append(this.col).append("\n");
        return sb.toString();
    }
    
}



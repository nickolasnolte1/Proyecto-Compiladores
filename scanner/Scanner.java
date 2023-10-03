import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


class ErrorProcessor {
    public void printErrores(LinkedList<Token> Errores) {
        for (Token token : Errores) {
            System.out.println(token.displayErrors());
        }
    }
}

class TokenProcessor {
    public void printTokens(LinkedList<Token> Tokens) {
        for (Token token : Tokens) {
            System.out.println(token.displayToken());
        }
    }
}

public class Scanner {
    public static void main(String[] args) throws IOException {
    LinkedList <Token> Tokens = new LinkedList<>();
    LinkedList <Token> Errores = new LinkedList<>();
    GeneratedLexer lexer = new GeneratedLexer(new BufferedReader(new FileReader("input.txt")));
    Token token;
    try{
        while ((token = lexer.yylex()) != null) {
            if (token.tag == 48) {
                Errores.add(token);
            }
            else {
                Tokens.add(token);
            }
        } 
    } catch (LexicalException l){
        System.out.println(l);
    }
    TokenProcessor tokenProcessor = new TokenProcessor();
    ErrorProcessor errorprocessor = new ErrorProcessor();

    tokenProcessor.printTokens(Tokens);
    errorprocessor.printErrores(Errores);
    }
}

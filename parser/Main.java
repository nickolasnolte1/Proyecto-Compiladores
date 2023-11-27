import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            GeneratedLexer lexer = new GeneratedLexer(new BufferedReader(new FileReader("/Users/estebansamayoa/Documents/GitHub/Proyecto-Compiladores/parser/input.txt")));

            parser myparser = new parser(lexer);
            myparser.parse();

            System.out.println("Parsing completed!");
        } catch (Exception e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}
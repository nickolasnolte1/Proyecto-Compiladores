import java.io.BufferedReader;
import java.io.FileReader;
import java_cup.runtime.*;

public class Main {
    public static void main(String[] args) {
        try {
            GeneratedLexer lexer = new GeneratedLexer(new BufferedReader(new FileReader("input.txt")));

            parser myparser = new parser(lexer);

            myparser.parse();

            System.out.println("Parsing completed successfully.");
        } catch (Exception e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}
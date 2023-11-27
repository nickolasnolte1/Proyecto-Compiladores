import java.io.BufferedReader;
import java.io.FileReader;
import java_cup.runtime.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Create an instance of the lexer
            GeneratedLexer lexer = new GeneratedLexer(new BufferedReader(new FileReader("input.txt")));

            // Create an instance of the parser
            parser myparser = new parser(lexer);

            // Start the parsing process
            myparser.parse();

            System.out.println("Parsing completed successfully.");
        } catch (Exception e) {
            System.err.println("Parsing error: " + e.getMessage());
        }
    }
}
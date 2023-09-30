import compiler.scanner.*;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo de entrada para el scanner
        String inputFile = "input.txt"; // Reemplaza con la ruta de tu archivo de entrada

        try {
            // Inicializa el scanner con el archivo de entrada
            Scanner scanner = new Scanner(new java.io.FileReader(inputFile));

            // Itera a través de los tokens producidos por el scanner
            Token token;
            while ((token = scanner.yylex()) != null) {
                // Maneja el token aquí
                System.out.println("Tipo: " + token.getType() + ", Valor: " + token.getValue());
            }

            // Cierra el scanner al finalizar
            scanner.yyclose();
        } catch (Exception e) {
            // Maneja las excepciones, por ejemplo, errores de archivo no encontrado
            e.printStackTrace();
        }
    }
}

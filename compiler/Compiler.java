package compiler;

public class Compiler {
    public static void main(String[] args) {
        // Declarar variables para almacenar opciones y valores
        String inputFile = null;
        String outputFileName = null;
        String targetStage = "codegen"; // Valor por defecto
        String optimizationStage = null;
        String debugStage = null;

        // Iterar a través de los argumentos de línea de comandos
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-o":
                    // Especificar el nombre del archivo de salida
                    outputFileName = args[++i];
                    break;
                case "-target":
                    // Definir la etapa de compilación deseada
                    targetStage = args[++i];
                    break;
                case "-opt":
                    // Realizar una optimización específica
                    optimizationStage = args[++i];
                    break;
                case "-debug":
                    // Activar el modo de depuración para una etapa
                    debugStage = args[++i];
                    break;
                case "-h":
                    // Mostrar la ayuda y salir
                    printHelp();
                    return;
                default:
                    // El argumento es el nombre del archivo de entrada
                    inputFile = arg;
                    break;
            }
        }

        // Lógica para la compilación según los argumentos proporcionados
        // Implementa la invocación de las clases de análisis y generación de código aquí
    }

    // Función para imprimir la ayuda
    private static void printHelp() {
        System.out.println("Uso: java compiler [option] <filename>");
        System.out.println("Opciones:");
        System.out.println("-o <outname>: Especifica el nombre del archivo de salida.");
        System.out.println("-target <stage>: Define la etapa de compilación deseada (scan, parse, ast, semantic, irt, codegen).");
        System.out.println("-opt <opt_stage>: Realiza una optimización específica (constant, algebraic).");
        System.out.println("-debug <stage>: Activa el modo de depuración para una o varias etapas de compilación.");
        System.out.println("-h: Muestra esta ayuda.");
    }
}

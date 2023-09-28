# Proyecto-Compiladores

# Proyecto de Compiladores - Decaf Compiler

Este proyecto es un compilador para el lenguaje Decaf, implementado en Java. El compilador se divide en varias etapas, incluyendo el análisis léxico (scanner), análisis sintáctico (parser), análisis semántico, generación de código intermedio y generación de código de máquina.

## Estructura de Archivos y Paquetes

La estructura de archivos y paquetes del proyecto se organiza de la siguiente manera:

/ # Directorio raíz del proyecto
/class # Directorio para las clases compiladas
/compiler # Paquete principal del compilador
Compiler.java # Clase principal del CLI
/scanner # Paquete para el análisis léxico
Scanner.java # Implementación del scanner
/parser # Paquete para el análisis sintáctico
Parser.java # Implementación del parser
/ast # Paquete para el árbol de sintaxis abstracta
Ast.java # Implementación del árbol de sintaxis abstracta
/semantic # Paquete para el análisis semántico
Semantic.java # Implementación del análisis semántico
/irt # Paquete para la representación de código intermedio
Irt.java # Implementación de la generación de código intermedio
/opt # Paquete para las optimizaciones
Algebraic.java # Implementación de la optimización algebraica
ConstantF.java # Implementación de la optimización de constantes
/codegen # Paquete para la generación de código de máquina
Codegen.java # Implementación de la generación de código de máquina


## Uso del CLI (Interfaz de Línea de Comandos)

Para compilar y ejecutar el compilador, utiliza el siguiente comando en la línea de comandos:

```bash
java compiler [option] <filename>

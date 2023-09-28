# Proyecto-Compiladores

# Proyecto de Compiladores - Decaf Compiler

Este proyecto es un compilador para el lenguaje Decaf, implementado en Java. El compilador se divide en varias etapas, incluyendo el análisis léxico (scanner), análisis sintáctico (parser), análisis semántico, generación de código intermedio y generación de código de máquina.

## Estructura de Archivos y Paquetes

La estructura de archivos y paquetes del proyecto se organiza de la siguiente manera:

```
/ 

/class 

/compiler 
    Compiler.java 

/scanner 
    Scanner.java 

/parser 
    Parser.java 

/ast 
    Ast.java 

/semantic 
    Semantic.java 

/irt 
    Irt.java 

/opt 
    Algebraic.java 
    ConstantF.java 

/codegen 
    Codegen.java 

```


## Uso del CLI

Para compilar y ejecutar el compilador, utiliza el siguiente comando en la línea de comandos:

```bash
java compiler [option] <filename>
```
### Opciones Disponibles:
-o <outname>: Especifica el nombre del archivo de salida.

-target <stage>: Define la etapa de compilación deseada (scan, parse, ast, semantic, irt, codegen).

-opt <opt_stage>: Realiza una optimización específica (constant, algebraic).

-debug <stage>: Activa el modo de depuración para una o varias etapas de compilación.
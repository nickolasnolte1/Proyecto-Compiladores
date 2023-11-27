package semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.HashMap;
import java.util.Map;

public class Semantic implements ParseTreeListener {
    private Map<String, String> symbolTable;

    public Semantic() {
        this.symbolTable = new HashMap<>();
    }

    @Override
    public void enterVariableDeclaration(MyParser.VariableDeclarationContext ctx) {
        String variableName = ctx.ID().getText();
        String variableType = ctx.TYPE().getText();

        // Realizar análisis semántico para la declaración de variables
        // Verificar si la variable ya está declarada en la tabla de símbolos
        if (symbolTable.containsKey(variableName)) {
            System.out.println("Error: Variable " + variableName + " ya está declarada");
        } else {
            symbolTable.put(variableName, variableType);
        }
    }

    @Override
    public void enterAssignment(MyParser.AssignmentContext ctx) {
        String variableName = ctx.ID().getText();
        String assignedType = getTypeOfExpression(ctx.expression());

        // Realizar análisis semántico para las asignaciones
        // Verificar si la variable está declarada y si los tipos son compatibles
        if (!symbolTable.containsKey(variableName)) {
            System.out.println("Error: Variable " + variableName + " no está declarada");
        } else {
            String variableType = symbolTable.get(variableName);
            if (!variableType.equals(assignedType)) {
                System.out.println("Error: Tipos incompatibles al asignar a la variable " + variableName);
            }
        }
    }

    // Método para obtener el tipo de una expresión en una asignación
    private String getTypeOfExpression(MyParser.ExpressionContext expressionContext) {
        // Lógica para determinar el tipo de la expresión
        if (expressionContext.INTEGER() != null) {
            return "int";
        } else if (expressionContext.ID() != null) {
            String variableName = expressionContext.ID().getText();
            if (symbolTable.containsKey(variableName)) {
                return symbolTable.get(variableName);
            } else {
                System.out.println("Error: Variable " + variableName + " no está declarada");
                return "undefined";
            }
        } else {
            // Otras lógicas para manejar operadores, llamadas a funciones, etc.
            System.out.println("Error: Tipo de expresión no reconocido");
            return "undefined";
        }
    }

    // Otros métodos enter para diferentes reglas gramaticales según sea necesario

    // Puedes agregar más métodos según sea necesario para otros nodos del árbol de derivación
}

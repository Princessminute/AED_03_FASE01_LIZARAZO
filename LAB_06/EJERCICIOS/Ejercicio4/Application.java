package LAB_06.EJERCICIOS.Ejercicio4;
import LAB_06.EJERCICIOS.Ejercicio1.*;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class Application {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>(); //Pila

        System.out.println("\n Iniciando análisis detallado de la cadena: \"" + s + "\"");

        int paso = 1;

        for (char ch : s.toCharArray()) {
            System.out.println("\nPaso " + paso++ + ": Leyendo símbolo '" + ch + "'");

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("→ Es un símbolo de apertura. Se apila '" + ch + "'"); 
                stack.print();
            } else if (ch == ')' || ch == ']' || ch == '}') {
                System.out.println("→ Es un símbolo de cierre. Se intentará desapilar");
                if (stack.isEmpty()) {
                    System.out.println(" ERROR: La pila está vacía. No hay símbolo de apertura para '" + ch + "'");
                    return false;
                }

                char top;
                try {
                    top = stack.pop();
                    System.out.println("→ Se desapiló '" + top + "'"); 
                } catch (ExceptionIsEmpty e) {
                    System.out.println(" ERROR inesperado: " + e.getMessage());
                    return false;
                }

                if (!matches(top, ch)) {
                    System.out.println(" ERROR: Se esperaba cerrar '" + top + "', pero se encontró '" + ch + "'");
                    System.out.println("        Comparación visual: [" + top + ch + "] <= [" + top + ch + "]");
                    return false;
                } else {
                    System.out.println(" Correcto: '" + top + "' empareja con '" + ch + "'");
                    System.out.println("        Comparación visual: [" + top + ch + "] <= [" + top + ch + "]");
                    stack.print();
                }                
            } else {
                System.out.println("ℹ Carácter ignorado (no es símbolo de agrupación): '" + ch + "'");
            }
        }

        if (stack.isEmpty()) {
            System.out.println("\n FIN DEL ANÁLISIS: La cadena está balanceada correctamente.");
            return true;
        } else {
            System.out.println("\n FIN DEL ANÁLISIS: Hay símbolos de apertura sin cerrar.");
            stack.print();
            return false;
        }
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}

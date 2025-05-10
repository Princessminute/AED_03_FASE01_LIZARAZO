package LAB_06.ACTIVIDADES.ACT_1;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("===== PILA DE ENTEROS =====");
            Stack<Integer> pilaEnteros = new StackArray<>(5);
            System.out.println("Agregando 100 a la pila");
            pilaEnteros.push(100);
            System.out.println("Agregando 200 a la pila");
            pilaEnteros.push(200);
            System.out.println("Agregando 300 a la pila");
            pilaEnteros.push(300);
            System.out.println("Estado actual de la pila: " + pilaEnteros);
            System.out.println("Elemento en la cima (top): " + pilaEnteros.top());
            System.out.println("Eliminando el elemento del tope");
            pilaEnteros.pop();
            System.out.println("Estado de la pila después de hacer pop(): " + pilaEnteros);

            System.out.println("\n===== PILA DE CADENAS =====");
            Stack<String> pilaCadenas = new StackArray<>(3);
            System.out.println("Agregando 'A' a la pila");
            pilaCadenas.push("A");
            System.out.println("Agregando 'B' a la pila");
            pilaCadenas.push("B");
            System.out.println("Agregando 'C' a la pila");
            pilaCadenas.push("C");
            System.out.println("Estado actual de la pila: " + pilaCadenas);
            System.out.println("Elemento en la cima (top): " + pilaCadenas.top());
            System.out.println("Eliminando el elemento del tope");
            pilaCadenas.pop();
            System.out.println("Agregando 'D' a la pila");
            pilaCadenas.push("D");
            System.out.println("Estado de la pila después de cambios: " + pilaCadenas);

            System.out.println("\n===== PRUEBA DE EXCEPCIÓN (PILA DE DOUBLES) =====");
            Stack<Double> pilaDoubles = new StackArray<>(1);
            System.out.println("Agregando 1.1 a la pila");
            pilaDoubles.push(1.1);
            System.out.println("Eliminando el único elemento");
            pilaDoubles.pop();
            System.out.println("Intentando eliminar otro elemento de una pila vacía");
            pilaDoubles.pop(); 

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error en tiempo de ejecución: " + e.getMessage());
        }
    }
}

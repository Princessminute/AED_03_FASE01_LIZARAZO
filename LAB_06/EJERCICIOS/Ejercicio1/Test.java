package LAB_06.EJERCICIOS.Ejercicio1;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new StackLink<>();
        Stack<String> stackStr = new StackLink<>();

        System.out.println("=== PILA DE ENTEROS ===");
        stackInt.push(10);
        stackInt.push(20);
        stackInt.push(30);
        System.out.print("Estado actual: ");
        stackInt.print();
        try {
            System.out.println("-> Tope actual: " + stackInt.top());
            System.out.println("-> Pop: " + stackInt.pop());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.print("Estado después del pop: ");
        stackInt.print();

        System.out.println("\n=== PILA DE STRINGS ===");
        stackStr.push("Hola");
        stackStr.push("Mundo");
        stackStr.push("Java");
        System.out.print("Estado actual: ");
        stackStr.print();
        try {
            System.out.println("-> Tope actual: " + stackStr.top());
            System.out.println("-> Pop: " + stackStr.pop());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.print("Estado después del pop: ");
        stackStr.print();

        System.out.println("\n=== PILA VACÍA DE DOUBLES ===");
        Stack<Double> stackDbl = new StackLink<>();

        boolean intentoExitoso = false;
        int intentos = 0;

        do {
            try {
                System.out.println("-> Intento " + (intentos + 1) + ": haciendo pop en pila vacía");
                stackDbl.pop(); 
                intentoExitoso = true; 
            } catch (ExceptionIsEmpty e) {
                System.out.println(" Error: " + e.getMessage());
                intentoExitoso = true;
            } finally {
                intentos++;
            }
        } while (!intentoExitoso && intentos < 1);

        System.out.println("-> Pushing 2.1 en la pila Double");
        stackDbl.push(2.1);
        System.out.print("Estado actual de la pila Double: ");
        stackDbl.print();
        try {
            System.out.println("-> Tope actual: " + stackDbl.top());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


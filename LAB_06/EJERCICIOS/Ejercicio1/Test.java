package LAB_06.EJERCICIOS.Ejercicio1;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new StackLink<>();
        Stack<String> stackStr = new StackLink<>();

        try {
            // Integers
            stackInt.push(10);
            stackInt.push(20);
            stackInt.push(30);
            stackInt.print();
            System.out.println("Peek: " + stackInt.peek());
            System.out.println("Pop: " + stackInt.pop());
            stackInt.print();

            // Strings
            stackStr.push("Hola");
            stackStr.push("Mundo");
            stackStr.push("Java");
            stackStr.print();
            System.out.println("Pop: " + stackStr.pop());
            stackStr.print();

            // Prueba vacía
            Stack<Double> stackDbl = new StackLink<>();
            stackDbl.pop(); // Excepción esperada

        } catch (ExcepcionIsEmpty e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}

package LAB_06.EJERCICIOS.Ejercicio2;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Queue<String> cola = new QueueArray<>(5);
        Queue<Integer> colaInt = new QueueArray<>(3);

        System.out.println("===== PRUEBA CON COLA DE STRINGS =====");
        try {
            System.out.println("Encolando elementos A, B, C, D, E");
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            cola.enqueue("D");
            cola.enqueue("E");

            cola.print();
            System.out.println("Frente de la cola: " + cola.front());
            System.out.println("Último elemento (back): " + cola.back());
            System.out.println("¿Está llena? " + cola.isFull());

            System.out.println("\nRealizando dequeue (eliminando un elemento)");
            String eliminado = cola.dequeue();
            System.out.println("Elemento eliminado: " + eliminado);
            cola.print();

            System.out.println("\nEncolando elemento 'F'");
            cola.enqueue("F");
            cola.print();

            System.out.println("Frente actual: " + cola.front());
            System.out.println("Último actual: " + cola.back());
            System.out.println("¿Está llena? " + cola.isFull());
            System.out.println("¿Está vacía? " + cola.isEmpty());

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        System.out.println("\n===== PRUEBA CON COLA DE ENTEROS =====");
        try {
            System.out.println("Encolando 1, 2, 3");
            colaInt.enqueue(1);
            colaInt.enqueue(2);
            colaInt.enqueue(3);
            colaInt.print();

            System.out.println("Frente: " + colaInt.front());
            System.out.println("Último: " + colaInt.back());
            System.out.println("¿Está llena? " + colaInt.isFull());

            System.out.println("\nIntentando encolar '4' en una cola llena");
            colaInt.enqueue(4); 

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

    }
}


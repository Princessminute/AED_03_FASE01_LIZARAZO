package LAB_06.ACTIVIDADES.ACT_3;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("==== PRUEBA 1: Cola de prioridad con tareas (String, Integer) ====");
            PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

            System.out.println("\n[Encolando elementos]");
            System.out.println("Agregando 'Tarea baja' con prioridad 1");
            cola.enqueue("Tarea baja", 1);
            System.out.println("Agregando 'Tarea media' con prioridad 5");
            cola.enqueue("Tarea media", 5);
            System.out.println("Agregando 'Tarea alta' con prioridad 10");
            cola.enqueue("Tarea alta", 10);
            System.out.println("Agregando 'Tarea intermedia' con prioridad 7");
            cola.enqueue("Tarea intermedia", 7);

            System.out.println("\n[Estado actual de la cola de prioridad]");
            System.out.println(cola.toString()); // Muestra el orden por prioridad

            System.out.println("\n[Consultando el frente de la cola]");
            System.out.println("Se espera el elemento con (más urgente): " + cola.front());

            System.out.println("\n[Consultando el final de la cola]");
            System.out.println("Se espera el elemento con (menos urgente): " + cola.back());

            System.out.println("\n[Eliminando el elemento con mayor prioridad (numéricamente MAYOR)]");
            String eliminado = cola.dequeue();
            System.out.println("Elemento eliminado: " + eliminado);

            System.out.println("\n[Estado de la cola luego del dequeue]");
            System.out.println(cola.toString());

            System.out.println("\n¿Está vacía la cola? " + cola.isEmpty());

            System.out.println("\n==== PRUEBA 2: Cola de prioridad con números (Integer, Double) ====");
            PriorityQueue<Integer, Double> colaNumeros = new PriorityQueueLinkSort<>();

            System.out.println("\n[Encolando números enteros con prioridad double]");
            System.out.println("Agregando número 100 con prioridad 2.5");
            colaNumeros.enqueue(100, 2.5);
            System.out.println("Agregando número 200 con prioridad 7.2");
            colaNumeros.enqueue(200, 7.2);
            System.out.println("Agregando número 300 con prioridad 1.1");
            colaNumeros.enqueue(300, 1.1);
            System.out.println("Agregando número 2 con prioridad 7.2");
            colaNumeros.enqueue(2, 7.2);
            System.out.println("Agregando número 2 con prioridad 7.2");
            colaNumeros.enqueue(20, 7.2);
            System.out.println("Agregando número 2 con prioridad 7.2");
            colaNumeros.enqueue(1, 7.2);

            System.out.println("\n[Estado actual de la cola de números]");
            System.out.println(colaNumeros.toString());

            System.out.println("\n[Elemento al frente de la cola de números]: " + colaNumeros.front());
            System.out.println("[Elemento al final de la cola de números]: " + colaNumeros.back());

        } catch (ExceptionIsEmpty e) {
            System.err.println("\n[ERROR] " + e.getMessage());
        }
    }
}
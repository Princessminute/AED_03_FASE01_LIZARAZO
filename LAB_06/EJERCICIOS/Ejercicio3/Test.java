package LAB_06.EJERCICIOS.Ejercicio3;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;
import LAB_06.ACTIVIDADES.ACT_3.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("===== INICIO DE PRUEBAS =====");

        // Creamos una cola de prioridad con 3 niveles: 0 (alta), 1 (media), 2 (baja)
        System.out.println("\nCreamos una cola de prioridad con 3 niveles: 0 (alta), 1 (media), 2 (baja)");
        PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinked<>(3);

        // Encolamos elementos en distintos niveles
        System.out.println("\n--- ENCOLANDO ELEMENTOS ---");

        System.out.println("Encolando 'Tarea A - Baja prioridad' con prioridad 2");
        colaPrioridad.enqueue("Tarea A - Baja prioridad", 2);
        System.out.println("Estado actual de la cola: " + colaPrioridad);

        System.out.println("Encolando 'Tarea B - Alta prioridad' con prioridad 0");
        colaPrioridad.enqueue("Tarea B - Alta prioridad", 0);
        System.out.println("Estado actual de la cola: " + colaPrioridad);

        System.out.println("Encolando 'Tarea C - Media prioridad' con prioridad 1");
        colaPrioridad.enqueue("Tarea C - Media prioridad", 1);
        System.out.println("Estado actual de la cola: " + colaPrioridad);

        System.out.println("Encolando 'Tarea D - Alta prioridad' con prioridad 0");
        colaPrioridad.enqueue("Tarea D - Alta prioridad", 0);
        System.out.println("Estado actual de la cola: " + colaPrioridad);

        // Visualizamos el frente y el final
        try {
            System.out.println("\n--- CONSULTANDO FRONT Y BACK ---");
            System.out.println("Elemento al frente (el que será atendido primero): " + colaPrioridad.front());
            System.out.println("Elemento al final (último en su prioridad): " + colaPrioridad.back());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error al consultar front o back: " + e.getMessage());
        }

        // Desencolar elementos uno por uno
        System.out.println("\n--- DESENCOLANDO ELEMENTOS ---");
        try {
            while (!colaPrioridad.isEmpty()) {
                System.out.println("Atendiendo (dequeue): " + colaPrioridad.dequeue());
                System.out.println("Estado actual de la cola: " + colaPrioridad);
            }
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error al desencolar: " + e.getMessage());
        }

        // Verificamos si está vacía
        System.out.println("\n¿La cola está vacía? " + colaPrioridad.isEmpty());
        System.out.println("===== FIN DE LA PRUEBA =====");
    }
}

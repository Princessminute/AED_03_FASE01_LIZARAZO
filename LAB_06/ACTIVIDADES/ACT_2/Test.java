package LAB_06.ACTIVIDADES.ACT_2;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("===== COLA DE ENTEROS =====");
            Queue<Integer> colaEnteros = new QueueLink<>();
            colaEnteros.enqueue(10);
            colaEnteros.enqueue(20);
            colaEnteros.enqueue(30);
            System.out.println("Cola actual: " + colaEnteros);
            System.out.println("Elemento al frente: " + colaEnteros.front());
            System.out.println("Elemento al final: " + colaEnteros.back());
            colaEnteros.dequeue();
            System.out.println("Cola después de hacer dequeue(): " + colaEnteros);

            System.out.println("\n===== COLA DE CADENAS =====");
            Queue<String> colaCadenas = new QueueLink<>();
            colaCadenas.enqueue("Ana");
            colaCadenas.enqueue("Luis");
            colaCadenas.enqueue("Carlos");
            System.out.println("Cola actual: " + colaCadenas);
            System.out.println("Elemento al frente: " + colaCadenas.front());
            colaCadenas.dequeue();
            System.out.println("Añadiendo un nuevo elemento: ");
            colaCadenas.enqueue("María");
            System.out.println("Cola después de cambios: " + colaCadenas);
            System.out.println("Elemento al final: " + colaCadenas.back());

            System.out.println("\n===== COLA DE DOUBLES =====");
            Queue<Double> colaDoubles = new QueueLink<>();
            colaDoubles.enqueue(3.14);
            System.out.println("Cola actual: " + colaDoubles);
            System.out.println("Desencolando: " + colaDoubles.dequeue());
            System.out.println("Intentando acceder al frente de una cola vacía...");
            colaDoubles.front(); 

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

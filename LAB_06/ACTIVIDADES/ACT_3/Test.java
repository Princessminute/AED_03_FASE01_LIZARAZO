package LAB_06.ACTIVIDADES.ACT_3;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> cola1 = new PriorityQueueLinkSort<>();

        try {
            cola1.enqueue("Correo urgente", 10);
            cola1.enqueue("Correo normal", 5);
            cola1.enqueue("Publicidad", 1);
            cola1.enqueue("Mensaje importante", 8);

            System.out.println("Cola 1: " + cola1);

            System.out.println("Front: " + cola1.front());
            System.out.println("Back: " + cola1.back());

            System.out.println("Dequeue: " + cola1.dequeue());
            System.out.println("Cola 1 tras dequeue: " + cola1);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        PriorityQueue<Integer, Double> cola2 = new PriorityQueueLinkSort<>();

        try {
            cola2.enqueue(100, 3.2);
            cola2.enqueue(50, 7.9);
            cola2.enqueue(200, 1.5);
            cola2.enqueue(150, 4.6);

            System.out.println("Cola 2: " + cola2);

            System.out.println("Front: " + cola2.front());
            System.out.println("Back: " + cola2.back());

            System.out.println("Dequeue: " + cola2.dequeue());
            System.out.println("Cola 2 tras dequeue: " + cola2);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

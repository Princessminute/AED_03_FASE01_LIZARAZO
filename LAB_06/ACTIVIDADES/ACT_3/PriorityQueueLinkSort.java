package LAB_06.ACTIVIDADES.ACT_3;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class PriorityQueueLinkSort<C, N> implements PriorityQueue<C, N> {

    class EntryNode {
        C dato;
        N prioridad;

        EntryNode(C dato, N prioridad) {
            this.dato = dato;
            this.prioridad = prioridad;
        }
    }



    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        first = last = null;
    }

    @Override
    public void enqueue(C x, N pr) {
        EntryNode nuevo = new EntryNode(x, pr);
        Node<EntryNode> nodoNuevo = new Node<>(nuevo);

        if (isEmpty()) {
            first = last = nodoNuevo;
            return;
        }

        Node<EntryNode> dummy = new Node<>(null);
        dummy.next = first;
        Node<EntryNode> ant = dummy;

        // Comparar primero por prioridad (orden descendente: mayor prioridad primero)
        // Si las prioridades son iguales, mantener el orden de inserción
       while (ant.next != null && compare(ant.next.data.prioridad, pr) >= 0) // Cambié el > por >=
            ant = ant.next;


        nodoNuevo.next = ant.next;
        ant.next = nodoNuevo;

        if (nodoNuevo.next == null) last = nodoNuevo; // El último elemento es el de menor prioridad
        first = dummy.next; // El primero es el de mayor prioridad
    }

    @Override
    public C dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía - dequeue");
        C dato = first.data.dato;
        first = first.next;
        if (first == null) last = null;
        return dato;
    }

    @Override
    public C front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía - front");
        return first.data.dato;  // Debería devolver el primero, el de mayor prioridad
    }

    @Override
    public C back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía - back");
        return last.data.dato;   // Debería devolver el último, el de menor prioridad
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // Comparar solo por prioridad
    @SuppressWarnings("unchecked")
    private int compare(N a, N b) {
        return ((Comparable<N>) a).compareTo(b);  // Comparación de prioridades
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[Cola vacía]";

        StringBuilder sb = new StringBuilder("[");
        for (Node<EntryNode> aux = first; aux != null; aux = aux.next) {
            sb.append("(").append(aux.data.dato).append(":").append(aux.data.prioridad).append(")");
            sb.append(aux.next != null ? " => " : "]");
        }
        return sb.toString();
    }
}

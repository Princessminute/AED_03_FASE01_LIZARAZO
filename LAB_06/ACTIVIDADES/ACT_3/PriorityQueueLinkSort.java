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

        while (ant.next != null && compare(ant.next.data.prioridad, pr) > 0)
            ant = ant.next;

        nodoNuevo.next = ant.next;
        ant.next = nodoNuevo;

        if (nodoNuevo.next == null) last = nodoNuevo;
        first = dummy.next;
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
        return first.data.dato;
    }

    @Override
    public C back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía - back");
        return last.data.dato;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @SuppressWarnings("unchecked")
    private int compare(N a, N b) {
        return ((Comparable<N>) a).compareTo(b);
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

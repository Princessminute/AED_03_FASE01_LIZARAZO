package LAB_06.ACTIVIDADES.ACT_2;

public class QueueLink<C> implements Queue<C> {
    private Node<C> primero;
    private Node<C> ultimo;

    public QueueLink() {
        this.primero = this.ultimo = null;
    }

    @Override
    public void enqueue(C x) {
        ultimo = (isEmpty()) 
            ? (primero = new Node<>(x)) 
            : (ultimo.next = new Node<>(x));
    }

    @Override
    public C dequeue() throws ExceptionIsEmpty {
        C dato = front(); // Aprovechamos el método ya implementado
        primero = (primero != null) ? primero.next : null;
        ultimo = (primero == null) ? null : ultimo; // Si se vacía, eliminamos último
        return dato;
    }

    @Override
    public C front() throws ExceptionIsEmpty {
        return (isEmpty()) 
            ? throwEx("Cola vacía - front") 
            : primero.data;
    }

    @Override
    public C back() throws ExceptionIsEmpty {
        return (isEmpty()) 
            ? throwEx("Cola vacía - back") 
            : ultimo.data;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isEmpty() ? "[Cola vacía]" : "[");

        for (Node<C> aux = primero; aux != null; aux = aux.next)
            sb.append(aux.data).append(aux.next != null ? " <= " : "]");

        return sb.toString();
    }

    // Lanzar excepción de forma expresiva
    private C throwEx(String msg) throws ExceptionIsEmpty {
        throw new ExceptionIsEmpty(msg);
    }
}

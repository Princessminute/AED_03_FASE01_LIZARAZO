package LAB_06.EJERCICIOS.Ejercicio3;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;
import LAB_06.ACTIVIDADES.ACT_2.*;
import LAB_06.ACTIVIDADES.ACT_3.*;

public class PriorityQueueLinked<C, N extends Number> implements PriorityQueue<C, N> {
    private QueueLink<C>[] colas;
    private int niveles;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int niveles) {
        this.niveles = niveles;
        this.colas = new QueueLink[niveles];
        for (int i = 0; i < niveles; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(C x, N pr) {
        int p = pr.intValue();
        if (p < 0 || p >= niveles) throw new IllegalArgumentException("Prioridad fuera de rango.");
        colas[p].enqueue(x);
    }

    @Override
    public C dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public C front() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].front();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public C back() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return colas[i].back();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public boolean isEmpty() {
        for (QueueLink<C> cola : colas) {
            if (!cola.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PriorityQueueLinked:\n");
        for (int i = 0; i < niveles; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(colas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}

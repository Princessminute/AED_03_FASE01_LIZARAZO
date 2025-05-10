package LAB_06.ACTIVIDADES.ACT_3;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public interface PriorityQueue <C,N> {
    void enqueue (C x, N pr);
    C dequeue() throws ExceptionIsEmpty;
    C front() throws ExceptionIsEmpty;
    C back() throws ExceptionIsEmpty;
    boolean isEmpty();
}

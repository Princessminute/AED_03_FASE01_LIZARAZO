package LAB_06.ACTIVIDADES.ACT_2;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public interface Queue <C> {
    void enqueue (C x);
    C dequeue() throws ExceptionIsEmpty;
    C front() throws ExceptionIsEmpty;
    C back() throws ExceptionIsEmpty;
    boolean isEmpty();
}

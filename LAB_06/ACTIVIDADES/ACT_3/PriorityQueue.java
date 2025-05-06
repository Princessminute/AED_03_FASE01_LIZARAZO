package LAB_06.ACTIVIDADES.ACT_3;

public interface PriorityQueue <C,N> {
    void enqueue (C x, N pr);
    C dequeue() throws ExceptionIsEmpty;
    C front() throws ExceptionIsEmpty;
    C back() throws ExceptionIsEmpty;
    boolean isEmpty();
}

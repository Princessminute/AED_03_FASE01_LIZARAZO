package LAB_06.EJERCICIOS.Ejercicio2;

public interface Queue<T> {
    void enqueue(T data) throws ExcepcionIsEmpty;
    T dequeue() throws ExcepcionIsEmpty;
    T front() throws ExcepcionIsEmpty;
    boolean isEmpty();
    boolean isFull();
    void print();
}


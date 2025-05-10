package LAB_06.EJERCICIOS.Ejercicio2;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public interface Queue<T> {
    void enqueue(T data) throws ExceptionIsEmpty;
    T dequeue() throws ExceptionIsEmpty;
    T front() throws ExceptionIsEmpty;
    T back() throws ExceptionIsEmpty;
    boolean isEmpty();
    boolean isFull();
    void print();
}


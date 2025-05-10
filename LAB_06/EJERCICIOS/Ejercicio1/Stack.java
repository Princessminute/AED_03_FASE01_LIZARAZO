package LAB_06.EJERCICIOS.Ejercicio1;

public interface Stack<T> {
    void push(T data);
    T pop() throws ExcepcionIsEmpty;
    T peek() throws ExcepcionIsEmpty;
    boolean isEmpty();
    void print(); // Método personalizado para impresión
}


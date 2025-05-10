package LAB_06.EJERCICIOS.Ejercicio1;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public interface Stack<T> {
    void push(T data);
    T pop() throws ExceptionIsEmpty;
    T top() throws ExceptionIsEmpty; 
    boolean isEmpty(); 
    void print(); //AÑADIMOS ESTO PARA QUE HAYA NECESIDAD DE LA IMPRESIÓN
}


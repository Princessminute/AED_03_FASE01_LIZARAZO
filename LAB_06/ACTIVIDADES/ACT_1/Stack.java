package LAB_06.ACTIVIDADES.ACT_1;

public interface Stack<C>{
    void push (C x);
    C pop() throws ExceptionIsEmpty;
    C top() throws ExceptionIsEmpty;
    boolean isEmpty();
}

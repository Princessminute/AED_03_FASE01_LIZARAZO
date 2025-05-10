package LAB_06.EJERCICIOS.Ejercicio1;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;

    @Override
    public void push(T data) {
        // Insertamos en el tope, que apunta hacia el nodo anterior (no siguiente)
        top = new Node<>(data, top);
    }

    @Override
    public T pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía");
        T data = top.data;
        top = top.previous;
        return data;
    }

    @Override
    public T top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía");
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void print() {
        System.out.print("Pila: ");
        recursivePrint(top);
        System.out.println();
    }

    private void recursivePrint(Node<T> node) {
        if (node == null) return;
        recursivePrint(node.previous);
        System.out.print("[" + node.data + "] ");
    }
}

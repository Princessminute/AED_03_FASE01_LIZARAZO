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
        top = top.previous; //Pila
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
        System.out.print("Estado actual de la pila (de base a cima): ");
        StringBuilder builder = new StringBuilder();
    Node<T> current = top;
    while (current != null) {
        builder.insert(0, "[ " + current.data + " ] <= ");
        current = current.previous;
    }
    if (builder.length() > 0) {
        builder.setLength(builder.length() - 5); // Quitar la última flecha "<= "
        System.out.println(builder.toString());
    } else {
        System.out.println("[ vacía ]");
    }
}

    private void recursivePrint(Node<T> node) {
        if (node == null) return;
        recursivePrint(node.previous);
        System.out.print("[" + node.data + "] ");
    }
}

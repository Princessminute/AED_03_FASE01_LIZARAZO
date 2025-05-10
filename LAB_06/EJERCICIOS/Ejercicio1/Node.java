package LAB_06.EJERCICIOS.Ejercicio1;

public class Node<T> {
    T data;
    Node<T> previous;

    public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
    }
}

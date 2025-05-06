package LAB_06.ACTIVIDADES.ACT_2;

public class Node<C> {
    C data;
    Node<C> next;

    public Node(C data) {
        this.data = data;
        this.next = null;
    }
}

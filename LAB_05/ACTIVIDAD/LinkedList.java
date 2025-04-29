package LAB_05.ACTIVIDAD;

public class LinkedList<C> {
    private Node<C> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(C data) {
        Node<C> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(C data) {
        Node<C> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<C> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int count() {
        return size;
    }

    public void printIsEmpty() {
        System.out.println(isEmpty() ? "La lista está vacía" : "La lista tiene elementos");
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            Node<C> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

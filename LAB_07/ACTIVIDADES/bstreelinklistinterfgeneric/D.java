package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

class LinkedQueue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) { this.data = data; }
    }

    private Node<E> front, rear;
    private int size = 0;

    public void enqueue(E item) {
        Node<E> node = new Node<>(item);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = node;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        E item = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}

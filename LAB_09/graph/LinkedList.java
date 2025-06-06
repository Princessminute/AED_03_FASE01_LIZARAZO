package LAB_09.graph;

public class LinkedList<C> {
    private Node<C> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(C data) {
        Node<C> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
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
    }

    // Cuenta los elementos recorriendo la lista
    public int count() {
        int count = 0;
        Node<C> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
/* 
    // Método recursivo para contar los elementos
    public int count() {
        return countNodes(head);
    }

    // Método auxiliar recursivo
    private int countNodes(Node<C> current) {
        if (current == null) {
            return 0;
        }
        return 1 + countNodes(current.next);
    }
*/
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



    //DESDE AQUI EMPIEZA PARA GRAFOS
    public boolean search(){
        return false;
    }



    

    //AQUI TERMINA PARA GRAFOS




    // Clase lógica de soporte Node
    // El usuario final no la ve
    private static class Node<C> {
        C data;
        Node<C> next;

        Node(C data) {
            this.data = data;
            this.next = null;
        }
    }

}

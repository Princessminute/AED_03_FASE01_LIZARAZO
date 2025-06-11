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
   public int search(C x) {
    int index = 0;
    Node<C> current = head;
    while (current != null) {
        if (current.data.equals(x)) {
            return index;
        }
        current = current.next;
        index++;
    }
    return -1;
}


    public C getElement(C x) {
    Node<C> current = head;
    while (current != null) {
        if (current.data.equals(x)) {
            return current.data;
        }
        current = current.next;
    }
    return null;
}



    public C insert(C x) {
    addLast(x); // O addFirst(x), según tu diseño
    return x;
}

private Node<C> iterator; // Añade este atributo a la clase

public void reset() {
    iterator = head;
}

public boolean hasNext() {
    return iterator != null;
}

public C next() {
    C data = iterator.data;
    iterator = iterator.next;
    return data;
}

public boolean remove(C x) {
    if (head == null) return false;

    if (head.data.equals(x)) {
        head = head.next;
        return true;
    }

    Node<C> current = head;
    while (current.next != null && !current.next.data.equals(x)) {
        current = current.next;
    }

    if (current.next != null) {
        current.next = current.next.next;
        return true;
    }

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

    public C getFirst() {
    if (head != null)
        return head.data;
    return null;
}

public int size() {
    int count = 0;
    Node<C> current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}
@SuppressWarnings("unused")
private boolean contiene(LinkedList<Vertex<C>> lista, Vertex<C> elemento) {
    lista.reset();
    while (lista.hasNext()) {
        if (lista.next().equals(elemento)) return true;
    }
    return false;
}



}

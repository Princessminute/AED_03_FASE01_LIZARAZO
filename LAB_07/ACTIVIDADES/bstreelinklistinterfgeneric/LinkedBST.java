package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

import LAB_07.ACTIVIDADES.bstreeInterface.*;
import LAB_07.EXCEPTION.*;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("El elemento '" + data + "' ya existe.");
        } else if (cmp < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        return search(root, data);
    }

    private E search(Node node, E data) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El elemento '" + data + "' no se encuentra.");
        }
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            return node.data;
        } else if (cmp < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío.");
        }
        root = delete(root, data);
    }

    private Node delete(Node node, E data) {
        if (node == null) {
            return null;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else { // Element found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

//-----IN-ORDEN--------------------------------------------

    public void mostrarRecorridoInOrden() {
    System.out.println("Recorrido In-Orden del árbol:");
    recorridoInOrden(this.root);
}

private void recorridoInOrden(Node node) {
    if (node != null) {
        System.out.println("Recorrer el subárbol izquierdo en entreorden.");
        recorridoInOrden(node.left);

        System.out.println("Visitar la raíz: " + node.data);

        System.out.println("Recorrer el subárbol derecho en entreorden.");
        recorridoInOrden(node.right);
    } else {
        System.out.println("Vacío");
        }
    }
//-----PRE-ORDEN--------------------------------------------

public void mostrarRecorridoPreOrden() {
    System.out.println("Recorrido Pre-Orden del árbol:");
    recorridoPreOrden(this.root);
}

private void recorridoPreOrden(Node node) {
    if (node != null) {
        System.out.println("Visitar la raíz: " + node.data);

        System.out.println("Recorrer el subárbol izquierdo en preorden.");
        recorridoPreOrden(node.left);

        System.out.println("Recorrer el subárbol derecho en preorden.");
        recorridoPreOrden(node.right);
    } else {
        System.out.println("Vacío");
        }
    }



    public void mostrarRecorridoPostOrden() {
    System.out.println("Recorrido Post-Orden del árbol:");
    recorridoPostOrden(this.root);
}

//-----POST-ORDEN--------------------------------------------

private void recorridoPostOrden(Node node) {
    if (node != null) {
        System.out.println("Recorrer el subárbol izquierdo en postorden.");
        recorridoPostOrden(node.left);

        System.out.println("Recorrer el subárbol derecho en postorden.");
        recorridoPostOrden(node.right);

        System.out.println("Visitar la raíz: " + node.data);
    } else {
        System.out.println("Vacío");
        }
    }


}



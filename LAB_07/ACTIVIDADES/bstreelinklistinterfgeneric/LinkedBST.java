package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

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
        } else { 
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
    toStringHelper(root, sb, 0);
    return sb.toString();
}

private void toStringHelper(Node node, StringBuilder sb, int level) {
    if (node != null) {
        // Lado derecho primero para mostrarlo en árbol visual
        toStringHelper(node.right, sb, level + 1);
        
        // Agregar indentación y el valor del nodo
        sb.append("    ".repeat(level));
        sb.append("- ").append(node.data).append("\n");

        // Lado izquierdo después
        toStringHelper(node.left, sb, level + 1);
    }
}

// ----- IN-ORDEN (nuevo método) -------------------------------------
public String obtenerRecorridoInOrden() {
    StringBuilder sb = new StringBuilder();
    construirInOrden(this.root, sb);
    return sb.toString().trim(); // elimina el último espacio
}

private void construirInOrden(Node node, StringBuilder sb) {
    if (node != null) {
        System.out.println("Entrando al subárbol izquierdo de: " + node.data);
        construirInOrden(node.left, sb);

        System.out.println("Visitando nodo: " + node.data);
        sb.append(node.data).append(" ");

        System.out.println("Entrando al subárbol derecho de: " + node.data);
        construirInOrden(node.right, sb);
    } else {
        System.out.println("Subárbol nulo, retrocediendo...");
    }
}


// ----- PRE-ORDEN (nuevo método) -------------------------------------
public String obtenerRecorridoPreOrden() {
    StringBuilder sb = new StringBuilder();
    construirPreOrden(this.root, sb);
    return sb.toString().trim();
}

private void construirPreOrden(Node node, StringBuilder sb) {
    if (node != null) {
        System.out.println("Visitando nodo: " + node.data);
        sb.append(node.data).append(" ");

        System.out.println("Entrando al subárbol izquierdo de: " + node.data);
        construirPreOrden(node.left, sb);

        System.out.println("Entrando al subárbol derecho de: " + node.data);
        construirPreOrden(node.right, sb);
    } else {
        System.out.println("Subárbol nulo, retrocediendo...");
    }
}


// ----- POST-ORDEN (nuevo método) -------------------------------------
public String obtenerRecorridoPostOrden() {
    StringBuilder sb = new StringBuilder();
    construirPostOrden(this.root, sb);
    return sb.toString().trim();
}

private void construirPostOrden(Node node, StringBuilder sb) {
    if (node != null) {
        System.out.println("Entrando al subárbol izquierdo de: " + node.data);
        construirPostOrden(node.left, sb);

        System.out.println("Entrando al subárbol derecho de: " + node.data);
        construirPostOrden(node.right, sb);

        System.out.println("Visitando nodo: " + node.data);
        sb.append(node.data).append(" ");
    } else {
        System.out.println("Subárbol nulo, retrocediendo...");
    }
}


//-----NUEVOS MÉTODOS-------------------------------------------

@SuppressWarnings("unused")
private E findMinNode(Node node) throws ItemNoFound {
    if (node == null) {
        throw new ItemNoFound("El árbol o subárbol está vacío. No se puede encontrar el mínimo.");
        }

    Node current = node;
    while (current.left != null) {
        current = current.left;
        }

    return search(current.data);
    }

@SuppressWarnings("unused")
private E findMaxNode(Node node) throws ItemNoFound {
    if (node == null) {
        throw new ItemNoFound("El árbol o subárbol está vacío. No se puede encontrar el máximo.");
        }

    Node current = node;
    while (current.right != null) {
        current = current.right;
        }

    return search(current.data);
    }
    
// Método público para obtener el mínimo valor del árbol
public E findMin() throws ItemNoFound {
    return findMinNode(root);
}

// Método público para obtener el máximo valor del árbol
public E findMax() throws ItemNoFound {
    return findMaxNode(root);
}

    //-----EJERCICIOS--------------------------------------------

    //a
    public void destroyNodes() throws ExceptionIsEmpty {
    if (isEmpty()) {
        throw new ExceptionIsEmpty("El árbol está vacío.");
    }
    root = null; // Asigna null a la raíz, el recolector de basura se encargará del resto
}


//b,c
public int countAllNodes() {
    return countNonLeafNodes(root);
}

public int countNodes() {
    return countNonLeafNodes(root);
}

private int countNonLeafNodes(Node node) {
    if (node == null || (node.left == null && node.right == null)) {
        return 0;
    }
    return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
}

//d

public int height(E x) {
    Node current = root;
    while (current != null) {
        int cmp = x.compareTo(current.data);
        if (cmp == 0) {
            return calculateHeightIterative(current);
        } else if (cmp < 0) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    return -1;
}

private int calculateHeightIterative(Node node) {
    if (node == null) return -1;
    
    java.util.LinkedList<Node> queue = new java.util.LinkedList<>();
    queue.add(node);
    int height = -1;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        height++;
        for (int i = 0; i < levelSize; i++) {
            Node temp = queue.poll();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }
    return height;
}

//e
public int amplitude(int nivel) {
    if (root == null) return 0;

    java.util.LinkedList<Node> queue = new java.util.LinkedList<>();
    queue.add(root);
    int currentLevel = 0;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        if (currentLevel == nivel) {
            return levelSize;
        }

        for (int i = 0; i < levelSize; i++) {
            Node temp = queue.poll();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        currentLevel++;
    }

    return 0; 
}

 //-----EJERCICIOS PARTE 02--------------------------------------------

 //A
 public int areaBST() {
    if (isEmpty()) return 0;

    // Usamos cola para recorrido por niveles (nivel por nivel)
    LinkedQueue<Node> queue = new LinkedQueue<>();
    queue.enqueue(root);
    int height = -1;
    int leafCount = 0;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        height++;
        for (int i = 0; i < levelSize; i++) {
            Node current = queue.dequeue();

            if (current.left == null && current.right == null) {
                leafCount++;
            }
            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
    }

    return leafCount * height;
}

//B
public void drawBST() {
    drawBST(root, 0);
}

private void drawBST(Node node, int level) {
    if (node == null) return;

    drawBST(node.right, level + 1);
    System.out.println("  ".repeat(level) + "|-- " + node.data);
    drawBST(node.left, level + 1);
}

//C
public class Prueba {
    public static boolean sameArea(LinkedBST<?> bst1, LinkedBST<?> bst2) {
        return bst1.areaBST() == bst2.areaBST();
    }
}


}



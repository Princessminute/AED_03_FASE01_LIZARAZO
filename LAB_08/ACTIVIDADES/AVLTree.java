package LAB_08.ACTIVIDADES;

import LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric.LinkedBST;
import LAB_07.EXCEPTION.ExceptionIsEmpty;
import LAB_07.EXCEPTION.ItemDuplicated;
import LAB_06.EJERCICIOS.Ejercicio2.QueueArray;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {

    private boolean height;

    protected class NodeAVL extends Node {
        protected int bf; // balance factor

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data + " (bf=" + bf + ")";
        }
    }
/* 
    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL(x);
        }

        int cmp = x.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("El elemento '" + x + "' ya se encuentra en el árbol...");
        }

        if (cmp > 0) { // Inserción a la derecha
            node.right = insert(x, (NodeAVL) node.right);
            if (this.height) {
                switch (node.bf) {
                    case -1:
                        node.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf = 1;
                        this.height = true;
                        break;
                    case 1:
                        node = balanceLeft(node);
                        this.height = false;
                        break;
                }
            }
        } else { // Inserción a la izquierda
            node.left = insert(x, (NodeAVL) node.left);
            if (this.height) {
                switch (node.bf) {
                    case 1:
                        node.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf = -1;
                        this.height = true;
                        break;
                    case -1:
                        node = balanceRight(node);
                        this.height = false;
                        break;
                }
            }
        }
        return node;
    }

    // Rotación simple a la izquierda
    private NodeAVL rotateLeft(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }

    // Rotación simple a la derecha
    private NodeAVL rotateRight(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        return p;
    }
*/

private NodeAVL rotateLeft(NodeAVL node) {
    System.out.println("Ejecutando rotateLeft en nodo " + node.data);
    NodeAVL newRoot = (NodeAVL) node.right;
    node.right = newRoot.left;
    newRoot.left = node;
    return newRoot;
}

private NodeAVL rotateRight(NodeAVL node) {
    System.out.println("Ejecutando rotateRight en nodo " + node.data);
    NodeAVL newRoot = (NodeAVL) node.left;
    node.left = newRoot.right;
    newRoot.right = node;
    return newRoot;
}

@Override
public void insert(E x) throws ItemDuplicated {
    System.out.println("Insertando " + x);
    this.height = false;
    this.root = insert(x, (NodeAVL) this.root);
    System.out.println("Árbol después de insertar " + x + ":");
    drawBST();
    System.out.println("---------------------------------------\n");
}

protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
    if (node == null) {
        this.height = true;
        System.out.println("Nodo " + x + " insertado. (bf=0)");
        return new NodeAVL(x);
    }

    int cmp = x.compareTo(node.data);
    if (cmp == 0) {
        throw new ItemDuplicated("El elemento '" + x + "' ya se encuentra en el árbol...");
    }

    if (cmp > 0) { // Inserción a la derecha
        node.right = insert(x, (NodeAVL) node.right);
        if (this.height) {
            switch (node.bf) {
                case -1:
                    node.bf = 0;
                    this.height = false;
                    System.out.println("Balance en nodo " + node.data + ": bf cambia de -1 a 0, altura estabilizada.");
                    break;
                case 0:
                    node.bf = 1;
                    this.height = true;
                    System.out.println("Balance en nodo " + node.data + ": bf cambia de 0 a 1, altura crece.");
                    break;
                case 1:
                    System.out.println("Desequilibrio detectado en nodo " + node.data + " con bf=1. Aplicando balanceLeft...");
                    node = balanceLeft(node);
                    this.height = false;
                    break;
            }
        }
    } else { // Inserción a la izquierda
        node.left = insert(x, (NodeAVL) node.left);
        if (this.height) {
            switch (node.bf) {
                case 1:
                    node.bf = 0;
                    this.height = false;
                    System.out.println("Balance en nodo " + node.data + ": bf cambia de 1 a 0, altura estabilizada.");
                    break;
                case 0:
                    node.bf = -1;
                    this.height = true;
                    System.out.println("Balance en nodo " + node.data + ": bf cambia de 0 a -1, altura crece.");
                    break;
                case -1:
                    System.out.println("Desequilibrio detectado en nodo " + node.data + " con bf=-1. Aplicando balanceRight...");
                    node = balanceRight(node);
                    this.height = false;
                    break;
            }
        }
    }
    return node;
}

private NodeAVL balanceLeft(NodeAVL node) {
    NodeAVL child = (NodeAVL) node.right;
    if (child.bf == 1) {
        // Rotación simple izquierda (RSL)
        System.out.println("Rotación Simple Izquierda (RSL) en nodo " + node.data);
        node.bf = 0;
        child.bf = 0;
        return rotateLeft(node);
    } else {
        // Rotación doble derecha-izquierda (RDL)
        System.out.println("Rotación Doble Derecha-Izquierda (RDL) en nodo " + node.data);
        NodeAVL grandchild = (NodeAVL) child.left;

        child.left = grandchild.right;
        grandchild.right = child;
        node.right = grandchild.left;
        grandchild.left = node;

        switch (grandchild.bf) {
            case 1:
                node.bf = -1;
                child.bf = 0;
                break;
            case 0:
                node.bf = 0;
                child.bf = 0;
                break;
            case -1:
                node.bf = 0;
                child.bf = 1;
                break;
        }
        grandchild.bf = 0;
        return grandchild;
    }
}

private NodeAVL balanceRight(NodeAVL node) {
    NodeAVL child = (NodeAVL) node.left;
    if (child.bf == -1) {
        // Rotación simple derecha (RSR)
        System.out.println("Rotación Simple Derecha (RSR) en nodo " + node.data);
        node.bf = 0;
        child.bf = 0;
        return rotateRight(node);
    } else {
        // Rotación doble izquierda-derecha (RDR)
        System.out.println("Rotación Doble Izquierda-Derecha (RDR) en nodo " + node.data);
        NodeAVL grandchild = (NodeAVL) child.right;

        child.right = grandchild.left;
        grandchild.left = child;
        node.left = grandchild.right;
        grandchild.right = node;

        switch (grandchild.bf) {
            case -1:
                node.bf = 1;
                child.bf = 0;
                break;
            case 0:
                node.bf = 0;
                child.bf = 0;
                break;
            case 1:
                node.bf = 0;
                child.bf = -1;
                break;
        }
        grandchild.bf = 0;
        return grandchild;
    }
}
 /* 
    // Balanceo cuando el subárbol derecho crece (casos RSL y RDL)
    private NodeAVL balanceLeft(NodeAVL node) {
        NodeAVL child = (NodeAVL) node.right;
        if (child.bf == 1) {
            // Rotación simple izquierda (RSL)
            node.bf = 0;
            child.bf = 0;
            return rotateLeft(node);
        } else {
            // Rotación doble derecha-izquierda (RDL)
            NodeAVL grandchild = (NodeAVL) child.left;

            child.left = grandchild.right;
            grandchild.right = child;
            node.right = grandchild.left;
            grandchild.left = node;

            switch (grandchild.bf) {
                case 1:
                    node.bf = -1;
                    child.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    child.bf = 0;
                    break;
                case -1:
                    node.bf = 0;
                    child.bf = 1;
                    break;
            }
            grandchild.bf = 0;
            return grandchild;
        }
    }

    // Balanceo cuando el subárbol izquierdo crece (casos RSR y RDR)
    private NodeAVL balanceRight(NodeAVL node) {
        NodeAVL child = (NodeAVL) node.left;
        if (child.bf == -1) {
            // Rotación simple derecha (RSR)
            node.bf = 0;
            child.bf = 0;
            return rotateRight(node);
        } else {
            // Rotación doble izquierda-derecha (RDR)
            NodeAVL grandchild = (NodeAVL) child.right;

            child.right = grandchild.left;
            grandchild.left = child;
            node.left = grandchild.right;
            grandchild.right = node;

            switch (grandchild.bf) {
                case -1:
                    node.bf = 1;
                    child.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    child.bf = 0;
                    break;
                case 1:
                    node.bf = 0;
                    child.bf = -1;
                    break;
            }
            grandchild.bf = 0;
            return grandchild;
        }
        
    }

*/

    // EJERCICIO 02

    @Override
public void delete(E data) throws ExceptionIsEmpty {
    if (isEmpty()) {
        throw new ExceptionIsEmpty("El árbol está vacío.");
    }
    this.height = false;
    root = delete((NodeAVL) root, data);
}

private NodeAVL delete(NodeAVL node, E data) {
    if (node == null) {
        return null; // No encontrado, simplemente retornamos null
    }

    int cmp = data.compareTo(node.data);

    if (cmp < 0) {
        node.left = delete((NodeAVL) node.left, data);
        if (this.height) {
            // Eliminación en subárbol izquierdo puede provocar desbalanceo a la derecha
            node = balanceAfterDeleteRight(node);
        }
    } else if (cmp > 0) {
        node.right = delete((NodeAVL) node.right, data);
        if (this.height) {
            // Eliminación en subárbol derecho puede provocar desbalanceo a la izquierda
            node = balanceAfterDeleteLeft(node);
        }
    } else {
        // Nodo encontrado, casos de eliminación:
        if (node.left == null) {
            this.height = true;
            return (NodeAVL) node.right;
        } else if (node.right == null) {
            this.height = true;
            return (NodeAVL) node.left;
        } else {
            // Nodo con dos hijos: reemplazamos con el sucesor mínimo del subárbol derecho
            NodeAVL min = findMin((NodeAVL) node.right);
            node.data = min.data;
            node.right = delete((NodeAVL) node.right, min.data);
            if (this.height) {
                node = balanceAfterDeleteLeft(node);
            }
        }
    }

    return node;
}

private NodeAVL findMin(NodeAVL node) {
    while (node.left != null) {
        node = (NodeAVL) node.left;
    }
    return node;
}

/**
 * Métodos para balancear después de eliminar en subárbol derecho o izquierdo.
 * Aquí debes ajustar los factores de balance y hacer rotaciones si es necesario.
 */

// Balanceo cuando el subárbol derecho pierde un nodo (podría necesitar balance a la izquierda)
private NodeAVL balanceAfterDeleteRight(NodeAVL node) {
    switch (node.bf) {
        case 1:
            node.bf = 0;
            break;
        case 0:
            node.bf = -1;
            this.height = false;
            break;
        case -1:
            NodeAVL leftChild = (NodeAVL) node.left;
            if (leftChild == null) {
                // No hay hijo izquierdo, ajustamos el factor de balance
                // porque el subárbol izquierdo no tiene nodos para rotar
                node.bf = 0;
                this.height = false;
                // Retornamos el nodo sin rotación
                return node;
            }
            if (leftChild.bf <= 0) {
                node = rotateRight(node);
                if (leftChild.bf == 0) {
                    node.bf = 1;
                    ((NodeAVL) node.right).bf = -1;
                    this.height = false;
                } else {
                    node.bf = 0;
                    ((NodeAVL) node.right).bf = 0;
                }
            } else {
                node = balanceRight(node);
            }
            break;
    }
    return node;
}

// Balanceo cuando el subárbol izquierdo pierde un nodo (podría necesitar balance a la derecha)
private NodeAVL balanceAfterDeleteLeft(NodeAVL node) {
    switch (node.bf) {
        case -1:
            node.bf = 0;
            break;
        case 0:
            node.bf = 1;
            this.height = false;
            break;
        case 1:
            NodeAVL rightChild = (NodeAVL) node.right;
            if (rightChild == null) {
                // No hay hijo derecho, no se puede rotar con él
                // Ajustamos el factor de balance y la altura
                node.bf = 0;
                this.height = false;
                return node;
            }
            if (rightChild.bf >= 0) {
                node = rotateLeft(node);
                if (rightChild.bf == 0) {
                    node.bf = -1;
                    ((NodeAVL) node.left).bf = 1;
                    this.height = false;
                } else {
                    node.bf = 0;
                    ((NodeAVL) node.left).bf = 0;
                }
            } else {
                node = balanceLeft(node);
            }
            break;
    }
    return node;
}


//EJERCICIO 03 
public void breadthFirstTraversal() {
    if (root == null) {
        System.out.println("El árbol está vacío.");
        return;
    }
    System.out.println("Iniciando recorrido por amplitud (BFS) con niveles:");

    try {
        QueueArray<Node> queue = new QueueArray<>(100);
        queue.enqueue(root);

        System.out.print("Estado inicial de la cola: ");
        queue.print();

        int nivel = 0;

        while (!queue.isEmpty()) {
            int nodesEnNivel = queue.size();
            System.out.println("\nNivel " + nivel + " (nodos en cola: " + nodesEnNivel + "):");

            for (int i = 0; i < nodesEnNivel; i++) {
                if (queue.isEmpty()) {
                    System.out.println("La cola está vacía antes de terminar el nivel. Abortando.");
                    return;
                }

                Node frontNode = queue.front();
                System.out.println("  Desencolando nodo: " + frontNode.data);
                
                Node current = queue.dequeue();
                System.out.println("  Visitando nodo: " + current.data);

                // Mostrar cola después de desencolar
                System.out.print("  Cola después de desencolar: ");
                queue.print();

                if (current.left != null) {
                    System.out.println("    Nodo " + current.data + " tiene hijo izquierdo: " + current.left.data + " → Encolando.");
                    queue.enqueue(current.left);
                } else {
                    System.out.println("    Nodo " + current.data + " no tiene hijo izquierdo.");
                }

                if (current.right != null) {
                    System.out.println("    Nodo " + current.data + " tiene hijo derecho: " + current.right.data + " → Encolando.");
                    queue.enqueue(current.right);
                } else {
                    System.out.println("    Nodo " + current.data + " no tiene hijo derecho.");
                }

                // Mostrar cola después de encolar hijos
                System.out.print("  Cola después de encolar hijos: ");
                queue.print();
            }
            nivel++;
        }

        System.out.print("\nEstado final de la cola (debe estar vacía): ");
        queue.print();

        System.out.println("\nRecorrido BFS finalizado.");
    } catch (Exception e) {
        System.out.println("Error durante el recorrido: " + e.getMessage());
        e.printStackTrace();
    }
}
@Override
public String obtenerRecorridoPreOrden() {
    System.out.println("Ejecutando recorrido en Preorden para árbol AVL:");
    return super.obtenerRecorridoPreOrden(); // usa el método del BST
}


}


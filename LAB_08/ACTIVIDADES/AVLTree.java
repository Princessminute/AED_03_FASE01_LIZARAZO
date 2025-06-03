package LAB_08.ACTIVIDADES;

import LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric.LinkedBST;
import LAB_07.EXCEPTION.ExceptionIsEmpty;
import LAB_07.EXCEPTION.ItemDuplicated;

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

    
}

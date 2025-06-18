package LAB_10.BTree;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;

        mediana = push(this.root, cl);

        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.addKey(mediana, 0);
            pnew.addChild(this.root, 0);
            pnew.addChild(nDes, 1);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            BNode.SearchResult result = current.searchNode(cl);

            if (result.found()) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }

            E mediana = push(current.childs.get(result.position()), cl);

            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, result.position());
                } else {
                    up = false;
                    putNode(current, mediana, nDes, result.position());
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }

        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : (this.orden / 2 + 1);
        nDes = new BNode<>(this.orden);

        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }

        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;

        if (k <= this.orden / 2) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - posMdna);
        }

        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;

        return median;
    }

    @Override
public String toString() {
    StringBuilder s = new StringBuilder();
    if (isEmpty()) {
        s.append("BTree is empty...\n");
    } else {
        writeTree(this.root, s);
    }
    return s.toString();
}

private void writeTree(BNode<E> current, StringBuilder sb) {
    if (current == null) return;

    // Mostrar claves del nodo
    sb.append("Id.Nodo: ").append(current.idNode).append(" | Claves: (");
    for (int i = 0; i < current.count; i++) {
        sb.append(current.keys.get(i));
        if (i < current.count - 1) sb.append(", ");
    }
    sb.append(")");

    // Mostrar hijos
    sb.append(" | Hijos: [");
    boolean hayHijos = false;
    for (int i = 0; i <= current.count; i++) {
        BNode<E> child = current.childs.get(i);
        if (child != null) {
            if (hayHijos) sb.append(", ");
            sb.append(child.idNode);
            hayHijos = true;
        }
    }
    sb.append("]\n");

    for (int i = 0; i <= current.count; i++) {
        writeTree(current.childs.get(i), sb);
    }
}

}

    

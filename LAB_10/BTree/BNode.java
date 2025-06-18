package LAB_10.BTree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;
    private static int nodeCounter = 0;

    public BNode(int n) {
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n + 1); // n claves → n+1 hijos
        this.count = 0;
        this.idNode = nodeCounter++;

        for (int i = 0; i < n; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i <= n; i++) {
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int maxKeys) {
        return count >= maxKeys;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public SearchResult searchNode(E key) {
        return searchRecursive(key, 0);
    }

    private SearchResult searchRecursive(E key, int index) {
        if (index >= count) {
            return new SearchResult(false, index);
        }

        E currentKey = keys.get(index);
        if (currentKey == null) {
            return new SearchResult(false, index);
        }

        int cmp = key.compareTo(currentKey);
        if (cmp == 0) {
            return new SearchResult(true, index);
        } else if (cmp > 0) {
            return searchRecursive(key, index + 1); // Sigue buscando
        } else {
            return new SearchResult(false, index); // Posición de descenso
        }
    }

    public void addKey(E key, int position) {
        if (position < keys.size()) {
            keys.set(position, key);  // reemplaza un null si ya existe
        } else {
            keys.add(key); // o bien agregamos al final si no está prellenado
        }
        count++;
    }

    public void addChild(BNode<E> child, int position) {
        while (childs.size() <= position) {
            childs.add(null);
        }
        childs.set(position, child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nodo ID ").append(idNode).append(" | Claves descendentes: ");
        for (E key : keys) {
            if (key != null) {
                sb.append(key).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public record SearchResult(boolean found, int position) {}
}



package LAB_10.BTree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;
    private static int nodeCounter = 0; // Para asignar un id único a cada nodo

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

    // Verifica si el nodo está lleno
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    // Verifica si el nodo está vacío
    public boolean nodeEmpty() {
        return count == 0;
    }

    public SearchResult searchNode(E key) {
        int i = 0;
        while (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) > 0) {
            i++;
        }

        if (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) == 0) {
            return new SearchResult(true, i); // Clave encontrada
        } else {
            return new SearchResult(false, i); // No encontrada, retorna posición para bajar
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ID: ").append(idNode).append(" | Keys: ");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    // Clase auxiliar para encapsular el resultado de búsqueda
    public static class SearchResult {
        public boolean found;
        public int position;

        public SearchResult(boolean found, int position) {
            this.found = found;
            this.position = position;
        }
    }
}


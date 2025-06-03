package LAB_09.graph;

public class GraphLink<E> {
    protected LinkedList<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new LinkedList<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<>(data);
        if (listVertex.search(v) < 0) {
            listVertex.insert(v);
        }
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vOri = listVertex.getElement(new Vertex<>(verOri));
        Vertex<E> vDes = listVertex.getElement(new Vertex<>(verDes));

        if (vOri == null || vDes == null) return;

        Edge<E> edgeToDes = new Edge<>(vDes);
        Edge<E> edgeToOri = new Edge<>(vOri);

        if (vOri.listAdj.search(edgeToDes) < 0) {
            vOri.listAdj.insert(edgeToDes);
        }

        if (vDes.listAdj.search(edgeToOri) < 0) {
            vDes.listAdj.insert(edgeToOri);
        }
    }

    public boolean searchVertex(E data) {
        return listVertex.search(new Vertex<>(data)) >= 0;
    }

    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vOri = listVertex.getElement(new Vertex<>(verOri));
        Vertex<E> vDes = listVertex.getElement(new Vertex<>(verDes));

        if (vOri == null || vDes == null) return false;

        return vOri.listAdj.search(new Edge<>(vDes)) >= 0;
    }

    // a) Eliminar vértice y sus aristas
    public void removeVertex(E data) {
        Vertex<E> v = listVertex.getElement(new Vertex<>(data));
        if (v == null) return;

        // Eliminar aristas en otros vértices que apuntan a este
        listVertex.reset();
        while (listVertex.hasNext()) {
            Vertex<E> current = listVertex.next();
            if (!current.equals(v)) {
                current.listAdj.remove(new Edge<>(v));
            }
        }

        // Eliminar el vértice
        listVertex.remove(v);
    }

    // b) Eliminar arista entre dos vértices
    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vOri = listVertex.getElement(new Vertex<>(verOri));
        Vertex<E> vDes = listVertex.getElement(new Vertex<>(verDes));

        if (vOri == null || vDes == null) return;

        vOri.listAdj.remove(new Edge<>(vDes));
        vDes.listAdj.remove(new Edge<>(vOri));
    }

    // c) DFS (Recorrido en profundidad)
    public void dfs(E data) {
        Vertex<E> start = listVertex.getElement(new Vertex<>(data));
        if (start == null) return;

        LinkedList<Vertex<E>> visited = new LinkedList<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(Vertex<E> current, LinkedList<Vertex<E>> visited) {
        System.out.print(current.getData() + " ");
        visited.insert(current);

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();

            if (visited.search(neighbor) < 0) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    @Override
    public String toString() {
        return this.listVertex.toString();
    }
}

package LAB_09.graph;

import LAB_06.EXCEPTIONS.ExceptionIsEmpty;
import java.util.ArrayList;
import LAB_06.ACTIVIDADES.ACT_2.QueueLink;
import LAB_06.EJERCICIOS.Ejercicio1.StackLink;
import LAB_06.ACTIVIDADES.*;

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

        listVertex.reset();
        while (listVertex.hasNext()) {
            Vertex<E> current = listVertex.next();
            if (!current.equals(v)) {
                current.listAdj.remove(new Edge<>(v));
            }
        }

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

    // c) DFS
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

    // a) BFS
public void bfs(E data) {
    Vertex<E> start = listVertex.getElement(new Vertex<>(data));
    if (start == null) return;

    LinkedList<Vertex<E>> visited = new LinkedList<>();
    QueueLink<Vertex<E>> queue = new QueueLink<>();

    visited.insert(start);
    queue.enqueue(start);

    while (!queue.isEmpty()) {
        Vertex<E> current;
        try {
            current = queue.dequeue();  // capturamos la excepción
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
            return;
        }

        System.out.print(current.getData() + " ");

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();
            if (visited.search(neighbor) < 0) {
                visited.insert(neighbor);
                queue.enqueue(neighbor);
            }
        }
    }
    System.out.println();
}


    // b) BFSPath
// b) BFSPath sin ArrayList ni HashMap
public LinkedList<E> bfsPath(E startData, E endData) {
    Vertex<E> start = listVertex.getElement(new Vertex<>(startData));
    Vertex<E> end = listVertex.getElement(new Vertex<>(endData));
    LinkedList<E> path = new LinkedList<>();

    if (start == null || end == null) return path;

    LinkedList<Vertex<E>> visited = new LinkedList<>();
    QueueLink<Vertex<E>> queue = new QueueLink<>();
    LinkedList<Vertex<E>> parentKeys = new LinkedList<>();
    LinkedList<Vertex<E>> parentValues = new LinkedList<>();

    visited.insert(start);
    queue.enqueue(start);
    parentKeys.insert(start);
    parentValues.insert(null); // start has no parent

    boolean found = false;

    while (!queue.isEmpty() && !found) {
        Vertex<E> current;
        try {
            current = queue.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
            return path;
        }

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();

            if (visited.search(neighbor) < 0) {
                visited.insert(neighbor);
                queue.enqueue(neighbor);
                parentKeys.insert(neighbor);
                parentValues.insert(current);

                if (neighbor.equals(end)) {
                    found = true;
                    break;
                }
            }
        }
    }

    if (!found) return path;

    Vertex<E> current = end;
    while (current != null) {
    path.addFirst(current.getData());  // Insertamos al inicio para formar el camino en orden
    current = getParent(current, parentKeys, parentValues);
}

    return path;
}

// Método auxiliar para encontrar el "padre" de un nodo en listas paralelas
private Vertex<E> getParent(Vertex<E> child, LinkedList<Vertex<E>> keys, LinkedList<Vertex<E>> values) {
    keys.reset();
    values.reset();
    while (keys.hasNext() && values.hasNext()) {
        Vertex<E> key = keys.next();
        Vertex<E> value = values.next();
        if (key.equals(child)) {
            return value;
        }
    }
    return null;
}


//EJERCICIO 02:(A)

public void insertEdgeWeight(E verOri, E verDes, int weight) {
    Vertex<E> vOri = listVertex.getElement(new Vertex<>(verOri));
    Vertex<E> vDes = listVertex.getElement(new Vertex<>(verDes));

    if (vOri == null || vDes == null) return;

    Edge<E> edgeToDes = new Edge<>(vDes, weight);
    Edge<E> edgeToOri = new Edge<>(vOri, weight);

    if (vOri.listAdj.search(edgeToDes) < 0) {
        vOri.listAdj.insert(edgeToDes);
    }

    if (vDes.listAdj.search(edgeToOri) < 0) {
        vDes.listAdj.insert(edgeToOri);
    }
}

//EJERCICIO 02:(B)

public ArrayList<E> shortPath(E startData, E endData) {
    ArrayList<E> path = new ArrayList<>();

    Vertex<E> start = listVertex.getElement(new Vertex<>(startData));
    Vertex<E> end = listVertex.getElement(new Vertex<>(endData));

    if (start == null || end == null) return path;

    ArrayList<Vertex<E>> vertices = new ArrayList<>();
    ArrayList<Integer> distances = new ArrayList<>();
    ArrayList<Vertex<E>> previous = new ArrayList<>();

    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        vertices.add(v);
        distances.add(v.equals(start) ? 0 : Integer.MAX_VALUE);
        previous.add(null);
    }

    while (!vertices.isEmpty()) {
        int minIndex = getMinIndex(distances);
        Vertex<E> current = vertices.get(minIndex);
        int currentDist = distances.get(minIndex);

        vertices.remove(minIndex);
        distances.remove(minIndex);
        Vertex<E> removedPrev = previous.remove(minIndex); // esto no se usa directamente, solo se mantiene alineación

        if (current.equals(end)) {
            while (current != null) {
                path.add(0, current.getData());
                int idx = listVertex.search(current);
                current = previous.get(idx);
            }
            break;
        }

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();
            int altDist = currentDist + edge.getWeight();
            int idx = listVertex.search(neighbor);
            if (idx >= 0 && altDist < distances.get(idx)) {
                distances.set(idx, altDist);
                previous.set(idx, current);
            }
        }
    }

    return path;
}

private int getMinIndex(ArrayList<Integer> distances) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for (int i = 0; i < distances.size(); i++) {
        if (distances.get(i) < min) {
            min = distances.get(i);
            minIndex = i;
        }
    }
    return minIndex;
}

//EJERCICIO 02:(C)

public boolean isConexo() {
    if (listVertex.isEmpty()) return true;

    LinkedList<Vertex<E>> visited = new LinkedList<>();
    dfsRecursive(listVertex.getFirst(), visited);
    return visited.size() == listVertex.size();
}


//EJERCICIO 02:(D)

public StackLink<E> Dijkstra(E startData, E endData) {
    StackLink<E> stack = new StackLink<>();
    ArrayList<E> path = shortPath(startData, endData);
    for (int i = path.size() - 1; i >= 0; i--) {
        stack.push(path.get(i));
    }
    return stack;
}

}

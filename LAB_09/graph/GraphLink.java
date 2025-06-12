package LAB_09.graph;

import LAB_06.EXCEPTIONS.ExceptionIsEmpty;
import java.util.ArrayList;
import LAB_06.ACTIVIDADES.ACT_2.QueueLink;
import LAB_06.EJERCICIOS.Ejercicio1.StackLink;

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
    System.out.println("--------------------------------------------------");
    System.out.println("Visitando nodo: " + current.getData());
    visited.insert(current);

    // Mostrar nodos visitados hasta el momento
    System.out.print("Nodos visitados hasta ahora: ");
    visited.reset();
    while (visited.hasNext()) {
        System.out.print(visited.next().getData() + " ");
    }
    System.out.println();

    // Mostrar vecinos del nodo actual
    System.out.print("Vecinos de " + current.getData() + ": ");
    current.listAdj.reset();
    while (current.listAdj.hasNext()) {
        Edge<E> edge = current.listAdj.next();
        System.out.print(edge.getRefDest().getData() + " ");
    }
    System.out.println();

    // Recorrido a vecinos no visitados
    current.listAdj.reset(); // Reiniciar para el recorrido
    while (current.listAdj.hasNext()) {
        Edge<E> edge = current.listAdj.next();
        Vertex<E> neighbor = edge.getRefDest();

        if (visited.search(neighbor) < 0) {
            System.out.println("-> Recorriendo desde " + current.getData() + " hacia " + neighbor.getData());
            dfsRecursive(neighbor, visited);
        } else {
            System.out.println("-> El nodo " + neighbor.getData() + " ya fue visitado. No se recorre nuevamente.");
        }
    }
}


    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        sb.append(v.getData()).append(" -> ");
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Edge<E> e = v.listAdj.next();
            sb.append(e.getRefDest().getData()).append(", ");
        }
        sb.append("\n");
    }
    return sb.toString();
}


    // a) BFS
    /* 
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
    */

    //IMPRESION EXPLICITA
   public void bfs(E data) {
    Vertex<E> start = listVertex.getElement(new Vertex<>(data));
    if (start == null) {
        System.out.println("Nodo inicial no encontrado: " + data);
        return;
    }

    System.out.println("Iniciando BFS desde el nodo: " + data);

    LinkedList<Vertex<E>> visited = new LinkedList<>();
    QueueLink<Vertex<E>> queue = new QueueLink<>();

    visited.insert(start);
    queue.enqueue(start);
    System.out.println("Cola inicial: " + start.getData());

    while (!queue.isEmpty()) {
        Vertex<E> current;
        try {
            current = queue.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
            return;
        }

        System.out.println("Procesando nodo: " + current.getData());

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();
            if (visited.search(neighbor) < 0) {
                visited.insert(neighbor);
                queue.enqueue(neighbor);
                System.out.println("  -> Nodo descubierto: " + neighbor.getData() + " (agregado a la cola)");
            } else {
                System.out.println("  -> Nodo ya visitado: " + neighbor.getData());
            }
        }
    }
}

/* 
    // b) BFSPath
// b) BFSPath sin ArrayList
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

*/

public LinkedList<E> bfsPath(E startData, E endData) {
    Vertex<E> start = listVertex.getElement(new Vertex<>(startData));
    Vertex<E> end = listVertex.getElement(new Vertex<>(endData));
    LinkedList<E> path = new LinkedList<>();

    if (start == null || end == null) {
        System.out.println("Error: nodo inicial o final no encontrado.");
        return path;
    }

    System.out.println("Buscando camino más corto desde " + startData + " hasta " + endData + " usando BFS...");

    LinkedList<Vertex<E>> visited = new LinkedList<>();
    QueueLink<Vertex<E>> queue = new QueueLink<>();
    LinkedList<Vertex<E>> parentKeys = new LinkedList<>();
    LinkedList<Vertex<E>> parentValues = new LinkedList<>();

    visited.insert(start);
    queue.enqueue(start);
    parentKeys.insert(start);
    parentValues.insert(null);

    boolean found = false;

    while (!queue.isEmpty() && !found) {
        Vertex<E> current;
        try {
            current = queue.dequeue();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
            return path;
        }

        System.out.println("Procesando nodo: " + current.getData());

        current.listAdj.reset();
        while (current.listAdj.hasNext()) {
            Edge<E> edge = current.listAdj.next();
            Vertex<E> neighbor = edge.getRefDest();

            if (visited.search(neighbor) < 0) {
                visited.insert(neighbor);
                queue.enqueue(neighbor);
                parentKeys.insert(neighbor);
                parentValues.insert(current);
                System.out.println("  -> Se visita: " + neighbor.getData() + ", padre: " + current.getData());

                if (neighbor.equals(end)) {
                    System.out.println("  -> Nodo final encontrado: " + endData);
                    found = true;
                    break;
                }
            } else {
                System.out.println("  -> Nodo ya visitado: " + neighbor.getData());
            }
        }
    }

    if (!found) {
        System.out.println("No se encontró un camino entre " + startData + " y " + endData);
        return path;
    }

    Vertex<E> current = end;
    while (current != null) {
        path.addFirst(current.getData());
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


//EJERCICIO 05 (a)
// Obtener el grado de un nodo (cantidad de aristas conectadas)
public int getGradoNodo(E data) {
    Vertex<E> v = listVertex.getElement(new Vertex<>(data));
    if (v == null) return -1;
    return v.listAdj.size();
}

//EJERCICIO 05 (b)
// Verifica si el grafo es un Camino (P)
public boolean isCamino() {
    int countGrado1 = 0;
    int countGrado2 = 0;
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        int grado = v.listAdj.size();
        if (grado == 1) countGrado1++;
        else if (grado == 2) countGrado2++;
        else return false;  // si algún nodo tiene grado distinto a 1 o 2, no es camino
    }
    return (countGrado1 == 2 && countGrado2 == listVertex.size() - 2);
}

//EJERCICIO 05 (C)
// Verifica si el grafo es un Ciclo (C)
public boolean isCiclo() {
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        if (v.listAdj.size() != 2) return false; // todos los nodos deben tener grado 2
    }
    return true;
}

//EJERCICIO 05 (d)
// Verifica si el grafo es una Rueda (W)
public boolean isRueda() {
    int n = listVertex.size();
    if (n < 4) return false; // mínimo 4 nodos para formar una rueda

    int centro = 0;
    int perifericos = 0;

    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        int grado = v.listAdj.size();
        if (grado == n - 1) centro++;
        else if (grado == 3) perifericos++;
        else return false;
    }

    return (centro == 1 && perifericos == n - 1);
}

//EJERCICIO 05 (e)
// Verifica si el grafo es Completo (K)
public boolean isCompleto() {
    int n = listVertex.size();
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        if (v.listAdj.size() != n - 1) return false;
    }
    return true;
}
//FORMAL 6.A
public void printFormal() {
    System.out.println("Vértices:");
    listVertex.reset();
    while (listVertex.hasNext()) {
        System.out.print(listVertex.next().getData() + " ");
    }
    System.out.println("\nAristas:");
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Vertex<E> dest = v.listAdj.next().getRefDest();
            // Para no imprimir duplicados en grafo no dirigido
            if (v.getData().toString().compareTo(dest.getData().toString()) < 0) {
                System.out.println("(" + v.getData() + ", " + dest.getData() + ")");
            }
        }
    }
}

/*public void printFormal() {
    System.out.println("Vértices:");
    listVertex.reset();
    while (listVertex.hasNext()) {
        System.out.print(listVertex.next().getData() + " ");
    }
    System.out.println("\nAristas:");
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Vertex<E> dest = v.listAdj.next().getRefDest();
            // Evitar imprimir aristas duplicadas (como (u,v) y (v,u))
            if (listVertex.search(dest) > listVertex.search(v)) {
                System.out.println("(" + v.getData() + ", " + dest.getData() + ")");
            }
        }
    }
}
 */

//ADYACENCIA 6.B
public void printListaAdyacencia() {
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        System.out.print(v.getData() + ": ");
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            System.out.print(v.listAdj.next().getRefDest().getData() + " ");
        }
        System.out.println();
    }
}


//MATRIZ 6.C
public void printMatrizAdyacencia() {
    ArrayList<Vertex<E>> vertices = new ArrayList<>();
    listVertex.reset();
    while (listVertex.hasNext()) {
        vertices.add(listVertex.next());
    }

    System.out.print("    ");
    for (Vertex<E> v : vertices) {
        System.out.print(v.getData() + " ");
    }
    System.out.println();

    for (Vertex<E> v1 : vertices) {
        System.out.print(v1.getData() + ": ");
        for (Vertex<E> v2 : vertices) {
            boolean connected = v1.listAdj.search(new Edge<>(v2)) >= 0;
            System.out.print((connected ? "1" : "0") + " ");
        }
        System.out.println();
    }
}

public void showFormal() {
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        System.out.print(v.getData() + " -> ");
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Edge<E> edge = v.listAdj.next();
            System.out.print(edge.getRefDest().getData());
            if (edge.getWeight() != 1) { // para grafos ponderados
                System.out.print("[" + edge.getWeight() + "]");
            }
            if (v.listAdj.hasNext()) System.out.print(", ");
        }
        System.out.println();
    }
}


// Mostrar lista de adyacencias
public void showAdyacencias() {
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        System.out.print(v.getData() + " -> ");
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Edge<E> edge = v.listAdj.next();
            System.out.print(edge.getRefDest().getData() + " ");
        }
        System.out.println();
    }
}

// Mostrar matriz de adyacencia
public void showMatrizAdyacencia() {
    int size = listVertex.size();
    Vertex<E>[] vertices = new Vertex[size];
    
    listVertex.reset();
    int i = 0;
    while (listVertex.hasNext()) {
        vertices[i++] = listVertex.next();
    }

    System.out.print("    ");
    for (int k = 0; k < size; k++) {
        System.out.print(vertices[k].getData() + " ");
    }
    System.out.println();

    for (i = 0; i < size; i++) {
        System.out.print(vertices[i].getData() + " | ");
        for (int j = 0; j < size; j++) {
            Vertex<E> ori = vertices[i];
            Vertex<E> des = vertices[j];
            int val = ori.listAdj.search(new Edge<>(des)) >= 0 ? 1 : 0;
            System.out.print(" " + val + " ");
        }
        System.out.println();
    }
}
// Retorna grado de salida (cantidad de aristas salientes)
public int getGradoSalida(E data) {
    Vertex<E> v = listVertex.getElement(new Vertex<>(data));
    if (v == null) return -1;
    return v.listAdj.size();
}

// Retorna grado de entrada (cantidad de aristas entrantes)
public int getGradoEntrada(E data) {
    Vertex<E> target = listVertex.getElement(new Vertex<>(data));
    if (target == null) return -1;

    int gradoEntrada = 0;
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        v.listAdj.reset();
        while (v.listAdj.hasNext()) {
            Edge<E> edge = v.listAdj.next();
            if (edge.getRefDest().equals(target)) {
                gradoEntrada++;
            }
        }
    }
    return gradoEntrada;
}

// Retorna grado total (entrada + salida)
public int getGradoTotal(E data) {
    int entrada = getGradoEntrada(data);
    int salida = getGradoSalida(data);
    if (entrada == -1 || salida == -1) return -1;
    return entrada + salida;
}


public boolean isCaminoDirigido() {
    int countStart = 0;  // nodos con grado entrada=0 y salida=1
    int countEnd = 0;    // nodos con grado entrada=1 y salida=0
    int countMid = 0;    // nodos con grado entrada=1 y salida=1

    int n = listVertex.size();
    if (n == 0) return false;

    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        int in = getGradoEntrada(v.getData());
        int out = getGradoSalida(v.getData());

        if (in == 0 && out == 1) countStart++;
        else if (in == 1 && out == 0) countEnd++;
        else if (in == 1 && out == 1) countMid++;
        else return false; // si no cumple estas condiciones, no es camino dirigido
    }

    return (countStart == 1 && countEnd == 1 && countMid == n - 2);
}

public boolean isCicloDirigido() {
    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        int in = getGradoEntrada(v.getData());
        int out = getGradoSalida(v.getData());

        if (in != 1 || out != 1) return false;
    }
    return true;
}

public boolean isRuedaDirigida() {
    int n = listVertex.size();
    if (n < 4) return false; // Rueda mínima 4 nodos

    int centro = 0;
    int perifericos = 0;

    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        int in = getGradoEntrada(v.getData());
        int out = getGradoSalida(v.getData());

        if (out == n - 1 && in == 0) {
            centro++;
        } else if (in == 1 && out == 1) {
            perifericos++;
        } else {
            return false;
        }
    }

    return (centro == 1 && perifericos == n - 1);
}

public void printInfoNodo(E data) {
    System.out.println("Nodo: " + data);
    System.out.println("Grado Entrada: " + getGradoEntrada(data));
    System.out.println("Grado Salida: " + getGradoSalida(data));
    System.out.println("Grado Total: " + getGradoTotal(data));
}

public void printTipoGrafo() {
    if (isCaminoDirigido()) System.out.println("El grafo es un Camino Dirigido.");
    else if (isCicloDirigido()) System.out.println("El grafo es un Ciclo Dirigido.");
    else if (isRuedaDirigida()) System.out.println("El grafo es una Rueda Dirigida.");
    else System.out.println("El grafo no es Camino, Ciclo ni Rueda Dirigida.");
}


//isoformo
public boolean isIsomorfo(GraphLink<E> other) {
    if (this.listVertex.size() != other.listVertex.size()) return false;

    this.listVertex.reset();
    while (this.listVertex.hasNext()) {
        Vertex<E> v1 = this.listVertex.next();

        Vertex<E> otherV = other.listVertex.getElement(new Vertex<>(v1.getData()));

        if (otherV == null || v1.listAdj.size() != otherV.listAdj.size()) {
            return false;
        }
    }
    // Si pasa todas las verificaciones básicas, retornamos true.
    // IMPORTANTE: Este método solo verifica un criterio simple de isomorfismo (basado en la existencia y el grado de los vértices).
    // Para una comprobación completa, se necesitaría probar todas las permutaciones posibles de los vértices,
    // lo cual es computacionalmente costoso (problema NP-completo).
    return true;
}


//grafo plano
public boolean isPlano() {
    int n = listVertex.size();
    int e = 0;

    listVertex.reset();
    while (listVertex.hasNext()) {
        Vertex<E> v = listVertex.next();
        e += v.listAdj.size();
    }

    e /= 2; // porque se cuenta doble (grafo no dirigido)

    return n < 3 || e <= 3 * n - 6;
}




//auto complementario

public boolean isAutoComplementario() {
    GraphLink<E> complement = new GraphLink<>();

    // Copiar vértices
    this.listVertex.reset();
    while (this.listVertex.hasNext()) {
        Vertex<E> v = this.listVertex.next();
        complement.insertVertex(v.getData());
    }

    this.listVertex.reset();
    while (this.listVertex.hasNext()) {
        Vertex<E> v1 = this.listVertex.next();

        this.listVertex.reset(); // Reiniciar para comparar con todos
        while (this.listVertex.hasNext()) {
            Vertex<E> v2 = this.listVertex.next();
            if (!v1.equals(v2) && !this.searchEdge(v1.getData(), v2.getData())) {
                complement.insertEdge(v1.getData(), v2.getData());
            }
        }
    }

    return this.isIsomorfo(complement);
}


//conexo
public boolean isConexo2() {
    if (listVertex.isEmpty()) return true;

    LinkedList<Vertex<E>> visitados = new LinkedList<>();
    QueueLink<Vertex<E>> cola = new QueueLink<>();

    listVertex.reset();
    Vertex<E> inicio = listVertex.next(); // obtener el primer vértice sin usar get(0)
    cola.enqueue(inicio);
    visitados.insert(inicio);

    while (!cola.isEmpty()) {
        Vertex<E> actual;
        try {
            actual = cola.dequeue();
        } catch (ExceptionIsEmpty e) {
            return false; // no debería pasar
        }

        actual.listAdj.reset();
        while (actual.listAdj.hasNext()) {
            Edge<E> arista = actual.listAdj.next();
            Vertex<E> vecino = arista.getRefDest();  // ✔️ Esto sí compila'

            if (!contiene(visitados, vecino)) {
                visitados.insert(vecino);
                cola.enqueue(vecino);
            }
        }
    }

    return visitados.size() == listVertex.size();
}

private boolean contiene(LinkedList<Vertex<E>> lista, Vertex<E> elemento) {
    lista.reset();
    while (lista.hasNext()) {
        if (lista.next().equals(elemento)) return true;
    }
    return false;
}

}

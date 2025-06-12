package LAB_09.graph;

public class TestEjercicio1 {
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();

        System.out.println("===== CREACIÓN DEL GRAFO =====");
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");

        System.out.println("\n===== IMPRESIÓN DEL GRAFO =====");
        System.out.println(grafo.toString());

        System.out.println("\n===== BFS DESDE 'A' =====");
        grafo.bfs("A");

        System.out.println("\n===== BFS PATH DE 'A' A 'E' =====");
        LinkedList<String> camino = grafo.bfsPath("A", "E");

        if (!camino.isEmpty()) {
            System.out.print("Camino encontrado de A a E: ");
            camino.reset();
            while (camino.hasNext()) {
                System.out.print(camino.next());
                if (camino.hasNext()) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino de A a E.");
        }
    }
}


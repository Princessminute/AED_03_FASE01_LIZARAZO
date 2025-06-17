package LAB_09.graph;

import LAB_06.EJERCICIOS.Ejercicio1.StackLink;

public class MainGraphLinkTest {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();

        // Insertamos los vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insertamos aristas con pesos
        System.out.println("Insertando aristas con pesos:");
        graph.insertEdgeWeight("A", "B", 4);
        graph.insertEdgeWeight("A", "C", 2);
        graph.insertEdgeWeight("B", "D", 5);
        graph.insertEdgeWeight("C", "D", 1);
        graph.insertEdgeWeight("D", "E", 3);

        // BFS desde A
        System.out.println("\nRecorrido BFS desde A:");
        graph.bfs("A");

        // BFS Path de A hasta E
        System.out.println("\nCamino BFS de A a E:");
        LinkedList<String> bfsPath = graph.bfsPath("A", "E");
        bfsPath.toString();  // Asumiendo que tienes un método print() en tu LinkedList

        // Camino más corto (por pesos) de A a E
        System.out.println("\nCamino más corto (por pesos) de A a E:");
        LinkedList<String> shortPath = graph.bfsPath("A", "E");
        System.out.println(shortPath);

        // Verificar si el grafo es conexo
        System.out.println("\n¿El grafo es conexo?");
        boolean conexo = graph.isConexo();
        System.out.println(conexo ? "Sí, es conexo." : "No, no es conexo.");

        // Camino más corto con Dijkstra (en stack)
        System.out.println("\nCamino más corto usando Dijkstra de A a E:");
        StackLink<String> dijkstraPath = graph.Dijkstra("A", "E");
        dijkstraPath.print();  // Asumiendo que tienes un método print() en tu StackLink
    }
}

package LAB_09.graph;

public class Ejercicio6 {

    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();

        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");

        System.out.println("Recorrido DFS desde A:");
        grafo.dfs("A");
        System.out.println();

        System.out.println("Recorrido BFS desde A:");
        grafo.bfs("A");

        System.out.println("\nCaminos BFS de A a D:");
        System.out.println(grafo.bfsPath("A", "D"));

        System.out.println("\nRepresentación Formal:");
        grafo.showFormal();

        System.out.println("\nLista de Adyacencias:");
        grafo.showAdyacencias();

        System.out.println("\nMatriz de Adyacencia:");
        grafo.showMatrizAdyacencia();
    }
}



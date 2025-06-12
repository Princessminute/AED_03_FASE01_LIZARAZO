package LAB_09.graph;

public class TestActividades {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();

        System.out.println("======== INICIO DE PRUEBAS CON GRAFO NO DIRIGIDO ========");
        System.out.println("\n-- Paso 1: Insertar vértices --");
        String[] vertices = {"A", "B", "C", "D"};
        for (String v : vertices) {
            System.out.println("-> Insertando vértice '" + v + "'");
            graph.insertVertex(v);
        }

        System.out.println("\n-- Paso 2: Insertar aristas --");
        String[][] aristas = {{"A", "B"}, {"A", "C"}, {"B", "D"}};
        for (String[] a : aristas) {
            System.out.println("-> Insertando arista entre '" + a[0] + "' y '" + a[1] + "'");
            graph.insertEdge(a[0], a[1]);
        }

        System.out.println("\n-- Paso 3: Mostrar estado actual del grafo --");
        System.out.println(graph);

        System.out.println("\n-- Paso 4: Búsquedas de vértices y aristas --");
        System.out.println("¿Existe el vértice 'A'? " + graph.searchVertex("A"));
        System.out.println("¿Existe el vértice 'E'? " + graph.searchVertex("E"));
        System.out.println("¿Existe la arista entre 'A' y 'B'? " + graph.searchEdge("A", "B"));
        System.out.println("¿Existe la arista entre 'A' y 'D'? " + graph.searchEdge("A", "D"));

        System.out.println("\n-- Paso 5: Recorrido DFS desde 'A' --");
        System.out.println("Visitando los vértices de forma recursiva desde 'A':");
        graph.dfs("A");

        System.out.println("\n\n-- Paso 6: Eliminar arista entre 'A' y 'B' --");
        System.out.println("Eliminando conexión entre 'A' y 'B'...");
        graph.removeEdge("A", "B");
        System.out.println("¿Existe la arista entre 'A' y 'B'? " + graph.searchEdge("A", "B"));

        System.out.println("\n-- Paso 7: Eliminar vértice 'B' --");
        System.out.println("Eliminando vértice 'B' y todas sus conexiones...");
        graph.removeVertex("B");
        System.out.println("¿Existe el vértice 'B'? " + graph.searchVertex("B"));
        System.out.println("¿Existe la arista entre 'B' y 'D'? " + graph.searchEdge("B", "D"));

        System.out.println("\n-- Paso 8: Estado final del grafo --");
        System.out.println(graph);

        System.out.println("\n-- Paso 9: DFS nuevamente desde 'A' --");
        System.out.println("Visitando vértices restantes desde 'A':");
        graph.dfs("A");

        System.out.println("\n======== FIN DE PRUEBAS ========");
    }
}

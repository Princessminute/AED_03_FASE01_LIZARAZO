package LAB_09.graph;

public class GraphFormal<V, E> extends GraphListEdge<V, E> {

    // Imprime el grafo en forma formal
    public void printFormal() {
        System.out.print("V = { ");
        for (VertexObj<V, E> v : secVertex) {
            System.out.print(v.info + " ");
        }
        System.out.println("}");

        System.out.print("E = { ");
        for (EdgeObj<V, E> e : secEdge) {
            System.out.print("(" + e.endVertex1.info + ", " + e.endVertex2.info + ") ");
        }
        System.out.println("}");
    }
}


package LAB_09.graph;

public class GraphAdjacencyList<E> extends GraphLink<E> {

    public void printAdjacencyList() {
        listVertex.reset();
        while (listVertex.hasNext()) {
            Vertex<E> v = listVertex.next();
            System.out.print(v.getData() + ": ");
            v.listAdj.reset();
            while (v.listAdj.hasNext()) {
                Edge<E> edge = v.listAdj.next();
                System.out.print(edge.getRefDest().getData() + " ");
            }
            System.out.println();
        }
    }
}

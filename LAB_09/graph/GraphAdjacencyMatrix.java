package LAB_09.graph;

public class GraphAdjacencyMatrix<V, E> extends GraphListEdge<V, E> {

    public int[][] getAdjacencyMatrix() {
        int n = secVertex.size();
        int[][] matrix = new int[n][n];

        for (EdgeObj<V, E> e : secEdge) {
           int i = e.endVertex1.getPosition();
           int j = e.endVertex2.getPosition();
            matrix[i][j] = 1;
            matrix[j][i] = 1;  // No dirigido
        }

        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        System.out.print("    ");
        for (VertexObj<V, E> v : secVertex) {
            System.out.print(v.info + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(secVertex.get(i).info + " | ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

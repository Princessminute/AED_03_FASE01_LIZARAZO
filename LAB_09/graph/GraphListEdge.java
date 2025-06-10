package LAB_09.graph;

import java.util.ArrayList;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V info) {
        if (!searchVertex(info)) {
            secVertex.add(new VertexObj<>(info, secVertex.size()));
        }
    }

    public void insertEdge(V v, V z) {
        VertexObj<V, E> vert1 = getVertex(v);
        VertexObj<V, E> vert2 = getVertex(z);

        if (vert1 == null || vert2 == null) return;

        if (!searchEdge(v, z)) {
            secEdge.add(new EdgeObj<>(vert1, vert2, null, secEdge.size()));
        }
    }

    public boolean searchVertex(V info) {
        return getVertex(info) != null;
    }

    public boolean searchEdge(V v, V z) {
        for (EdgeObj<V, E> edge : secEdge) {
            if ((edge.endVertex1.info.equals(v) && edge.endVertex2.info.equals(z)) ||
                (edge.endVertex1.info.equals(z) && edge.endVertex2.info.equals(v))) {
                return true;
            }
        }
        return false;
    }

    private VertexObj<V, E> getVertex(V info) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.info.equals(info)) return vertex;
        }
        return null;
    }

    public void bfs(V startInfo) {
        VertexObj<V, E> start = getVertex(startInfo);
        if (start == null) return;

        ArrayList<VertexObj<V, E>> visited = new ArrayList<>();
        ArrayList<VertexObj<V, E>> queue = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.remove(0);
            System.out.print(current.info + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;

                if (edge.endVertex1.equals(current) && !visited.contains(edge.endVertex2)) {
                    neighbor = edge.endVertex2;
                } else if (edge.endVertex2.equals(current) && !visited.contains(edge.endVertex1)) {
                    neighbor = edge.endVertex1;
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    
}

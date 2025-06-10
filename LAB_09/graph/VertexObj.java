package LAB_09.graph;

public class VertexObj<V, E> {
    protected V info;
    protected int position;

    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VertexObj)) return false;
        VertexObj<V, E> other = (VertexObj<V, E>) obj;
        return this.info.equals(other.info);
    }

    @Override
    public String toString() {
        return info.toString();
    }

    public int getPosition() {
    return position;
}

}


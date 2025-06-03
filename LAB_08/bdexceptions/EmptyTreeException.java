package LAB_08.bdexceptions;

public class EmptyTreeException extends TreeException {
    public EmptyTreeException() {
        super("El árbol está vacío.");
    }
}

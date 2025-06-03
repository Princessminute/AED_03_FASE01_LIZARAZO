package LAB_08.bdexceptions;

public class InvalidBalanceException extends TreeException {
    public InvalidBalanceException() {
        super("Error en el factor de equilibrio del árbol AVL.");
    }
}

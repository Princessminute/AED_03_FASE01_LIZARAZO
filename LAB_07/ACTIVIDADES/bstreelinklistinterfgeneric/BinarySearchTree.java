package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;
import LAB_07.EXCEPTION.*;

public interface BinarySearchTree<E> {
    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionIsEmpty, LAB_06.EXCEPTIONS.ExceptionIsEmpty;
    boolean isEmpty();
}
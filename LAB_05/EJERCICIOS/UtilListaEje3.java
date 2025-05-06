package LAB_05.EJERCICIOS;

// Clase utilitaria con métodos genéricos para listas
public class UtilListaEje3 {

    // Inserta un nodo al final de una lista enlazada
    public static <T> Nodo<T> insertarAlFinal(Nodo<T> cabeza, T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        // Si la lista está vacía, el nuevo nodo será la cabeza
        if (cabeza == null) {
            return nuevo;
        }

        // Recorremos hasta el último nodo
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        // Insertamos al final
        actual.siguiente = nuevo;

        return cabeza; //misma cabeza
    }

    public static <T> void imprimir(Nodo<T> cabeza) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}


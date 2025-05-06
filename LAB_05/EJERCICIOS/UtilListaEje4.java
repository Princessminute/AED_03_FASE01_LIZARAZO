package LAB_05.EJERCICIOS;

public class UtilListaEje4 {

    public static <T> Nodo<T> insertarAlFinal(Nodo<T> cabeza, T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) return nuevo;

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        return cabeza;
    }

    public static <T> void imprimir(Nodo<T> cabeza) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Método recursivo para contar nodos
    public static <T> int contarNodos(Nodo<T> cabeza) {
        if (cabeza == null) {
            return 0;
        }
        return 1 + contarNodos(cabeza.siguiente);
    }
}

package LAB_05.EJERCICIOS;

public class UtilListaEje5 {

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

    // Método recursivo para comparar dos listas
    public static <T> boolean sonIguales(Nodo<T> cabeza1, Nodo<T> cabeza2) {
        // Si ambas listas son nulas, son iguales
        if (cabeza1 == null && cabeza2 == null) {
            return true;
        }

        // Si una lista es nula y la otra no, no son iguales
        if (cabeza1 == null || cabeza2 == null) {
            return false;
        }

        // Comparamos el dato y llamamos recursivamente al siguiente nodo
        return cabeza1.dato.equals(cabeza2.dato) && sonIguales(cabeza1.siguiente, cabeza2.siguiente);
    }
}

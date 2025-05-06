package LAB_05.EJERCICIOS;

public class UtilListaEje6 {

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

    // Método recursivo para concatenar dos listas
    public static <T> Nodo<T> concatenarListas(Nodo<T> lista1, Nodo<T> lista2) {
        // Si la primera lista está vacía, devolvemos la segunda lista
        if (lista1 == null) {
            return lista2;
        }

        // Si la segunda lista está vacía, devolvemos la primera lista
        if (lista2 == null) {
            return lista1;
        }

        // Si ambas listas no están vacías, recursivamente concatenamos
        Nodo<T> actual = lista1;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        // Ahora concatenamos la segunda lista al final de la primera
        actual.siguiente = lista2;

        return lista1; // Retornamos la cabeza de la lista concatenada
    }
}

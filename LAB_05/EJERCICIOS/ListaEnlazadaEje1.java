package LAB_05.EJERCICIOS;

import java.util.ArrayList;
import java.util.List;

// Lista enlazada simple genérica
public class ListaEnlazadaEje1<T> {
    private Nodo<T> cabeza;

    // d -> d -> d-> [] agregar al final de la lista
    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Búsqueda  alternada desde los extremos
    public boolean buscarElemento(T valor) {
        if (cabeza == null) return false;

        // Convertimos la lista enlazada a lista de acceso aleatorio
        List<T> elementos = new ArrayList<>();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            elementos.add(actual.dato);
            actual = actual.siguiente;
        }

        // Buscamos intercalando entre extremos
        int izquierda = 0;
        int derecha = elementos.size() - 1;
        boolean turnoIzquierda = true;

        while (izquierda <= derecha) {
            if (turnoIzquierda) {
                if (elementos.get(izquierda).equals(valor)) return true;
                izquierda++;
            } else {
                if (elementos.get(derecha).equals(valor)) return true;
                derecha--;
            }
            turnoIzquierda = !turnoIzquierda;
        }

        return false;
    }
}


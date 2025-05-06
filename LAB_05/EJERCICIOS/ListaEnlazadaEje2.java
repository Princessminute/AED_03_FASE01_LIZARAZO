package LAB_05.EJERCICIOS;

import java.util.ArrayList;
import java.util.List;

public class ListaEnlazadaEje2<T> {
    private Nodo<T> cabeza;

    // Agrega un nuevo nodo al final
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

    // Imprime la lista (para pruebas)
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Devuelve nueva lista con elementos invertidos (sin modificar la original)
    public ListaEnlazadaEje2<T> invertirLista() {
        List<T> pila = new ArrayList<>();  // simulamos pila

        // Guardamos datos en pila
        Nodo<T> actual = cabeza;
        while (actual != null) {
            pila.add(actual.dato);
            actual = actual.siguiente;
        }

        // Creamos nueva lista con los datos en orden inverso
        ListaEnlazadaEje2<T> invertida = new ListaEnlazadaEje2<>();
        for (int i = pila.size() - 1; i >= 0; i--) {
            invertida.agregar(pila.get(i));
        }

        return invertida;
    }
}

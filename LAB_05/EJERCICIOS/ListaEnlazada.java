package LAB_05.EJERCICIOS;

import java.util.HashSet;
import java.util.Set;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;  // Apunta al primer nodo de la lista
    private Set<T> cacheVisitados;  // Cache para almacenar elementos visitados

    public ListaEnlazada() {
        this.cabeza = null;
        this.cacheVisitados = new HashSet<>();  // Inicializa el cache
    }

    // Verifica si la lista está vacía (cabeza es null)
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Obtiene el primer elemento de la lista
    public T obtenerPrimerElemento() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.dato;
    }

    // Elimina el primer nodo de la lista
    public void eliminarPrimerElemento() {
        if (estaVacia()) {
            throw new IllegalStateException("No hay elementos para eliminar");
        }
        cabeza = cabeza.siguiente;
    }

    // Elimina un nodo que contiene el dato especificado
    public void eliminarElemento(T dato) {
        if (estaVacia()) {
            return;
        }
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;  // Eliminar la cabeza
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;  // Eliminar el nodo
        }
    }

    // Insertar un elemento al final de la lista
    public void insertarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }

        // Crear una referencia cíclica en un nodo aleatorio
        if (Math.random() > 0.5) {  // Crea un ciclo en un nodo aleatorio
            Nodo<T> actual = cabeza;
            int nodoAleatorio = (int)(Math.random() * contarNodos());  // Seleccionamos un nodo aleatorio
            for (int i = 0; i < nodoAleatorio; i++) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual;  // Hacemos referencia cíclica
        }
    }

    // Buscar un elemento en la lista
    public boolean buscarElemento(T dato) {
        if (cacheVisitados.contains(dato)) {
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                cacheVisitados.add(dato);  // Guardamos el valor en el cache
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Invertir la lista
    public ListaEnlazada<T> invertirLista() {
        ListaEnlazada<T> listaInvertida = new ListaEnlazada<>();
        Nodo<T> actual = cabeza;

        while (actual != null) {
            Nodo<T> nuevoNodo = new Nodo<>(actual.dato);
            nuevoNodo.siguiente = listaInvertida.cabeza;
            listaInvertida.cabeza = nuevoNodo;
            actual = actual.siguiente;
        }
        return listaInvertida;
    }

    // Contar nodos en la lista
    public int contarNodos() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Concatenar dos listas
    public ListaEnlazada<T> concatenarListas(ListaEnlazada<T> lista2) {
        ListaEnlazada<T> listaConcatenada = new ListaEnlazada<>();
        Nodo<T> actual = cabeza;

        // Copiar todos los elementos de la primera lista
        while (actual != null) {
            listaConcatenada.insertarAlFinal(actual.dato);
            actual = actual.siguiente;
        }

        // Copiar todos los elementos de la segunda lista
        actual = lista2.cabeza;
        while (actual != null) {
            listaConcatenada.insertarAlFinal(actual.dato);
            actual = actual.siguiente;
        }

        return listaConcatenada;
    }

    // Método para comparar si dos listas son iguales
    public boolean sonIguales(ListaEnlazada<T> otraLista) {
        Nodo<T> actual1 = this.cabeza;
        Nodo<T> actual2 = otraLista.cabeza;

        while (actual1 != null && actual2 != null) {
            if (!actual1.dato.equals(actual2.dato)) {
                return false;  // Si los elementos no son iguales, las listas no son iguales
            }
            actual1 = actual1.siguiente;
            actual2 = actual2.siguiente;
        }

        return actual1 == null && actual2 == null;  // Verifica si ambas listas llegaron al final
    }

    // Imprimir la lista
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

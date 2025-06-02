package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

public class ArbolEmpresa<E extends Comparable<E>> {

    private static class Nodo<E> {
        E elemento;
        Nodo<E> izquierdo, derecho;

        public Nodo(E elemento) {
            this.elemento = elemento;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    private Nodo<E> raiz;

    // Método público que inicia la visualización con paréntesis
    public void parenthesize() {
        parenthesize(raiz, 0);
    }

    // Método recursivo privado
    private void parenthesize(Nodo<E> nodo, int nivel) {
        if (nodo == null) return;

        imprimirSangria(nivel);
        System.out.println(nodo.elemento);

        boolean tieneIzquierdo = nodo.izquierdo != null;
        boolean tieneDerecho = nodo.derecho != null;

        if (tieneIzquierdo || tieneDerecho) {
            imprimirSangria(nivel);
            System.out.println("(");

            if (tieneIzquierdo) {
                parenthesize(nodo.izquierdo, nivel + 1);
            }

            if (tieneDerecho) {
                parenthesize(nodo.derecho, nivel + 1);
            }

            imprimirSangria(nivel);
            System.out.println(")");
        }
    }

    // Método auxiliar para imprimir sangría
    private void imprimirSangria(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
    }

    // Método para insertar manualmente (solo para pruebas)
    public void insertarManual(E raizElem, ArbolEmpresa<E> izq, ArbolEmpresa<E> der) {
        this.raiz = new Nodo<>(raizElem);
        this.raiz.izquierdo = izq != null ? izq.raiz : null;
        this.raiz.derecho = der != null ? der.raiz : null;
    }

    // Método típico de inserción en un Árbol Binario de Búsqueda (BST)
    public void insertar(E elemento) {
        raiz = insertarRecursivo(raiz, elemento);
    }

    private Nodo<E> insertarRecursivo(Nodo<E> nodo, E elemento) {
        if (nodo == null) {
            return new Nodo<>(elemento);
        }

        int comparacion = elemento.compareTo(nodo.elemento);

        if (comparacion < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, elemento);
        } else if (comparacion > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, elemento);
        }
        // Si es igual, no insertamos duplicados

        return nodo;
    }

    public class Main {
    public static void main(String[] args) {
        ArbolEmpresa<String> africa = new ArbolEmpresa<>();
        africa.insertarManual("Africa", null, null);

        ArbolEmpresa<String> europa = new ArbolEmpresa<>();
        europa.insertarManual("Europe", null, null);

        ArbolEmpresa<String> asia = new ArbolEmpresa<>();
        asia.insertarManual("Asia", null, null);

        ArbolEmpresa<String> australia = new ArbolEmpresa<>();
        australia.insertarManual("Australia", null, null);

        ArbolEmpresa<String> overseas = new ArbolEmpresa<>();
        overseas.insertarManual("Overseas", africa, europa);
        overseas.raiz.derecho.derecho = asia.raiz;
        asia.raiz.derecho = australia.raiz; // encadenamos manualmente

        ArbolEmpresa<String> canada = new ArbolEmpresa<>();
        canada.insertarManual("Canada", null, null);

        ArbolEmpresa<String> samerica = new ArbolEmpresa<>();
        samerica.insertarManual("S. America", null, null);

        ArbolEmpresa<String> international = new ArbolEmpresa<>();
        international.insertarManual("International", canada, samerica);
        samerica.raiz.derecho = overseas.raiz;

        ArbolEmpresa<String> domestic = new ArbolEmpresa<>();
        domestic.insertarManual("Domestic", null, null);

        ArbolEmpresa<String> sales = new ArbolEmpresa<>();
        sales.insertarManual("Sales", domestic, international);

        sales.parenthesize();
    }
}

}



package LAB_08.ACTIVIDADES;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class NodoAVL {
    int clave, altura;
    NodoAVL izq, der;

    NodoAVL(int clave) {
        this.clave = clave;
        this.altura = 1;
    }
}

class RegistroRotacion {
    int insercionK;
    int nodoX;
    String rotacion;
    int nodoY;

    public RegistroRotacion(int k, int x, String rot, int y) {
        this.insercionK = k;
        this.nodoX = x;
        this.rotacion = rot;
        this.nodoY = y;
    }
}

class ArbolAVL {
    private NodoAVL raiz;
    private List<RegistroRotacion> tablaRotaciones = new ArrayList<>();

    private int altura(NodoAVL n) {
        return (n == null) ? 0 : n.altura;
    }

    private int balance(NodoAVL n) {
        return (n == null) ? 0 : altura(n.izq) - altura(n.der);
    }

    private void actualizarAltura(NodoAVL n) {
        n.altura = 1 + Math.max(altura(n.izq), altura(n.der));
    }

    private NodoAVL rotacionDerecha(NodoAVL y, int k) {
        NodoAVL x = y.izq;
        NodoAVL T2 = x.der;

        x.der = y;
        y.izq = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        tablaRotaciones.add(new RegistroRotacion(k, y.clave, "Rotación Derecha (LL)", x.clave));
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x, int k) {
        NodoAVL y = x.der;
        NodoAVL T2 = y.izq;

        y.izq = x;
        x.der = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        tablaRotaciones.add(new RegistroRotacion(k, x.clave, "Rotación Izquierda (RR)", y.clave));
        return y;
    }

    private NodoAVL rotacionIzqDer(NodoAVL n, int k) {
        n.izq = rotacionIzquierda(n.izq, k);
        return rotacionDerecha(n, k);
    }

    private NodoAVL rotacionDerIzq(NodoAVL n, int k) {
        n.der = rotacionDerecha(n.der, k);
        return rotacionIzquierda(n, k);
    }

    private NodoAVL insertar(NodoAVL nodo, int clave) {
        if (nodo == null)
            return new NodoAVL(clave);

        if (clave < nodo.clave)
            nodo.izq = insertar(nodo.izq, clave);
        else if (clave > nodo.clave)
            nodo.der = insertar(nodo.der, clave);
        else
            return nodo;

        actualizarAltura(nodo);
        int bal = balance(nodo);

        if (bal > 1 && clave < nodo.izq.clave)
            return rotacionDerecha(nodo, clave);
        if (bal < -1 && clave > nodo.der.clave)
            return rotacionIzquierda(nodo, clave);
        if (bal > 1 && clave > nodo.izq.clave)
            return rotacionIzqDer(nodo, clave);
        if (bal < -1 && clave < nodo.der.clave)
            return rotacionDerIzq(nodo, clave);

        return nodo;
    }

    public void insertar(int clave) {
        raiz = insertar(raiz, clave);
    }

    public void imprimirArbol() {
        System.out.println("\nÁrbol actual:");
        dibujarArbol(raiz, 0, 6);
        System.out.println("--------------------------");
    }

    private void dibujarArbol(NodoAVL nodo, int espacio, int indent) {
        if (nodo == null) return;
        espacio += indent;
        dibujarArbol(nodo.der, espacio, indent);
        System.out.printf("%" + espacio + "s%n", nodo.clave);
        dibujarArbol(nodo.izq, espacio, indent);
    }

    public void imprimirTabla() {
        System.out.println("\n| Inserción K | Nodo X | Rotación               | Nodo Y |");
        System.out.println("|-------------|--------|------------------------|--------|");
        for (RegistroRotacion r : tablaRotaciones) {
            System.out.printf("| %11d | %6d | %-22s | %6d |\n",
                    r.insercionK, r.nodoX, r.rotacion, r.nodoY);
        }
        System.out.println("-----------------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        int[] claves = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};

        for (int clave : claves) {
            arbol.insertar(clave);
            arbol.imprimirArbol();
        }

        arbol.imprimirTabla();
    }
}
  


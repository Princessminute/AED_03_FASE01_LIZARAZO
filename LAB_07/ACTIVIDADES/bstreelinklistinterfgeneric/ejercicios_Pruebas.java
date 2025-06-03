package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

import LAB_07.EXCEPTION.*;
public class ejercicios_Pruebas {

    public static void main(String[] args) throws ItemDuplicated {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        System.out.println("Insertando nodos en el árbol:");
        int[] datos = {37, 15, 82, 9, 21, 65, 90, 7, 18, 70, 88};
        for (int dato : datos) {
            System.out.println("- Insertando: " + dato);
            arbol.insert(dato);
        }

        System.out.println("\nRepresentación del árbol en consola:");
        arbol.drawBST();

        System.out.println("\nRecorrido In-Orden con trazado:");
        String inOrden = arbol.obtenerRecorridoInOrden();
        System.out.println("Resultado In-Orden: " + inOrden);

        System.out.println("\nRecorrido Pre-Orden con trazado:");
        String preOrden = arbol.obtenerRecorridoPreOrden();
        System.out.println("Resultado Pre-Orden: " + preOrden);

        System.out.println("\nRecorrido Post-Orden con trazado:");
        String postOrden = arbol.obtenerRecorridoPostOrden();
        System.out.println("Resultado Post-Orden: " + postOrden);
// Conteo de nodos internos (no hojas)
System.out.println("\nConteo de nodos internos (no hojas):");
int nodosInternos = arbol.countAllNodes();
System.out.println("Se cuentan todos los nodos que no son hojas.");
System.out.println("Cantidad de nodos no hoja: " + nodosInternos);

// Altura desde nodo 15
System.out.println("\nAltura desde el nodo 15:");
int altura15 = arbol.height(15);
if (altura15 == -1) {
    System.out.println("El nodo 15 no fue encontrado en el árbol.");
} else {
    System.out.println("La altura del subárbol con raíz en el nodo 15 es: " + altura15);
    System.out.println("(Se cuenta el número máximo de niveles hacia abajo desde este nodo)");
}

// Altura desde nodo 82
System.out.println("\nAltura desde el nodo 82:");
int altura82 = arbol.height(82);
if (altura82 == -1) {
    System.out.println("El nodo 82 no fue encontrado en el árbol.");
} else {
    System.out.println("La altura del subárbol con raíz en el nodo 82 es: " + altura82);
    System.out.println("(Se cuenta el número máximo de niveles hacia abajo desde este nodo)");
}

// Amplitud por nivel
System.out.println("\nAmplitud por nivel:");
for (int i = 0; i <= 4; i++) {
    int amplitud = arbol.amplitude(i);
    System.out.println("Nivel " + i + ": " + amplitud + " nodo(s)");
    System.out.println("  (Cantidad de nodos existentes en el nivel " + i + " contando desde la raíz en nivel 0)");
}

// Área del árbol (altura total x cantidad de hojas)
System.out.println("\nÁrea del árbol (altura total x cantidad de hojas):");
int area = arbol.areaBST();
System.out.println("El área se calcula multiplicando la altura total del árbol por la cantidad de hojas.");
System.out.println("Área: " + area);

        //
        System.out.println("\nComparación de área con otro árbol:");
        LinkedBST<Integer> otro = new LinkedBST<>();
        int[] datos2 = {40, 20, 85, 10, 25, 60, 95};
        for (int dato : datos2) {
            otro.insert(dato);
        }
        System.out.println("Área del árbol actual: " + arbol.areaBST());
        System.out.println("Área del segundo árbol: " + otro.areaBST());

        boolean mismaArea = LinkedBST.sameArea(arbol, otro);
        System.out.println("¿Ambos árboles tienen la misma área? " + (mismaArea ? "Sí" : "No"));

        System.out.println("\nDestruyendo el árbol original:");
        try {
            arbol.destroyNodes();
            System.out.println("El árbol ha sido destruido correctamente.");
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al destruir el árbol: " + e.getMessage());
        }

        System.out.println("\nIntentando dibujar el árbol después de destruirlo:");
        arbol.drawBST(); // No debería mostrar nada
    }
}


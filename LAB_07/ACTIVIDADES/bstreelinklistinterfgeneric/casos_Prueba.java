package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

import LAB_07.EXCEPTION.*;

public class casos_Prueba {

    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        try {
            System.out.println("===== INICIO DE PRUEBAS DEL ÁRBOL BINARIO DE BÚSQUEDA =====\n");

            System.out.println(">>> Insertando elementos: 50, 30, 70, 20, 40, 60, 80");
            arbol.insert(50);
            System.out.println("Insertado 50");
            arbol.insert(30);
            System.out.println("Insertado 30");
            arbol.insert(70);
            System.out.println("Insertado 70");
            arbol.insert(20);
            System.out.println("Insertado 20");
            arbol.insert(40);
            System.out.println("Insertado 40");
            arbol.insert(60);
            System.out.println("Insertado 60");
            arbol.insert(80);
            System.out.println("Insertado 80");

            System.out.println("\n>>> Mostrar árbol (toString):");
            System.out.println(arbol);

            System.out.println("\n>>> Probando búsqueda de elementos:");
            System.out.println("Buscando el elemento 40...");
            Integer encontrado = arbol.search(40);
            System.out.println("Resultado: Encontrado -> " + encontrado);

            System.out.println("Buscando el elemento 100 (no existe, debe lanzar excepción)...");
            try {
                arbol.search(100);
            } catch (ItemNoFound e) {
                System.out.println("Excepción capturada correctamente: " + e.getMessage());
            }

            System.out.println("\n>>> Probando recorridos del árbol:");
            System.out.println("Recorrido In-Orden:");
            arbol.mostrarRecorridoInOrden();

            System.out.println("\nRecorrido Pre-Orden:");
            arbol.mostrarRecorridoPreOrden();

            System.out.println("\nRecorrido Post-Orden:");
            arbol.mostrarRecorridoPostOrden();

            System.out.println("\n>>> Probando eliminación de nodos:");
            System.out.println("Eliminando nodo hoja: 20");
            arbol.delete(20);
            System.out.println("Árbol después de eliminar 20:");
            System.out.println(arbol);

            System.out.println("Eliminando nodo con un hijo: 30");
            arbol.delete(30);
            System.out.println("Árbol después de eliminar 30:");
            System.out.println(arbol);

            System.out.println("Eliminando nodo con dos hijos: 50");
            arbol.delete(50);
            System.out.println("Árbol después de eliminar 50:");
            System.out.println(arbol);

            System.out.println("\n>>> Probando inserción de elemento duplicado (70):");
            try {
                arbol.insert(70);
            } catch (ItemDuplicated e) {
                System.out.println("Excepción capturada correctamente: " + e.getMessage());
            }

            System.out.println("\n>>> Probando eliminación en árbol vacío:");
            LinkedBST<Integer> arbolVacio = new LinkedBST<>();
            try {
                System.out.println("Intentando eliminar el elemento 10 en árbol vacío...");
                arbolVacio.delete(10);
            } catch (ExceptionIsEmpty e) {
                System.out.println("Excepción capturada correctamente: " + e.getMessage());
            }

            System.out.println("\n===== FIN DE PRUEBAS =====");

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

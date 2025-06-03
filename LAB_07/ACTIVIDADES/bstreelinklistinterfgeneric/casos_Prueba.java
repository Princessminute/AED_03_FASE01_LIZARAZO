package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;

import LAB_07.EXCEPTION.*;

public class casos_Prueba {

    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        try {
            System.out.println("===== INICIO DE PRUEBAS DEL ÁRBOL BINARIO DE BÚSQUEDA =====\n");

            System.out.println(">>> Insertando los siguientes elementos en el árbol: 50, 30, 70, 20, 40, 60, 80");
            arbol.insert(50); System.out.println("+ Elemento 50 insertado correctamente.");
            arbol.insert(30); System.out.println("+ Elemento 30 insertado correctamente.");
            arbol.insert(70); System.out.println("+ Elemento 70 insertado correctamente.");
            arbol.insert(20); System.out.println("+ Elemento 20 insertado correctamente.");
            arbol.insert(40); System.out.println("+ Elemento 40 insertado correctamente.");
            arbol.insert(60); System.out.println("+ Elemento 60 insertado correctamente.");
            arbol.insert(80); System.out.println("+ Elemento 80 insertado correctamente.");

            System.out.println("\n>>> Representación actual del árbol (toString):");
            System.out.println(arbol);

            System.out.println("\n>>> Pruebas de búsqueda en el árbol:");
            System.out.print("Buscando el elemento 40... ");
            Integer encontrado = arbol.search(40);
            System.out.println("✔ Encontrado: " + encontrado);

            System.out.print("Buscando el elemento 100 (no está en el árbol)... ");
            try {
                arbol.search(100);
            } catch (ItemNoFound e) {
                System.out.println("✘ Excepción esperada capturada: " + e.getMessage());
            }
System.out.println("\n>>> Probando recorridos del árbol:");
System.out.println("\nRecorrido In-Orden:");
String inorden = arbol.obtenerRecorridoInOrden();
System.out.println("Resultado final del recorrido: " + inorden);


System.out.println("");

System.out.println("\nRecorrido Pre-Orden:");
String preorden = arbol.obtenerRecorridoPreOrden();
System.out.println("Resultado final del recorrido: " + preorden);

System.out.println("");
System.out.println("\nRecorrido Post-Orden:");
String posteorden = arbol.obtenerRecorridoPostOrden();
System.out.println("Resultado final del recorrido: " + posteorden);


            System.out.println("\n>>> Pruebas de eliminación de nodos:");
            System.out.println("Eliminando nodo hoja (20)...");
            arbol.delete(20);
            System.out.println("Árbol después de eliminar 20:");
            System.out.println(arbol);

            System.out.println("Eliminando nodo con un solo hijo (30)...");
            arbol.delete(30);
            System.out.println("Árbol después de eliminar 30:");
            System.out.println(arbol);

            System.out.println("Eliminando nodo con dos hijos (50)...");
            arbol.delete(50);
            System.out.println("Árbol después de eliminar 50:");
            System.out.println(arbol);

            System.out.println("\n>>> Prueba de inserción de un elemento duplicado (70):");
            try {
                arbol.insert(70);
            } catch (ItemDuplicated e) {
                System.out.println("✘ Excepción esperada capturada: " + e.getMessage());
            }

            System.out.println("\n>>> Prueba de eliminación en un árbol vacío:");
            LinkedBST<Integer> arbolVacio = new LinkedBST<>();
            try {
                System.out.println("Intentando eliminar el elemento 10 de un árbol vacío...");
                arbolVacio.delete(10);
            } catch (ExceptionIsEmpty e) {
                System.out.println(" Excepción esperada capturada: " + e.getMessage());
            }

            System.out.println("\n>>> Pruebas de obtención del valor mínimo y máximo en el árbol:");
try {
    Integer min = arbol.findMin();
    System.out.println(" Mínimo valor en el árbol: " + min);

    Integer max = arbol.findMax();
    System.out.println(" Máximo valor en el árbol: " + max);
} catch (ItemNoFound e) {
    System.out.println(" Excepción al buscar mínimo o máximo: " + e.getMessage());
}


            System.out.println("\n===== FIN DE LAS PRUEBAS =====");

        } catch (Exception e) {
            System.out.println(" Se produjo un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

}
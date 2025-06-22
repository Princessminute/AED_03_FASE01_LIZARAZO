package LAB_10.BTree;

public class Ejercicio02 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: ELIMINACIÓN EN ÁRBOL B ===\n");

        // Paso 1: Crear el árbol B de orden 4
        System.out.println("Paso 1: Crear el árbol B (orden 4)");
        BTree<Integer> arbol = new BTree<>(4);
        System.out.println("Árbol B creado correctamente.\n");

        // Paso 2: Insertar claves
        int[] claves = {10, 20, 5, 6, 12, 30, 7, 17};
        System.out.println("Paso 2: Insertar claves en el árbol:");
        for (int clave : claves) {
            System.out.println("- Insertando: " + clave);
            arbol.insert(clave);
        }

        // Mostrar estructura del árbol después de las inserciones
        System.out.println("\nEstado del árbol luego de todas las inserciones:");
        System.out.println(arbol);

        // Paso 3: Eliminar algunas claves del árbol
        int[] clavesAEliminar = {6, 20, 10, 12};

        System.out.println("Paso 3: Comenzar la eliminación de claves\n");

        for (int clave : clavesAEliminar) {
            System.out.println("Eliminando clave: " + clave);
            arbol.remove(clave);

            System.out.println("\nEstructura del árbol luego de eliminar " + clave + ":");
            System.out.println(arbol);
        }

        System.out.println("=== FIN DEL EJERCICIO 2 ===");
    }
}

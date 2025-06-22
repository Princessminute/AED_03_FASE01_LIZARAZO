package LAB_10.BTree;

public class Ejercicio01 {
    
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: BÚSQUEDA EN ÁRBOL B ===\n");

        // Paso 1: Crear un árbol B de orden 4 (máximo 3 claves por nodo)
        System.out.println("Paso 1: Crear el árbol B de orden 4");
        BTree<Integer> arbol = new BTree<>(4);
        System.out.println("Árbol B creado exitosamente.\n");

        // Paso 2: Insertar claves en el árbol
        int[] claves = {10, 20, 5, 6, 12, 30, 7, 17};
        System.out.println("Paso 2: Insertar claves:");
        for (int clave : claves) {
            System.out.println("Insertando: " + clave);
            arbol.insert(clave);
        }
        System.out.println("Claves insertadas correctamente.\n");

        // Paso 3: Buscar claves existentes y no existentes
        int[] clavesABuscar = {12, 7, 25, 6, 100};
        System.out.println("Paso 3: Buscar claves en el árbol:\n");

        for (int clave : clavesABuscar) {
            System.out.println("Buscando clave: " + clave);
            boolean encontrado = arbol.search(clave);
            if (!encontrado) {
                System.out.println(clave + " no se encuentra en el árbol.\n");
            } else {
                System.out.println("Búsqueda finalizada con éxito.\n");
            }
        }

        System.out.println("=== FIN DEL EJERCICIO 1 ===");
    }
}

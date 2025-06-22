package LAB_10.BTree;
public class Actividad3 {
    public static void main(String[] args) {
        System.out.println("=== ACTIVIDAD 3: VISUALIZACIÓN DEL ÁRBOL B ===\n");

        // Paso 1: Crear el árbol B de orden 4 (máx. 3 claves por nodo)
        System.out.println("Paso 1: Crear el árbol B de orden 4");
        BTree<Integer> arbol = new BTree<>(4);
        System.out.println("Árbol B creado correctamente.\n");

        // Paso 2: Insertar varias claves
        int[] claves = {10, 20, 5, 6, 12, 30, 7, 17};

        System.out.println("Paso 2: Insertar claves en el árbol:");
        for (int clave : claves) {
            System.out.println("Insertando clave: " + clave);
            arbol.insert(clave);
        }
        System.out.println("\nTodas las claves han sido insertadas.\n");

        // Paso 3: Mostrar la estructura completa del árbol
        System.out.println("Paso 3: Mostrar estructura actual del árbol B:\n");
        System.out.println(arbol.toString());

        System.out.println("=== FIN DE LA ACTIVIDAD 3 ===");
    }
}

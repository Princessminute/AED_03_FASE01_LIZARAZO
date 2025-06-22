package LAB_10.BTree;

public class Actividad2 {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE LA ACTIVIDAD 2 ===");
        System.out.println("Objetivo: Probar inserciones en un árbol B de orden 4 (máximo 3 claves por nodo)\n");

        System.out.println("Paso 1: Crear el árbol B");
        BTree<Integer> arbol = new BTree<>(4);
        System.out.println("Árbol creado correctamente.\n");

        System.out.println("Paso 2: Insertar una serie de claves en el árbol:");
        int[] claves = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int clave : claves) {
            System.out.println("Insertando clave: " + clave);
            arbol.insert(clave);
            System.out.println("Clave " + clave + " insertada.\n");
        }

        System.out.println("Paso 3: Verificar si el árbol está vacío");
        System.out.println("El árbol está vacío: " + arbol.isEmpty());
        System.out.println("\n=== FIN DE LA ACTIVIDAD 2 ===");
    }
}


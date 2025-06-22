package LAB_10.BTree;
import java.util.ArrayList;

public class Actividad1 {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE LA ACTIVIDAD 1 ===");

        // Paso 1: Crear un nodo B de orden 4 (por lo tanto, máximo 3 claves)
        System.out.println("Paso 1: Crear un nodo B con capacidad para 3 claves (orden 4)");
        BNode<Integer> nodo = new BNode<>(3);
        System.out.println("Nodo creado exitosamente.\n");

        // Paso 2: Insertar claves en el nodo
        System.out.println("Paso 2: Insertar claves en el nodo");
        System.out.println("→ Insertando clave 10 en la posición 0");
        nodo.addKey(10, 0);
        System.out.println("→ Insertando clave 20 en la posición 1");
        nodo.addKey(20, 1);
        System.out.println("→ Insertando clave 30 en la posición 2");
        nodo.addKey(30, 2);
        System.out.println("Claves insertadas correctamente.\n");

        // Paso 3: Mostrar el contenido actual del nodo
        System.out.println("Paso 3: Mostrar el contenido del nodo");
        System.out.println("→ Contenido del nodo:");
        System.out.println(nodo + "\n");

        // Paso 4: Buscar una clave que sí existe
        System.out.println("Paso 4: Buscar la clave 20 (esperamos encontrarla)");
        var resultado1 = nodo.searchNode(20);
        if (resultado1.found()) {
            System.out.println("✔ Clave 20 encontrada en la posición " + resultado1.position());
        } else {
            System.out.println("✘ Clave 20 no encontrada. Debería descender por el hijo en la posición " + resultado1.position());
        }
        System.out.println();

        // Paso 5: Buscar una clave que no existe
        System.out.println("Paso 5: Buscar la clave 15 (no debería existir)");
        var resultado2 = nodo.searchNode(15);
        if (resultado2.found()) {
            System.out.println("✔ Clave 15 encontrada en la posición " + resultado2.position());
        } else {
            System.out.println("✘ Clave 15 no encontrada. Debería descender por el hijo en la posición " + resultado2.position());
        }
        System.out.println();

        // Paso 6: Verificar si el nodo está lleno
        System.out.println("Paso 6: Verificar si el nodo está lleno");
        System.out.println("→ ¿El nodo está lleno? " + (nodo.nodeFull(3) ? "✔ Sí" : "✘ No"));
        System.out.println();

        // Paso 7: Verificar si el nodo está vacío
        System.out.println("Paso 7: Verificar si el nodo está vacío");
        System.out.println("→ ¿El nodo está vacío? " + (nodo.nodeEmpty() ? "✔ Sí" : "✘ No"));
        System.out.println();

        System.out.println("=== FIN DE LA ACTIVIDAD 1 ===");
    }
}


package LAB_08.EJERCICIOS;

import LAB_07.EXCEPTION.ItemDuplicated;
import LAB_08.ACTIVIDADES.*;

public class Ejercicio04 {
    public static void main(String[] args) throws ItemDuplicated {
        AVLTree<Integer> tree = new AVLTree<>();

        System.out.println("=== Insertando nodos ===");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.drawBST();
        System.out.println("\n=== Ejecutando recorrido BFS ===");
        tree.breadthFirstTraversal();
        
    }
}

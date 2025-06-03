package LAB_08.EJERCICIOS;

import LAB_08.ACTIVIDADES.AVLTree;

public class Ejercicio06 {
    public static void main(String[] args) throws Exception {
        AVLTree<Integer> avl = new AVLTree<>();

        System.out.println(">>> Inserciones:");
        avl.insert(30);
        avl.breadthFirstTraversal(); // estado actual
        avl.insert(20);
        avl.breadthFirstTraversal();
        avl.insert(10); // aquí se debe dar RSR
        avl.breadthFirstTraversal();
        System.out.println("");
        avl.drawBST();
        System.out.println("");
        avl.insert(25);
        avl.breadthFirstTraversal();
        
        
        avl.insert(5); // puede disparar una RDR

        System.out.println("");
        avl.drawBST();
        System.out.println("");
        
        avl.breadthFirstTraversal();
       System.out.println("");
        avl.drawBST();
        System.out.println("");
        System.out.println("\n>>> Eliminaciones:");
        avl.delete(25);
        avl.breadthFirstTraversal(); // estado tras borrar
        System.out.println("");
        avl.drawBST();
        System.out.println("");
        avl.delete(10);
        avl.breadthFirstTraversal(); // podría haber rebalanceo
        System.out.println("");
        avl.drawBST();
        System.out.println("");
        System.out.println("BYE BYE...");
    }
}

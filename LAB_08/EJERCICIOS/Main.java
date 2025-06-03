package LAB_08.EJERCICIOS;

import LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric.LinkedBST;
import LAB_07.EXCEPTION.ItemDuplicated;
import LAB_07.EXCEPTION.ItemNoFound;
import LAB_08.ACTIVIDADES.*;

public class Main {
    public static void main(String[] args) throws ItemDuplicated, ItemNoFound {

        //  Caso 1: Inserción en orden creciente (peor caso para BST)
        System.out.println("===== CASO 1: Inserción en orden creciente =====");
        AVLTree<Integer> avl1 = new AVLTree<>();
        LinkedBST<Integer> bst1 = new LinkedBST<>();

        int[] caso1 = {10, 20, 30, 40, 50};
        for (int v : caso1) {
            avl1.insert(v);
            bst1.insert(v);
        }

        System.out.println("\nAVL Tree (Caso 1):");
        System.out.println(avl1.toString());

        System.out.println("BST Tree (Caso 1):");
        System.out.println(bst1.toString());

        // Caso 2: Inserción desordenada y búsqueda
        System.out.println("\n===== CASO 2: Inserción desordenada + búsqueda =====");
        AVLTree<Integer> avl2 = new AVLTree<>();
        LinkedBST<Integer> bst2 = new LinkedBST<>();

        int[] caso2 = {30, 10, 50, 5, 20, 40, 60};
        for (int v : caso2) {
            avl2.insert(v);
            bst2.insert(v);
        }

        System.out.println("\nAVL Tree (Caso 2):");
        System.out.println(avl2.toString());

        System.out.println("BST Tree (Caso 2):");
        System.out.println(bst2.toString());

        System.out.println("\nBúsqueda del valor 5:");
        System.out.println("AVL: " + avl2.search(5));
        System.out.println("BST: " + bst2.search(5));
    }
}

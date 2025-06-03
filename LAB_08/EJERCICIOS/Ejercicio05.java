package LAB_08.EJERCICIOS;

import LAB_07.EXCEPTION.ItemDuplicated;
import LAB_08.ACTIVIDADES.AVLTree;

public class Ejercicio05 {
   public static void main(String[] args) throws ItemDuplicated {
        @SuppressWarnings("rawtypes")
        AVLTree arbolAVL = new AVLTree();
        arbolAVL.insert(50);
        arbolAVL.insert(30);
        arbolAVL.insert(70);
        arbolAVL.insert(20);
        arbolAVL.insert(40);
        arbolAVL.insert(60);
        arbolAVL.insert(80);

        System.out.println("=== Recorrido Preorden del árbol AVL ===");
        System.out.println(arbolAVL.obtenerRecorridoPreOrden());
    }

}


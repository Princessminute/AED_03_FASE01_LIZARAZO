package LAB_08.ACTIVIDADES;

import LAB_07.EXCEPTION.ItemDuplicated;

public class TestAVL {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        try {
            // RSR - Rotación simple derecha
            // Inserción en orden descendente: 30, 20, 10
            tree.insert(30);
            
            tree.insert(20);
            tree.insert(10); // Aquí se aplica RSR en 30

            // RSL - Rotación simple izquierda
            // Inserción en orden ascendente: 40, 50
            tree.insert(40);
            tree.insert(50); // Aquí se aplica RSL en 30

            // RDR - Rotación doble izquierda-derecha
            // Provoca desequilibrio en el hijo izquierdo del hijo izquierdo
            tree.insert(5);
            tree.insert(8); // Aquí se aplica RDR en 10

            // RDL - Rotación doble derecha-izquierda
            tree.insert(60);
            tree.insert(55); // Aquí se aplica RDL en 50

            // Casos adicionales (repetimos los tipos para cumplir con 8 pruebas totales)
            tree.insert(65); // RSL si es necesario
            tree.insert(3);  // RSR o RDR según el balance

        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }

    }
    
}


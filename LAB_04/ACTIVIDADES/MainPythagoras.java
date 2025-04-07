package LAB_04.ACTIVIDADES;

import javax.swing.*;

public class MainPythagoras {
    public static void main(String[] args) {
        crearVentana("Árbol de Pitágoras - Nivel 6", 6);
        crearVentana("Árbol de Pitágoras - Nivel 8", 8);
        crearVentana("Árbol de Pitágoras - Nivel 10", 10);
    }

    private static void crearVentana(String titulo, int profundidad) {
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PythagorasTree(profundidad));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


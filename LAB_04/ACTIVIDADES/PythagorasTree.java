package LAB_04.ACTIVIDADES;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class PythagorasTree extends JPanel {
    private int profundidad;

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.GREEN);

        trazaArbol(g2d, 400, 700, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, double x, double y, double lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;

        float tono = (float) nivel / profundidad;
        g.setColor(Color.getHSBColor(tono, 1f, 1f));

        double rad = Math.toRadians(angulo);
        double x2 = x + lado * Math.cos(rad);
        double y2 = y + lado * Math.sin(rad);
        g.drawLine((int) x, (int) y, (int) x2, (int) y2);

        double nuevoLado = lado * 0.7;

        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

}

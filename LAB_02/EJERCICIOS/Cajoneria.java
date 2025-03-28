package LAB_02.EJERCICIOS;

import java.util.ArrayList;
import java.util.Iterator;

public class Cajoneria implements Iterable<Caja<?>> {
    private ArrayList<Caja<?>> lista = new ArrayList<>();
    private int tope;

    public Cajoneria(int tope) {
        super();
        this.tope = tope;
    }

    public void add(Caja<?> caja) {
        if (lista.size() < tope) {
            lista.add(caja);
        } else {
            throw new RuntimeException("No caben más cajas en la cajoneria");
        }
    }

    public String search(Object objeto) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            if (caja.obtenerContenido().equals(objeto)) {
                return "Posición: " + (i + 1) + ", Color: " + caja.obtenerColor();
            }
        }
        return "El objeto no se encuentra en ninguna caja.";
    }

    public void delete(Object objeto) {
        boolean eliminacionRealizada = false;
        StringBuilder cajasEliminadas = new StringBuilder();
        cajasEliminadas.append("Cajas eliminadas:\n");
    
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            if (caja.obtenerContenido().equals(objeto)) {
                cajasEliminadas.append("Posición: " + (i + 1) + ", Color: " + caja.obtenerColor() + ", Contenido: " + caja.obtenerContenido() + "\n");
                lista.remove(i); 
                i--; 
                eliminacionRealizada = true;
            }
        }
    
        if (eliminacionRealizada) {
            System.out.println(cajasEliminadas.toString());
            System.out.println("Estado de la cajonería después de las eliminaciones:");
            System.out.println(this.toString()); 
        } else {
            System.out.println("No se encontró ninguna caja con el contenido especificado.");
        }
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-15s %-20s\n", "Posición", "Color Caja", "Objeto"));
    
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            sb.append(String.format("%-10d %-15s %-20s\n", (i + 1), caja.obtenerColor(), caja.obtenerContenido()));
        }
    
        return sb.toString();
    }    

    @Override
    public Iterator<Caja<?>> iterator() {
        return lista.iterator();
    }
}

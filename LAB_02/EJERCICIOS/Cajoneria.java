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

    public Object delete(Object objeto) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            if (caja.obtenerContenido().equals(objeto)) {
                lista.remove(i); 
                return caja.obtenerContenido(); 
            }
        }
        return null; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posición\tColor Caja\tObjeto\n");

        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            sb.append((i + 1) + "\t" + caja.obtenerColor() + "\t\t" + caja.obtenerContenido() + "\n");
        }

        return sb.toString();
    }

    @Override
    public Iterator<Caja<?>> iterator() {
        return lista.iterator();
    }
}

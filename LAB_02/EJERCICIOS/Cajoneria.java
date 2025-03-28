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

    public String search(Object objetoBusqueda) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            Object contenido = caja.obtenerContenido();
            if (contenido instanceof Chocolatina) {
                Chocolatina choco = (Chocolatina) contenido;
                if (choco.getMarca().equalsIgnoreCase(objetoBusqueda.toString())) {
                    return "Posición: " + (i + 1) + ", Color: " + caja.obtenerColor() + ", Contenido: " + contenido;
                }
            } else if (contenido instanceof Golosina) {
                Golosina golosina = (Golosina) contenido;
                if (objetoBusqueda instanceof String) {
                    String[] partes = ((String) objetoBusqueda).split(",");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        try {
                            double peso = Double.parseDouble(partes[1].trim());
                            if (golosina.getNombre().equalsIgnoreCase(nombre) && golosina.getPeso() == peso) {
                                return "Posición: " + (i + 1) + ", Color: " + caja.obtenerColor() + ", Contenido: " + contenido;
                            }
                        } catch (NumberFormatException e) {
                            return "El peso proporcionado no es válido.";
                        }
                    }
                }
            }
        }
        return "El objeto no se encuentra en ninguna caja.";
    }

    public void delete(Object objetoBusqueda) {
        boolean eliminacionRealizada = false;
        StringBuilder cajasEliminadas = new StringBuilder();
        cajasEliminadas.append("Cajas eliminadas:\n");
    
        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);
            Object contenido = caja.obtenerContenido();
            if (contenido instanceof Chocolatina) {
                Chocolatina choco = (Chocolatina) contenido;
                if (choco.getMarca().equalsIgnoreCase(objetoBusqueda.toString())) {
                    cajasEliminadas.append("Posición: " + (i + 1) + ", Color: " + caja.obtenerColor() + ", Contenido: " + contenido + "\n");
                    lista.remove(i);
                    i--;
                    eliminacionRealizada = true;
                }
            } else if (contenido instanceof Golosina) {
                Golosina golosina = (Golosina) contenido;
                if (objetoBusqueda instanceof String) {
                    String[] partes = ((String) objetoBusqueda).split(",");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        try {
                            double peso = Double.parseDouble(partes[1].trim());
                            if (golosina.getNombre().equalsIgnoreCase(nombre) && golosina.getPeso() == peso) {
                                cajasEliminadas.append("Posición: " + (i + 1) + ", Color: " + caja.obtenerColor() + ", Contenido: " + contenido + "\n");
                                lista.remove(i);
                                i--;
                                eliminacionRealizada = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("El peso proporcionado no es válido.");
                        }
                    }
                }
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

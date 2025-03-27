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

    @Override
    public Iterator<Caja<?>> iterator() {
        return lista.iterator();
    }
}


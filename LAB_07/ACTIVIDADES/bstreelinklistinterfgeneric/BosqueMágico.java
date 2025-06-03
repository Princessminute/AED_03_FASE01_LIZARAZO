package LAB_07.ACTIVIDADES.bstreelinklistinterfgeneric;
import java.util.*;

public class BosqueMágico<T> {

    static class Hojita<T> {
        T esencia;
        List<Hojita<T>> retoños = new ArrayList<>();

        public Hojita(T esencia) {
            this.esencia = esencia;
        }

        public void brotar(Hojita<T> nuevoRetoño) {
            retoños.add(nuevoRetoño);
        }
    }

    private Hojita<T> troncoMayor;

    public BosqueMágico(T esenciaRaíz) {
        this.troncoMayor = new Hojita<>(esenciaRaíz);
    }

    public Hojita<T> almaDelÁrbol() {
        return troncoMayor;
    }

    public void hechizoVisual() {
        conjurar(troncoMayor, 0);
    }

    private void conjurar(Hojita<T> actual, int profundidad) {
        eco(profundidad);
        System.out.println(actual.esencia);

        if (!actual.retoños.isEmpty()) {
            eco(profundidad);
            System.out.println("(");
            for (Hojita<T> brote : actual.retoños) {
                conjurar(brote, profundidad + 1);
            }
            eco(profundidad);
            System.out.println(")");
        }
    }

    private void eco(int nivel) {
        System.out.print("    ".repeat(nivel));
    }
}

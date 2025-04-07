package LAB_04.ACTIVIDADES;

public class Hanoi {
    public static void main(String[] args) {
        int numeroDeDiscos = 3;
        System.out.println("Solución para " + numeroDeDiscos + " discos:");
        torresHanoi(numeroDeDiscos, 1, 2, 3);
    }

    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
        } else {
            torresHanoi(discos - 1, origen, destino, auxiliar);
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}


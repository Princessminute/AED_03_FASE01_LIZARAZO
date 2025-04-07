package LAB_04.ACTIVIDADES;

import java.util.Scanner;

public class HanoiTower {

    static int movimientos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de discos: ");
        int numeroDeDiscos = sc.nextInt();

        System.out.println("\nSolución para " + numeroDeDiscos + " discos:");
        torresHanoi(numeroDeDiscos, 1, 2, 3);
        System.out.println("\nLa cantidad máxima de movimientos es: " + movimientos);

        sc.close();
    }

    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        if (discos == 1) {
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            movimientos++;
        } else {
            torresHanoi(discos - 1, origen, destino, auxiliar);
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            movimientos++;
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}

package LAB_02.ACTIVIDADES;

import java.util.Scanner;

public class PrincipalIngreso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número máximo de chocolatinas que puede tener la bolsa: ");
        int tope = scanner.nextInt();
        scanner.nextLine(); 

        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(tope);

        for (int i = 0; i < tope; i++) {
            System.out.print("Ingrese la marca de la chocolatina #" + (i + 1) + ": ");
            String marca = scanner.nextLine();
            Chocolatina chocolatina = new Chocolatina(marca);
            bolsaCho.add(chocolatina);
        }

        System.out.println("\nChocolatinas en la bolsa:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        scanner.close();
    }
}

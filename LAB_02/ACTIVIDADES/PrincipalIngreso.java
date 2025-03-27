package LAB_02.ACTIVIDADES;

import java.util.Scanner;

public class PrincipalIngreso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso para la bolsa de chocolatinas
        System.out.print("Ingrese el número máximo de chocolatinas que puede tener la bolsa: ");
        int topeChocolatinas = scanner.nextInt();
        scanner.nextLine(); 

        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(topeChocolatinas);

        for (int i = 0; i < topeChocolatinas; i++) {
            System.out.print("Ingrese la marca de la chocolatina #" + (i + 1) + ": ");
            String marca = scanner.nextLine();
            Chocolatina chocolatina = new Chocolatina(marca);
            bolsaCho.add(chocolatina);
        }

        System.out.println("\nChocolatinas en la bolsa:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Ingreso para la bolsa de golosinas
        System.out.print("\nIngrese el número máximo de golosinas que puede tener la bolsa: ");
        int topeGolosinas = scanner.nextInt();
        scanner.nextLine(); 

        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(topeGolosinas);

        for (int i = 0; i < topeGolosinas; i++) {
            System.out.print("Ingrese el nombre de la golosina #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el peso de la golosina #" + (i + 1) + " (en gramos): ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); 
            Golosina golosina = new Golosina(nombre, peso);
            bolsaGolo.add(golosina);
        }

        System.out.println("\nGolosinas en la bolsa:");
        for (Golosina golosina : bolsaGolo) {
            System.out.println(golosina);
        }

        scanner.close();
    }
}


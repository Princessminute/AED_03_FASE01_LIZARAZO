package LAB_01.PyPooAct1;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // añadir una condicional donde pida que los usuarios si o si
        System.out.println("********************************************");
        System.out.println("Bienvenido al Programa de la Actividad 01");
        System.out.println("********************************************");

        System.out.println("Por favor ingrese las coordenadas de la esquina 1 del rectángulo A (x y): ");
        double xA1 = scanner.nextDouble();
        double yA1 = scanner.nextDouble();
        System.out.println("Por favor ingrese las coordenadas de la esquina 2 del rectángulo A (x y): ");
        double xA2 = scanner.nextDouble();
        double yA2 = scanner.nextDouble();

        System.out.println("Por favor ingrese las coordenadas de la esquina 1 del rectángulo B (x y): ");
        double xB1 = scanner.nextDouble();
        double yB1 = scanner.nextDouble();
        System.out.println("Por favor ingrese las coordenadas de la esquina 2 del rectángulo B (x y): ");
        double xB2 = scanner.nextDouble();
        double yB2 = scanner.nextDouble();

        Coordenada esquina1A = new Coordenada(xA1, yA1);
        Coordenada esquina2A = new Coordenada(xA2, yA2);
        Coordenada esquina1B = new Coordenada(xB1, yB1);
        Coordenada esquina2B = new Coordenada(xB2, yB2);

        Rectangulo rectanguloA = new Rectangulo(esquina1A, esquina2A);
        Rectangulo rectanguloB = new Rectangulo(esquina1B, esquina2B);

        System.out.println("Rectángulo A: " + rectanguloA);
        System.out.println("Rectángulo B: " + rectanguloB);

        Verificador verificador = new Verificador();

        if (verificador.seSobreponen(rectanguloA, rectanguloB)) {
            System.out.println("Caso 1: Los rectángulos A y B se sobreponen.");
        } else if (verificador.estanJuntos(rectanguloA, rectanguloB)) {
            System.out.println("Caso 2: Los rectángulos A y B están juntos.");
        } else if (verificador.sonDisjuntos(rectanguloA, rectanguloB)) {
            System.out.println("Caso 3: Los rectángulos A y B son disjuntos.");
        }

        scanner.close();
    }
}




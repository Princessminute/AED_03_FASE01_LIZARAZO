package LAB_01.PyPooEje1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********************************************");
        System.out.println("Bienvenido al Programa Modificado");
        System.out.println("********************************************");

        System.out.println("Ingrese el número máximo de rectángulos a almacenar: ");
        int maxRectangulos = scanner.nextInt();
        ContainerRect contenedor = new ContainerRect(maxRectangulos);

        for (int i = 0; i < maxRectangulos; i++) {
            System.out.println("Ingrese las coordenadas de la esquina 1 del rectángulo " + (i + 1) + " (x y): ");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            System.out.println("Ingrese las coordenadas de la esquina 2 del rectángulo " + (i + 1) + " (x y): ");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            Coordenada esquina1 = new Coordenada(x1, y1);
            Coordenada esquina2 = new Coordenada(x2, y2);
            Rectangulo rect = new Rectangulo(esquina1, esquina2);

            contenedor.agregarRectangulo(rect);
        }

        System.out.println("\nInformación de los rectángulos:");
        contenedor.mostrarInfoRectangulos();

        Verificador verificador = new Verificador();
        for (int i = 0; i < maxRectangulos - 1; i++) {
            for (int j = i + 1; j < maxRectangulos; j++) {
                Rectangulo rectanguloA = contenedor.getRectangulo(i);
                Rectangulo rectanguloB = contenedor.getRectangulo(j);

                System.out.println("\nComparando Rectángulo " + (i + 1) + " con Rectángulo " + (j + 1) + ":");

                if (verificador.seSobreponen(rectanguloA, rectanguloB)) {
                    System.out.println("Caso 1: Los rectángulos se sobreponen.");
                } else if (verificador.estanJuntos(rectanguloA, rectanguloB)) {
                    System.out.println("Caso 2: Los rectángulos están juntos.");
                } else if (verificador.sonDisjuntos(rectanguloA, rectanguloB)) {
                    System.out.println("Caso 3: Los rectángulos son disjuntos.");
                }
            }
        }

        scanner.close();
    }
}



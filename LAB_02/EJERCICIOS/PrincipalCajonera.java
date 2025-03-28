package LAB_02.EJERCICIOS;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalCajonera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int topeCajoneria;
        while (true) {
            System.out.println("¿Cuál es el tope de la cajonería (máxima cantidad de cajas)?");
            topeCajoneria = scanner.nextInt();
            scanner.nextLine(); 

            if (topeCajoneria > 0) {
                break;
            } else {
                System.out.println("El tope debe ser un número mayor que cero. Intente nuevamente.");
            }
        }
        Cajoneria cajoneria = new Cajoneria(topeCajoneria);

        int cantidadCajas;
        while (true) {
            System.out.println("¿Cuántas cajas desea crear? (Debe ser menor o igual al tope)");
            cantidadCajas = scanner.nextInt();
            scanner.nextLine(); 

            if (cantidadCajas > 0 && cantidadCajas <= topeCajoneria) {
                break;
            } else {
                System.out.println("Cantidad inválida. Debe ser mayor que cero y menor o igual al tope.");
            }
        }

        for (int i = 0; i < cantidadCajas; i++) {
            int tipo;
            while (true) {
                System.out.println("Ingrese el tipo de contenido para la caja " + (i + 1) + " (1: Integer, 2: String, 3: Double):");
                tipo = scanner.nextInt();
                scanner.nextLine(); 
                if (tipo == 1 || tipo == 2 || tipo == 3) {
                    break;
                } else {
                    System.out.println("Tipo de contenido no válido. Intente nuevamente.");
                }
            }

            String color;
            switch (tipo) {
                case 1: 
                    int numero;
                    while (true) {
                        System.out.println("Ingrese un número entero para la caja " + (i + 1) + ":");
                        try {
                            numero = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Debe ingresar un número entero.");
                            scanner.nextLine(); 
                        }
                    }
                    while (true) {
                        System.out.println("Ingrese un color para la caja:");
                        color = scanner.nextLine();
                        if (color.matches("[a-zA-Z]+")) { 
                            break;
                        } else {
                            System.out.println("El color solo puede contener letras. Intente nuevamente.");
                        }
                    }                    
                    Caja<Integer> cajaDeEnteros = new Caja<>(numero, color);
                    cajoneria.add(cajaDeEnteros);
                    break;

                    case 2: 
                    String texto;
                    while (true) {
                        System.out.println("Ingrese un texto para la caja " + (i + 1) + ":");
                        texto = scanner.nextLine();
                        if (texto.matches("[a-zA-Z]+")) { 
                            break;
                        } else {
                            System.out.println("El texto solo puede contener letras. Intente nuevamente.");
                        }
                    }                    
                    while (true) {
                        System.out.println("Ingrese un color para la caja:");
                        color = scanner.nextLine();
                        if (color.matches("[a-zA-Z]+")) { 
                            break;
                        } else {
                            System.out.println("El color solo puede contener letras. Intente nuevamente.");
                        }
                    }                    
                    Caja<String> cajaDeCadenas = new Caja<>(texto, color);
                    cajoneria.add(cajaDeCadenas);
                    break;                

                case 3: 
                    double decimal;
                    while (true) {
                        System.out.println("Ingrese un número decimal para la caja " + (i + 1) + ":");
                        try {
                            decimal = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Debe ingresar un número decimal.");
                            scanner.nextLine(); 
                        }
                    }
                    while (true) {
                        System.out.println("Ingrese un color para la caja:");
                        color = scanner.nextLine();
                        if (color.matches("[a-zA-Z]+")) { 
                            break;
                        } else {
                            System.out.println("El color solo puede contener letras. Intente nuevamente.");
                        }
                    }
                    Caja<Double> cajaDeDecimales = new Caja<>(decimal, color);
                    cajoneria.add(cajaDeDecimales);
                    break;
            }
        }

        System.out.println("\nContenido de la cajonería:");
        for (Caja<?> caja : cajoneria) {
            System.out.println("Contenido: " + caja.obtenerContenido() + ", Color: " + caja.obtenerColor());
        }

        scanner.close();
    }
}


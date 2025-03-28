package LAB_02.EJERCICIOS;
import java.util.InputMismatchException; //captura errores cuando se ingresa un dato de tipo incorrecto
import java.util.Scanner;

public class PrincipalCajoneria4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int topeCajoneria;
        while (true) {
            System.out.println("¿Cuál es el tope de la cajonería (máxima cantidad de cajas)?");
            try {
                topeCajoneria = scanner.nextInt();
                scanner.nextLine();
                if (topeCajoneria > 0) {
                    break;
                } else {
                    System.out.println("El tope debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }
        
        Cajoneria cajoneria = new Cajoneria(topeCajoneria);
        int cantidadCajas;
        while (true) {
            System.out.println("¿Cuántas cajas desea crear? (Debe ser menor o igual al tope)");
            try {
                cantidadCajas = scanner.nextInt();
                scanner.nextLine();
                if (cantidadCajas > 0 && cantidadCajas <= topeCajoneria) {
                    break;
                } else {
                    System.out.println("Cantidad inválida. Debe ser mayor que cero y menor o igual al tope.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }
        
        for (int i = 0; i < cantidadCajas; i++) {
            System.out.println("\nCreando caja " + (i + 1) + ":");
            int tipo;
            while (true) {
                System.out.println("Ingrese el tipo de objeto para la caja " + (i + 1) + " (1: Chocolatina, 2: Golosina):");
                try {
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1 || tipo == 2) {
                        break;
                    } else {
                        System.out.println("Tipo de objeto no válido. Intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Debe ingresar un número entero (1 o 2).");
                    scanner.nextLine();
                }
            }
            
            switch (tipo) {
                case 1:
                    System.out.println("Ingrese la marca de la Chocolatina para la caja " + (i + 1) + ":");
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el color de la caja:");
                    String colorChoco = scanner.nextLine();
                    Caja<Chocolatina> cajaDeChocolatina = new Caja<>(new Chocolatina(marca), colorChoco);
                    cajoneria.add(cajaDeChocolatina);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la Golosina para la caja " + (i + 1) + ":");
                    String nombre = scanner.nextLine();
                    double peso;
                    while (true) {
                        System.out.println("Ingrese el peso de la Golosina en gramos:");
                        try {
                            peso = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Debe ingresar un número decimal.");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Ingrese el color de la caja:");
                    String colorGolosina = scanner.nextLine();
                    Caja<Golosina> cajaDeGolosina = new Caja<>(new Golosina(nombre, peso), colorGolosina);
                    cajoneria.add(cajaDeGolosina);
                    break;
            }
        }
        
        System.out.println("\nContenido inicial de la cajonería:");
        System.out.println(cajoneria.toString());
        
        while (true) {
            System.out.println("\n¿Desea buscar un objeto en la cajonería? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                int tipoBusqueda;
                while (true) {
                    System.out.println("Ingrese el tipo de objeto a buscar (1: Chocolatina, 2: Golosina):");
                    try {
                        tipoBusqueda = scanner.nextInt();
                        scanner.nextLine();
                        if (tipoBusqueda == 1 || tipoBusqueda == 2) {
                            break;
                        } else {
                            System.out.println("Tipo no válido. Intente nuevamente.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Debe ingresar 1 o 2.");
                        scanner.nextLine();
                    }
                }
                if (tipoBusqueda == 1) {
                    System.out.println("Ingrese la marca de la Chocolatina a buscar:");
                    String marcaBusqueda = scanner.nextLine();
                    Chocolatina objBuscado = new Chocolatina(marcaBusqueda);
                    String resultadoBusqueda = cajoneria.search(objBuscado);
                    System.out.println(resultadoBusqueda);
                    if (!resultadoBusqueda.toLowerCase().contains("no se encuentra")) {
                        System.out.println("¿Desea eliminar este objeto de la cajonería? (s/n):");
                        String eliminar = scanner.nextLine();
                        if (eliminar.equalsIgnoreCase("s")) {
                            cajoneria.delete(objBuscado);
                        }
                    }
                } else if (tipoBusqueda == 2) {
                    System.out.println("Ingrese el nombre de la Golosina a buscar:");
                    String nombreBusqueda = scanner.nextLine();
                    double pesoBusqueda;
                    while (true) {
                        System.out.println("Ingrese el peso de la Golosina en gramos:");
                        try {
                            pesoBusqueda = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Debe ingresar un número decimal.");
                            scanner.nextLine();
                        }
                    }
                    Golosina objBuscado = new Golosina(nombreBusqueda, pesoBusqueda);
                    String resultadoBusqueda = cajoneria.search(objBuscado);
                    System.out.println(resultadoBusqueda);
                    if (!resultadoBusqueda.toLowerCase().contains("no se encuentra")) {
                        System.out.println("¿Desea eliminar este objeto de la cajonería? (s/n):");
                        String eliminar = scanner.nextLine();
                        if (eliminar.equalsIgnoreCase("s")) {
                            cajoneria.delete(objBuscado);
                        }
                    }
                }
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("Finalizando búsqueda.");
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        System.out.println("\nEstado final de la cajonería:");
        System.out.println(cajoneria.toString());
        scanner.close();
    }
}



package LAB_06.EJERCICIOS.Ejercicio4;
import java.util.Scanner;

public class Test {

    private static void procesarEntrada(String linea) {
        System.out.println("\n Cadena ingresada: \"" + linea + "\"");
    
        boolean resultado = Application.symbolBalancing(linea);
    
        System.out.println("\n RESUMEN DEL ANÁLISIS:"); //Pila
        if (resultado) {
            System.out.println(" La cadena ESTÁ correctamente anidada.");
            System.out.println("   Todos los símbolos de apertura tienen su símbolo de cierre.");
            System.out.println("   El orden de cierre es correcto.");
            System.out.println("   No hay símbolos sin emparejar.");
        } else {
            System.out.println(" La cadena NO está correctamente anidada.");
            System.out.println("   Puede haber un símbolo cerrado sin haberse abierto.");
            System.out.println("   O un símbolo abierto que nunca se cerró.");
            System.out.println("   O el orden de los símbolos está incorrecto.");
        }
    }

    private static void ejecutarPruebas() {
        System.out.println("\n--- Ejecutando pruebas ---");

        String[] pruebas = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}"
        };

        for (String entrada : pruebas) {
            System.out.println("\n------------------------------------");
            System.out.println("Cadena de prueba: \"" + entrada + "\"");
            boolean resultado = Application.symbolBalancing(entrada);
            System.out.println("Resultado del análisis:");
            if (resultado) {
                System.out.println(" Anidamiento correcto.");
            } else {
                System.out.println(" Anidamiento incorrecto.");
            }
            System.out.println("------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Ingresar una cadena manualmente");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\nNOTA:");
                    System.out.println("- Puedes usar cualquier combinación de (), [], {}.");
                    System.out.println("- Se evaluará si están correctamente abiertos y cerrados.");
                    System.out.print("Ingresa la cadena de corchetes (ej. ()()[()]{}): ");
                    String linea = sc.nextLine();
                    procesarEntrada(linea);
                    break;

                case 2:
                    ejecutarPruebas();
                    break;

                case 0:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 0);
    }
    +
}


package LAB_04.EJERCICIOS;
import java.util.*;

public class PotenciaRestringida {

    public static boolean Potencia2(int n) {
        return n > 0 && Math.log(n) / Math.log(2) % 1 == 0;
    }

    static boolean sumarrObjetivo(int[] arreglo, int objetivo) {
        int suma = 0;
        List<Integer> opcionales = new ArrayList<>();

        for (int i = 0; i < arreglo.length; i++) {
            int actual = arreglo[i];

            if (Potencia2(actual)) {
                suma += actual;
            } else if (actual % 5 == 0 && i + 1 < arreglo.length && arreglo[i + 1] % 2 != 0) {
                continue;
            } else {
                opcionales.add(actual);
            }
        }

        if (suma > objetivo) return false;

        return puedeFormarConDP(opcionales, objetivo - suma);
    }

    static boolean puedeFormarConDP(List<Integer> lista, int objetivo) {
        boolean[] dp = new boolean[objetivo + 1];
        dp[0] = true;

        for (int num : lista) {
            for (int j = objetivo; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[objetivo];
    }

    public static void procesarEntrada(String linea) {
        String[] partes = linea.trim().split("\\s+");
        int N = Integer.parseInt(partes[0]);
        int[] arreglo = new int[N];
        for (int i = 0; i < N; i++) {
            arreglo[i] = Integer.parseInt(partes[i + 1]);
        }
        int objetivo = Integer.parseInt(partes[partes.length - 1]);

        System.out.println("Arreglo: " + Arrays.toString(arreglo));
        System.out.println("Objetivo: " + objetivo);
        boolean resultado = sumarrObjetivo(arreglo, objetivo);
        System.out.println("Resultado: " + resultado);
    }

    public static void ejecutarPruebas() {
        String[] pruebas = {
            "5 4 8 10 3 5 27",
            "5 4 8 10 3 6 27",
            "6 2 16 5 7 10 33",
            "6 2 16 5 3 10 33",
            "4 2 5 1 6 13"
        };

        for (String prueba : pruebas) {
            System.out.println("\nEntrada: " + prueba);
            procesarEntrada(prueba);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar un conjunto manualmente");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("NOTA:");
                    System.out.println("- 1er num -> cant de elementos del arreglo");
                    System.out.println("- Los siguientes números son los elementos del arreglo");
                    System.out.println("- Último num -> Objetivo (suma esperada)");
                    System.out.print("Ingresa los números separados por espacio (ej. 5 4 8 10 3 5 27): ");
                    String linea = sc.nextLine();
                    procesarEntrada(linea);
                    break;

                case 2:
                    ejecutarPruebas();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}

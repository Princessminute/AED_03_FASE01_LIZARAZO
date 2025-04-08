package LAB_04.EJERCICIOS;

import java.util.*;


public class PotenciaRestringida {


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
                    System.out.println("- 1er num -> cant de elementos del arreglo ");
                    System.out.println("- Los siguientes numeros son los elementos del arreglo");
                    System.out.println("- Ultimo num -> Objetivo (suma esperada)");
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


    public static void procesarEntrada(String linea) {
        String[] partes = linea.trim().split(" ");
        int N = Integer.parseInt(partes[0]);
        int[] arreglo = new int[N];


        for (int i = 0; i < N; i++) {
            arreglo[i] = Integer.parseInt(partes[i + 1]);
        }


        int objetivo = Integer.parseInt(partes[partes.length - 1]);
        boolean resultado = sePuedeFormarSuma(arreglo, objetivo);
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


    public static boolean sePuedeFormarSuma(int[] arr, int objetivo) {
        List<Integer> obligatorios = new ArrayList<>();
        List<Integer> opcionales = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            int actual = arr[i];


            if (esPotenciaDeDos(actual)) {
                obligatorios.add(actual);
            } else if (esMultiploDeCinco(actual) && i < arr.length - 1 && esImpar(arr[i + 1])) {
                continue;
            } else {
                opcionales.add(actual);
            }
        }


        int sumaObligatoria = sumaLista(obligatorios);
        int objetivoRestante = objetivo - sumaObligatoria;


        if (objetivoRestante < 0) return false;
        return sePuedeFormarSubconjunto(opcionales, objetivoRestante);
    }


    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public static boolean esMultiploDeCinco(int n) {
        return n % 5 == 0;
    }


    public static boolean esImpar(int n) {
        return n % 2 != 0;
    }


    public static int sumaLista(List<Integer> lista) {
        int suma = 0;
        for (int num : lista) suma += num;
        return suma;
    }


    public static boolean sePuedeFormarSubconjunto(List<Integer> nums, int objetivo) {
        int n = nums.size();
        boolean[][] dp = new boolean[n + 1][objetivo + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;


        for (int i = 1; i <= n; i++) {
            int num = nums.get(i - 1);
            for (int j = 0; j <= objetivo; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[n][objetivo];
    }
}

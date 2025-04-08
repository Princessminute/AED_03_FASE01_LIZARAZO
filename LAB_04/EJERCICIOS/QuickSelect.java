package LAB_04.EJERCICIOS;
import java.util.*;

public class QuickSelect {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    private static int quickselect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }
        
        int pivotIndex = partition(arr, low, high);
        
        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (pivotIndex < k) {
            return quickselect(arr, pivotIndex + 1, high, k);
        } else {
            return quickselect(arr, low, pivotIndex - 1, k);
        }
    }

    public static int kThSmallestElement(int[] arr, int k) {
        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    private static void procesarEntrada(String linea) {
        String[] tokens = linea.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[tokens.length - 1]);
        
        int[] arr = new int[n];
        for (int i = 1; i < tokens.length - 1; i++) {
            arr[i - 1] = Integer.parseInt(tokens[i]);
        }
        
        System.out.println("El " + k + "-ésimo elemento más pequeño es: " + kThSmallestElement(arr, k));
    }

    private static void ejecutarPruebas() {
        System.out.println("\nEjecutando pruebas de ejemplo...");
        
        int[] arr1 = {4, 2, 7, 10, 4, 17};
        System.out.println("Entrada: " + Arrays.toString(arr1) + ", 3");
        System.out.println("Salida: " + kThSmallestElement(arr1, 3));

        int[] arr2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println("Entrada: " + Arrays.toString(arr2) + ", 5");
        System.out.println("Salida: " + kThSmallestElement(arr2, 5));

        int[] arr3 = {4, 2, 7, 1, 4, 6};
        System.out.println("Entrada: " + Arrays.toString(arr3) + ", 1");
        System.out.println("Salida: " + kThSmallestElement(arr3, 1));

        int[] arr4 = {9, 2, 7, 1, 7};
        System.out.println("Entrada: " + Arrays.toString(arr4) + ", 4");
        System.out.println("Salida: " + kThSmallestElement(arr4, 4));
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
                    System.out.println("- 1er num -> cant de elementos del arreglo ");
                    System.out.println("- Los siguientes numeros son los elementos del arreglo");
                    System.out.println("- Ultimo num -> Objetivo (posición esperada)");
                    System.out.print("Ingresa los números separados por espacio (ej. 6 4 2 7 10 4 17 3): ");
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

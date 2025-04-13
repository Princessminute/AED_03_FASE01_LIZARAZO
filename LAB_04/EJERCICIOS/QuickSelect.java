package LAB_04.EJERCICIOS;
import java.util.*;

public class QuickSelect {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println("  -> Particionando con pivote " + pivot + " (índice " + high + ")");
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

        System.out.println("     Estado del arreglo: " + Arrays.toString(arr));
        System.out.println("     Índice del pivote después de particionar: " + (i + 1));
        return i + 1;
    }

    private static int quickselect(int[] arr, int low, int high, int k) {
        if (low == high) {
            System.out.println("  -> Solo un elemento restante. Resultado encontrado: " + arr[low]);
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == k) {
            System.out.println("  -> El índice del pivote coincide con k. Resultado encontrado: " + arr[pivotIndex]);
            return arr[pivotIndex];
        } else if (pivotIndex < k) {
            System.out.println("  -> Buscando en la mitad derecha desde " + (pivotIndex + 1) + " hasta " + high);
            return quickselect(arr, pivotIndex + 1, high, k);
        } else {
            System.out.println("  -> Buscando en la mitad izquierda desde " + low + " hasta " + (pivotIndex - 1));
            return quickselect(arr, low, pivotIndex - 1, k);
        }
    }

    public static int kThSmallestElement(int[] arr, int k) {
        System.out.println("\nIniciando búsqueda del " + k + "-ésimo elemento más pequeño...");
        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    private static void procesarEntrada(String linea) {
        String[] tokens = linea.trim().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[tokens.length - 1]);

        int[] arr = new int[n];
        for (int i = 1; i < tokens.length - 1; i++) {
            arr[i - 1] = Integer.parseInt(tokens[i]);
        }

        System.out.println("Entrada original: " + Arrays.toString(arr));
        int resultado = kThSmallestElement(arr, k);
        System.out.println("Resultado final: El " + k + "-ésimo elemento más pequeño es " + resultado);
    }

    private static void ejecutarPruebas() {
        System.out.println("\nEjecutando pruebas de ejemplo...");

        int[][] pruebas = {
            {6, 4, 2, 7, 10, 5, 17, 3},
            {7, 4, 2, 7, 10, 4, 1, 6, 5},
            {6, 4, 2, 7, 1, 4, 6, 1},
            {5, 9, 2, 7, 1, 7, 4}
        };

        for (int[] entrada : pruebas) {
            int n = entrada[0];
            int k = entrada[entrada.length - 1];
            int[] datos = Arrays.copyOfRange(entrada, 1, entrada.length - 1);
            System.out.println("\n------------------------------------");
            System.out.println("Entrada: " + Arrays.toString(datos) + ", k = " + k);
            int resultado = kThSmallestElement(datos, k);
            System.out.println("Resultado final: " + resultado);
            System.out.println("------------------------------------");
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
                    System.out.println("- 1er número → cantidad de elementos del arreglo");
                    System.out.println("- Los siguientes → elementos del arreglo");
                    System.out.println("- Último número → posición del elemento que deseas encontrar");
                    System.out.print("Ingresa los números separados por espacio (ej. 6 4 2 7 10 4 17 3): ");
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
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}

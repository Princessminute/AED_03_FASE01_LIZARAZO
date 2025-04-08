package LAB_04.ACTIVIDADES;

import java.util.Scanner;

public class BBIterativo {
    int binarySearch(int arr[], int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BBIterativo ob = new BBIterativo();
        int arr[] = { 1, 3, 5, 4, 5 };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número a buscar: ");
        int x = scanner.nextInt();

        long startTime = System.nanoTime();
        int position = ob.binarySearch(arr, x);
        long endTime = System.nanoTime();

        if (position == -1)
            System.out.println("Elemento no encontrado");
        else
            System.out.println("Elemento encontrado en el índice: " + position);

        System.out.print("El arreglo es el siguiente: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Tiempo de ejecución (iterativo): " + (endTime - startTime) + " nanosegundos");
    }
}

    

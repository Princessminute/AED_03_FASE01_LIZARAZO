package LAB_04.ACTIVIDADES;

import java.util.Scanner;

public class BusquedaBinaria {
    
    int binarySearch(int arr[], int lo, int hi, int x) {
        if (hi >= lo && lo < arr.length) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);
            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        BusquedaBinaria ob = new BusquedaBinaria();
        int arr[] = { 1, 2, 3, 4, 5 };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número a buscar: ");
        int x = scanner.nextInt();
        int n = arr.length;
        int position = ob.binarySearch(arr, 0, n - 1, x);
        if (position == -1)
            System.out.println("Elemento no encontrado !!!");
        else
            System.out.println("Elemento encontrado en el índice: " + position);
        System.out.print("El arreglo es el siguiente: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

    
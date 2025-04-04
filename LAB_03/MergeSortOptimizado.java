package LAB_03;

import java.util.Arrays;

public class MergeSortOptimizado {
    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length]; // Arreglo auxiliar reutilizable
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] aux, int left, int right) {
        if (left >= right) return; // Caso base

        int mid = left + (right - left) / 2;
        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        System.arraycopy(arr, left, aux, left, right - left + 1); // Copia eficiente

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            arr[k++] = (aux[i] <= aux[j]) ? aux[i++] : aux[j++];
        }
        while (i <= mid) arr[k++] = aux[i++]; // Copia elementos restantes
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }
}

package LAB_04.ACTIVIDADES;
public class MainModa1 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 2, 2, 3, 4, 4, 4};
        
        System.out.print("El arreglo es: ");
        imprimirArreglo(array);
        
        int moda = modal(array);
        System.out.println("La moda del arreglo es: " + moda);
    }

    public static int modal(int[] array) {
        int first = 0;
        int end = array.length - 1;
        if (first == end) return array[first];
        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda);
        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }
        return moda;
    }

    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end) return 0;
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele) {
                suma++;
            }
        }
        return suma;
    }

    private static void imprimirArreglo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); 
    }
}





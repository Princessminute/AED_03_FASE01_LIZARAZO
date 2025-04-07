package LAB_04.ACTIVIDADES;

public class MainModa2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        
        System.out.print("El arreglo es: ");
        imprimirArreglo(array);
        
        int moda = modaOrdenada(array);
        System.out.println("La moda del arreglo es: " + moda);
    }

    public static int modaOrdenada(int[] array) {
        int first = 0;
        int end = array.length - 1;
        if (first == end) return array[first];
        
        int moda = array[first];
        int maxfrec = 1;
        int frec = 1;
        
        for (int i = 1; i <= end; i++) {
            if (array[i] == array[i - 1]) {
                frec++;
            } else {
                if (frec > maxfrec) {
                    maxfrec = frec;
                    moda = array[i - 1];
                }
                frec = 1;
            }
        }
        
        if (frec > maxfrec) {
            moda = array[end];
        }
        
        return moda;
    }

    private static void imprimirArreglo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); 
    }
}

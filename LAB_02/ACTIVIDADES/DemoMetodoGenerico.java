package LAB_02.ACTIVIDADES;

class DemoMetodoGenerico {
    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes de los arrays son diferentes,
        // entonces los arrays son diferentes
        if (x.length != y.length)
            return false;

        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i]))
                return false; // arrays diferentes
        }
        return true; // Contenido de arrays es equivalente
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a nums3");
        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");

        // Crea un array de double
        Double dvals[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        //if(igualArrays(nums, dvals)) // Error de tipo
        System.out.println("nums es igual a dvals");
    }
}

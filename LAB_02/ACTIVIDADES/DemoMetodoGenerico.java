package LAB_02.ACTIVIDADES;

class DemoMetodoGenerico {
    static <T extends Comparable<T>> boolean igualArrays (T[] x, T[] y){
        if (x.length != y.length)
        return false;
        for (int i = 0; i < x.length; i++)
        if(!x[i].equals(y[i]))
        return false; //arrays diferentes
        return true; // Contenido de arrays son equivalentes
        }

}

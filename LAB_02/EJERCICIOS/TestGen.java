package LAB_02.EJERCICIOS;

public class TestGen {
    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        if (x.length != y.length)
            return false;

        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i]))
                return false; 
        }
        return true; 
    }
    public static <T> boolean exist(T[] array, T elemento) {
        for (T item : array) {
            if (item.equals(elemento)) {
                return true; 
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        String[] v = {"Perez", "Sanchez", "Rodriguez"};
        Integer[] w = {12, 34, 56};

        System.out.println(exist(v, "Sanchez")); 
        System.out.println(exist(w, 34)); 
        System.out.println(exist(w, "Salas")); 

        //Pruebas con objetos Golosina y Chocolatina
        Golosina[] g = {new Golosina("Caramelo", 10), new Golosina("Chicle", 5)};
        Chocolatina[] g1 = {new Chocolatina("Milka"), new Chocolatina("Ferrero")};

        System.out.println(exist(g, new Golosina("Chicle", 5))); 
        System.out.println(exist(g1, new Chocolatina("Milka"))); 
        System.out.println(exist(g1, new Chocolatina("Nestle"))); 
    }
}





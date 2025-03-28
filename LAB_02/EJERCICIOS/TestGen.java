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
        /* 
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
        */

        Cajoneria cajoneria = new Cajoneria(5);  

        cajoneria.add(new Caja<>(new Golosina("Chicle", 10), "Celeste"));
        cajoneria.add(new Caja<>(new Golosina("Caramelo", 15), "Morado"));
        cajoneria.add(new Caja<>(new Golosina("Algodón de Azúcar", 50), "Turquesa"));
        cajoneria.add(new Caja<>(new Golosina("Galleta", 30), "Fucsia"));
        cajoneria.add(new Caja<>(new Golosina("Tic Tac", 20), "Blanco"));

        System.out.println("Contenido de la cajoneria:");
        System.out.println(cajoneria);

        System.out.println("\nBuscar 'Caramelo, 15g' en la cajoneria:");
        System.out.println(cajoneria.search(new Golosina("Caramelo", 15)));

        System.out.println("\nBuscar 'Algodón de Azúcar, 50g' en la cajoneria:");
        System.out.println(cajoneria.search(new Golosina("Algodón de Azúcar", 50)));

        System.out.println("\nBuscar 'Tic Tac, 30g' en la cajoneria:");
        System.out.println(cajoneria.search(new Golosina("Tic Tac", 30))); //PESO INCORRECTO

        System.out.println("\nEliminar 'Galleta, 30g' de la cajoneria:");
        cajoneria.delete(new Golosina("Galleta", 30));

        System.out.println("\nContenido de la cajoneria después de la eliminación:");
        System.out.println(cajoneria);
    }
}





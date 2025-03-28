package LAB_02.EJERCICIOS;

public class PrincipalCajonera2 {
    public static void main(String[] args) {
        Caja<Integer> cajaEnteros = new Caja<>(327, "Rosa");
        Caja<String> cajaCadenas = new Caja<>("Danhia", "Celeste");
        Caja<Double> cajaDecimales = new Caja<>(5.5, "Naranja");
        
        Cajoneria cajoneria = new Cajoneria(3);

        cajoneria.add(cajaEnteros);
        cajoneria.add(cajaCadenas);
        cajoneria.add(cajaDecimales);

        System.out.println("Estado inicial de la cajonería:");
        System.out.println(cajoneria.toString());

        System.out.println("\nBuscar el objeto 'Danhia':");
        System.out.println(cajoneria.search("Danhia"));

        System.out.println("\nBuscar el objeto 'Adiós':");
        System.out.println(cajoneria.search("Adiós"));

        System.out.println("\nEliminar el objeto 5.5:");
        cajoneria.delete(5.5);

        System.out.println("\nEstado de la cajonería después de eliminar 5.5:");
        System.out.println(cajoneria.toString());

        System.out.println("\nIntentar eliminar el objeto 42:");
        cajoneria.delete(42);
    }
}





 

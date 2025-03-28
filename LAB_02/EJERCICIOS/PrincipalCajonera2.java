package LAB_02.EJERCICIOS;

public class PrincipalCajonera2 {
    public static void main(String[] args) {
        Caja<Integer> cajaDeEnteros = new Caja<>(42, "Rojo");
        Caja<String> cajaDeCadenas = new Caja<>("Hola Mundo", "Azul");
        Caja<Double> cajaDeDoubles = new Caja<>(3.14, "Verde");

        Cajoneria cajoneria = new Cajoneria(3);
        
        cajoneria.add(cajaDeEnteros);
        cajoneria.add(cajaDeCadenas);
        cajoneria.add(cajaDeDoubles);

        System.out.println(cajoneria.toString());

        System.out.println("Buscar el objeto 'Hola Mundo': " + cajoneria.search("Hola Mundo"));
        System.out.println("Buscar el objeto 99: " + cajoneria.search(99));  // No existe

        System.out.println("Eliminar el objeto 3.14: " + cajoneria.delete(3.14));
        
        System.out.println(cajoneria.toString());
    }
}


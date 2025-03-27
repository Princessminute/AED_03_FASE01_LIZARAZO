package LAB_02.EJERCICIOS;

public class PrincipalCajonera {
    public static void main(String[] args) {
        Caja<Integer> cajaDeEnteros = new Caja<>(42, "Rojo");
        Caja<String> cajaDeCadenas = new Caja<>("Hola Mundo", "Azul");

        Cajoneria cajoneria = new Cajoneria(3);
        
        cajoneria.add(cajaDeEnteros);
        cajoneria.add(cajaDeCadenas);

        for (Caja<?> caja : cajoneria) {
            System.out.println("Contenido: " + caja.obtenerContenido() + ", Color: " + caja.obtenerColor());
        }
    }
}

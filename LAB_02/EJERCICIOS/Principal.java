package LAB_02.EJERCICIOS;

public class Principal {
    public static void main(String[] args) {
        
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
        bolsaCho.add(new Chocolatina("milka"));
        bolsaCho.add(new Chocolatina("milka"));
        bolsaCho.add(new Chocolatina("ferrero"));
        
        Bolsa<Golosina> bolsaGolo = new Bolsa<>(3);
        bolsaGolo.add(new Golosina("Mentas", 5));
        bolsaGolo.add(new Golosina("Chicle", 3));
        bolsaGolo.add(new Golosina("Tic Tac", 5));
        
        // Mostrar contenido de ambas bolsas
        mostrarContenido(bolsaCho, "Chocolatinas");
        mostrarContenido(bolsaGolo, "Golosinas");
    }
    
    // Método genérico para mostrar el contenido de la bolsa
    public static <T> void mostrarContenido(Bolsa<T> bolsa, String tipo) {
        System.out.println("\nProductos dentro de la bolsa de " + tipo + ": ");
        for (T item : bolsa) {
            System.out.println(item);
        }
    }
}

package LAB_02.ACTIVIDADES;

public class Principal {
    public static void main(String[] args) {
        // Bolsa de Chocolatinas
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(3);
        Chocolatina c = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2); 
        System.out.println("Productos dentro de la bolsa de Chocolatinas: ");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Bolsa de Golosinas
        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(3);
        Golosina g = new Golosina("Mentas", 5);
        Golosina g1 = new Golosina("Chicle", 3);
        Golosina g2 = new Golosina("Tic Tac", 5);
        bolsaGolo.add(g);
        bolsaGolo.add(g1);
        bolsaGolo.add(g2); 
        System.out.println("\nProductos dentro de la bolsa de Golosinas: ");
        for (Golosina golosina : bolsaGolo) {
            System.out.println(golosina);
        }
    }
}

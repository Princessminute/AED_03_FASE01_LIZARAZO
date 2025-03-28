package LAB_02.EJERCICIOS;

public class TestGen2 {
    public static void main(String[] args) {
        Cajoneria cajoneria = new Cajoneria(5);

        cajoneria.add(new Caja<>(new Chocolatina("Milka"), "Celeste"));
        cajoneria.add(new Caja<>(new Chocolatina("Ferrero"), "Morado"));
        cajoneria.add(new Caja<>(new Chocolatina("Nestlé"), "Turquesa"));
        cajoneria.add(new Caja<>(new Chocolatina("Kit Kat"), "Fucsia"));
        cajoneria.add(new Caja<>(new Chocolatina("Sublime"), "Blanco"));  
        
        System.out.println("Contenido de la cajoneria:");
        System.out.println(cajoneria);
        
        System.out.println("\nBuscar 'Ferrero' en la cajoneria:");
        System.out.println(cajoneria.search(new Chocolatina("Ferrero")));
        
        System.out.println("\nBuscar 'Nestle' en la cajoneria:");
        System.out.println(cajoneria.search(new Chocolatina("Nestle")));
        
        System.out.println("\nBuscar 'Sublime' en la cajoneria:");
        System.out.println(cajoneria.search(new Chocolatina("Sublime")));
        
        System.out.println("\nEliminar 'Kit Kat' de la cajoneria:");
        cajoneria.delete(new Chocolatina("Kit Kat"));
        
        System.out.println("\nContenido de la cajoneria después de la eliminación:");
        System.out.println(cajoneria);
    }
}

package LAB_05.EJERCICIOS;

public class Main1 {
    public static void main(String[] args) {
        ListaEnlazadaEje1<String> lista = new ListaEnlazadaEje1<>();

        lista.agregar("uno");
        lista.agregar("dos");
        lista.agregar("tres");
        lista.agregar("cuatro");
        lista.agregar("cinco");

        System.out.println("¿Está 'cuatro'? " + lista.buscarElemento("cuatro")); // true
        System.out.println("¿Está 'seis'? " + lista.buscarElemento("seis"));     // false
    }
}

package LAB_05.EJERCICIOS;

public class Main2 {
    public static void main(String[] args) {
        ListaEnlazadaEje2<Integer> lista = new ListaEnlazadaEje2<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);

        System.out.println("Lista original:");
        lista.imprimir();

        ListaEnlazadaEje2<Integer> invertida = lista.invertirLista();

        System.out.println("Lista invertida:");
        invertida.imprimir();
    }
}

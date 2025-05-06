package LAB_05.EJERCICIOS;

public class Main4 {
    public static void main(String[] args) {
        Nodo<Integer> lista = null;

        lista = UtilListaEje4.insertarAlFinal(lista, 5);
        lista = UtilListaEje4.insertarAlFinal(lista, 10);
        lista = UtilListaEje4.insertarAlFinal(lista, 15);
        lista = UtilListaEje4.insertarAlFinal(lista, 20);

        System.out.println("Lista:");
        UtilListaEje4.imprimir(lista);

        int total = UtilListaEje4.contarNodos(lista);
        System.out.println("Total de nodos: " + total);
    }
}

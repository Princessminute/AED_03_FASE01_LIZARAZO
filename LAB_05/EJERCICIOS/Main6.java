package LAB_05.EJERCICIOS;

public class Main6 {
    public static void main(String[] args) {
        Nodo<Integer> lista1 = null;
        Nodo<Integer> lista2 = null;

        lista1 = UtilListaEje6.insertarAlFinal(lista1, 1);
        lista1 = UtilListaEje6.insertarAlFinal(lista1, 2);
        lista1 = UtilListaEje6.insertarAlFinal(lista1, 3);

        lista2 = UtilListaEje6.insertarAlFinal(lista2, 4);
        lista2 = UtilListaEje6.insertarAlFinal(lista2, 5);
        lista2 = UtilListaEje6.insertarAlFinal(lista2, 6);

        System.out.println("Lista 1:");
        UtilListaEje6.imprimir(lista1);

        System.out.println("Lista 2:");
        UtilListaEje6.imprimir(lista2);

        Nodo<Integer> listaConcatenada = UtilListaEje6.concatenarListas(lista1, lista2);

        System.out.println("Lista concatenada:");
        UtilListaEje6.imprimir(listaConcatenada);
    }
}

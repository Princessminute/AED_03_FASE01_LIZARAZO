package LAB_05.EJERCICIOS;

public class Main5 {
    public static void main(String[] args) {
        Nodo<Integer> lista1 = null;
        Nodo<Integer> lista2 = null;

        lista1 = UtilListaEje5.insertarAlFinal(lista1, 1);
        lista1 = UtilListaEje5.insertarAlFinal(lista1, 2);
        lista1 = UtilListaEje5.insertarAlFinal(lista1, 3);

        lista2 = UtilListaEje5.insertarAlFinal(lista2, 1);
        lista2 = UtilListaEje5.insertarAlFinal(lista2, 3);
        lista2 =  UtilListaEje5.insertarAlFinal(lista2, 3);

        System.out.println("Lista 1:");
        UtilListaEje5.imprimir(lista1);
        System.out.println("Lista 2:");
        UtilListaEje5.imprimir(lista2);

        boolean iguales =  UtilListaEje5.sonIguales(lista1, lista2);
        System.out.println("¿Las listas son iguales? " + iguales);
    }
}

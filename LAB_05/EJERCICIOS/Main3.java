package LAB_05.EJERCICIOS;

public class Main3 {
    public static void main(String[] args) {
        Nodo<String> lista = null;

        // Insertamos elementos de manera incremental
        lista = UtilListaEje3.insertarAlFinal(lista, "A");
        lista = UtilListaEje3.insertarAlFinal(lista, "B");
        lista = UtilListaEje3.insertarAlFinal(lista, "C");
        lista = UtilListaEje3.insertarAlFinal(lista, "D");

        System.out.println("Lista resultante:");
        UtilListaEje3.imprimir(lista);
    }
}

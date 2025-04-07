package LAB_04.ACTIVIDADES;
import java.util.List;
import java.util.ArrayList;


public class MainModa3 {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        
        System.out.print("El arreglo es: ");
        imprimirArreglo(array);
        
        int moda = moda3(array, 0, array.length - 1);
        System.out.println("La moda del arreglo es: " + moda);
    }

    public static int moda3(int[] a, int prim, int ult) {
        Limits p = new Limits(a, prim, ult);
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();

        heterogeneo.insertar(p);

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            int mediana = a[(p.prim + p.ult) / 2];
            int[] pivote = pivote2(a, mediana, p.prim, p.ult);
            int izq = pivote[0];
            int der = pivote[1];

            Limits p1 = new Limits(a, p.prim, izq - 1);
            Limits p2 = new Limits(a, izq, der - 1);
            Limits p3 = new Limits(a, der, p.ult);

            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) {
            return a[prim];
        }

        p = homogeneo.mayor();
        return a[p.prim];
    }

    public static int[] pivote2(int[] a, int mediana, int prim, int ult) {
        int izq = prim;
        int der = ult;
        while (izq <= der) {
            while (a[izq] < mediana) izq++;
            while (a[der] > mediana) der--;
            if (izq <= der) {
                int temp = a[izq];
                a[izq] = a[der];
                a[der] = temp;
                izq++;
                der--;
            }
        }
        return new int[]{izq, der};
    }

    private static void imprimirArreglo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); 
    }
}

class Limits {
    int[] a;
    int prim;
    int ult;

    public Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }
}

class SetVectors {
    private List<Limits> conjunto;

    public SetVectors() {
        conjunto = new ArrayList<>();
    }

    public void insertar(Limits p) {
        conjunto.add(p);
    }

    public int longMayor() {
        int max = 0;
        for (Limits p : conjunto) {
            int length = p.ult - p.prim + 1;
            if (length > max) max = length;
        }
        return max;
    }

    public Limits mayor() {
        Limits max = conjunto.get(0);
        for (Limits p : conjunto) {
            if ((p.ult - p.prim) > (max.ult - max.prim)) {
                max = p;
            }
        }
        conjunto.remove(max);
        return max;
    }

    public boolean esVacio() {
        return conjunto.isEmpty();
    }

    public void destruir() {
        conjunto.clear();
    }
}

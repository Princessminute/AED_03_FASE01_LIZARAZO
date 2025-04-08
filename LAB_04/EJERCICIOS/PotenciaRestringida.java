package LAB_04.EJERCICIOS;
import java.util.*;

public class PotenciaRestringida {
    
    public static boolean Potencia2(int n) {
        return n > 0 && Math.log(n) / Math.log(2) % 1 == 0;
    }
    
    static boolean sumarrObjetivo(int[] arreglo, int objetivo) {
    int suma = 0;
    List<Integer> opcionales = new ArrayList<>();

    for (int i = 0; i < arreglo.length; i++) {
        int actual = arreglo[i];

        if (Potencia2(actual)) {
            suma += actual; 
        } else if (actual % 5 == 0 && i + 1 < arreglo.length && arreglo[i + 1] % 2 != 0) {
            continue;
        } else {
            opcionales.add(actual); 
        }
    }

    if (suma > objetivo) return false;

    return puedeFormarConDP(opcionales, objetivo - suma);
}

    static boolean puedeFormarConDP(List<Integer> lista, int objetivo) {
        boolean[] dp = new boolean[objetivo + 1];
        dp[0] = true; 

        for (int num : lista) {
            for (int j = objetivo; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num]; 
            }
        }
        return dp[objetivo]; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos del arreglo :)");
        int N = sc.nextInt();
        int[] arreglo = new int[N];
         System.out.println("Ingrese los elementos del arreglo :)");
        for (int i = 0; i < N; i++) {
            arreglo[i] = sc.nextInt();
        }
        
        System.out.println("Ingrese el objetivo :)");

        int objetivo = sc.nextInt();
        
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Objetivo: " + objetivo);

        boolean resultado = sumarrObjetivo(arreglo, objetivo);

        System.out.println("Resultado: " + resultado);
    } 
}
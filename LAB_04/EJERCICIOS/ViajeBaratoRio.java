package LAB_04.EJERCICIOS;

import java.util.Arrays;

public class ViajeBaratoRio {

    public static int[][] calcularCostesMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(C[i], Integer.MAX_VALUE);
            C[i][i] = 0;
        }

        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                C[i][j] = T[i][j];  
                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }

        return C;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                if (val == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] T = {
            {0,   3,   10,  100},
            {Integer.MAX_VALUE, 0,   5,   8},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   2},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int[][] C = calcularCostesMinimos(T);

        System.out.println("Matriz de costes mínimos:");
        imprimirMatriz(C);
    }
}


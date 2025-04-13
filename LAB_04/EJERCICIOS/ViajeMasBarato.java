package LAB_04.EJERCICIOS;

public class ViajeMasBarato {

    static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // Inicializamos la diagonal con 0 (costo de i a i es 0)
        for (int i = 0; i < n; i++) {
            costos[i][i] = 0;
        }

        // Calculamos los costos mínimos
        for (int distancia = 1; distancia < n; distancia++) {
            for (int i = 0; i < n - distancia; i++) {
                int j = i + distancia;
                costos[i][j] = tarifas[i][j]; // Empezamos con el costo directo

                System.out.printf("Calculando costo mínimo de %d a %d:\n", i, j);
                System.out.printf("  Costo directo T[%d][%d] = %d\n", i, j, tarifas[i][j]);

                for (int k = i + 1; k < j; k++) {
                    int costoAlternativo = tarifas[i][k] + costos[k][j];
                    System.out.printf("  Evaluando camino %d → %d → %d: T[%d][%d] + C[%d][%d] = %d + %d = %d\n",
                            i, k, j, i, k, k, j, tarifas[i][k], costos[k][j], costoAlternativo);

                    if (costoAlternativo < costos[i][j]) {
                        System.out.printf("    → Se actualiza: C[%d][%d] = %d (anterior: %d)\n", i, j, costoAlternativo, costos[i][j]);
                        costos[i][j] = costoAlternativo;
                    }
                }
                System.out.println();
            }
        }

        return costos;
    }

    static void imprimirMatriz(String titulo, int[][] matriz, boolean triangularSuperior) {
        int n = matriz.length;
        System.out.println("\n" + titulo + ":\n");

        // Encabezado de columnas
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%6d", j);
        }
        System.out.println();
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.print("------");
        }
        System.out.println();

        // Contenido de la matriz
        for (int i = 0; i < n; i++) {
            System.out.printf("%3d |", i);
            for (int j = 0; j < n; j++) {
                if (!triangularSuperior || i <= j) {
                    System.out.printf("%6d", matriz[i][j]);
                } else {
                    System.out.printf("%6s", "-");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tarifas = {
            { 0, 6, 14, 20, 25 },
            { 0, 0, 7, 18, 21 },
            { 0, 0, 0, 3, 10 },
            { 0, 0, 0, 0, 5 },
            { 0, 0, 0, 0, 0 }
        };

        System.out.println("========== MATRIZ DE TARIFAS ==========");
        imprimirMatriz("Matriz de tarifas T[i][j]", tarifas, true);

        System.out.println("\n========== CÁLCULO DE COSTOS MÍNIMOS ==========");
        int[][] costos = calcularCostosMinimos(tarifas);

        System.out.println("========== MATRIZ DE COSTOS MÍNIMOS ==========");
        imprimirMatriz("Matriz de costos mínimos C[i][j]", costos, true);
    }
}

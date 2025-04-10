package LAB_04.EJERCICIOS;
import java.util.*;

public class PotenciasRestringidas {

    public static boolean esPotenciaDe2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean puedeFormarSuma(int[] arr) {
        int n = arr[0];
        int[] numeros = Arrays.copyOfRange(arr, 1, n + 1);
        int target = arr[n + 1];

        List<Integer> obligatorios = new ArrayList<>();
        List<Integer> candidatos = new ArrayList<>();

        for (int i = 0; i < numeros.length; i++) {
            int actual = numeros[i];
            if (esPotenciaDe2(actual)) {
                obligatorios.add(actual);
            } else if (actual % 5 == 0 && i + 1 < numeros.length && numeros[i + 1] % 2 != 0) {
                continue;
            } else {
                candidatos.add(actual);
            }
        }

        int sumaObligatorios = obligatorios.stream().mapToInt(Integer::intValue).sum();
        if (sumaObligatorios > target) {
            return false;
        }

        int resto = target - sumaObligatorios;
        return puedeSumar(candidatos, 0, resto);
    }

    private static boolean puedeSumar(List<Integer> candidatos, int index, int objetivo) {
        if (objetivo == 0) return true;
        if (index >= candidatos.size() || objetivo < 0) return false;
        if (puedeSumar(candidatos, index + 1, objetivo - candidatos.get(index))) {
            return true;
        }
        return puedeSumar(candidatos, index + 1, objetivo);
    }

    public static void main(String[] args) {
        int[][] entradas = {
            {5, 2, 4, 8, 10, 3, 14},
            {5, 4, 8, 10, 3, 5, 27},
            {5, 4, 8, 10, 3, 6, 27},
            {6, 2, 16, 5, 7, 10, 33},
            {6, 2, 16, 5, 3, 10, 33},
            {4, 2, 5, 1, 6, 13}
        };
    
        for (int[] entrada : entradas) {
            try {
                System.out.println(puedeFormarSuma(entrada));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }    
}

package LAB_04.EJERCICIOS;
import java.util.*;

public class PotenciasRestringidas {

    public static boolean esPotenciaDe2(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
    public static boolean puedeFormarseSubconjunto(int[] arreglo, int objetivo) {
        List<Integer> obligatorios = new ArrayList<>();
        List<Integer> opcionales = new ArrayList<>();
        List<Integer> ignorados = new ArrayList<>();

        for (int i = 0; i < arreglo.length; i++) {
            int actual = arreglo[i];
            boolean esMultiploDe5 = actual % 5 == 0;
            boolean siguienteEsImpar = (i + 1 < arreglo.length) && (arreglo[i + 1] % 2 != 0);

            if (esPotenciaDe2(actual)) {
                obligatorios.add(actual);
            } else if (esMultiploDe5 && siguienteEsImpar) {
                ignorados.add(actual);
                continue;
            } else {
                opcionales.add(actual);
            }
        }

        int sumaObligatorios = obligatorios.stream().mapToInt(Integer::intValue).sum();
        int objetivoRestante = objetivo - sumaObligatorios;

        System.out.println("➤ Números obligatorios (potencias de 2): " + obligatorios);
        System.out.println("➤ Números ignorados (múltiplos de 5 seguidos de impar): " + ignorados);
        System.out.println("➤ Números disponibles para completar la suma: " + opcionales);
        System.out.println("➤ Suma parcial obligatoria: " + sumaObligatorios);
        System.out.println("➤ Objetivo restante: " + objetivoRestante);

        if (objetivoRestante < 0) return false;

        List<Integer> subconjunto = new ArrayList<>();
        boolean sePuede = puedeSumarConLista(opcionales, 0, objetivoRestante, subconjunto);

        if (sePuede) {
            System.out.println("✔ Subconjunto encontrado que suma " + objetivoRestante + ": " + subconjunto);
        } else {
            System.out.println("✖ No se encontró subconjunto que complete la suma.");
        }

        return sePuede;
    }

    private static boolean puedeSumarConLista(List<Integer> numeros, int i, int objetivo, List<Integer> resultado) {
        if (objetivo == 0) return true;
        if (i >= numeros.size()) return false;

        resultado.add(numeros.get(i));
        if (puedeSumarConLista(numeros, i + 1, objetivo - numeros.get(i), resultado)) {
            return true;
        }
        resultado.remove(resultado.size() - 1); 

        return puedeSumarConLista(numeros, i + 1, objetivo, resultado);
    }

    public static void procesarEntrada(String linea) {
        try {
            String[] partes = linea.trim().split("\\s+");
            if (partes.length < 2) {
                System.out.println("Error: La entrada no tiene el formato correcto.");
                return;
            }

            int n = Integer.parseInt(partes[0]);
            int objetivo = Integer.parseInt(partes[partes.length - 1]);

            int[] datos = new int[n];
            for (int i = 0; i < n; i++) {
                int idx = i + 1;
                datos[i] = (idx < partes.length - 1) ? Integer.parseInt(partes[idx]) : 0;
            }

            boolean resultado = puedeFormarseSubconjunto(datos, objetivo);
            System.out.println("► Resultado final: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrate de ingresar solo números separados por espacio.");
        }
    }

    public static void ejecutarPruebas() {
        int[][] entradas = {
            {5, 2, 4, 8, 10, 3, 14},
            {5, 4, 8, 10, 3, 5, 27},
            {5, 4, 8, 10, 3, 6, 27},
            {6, 2, 16, 5, 7, 10, 33},       // <- incompleto (solo 5 datos + suma)
            {6, 2, 16, 5, 3, 10, 33},       // <- incompleto
            {4, 2, 5, 1, 6, 13},
            {6, 2, 16, 5, 7, 10, 10, 33},   // <- extra , será IGNORADO
            {5, 4, 8, 10, 2, 3, 27},        // <- extra , será ACEPTADO
        };

        for (int[] entrada : entradas) {
            System.out.println("\n➤ Prueba con entrada: " + Arrays.toString(entrada));
            if (entrada.length < 2) {
                System.out.println("Error: Entrada demasiado corta.");
                continue;
            }

            int n = entrada[0];
            int objetivo = entrada[entrada.length - 1];
            int[] datos = new int[n];

            for (int i = 0; i < n; i++) {
                int idx = i + 1;
                datos[i] = (idx < entrada.length - 1) ? entrada[idx] : 0;
            }

            boolean resultado = puedeFormarseSubconjunto(datos, objetivo);
            System.out.println("► Resultado final: " + resultado);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar un conjunto manualmente");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("NOTA:");
                    System.out.println("- 1er número → cantidad de elementos del arreglo");
                    System.out.println("- Los siguientes → elementos del arreglo");
                    System.out.println("- Último número → objetivo a alcanzar");
                    System.out.print("Ingresa los números separados por espacio (ej. 6 4 2 7 10 4 17 3): ");
                    String linea = sc.nextLine();
                    procesarEntrada(linea);
                    break;

                case 2:
                    ejecutarPruebas();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}

package LAB_04.ACTIVIDADES;

public class DpSolution {
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];
        
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++) {
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax; // Guardamos el valor máximo para la longitud i
        }
        
        return subSolutions[rodLength]; // El valor máximo para la longitud total de la varilla
    }
    
    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9};  
        int rodLength = values.length;
        System.out.println("El valor máximo: " + getValue(values, rodLength));
    }
}


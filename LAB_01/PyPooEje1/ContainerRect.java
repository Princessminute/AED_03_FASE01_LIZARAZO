package LAB_01.PyPooEje1;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0;

    public ContainerRect(int maxRectangulos) {
        this.n = maxRectangulos;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    public void agregarRectangulo(Rectangulo rect) {
        if (numRec < n) {
            this.rectangulos[numRec] = rect;
            Coordenada c1 = rect.getEsquina1();
            Coordenada c2 = rect.getEsquina2();
            this.distancias[numRec] = Coordenada.distancia(c1, c2);
            this.areas[numRec] = rect.calculoArea();
            numRec++;
        } else {
            System.out.println("El contenedor está lleno. No se puede agregar más rectángulos.");
        }
    }    

    public Rectangulo getRectangulo(int index) {
        if (index >= 0 && index < numRec) {
            return rectangulos[index];
        } else {
            System.out.println("Índice fuera de rango.");
            return null; 
        }
    }

    public void mostrarInfoRectangulos() {
        for (int i = 0; i < numRec; i++) {
            System.out.println("Rectángulo " + (i + 1) + ": " + rectangulos[i]);
            System.out.println("Distancia Euclidiana: " + distancias[i]);
            System.out.println("Área: " + areas[i]);
            System.out.println();
        }
    }

    public static int getNumRec() {
        return numRec;
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Rectangulo\tCoordenadas\t\t\t\tDistancia\tArea\n");
    for (int i = 0; i < numRec; i++) {
        Rectangulo rect = rectangulos[i];
        Coordenada c1 = rect.getEsquina1();
        Coordenada c2 = rect.getEsquina2();
        double distancia = distancias[i];
        double area = areas[i];
        sb.append((i + 1) + "\t" +
                  "[" + c1.getX() + ", " + c1.getY() + "]\t" +
                  "[" + c2.getX() + ", " + c2.getY() + "]\t" +
                  distancia + "\t" + area + "\n");
        }
    return sb.toString();
    }

}


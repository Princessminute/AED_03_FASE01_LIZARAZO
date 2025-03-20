package LAB_01.PyPooAct1;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    public void setEsquina1(Coordenada coo) {
        this.esquina1 = coo;
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = coo;
    }

    public Coordenada getEsquina1() {
        return this.esquina1;
    }

    public Coordenada getEsquina2() {
        return this.esquina2;
    }

    /* 
    @Override
    public String toString() {
        return "Esquina 1: " + this.esquina1.toString() + ", Esquina 2: " + this.esquina2.toString();
    }
    */

    
    public double calculoArea() {
        double largo = Math.abs(esquina2.getX() - esquina1.getX());
        double ancho = Math.abs(esquina2.getY() - esquina1.getY());
        return largo * ancho;
    }

    // Método toString para mostrar la información del rectángulo
    @Override
    public String toString() {
        return "Rectángulo [esquina 1: (" + esquina1.getX() + ", " + esquina1.getY() + "), "
                + "esquina 2: (" + esquina2.getX() + ", " + esquina2.getY() + ")]";
    }

}


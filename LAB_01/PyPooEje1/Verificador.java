package LAB_01.PyPooEje1;

public class Verificador {

    public double areaDeInterseccion(Rectangulo A, Rectangulo B) {
        double xIzquierda = Math.max(A.getEsquina1().getX(), B.getEsquina1().getX());
        double xDerecha = Math.min(A.getEsquina2().getX(), B.getEsquina2().getX());
        double yInferior = Math.max(Math.min(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.min(B.getEsquina1().getY(), B.getEsquina2().getY()));
        double ySuperior = Math.min(Math.max(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.max(B.getEsquina1().getY(), B.getEsquina2().getY()));

        if (xIzquierda >= xDerecha || yInferior >= ySuperior) {
            return 0;
        }

        double base = xDerecha - xIzquierda;
        double altura = ySuperior - yInferior;
        return base * altura;
    }

    public boolean seSobreponen(Rectangulo A, Rectangulo B) {
        double area = areaDeInterseccion(A, B);
        if (area > 0) {
            System.out.println("Los rectángulos se sobreponen con un área de: " + area);
            return true;
        }
        return false;
    }

    public boolean estanJuntos(Rectangulo A, Rectangulo B) {
        double xIzquierda = Math.max(A.getEsquina1().getX(), B.getEsquina1().getX());
        double xDerecha = Math.min(A.getEsquina2().getX(), B.getEsquina2().getX());
        double yInferior = Math.max(Math.min(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.min(B.getEsquina1().getY(), B.getEsquina2().getY()));
        double ySuperior = Math.min(Math.max(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.max(B.getEsquina1().getY(), B.getEsquina2().getY()));

        boolean bordeComun = (xIzquierda == xDerecha || yInferior == ySuperior);
        return bordeComun && areaDeInterseccion(A, B) == 0;
    }

    public boolean sonDisjuntos(Rectangulo A, Rectangulo B) {
        return areaDeInterseccion(A, B) == 0 && !estanJuntos(A, B);
    }

    public Rectangulo rectanguloSobre(Rectangulo A, Rectangulo B) {
        double xIzquierda = Math.max(A.getEsquina1().getX(), B.getEsquina1().getX());
        double xDerecha = Math.min(A.getEsquina2().getX(), B.getEsquina2().getX());
        double yInferior = Math.max(Math.min(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.min(B.getEsquina1().getY(), B.getEsquina2().getY()));
        double ySuperior = Math.min(Math.max(A.getEsquina1().getY(), A.getEsquina2().getY()),
                                    Math.max(B.getEsquina1().getY(), B.getEsquina2().getY()));

        if (xIzquierda >= xDerecha || yInferior >= ySuperior) {
            return null;
        }

        return new Rectangulo(new Coordenada(xIzquierda, ySuperior), new Coordenada(xDerecha, yInferior));
    }
}
    


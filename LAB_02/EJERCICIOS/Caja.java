package LAB_02.EJERCICIOS;

public class Caja<T> {
    private T contenido;
    private String color;

    public Caja(T contenido, String color) {
        this.contenido = contenido;
        this.color = color;
    }

    public T obtenerContenido() {
        return contenido;
    }

    public void establecerContenido(T contenido) {
        this.contenido = contenido;
    }

    public String obtenerColor() {
        return color;
    }

    public void establecerColor(String color) {
        this.color = color;
    }
}



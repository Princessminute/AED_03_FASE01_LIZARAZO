package LAB_02.EJERCICIOS;

public class Golosina {
    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Golosina [Nombre: " + nombre + ", Peso: " + peso + "g]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  
        }
        Golosina other = (Golosina) obj;
        return nombre.equals(other.nombre) && peso == other.peso;  
    }
/* 
    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        long temp = Double.doubleToLongBits(peso);
        result = 31 * result + (int) (temp ^ (temp >>> 32));  // Genera un hash usando nombre y peso
        return result;
    }
        */
}

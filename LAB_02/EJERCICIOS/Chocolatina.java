package LAB_02.EJERCICIOS;

public class Chocolatina {
    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Chocolatina [Marca: " + marca + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  
        }
        Chocolatina other = (Chocolatina) obj;
        return marca.equals(other.marca);  
    }

    @Override
    public int hashCode() {
        return marca.hashCode();  // Genera un hash basado en la marca
    }
}

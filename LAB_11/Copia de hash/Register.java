package LAB_11.hash;

/**
 * Clase genérica que representa un registro con una clave entera
 * y un valor de tipo genérico E.
 */
public class Register<E> implements Comparable<Register<E>> {
    private int key;
    private E value;

    public Register(int key, E value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    @Override
    public int compareTo(Register<E> other) {
        return Integer.compare(this.key, other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Register<?>) {
            Register<?> other = (Register<?>) obj;
            return this.key == other.key;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(key);
    }
}

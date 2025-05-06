package LAB_06.ACTIVIDADES.ACT_1;

public class StackArray<C> implements Stack<C> {
    private C[] array;
    private int tope;

    @SuppressWarnings("unchecked")
    public StackArray(int n) {
        this.array = (C[]) new Object[n];
        this.tope = -1;
    }

    @Override
    public void push(C x) {
        if (full()) throw new RuntimeException("La pila está llena");
        array[++tope] = x; // Preincremento: primero incrementa, luego asigna
    }

    @Override
    public C pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("No se puede eliminar: pila vacía");
        C eliminado = array[tope];
        array[tope--] = null; // Limpieza explícita y postdecremento
        return eliminado;
    }

    @Override
    public C top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("No hay elementos en la pila");
        return array[tope];
    }

    @Override
    public boolean isEmpty() {
        return tope < 0; // Alternativa a "tope == -1"
    }

    public boolean full() {
        return tope == array.length - 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[Pila vacía]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= tope; i++) {
            sb.append(array[i]);
            sb.append(i < tope ? " <- " : "]");
        }
        return sb.toString();
    }
}

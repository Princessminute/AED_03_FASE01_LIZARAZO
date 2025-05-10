package LAB_06.EJERCICIOS.Ejercicio2;
import LAB_06.EXCEPTIONS.ExceptionIsEmpty;

public class QueueArray<T> implements Queue<T> {
    private Object[] data;
    private int front;
    private int rear;
    private int count;
    private int size;

    public QueueArray(int size) {
        this.size = size;
        data = new Object[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    @Override
    public void enqueue(T value) throws ExceptionIsEmpty {
        if (isFull()) throw new ExceptionIsEmpty("La cola está llena");
        rear = (rear + 1) % size;
        data[rear] = value;
        count++;
    }

    @Override
    public T dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        @SuppressWarnings("unchecked")
        T value = (T) data[front];
        data[front] = null; 
        front = (front + 1) % size;
        count--;
        return value;
    }

    @Override
    public T front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        @SuppressWarnings("unchecked")
        T value = (T) data[front];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == size;
    }

    @Override
    public void print() {
        System.out.print("Cola: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print("[" + data[index] + "] ");
        }
        System.out.println();
    }

    @Override
    public T back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        @SuppressWarnings("unchecked")
        T value = (T) data[rear];
        return value;
    }
}

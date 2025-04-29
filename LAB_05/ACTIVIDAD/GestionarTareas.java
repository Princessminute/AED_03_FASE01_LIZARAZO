package LAB_05.ACTIVIDAD;
import java.util.ArrayList;
import java.util.List;

public class GestionarTareas <C extends Comparable <C>> {
    private Node <C> cabeza;
    private List <C> tareasFinalizadas;

    public  GestionarTareas(){
        cabeza=null;
        tareasFinalizadas = new ArrayList<>();
    }

    public void agregarTarea(C tarea) {
        Node<C> nuevo = new Node<>(tarea);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Node<C> actual = cabeza;
            while (actual.next != null)
                actual = actual.next;
            actual.next = nuevo;
        }
    }

    public boolean eliminarTarea(C tarea) {
        if (cabeza == null) return false;
        if (cabeza.data.equals(tarea)) {
            cabeza = cabeza.next;
            return true;
        }
        Node<C> actual = cabeza;
        while (actual.next != null && !actual.next.data.equals(tarea)) {
            actual = actual.next;
        }
        if (actual.next == null) return false;
        actual.next = actual.next.next;
        return true;
    }

    public boolean contieneTarea (C tarea){
        Node<C> actual = cabeza;
        while (actual != null) {
            if (actual.data.equals(tarea))
                return true;
            actual = actual.next;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<C> actual = cabeza;
        System.out.println("Tareas actuales:");
        while (actual != null) {
            System.out.println(" - " + actual.data);
            actual = actual.next;
        }
    }

    public int contarTareas() {
        int count = 0;
        Node<C> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.next;
        }
        return count;
    }

    public C obtenerTareaMasPrioritaria() {
        if (cabeza == null) return null;
        Node<C> actual = cabeza;
        C mejor = actual.data;
        while (actual != null) {
            if (actual.data.compareTo(mejor) < 0) {
                mejor = actual.data;
            }
            actual = actual.next;
        }
        return mejor;
    }

    public void invertirTareas() {
        Node<C> prev = null;
        Node<C> actual = cabeza;
        while (actual != null) {
            Node<C> next = actual.next;
            actual.next = prev;
            prev = actual;
            actual = next;
        }
        cabeza = prev;
    }

    public boolean transferirTareaACompletadas(C tarea) {
        if (eliminarTarea(tarea)) {
            tareasFinalizadas.add(tarea);
            return true;
        }
        return false;
    }

    public void mostrarTareasCompletadas() {
        System.out.println("Tareas completadas:");
        for (C tarea : tareasFinalizadas) {
            System.out.println(" ✓ " + tarea);
        }
    }
}
    


package LAB_05.ACTIVIDAD;

public class TareaActividad implements Comparable<TareaActividad> {
    private String titulo;
    private int prioridad;

    public TareaActividad(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(TareaActividad otra) {
        return Integer.compare(this.prioridad, otra.prioridad); // menor valor = más prioridad
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TareaActividad) {
            TareaActividad t = (TareaActividad) obj;
            return this.titulo.equals(t.titulo);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Prioridad: " + prioridad;
    }
}


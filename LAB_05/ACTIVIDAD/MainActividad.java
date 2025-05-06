package LAB_05.ACTIVIDAD;

public class MainActividad {
    public static void main(String[] args) {
        GestionarTareas<TareaActividad> gestor = new GestionarTareas<>();

        gestor.agregarTarea(new TareaActividad("Enviar correo", 3));
        gestor.agregarTarea(new TareaActividad("Revisar informe", 2));
        gestor.agregarTarea(new TareaActividad("Reunión con cliente", 1));

        gestor.imprimirTareas();


        gestor.eliminarTarea(new TareaActividad("Revisar informe", 2));

        System.out.println("\n¿Existe 'Enviar correo'? " +
                gestor.contieneTarea(new TareaActividad("Enviar correo", 3)));

        System.out.println("Tarea más prioritaria: " + gestor.obtenerTareaMasPrioritaria());

        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

        gestor.transferirTareaACompletadas(new TareaActividad("Enviar correo", 3));

        System.out.println("\nTareas actuales:");
        gestor.imprimirTareas();

        gestor.mostrarTareasCompletadas();
    }
}


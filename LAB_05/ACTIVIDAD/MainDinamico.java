package LAB_05.ACTIVIDAD;

import java.util.Scanner;

public class MainDinamico {

    private static void procesarEntrada(String linea, GestionarTareas<TareaActividad> gestor) {
        String[] tokens = linea.trim().split(" ");
        
        if (tokens.length < 2) {
            System.out.println("Entrada inválida. Por favor ingresa una tarea con su prioridad.");
            return;
        }

        String descripcion = tokens[0];
        int prioridad;
        
        try {
            prioridad = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: La prioridad debe ser un número entero.");
            return;
        }

        TareaActividad tarea = new TareaActividad(descripcion, prioridad);
        gestor.agregarTarea(tarea);
        System.out.println("Tarea agregada: " + tarea);
    }

    private static void ejecutarPruebas(GestionarTareas<TareaActividad> gestor) {
        System.out.println("\nEjecutando pruebas de ejemplo...");

        gestor.agregarTarea(new TareaActividad("Enviar correo", 3));
        gestor.agregarTarea(new TareaActividad("Revisar informe", 2));
        gestor.agregarTarea(new TareaActividad("Reunión con cliente", 1));

        System.out.println("\nTareas agregadas:");
        gestor.imprimirTareas();

        gestor.eliminarTarea(new TareaActividad("Revisar informe", 2));
        System.out.println("\nTareas después de eliminar 'Revisar informe':");
        gestor.imprimirTareas();

        System.out.println("\n¿Existe 'Enviar correo'? " +
                gestor.contieneTarea(new TareaActividad("Enviar correo", 3)));

        System.out.println("Tarea más prioritaria: " + gestor.obtenerTareaMasPrioritaria());

        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

        gestor.transferirTareaACompletadas(new TareaActividad("Enviar correo", 3));
        System.out.println("\nTareas actuales después de transferir 'Enviar correo' a completadas:");
        gestor.imprimirTareas();

        gestor.mostrarTareasCompletadas();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        GestionarTareas<TareaActividad> gestor = new GestionarTareas<>();

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar tarea manualmente");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("NOTA:");
                    System.out.println("- El primer valor es la descripción de la tarea");
                    System.out.println("- El segundo valor es la prioridad de la tarea");
                    System.out.print("Ingresa la tarea y su prioridad (ej. 'Enviar correo 3'): ");
                    String linea = sc.nextLine();
                    procesarEntrada(linea, gestor);
                    break;

                case 2:
                    ejecutarPruebas(gestor);
                    break;

                case 0:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

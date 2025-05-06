package LAB_05.ACTIVIDAD;

import java.util.Scanner;

public class MainDinamico {

    private static void procesarEntrada(int cantidad, GestionarTareas<TareaActividad> gestor, Scanner sc) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa la descripción de la tarea: ");
            String descripcion = sc.nextLine();
            System.out.print("Ingresa la prioridad de la tarea (número entero): ");
            int prioridad = Integer.parseInt(sc.nextLine());

            TareaActividad tarea = new TareaActividad(descripcion, prioridad);
            gestor.agregarTarea(tarea);
            System.out.println("Tarea agregada: " + tarea);
        }
    }

    private static void mostrarMenuTareas(GestionarTareas<TareaActividad> gestor, Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE TAREAS ---");
            System.out.println("1. Comparar dos tareas");
            System.out.println("2. Eliminar una tarea");
            System.out.println("3. Marcar una tarea como completada");
            System.out.println("4. Imprimir todas las tareas");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Para limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la descripción de la primera tarea: ");
                    String descripcion1 = sc.nextLine();
                    System.out.print("Ingresa la prioridad de la primera tarea: ");
                    int prioridad1 = Integer.parseInt(sc.nextLine());
                    TareaActividad tarea1 = new TareaActividad(descripcion1, prioridad1);

                    System.out.print("Ingresa la descripción de la segunda tarea: ");
                    String descripcion2 = sc.nextLine();
                    System.out.print("Ingresa la prioridad de la segunda tarea: ");
                    int prioridad2 = Integer.parseInt(sc.nextLine());
                    TareaActividad tarea2 = new TareaActividad(descripcion2, prioridad2);

                    int resultadoComparacion = tarea1.compareTo(tarea2);
                    if (resultadoComparacion < 0) {
                        System.out.println("La tarea '" + tarea1.getTitulo() + "' tiene mayor prioridad que '" + tarea2.getTitulo() + "'.");
                    } else if (resultadoComparacion > 0) {
                        System.out.println("La tarea '" + tarea2.getTitulo() + "' tiene mayor prioridad que '" + tarea1.getTitulo() + "'.");
                    } else {
                        System.out.println("Ambas tareas tienen la misma prioridad.");
                    }
                    break;

                case 2:
                    System.out.print("Ingresa la descripción de la tarea a eliminar: ");
                    String descripcionEliminar = sc.nextLine();
                    System.out.print("Ingresa la prioridad de la tarea a eliminar: ");
                    int prioridadEliminar = Integer.parseInt(sc.nextLine());
                    TareaActividad tareaEliminar = new TareaActividad(descripcionEliminar, prioridadEliminar);

                    if (gestor.eliminarTarea(tareaEliminar)) {
                        System.out.println("Tarea eliminada: " + tareaEliminar);
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa la descripción de la tarea a marcar como completada: ");
                    String descripcionCompletada = sc.nextLine();
                    System.out.print("Ingresa la prioridad de la tarea a marcar como completada: ");
                    int prioridadCompletada = Integer.parseInt(sc.nextLine());
                    TareaActividad tareaCompletada = new TareaActividad(descripcionCompletada, prioridadCompletada);

                    if (gestor.transferirTareaACompletadas(tareaCompletada)) {
                        System.out.println("Tarea completada: " + tareaCompletada);
                    } else {
                        System.out.println("No se encontró la tarea para completar.");
                    }
                    break;

                case 4:
                    gestor.imprimirTareas();
                    break;

                case 0:
                    System.out.println("Regresando al menú principal.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        GestionarTareas<TareaActividad> gestor = new GestionarTareas<>();

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ingresar tareas manualmente");
            System.out.println("2. Ejecutar casos de prueba");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Preguntar cuántas tareas ingresar
                    System.out.print("¿Cuántas tareas deseas ingresar? ");
                    int cantidad = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    procesarEntrada(cantidad, gestor, sc);
                    mostrarMenuTareas(gestor, sc);  // Después de ingresar tareas, mostrar el menú para gestionar
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

    private static void ejecutarPruebas(GestionarTareas<TareaActividad> gestor) {
        // Pruebas de ejemplo para el caso 2 (con tareas menos comunes)
        System.out.println("\n--- EJECUTANDO CASOS DE PRUEBA ---");

        // Agregar tareas
        System.out.println("\nAgregando tareas:");
        gestor.agregarTarea(new TareaActividad("Desarrollar algoritmo cuántico", 1));
        gestor.agregarTarea(new TareaActividad("Recopilar ADN de especies extintas", 5));
        gestor.agregarTarea(new TareaActividad("Planificar lanzamiento de satélite", 3));

        // Imprimir todas las tareas
        System.out.println("\nTareas después de agregar:");
        gestor.imprimirTareas();

        // Comparar tareas
        System.out.println("\nComparando tareas:");
        TareaActividad tarea1 = new TareaActividad("Desarrollar algoritmo cuántico", 1);
        TareaActividad tarea2 = new TareaActividad("Planificar lanzamiento de satélite", 3);
        int resultadoComparacion = tarea1.compareTo(tarea2);
        if (resultadoComparacion < 0) {
            System.out.println("La tarea '" + tarea1.getTitulo() + "' tiene mayor prioridad que '" + tarea2.getTitulo() + "'.");
        } else if (resultadoComparacion > 0) {
            System.out.println("La tarea '" + tarea2.getTitulo() + "' tiene mayor prioridad que '" + tarea1.getTitulo() + "'.");
        } else {
            System.out.println("Ambas tareas tienen la misma prioridad.");
        }

        // Eliminar tarea
        System.out.println("\nEliminando tarea:");
        TareaActividad tareaEliminar = new TareaActividad("Recopilar ADN de especies extintas", 5);
        if (gestor.eliminarTarea(tareaEliminar)) {
            System.out.println("Tarea eliminada: " + tareaEliminar);
        } else {
            System.out.println("No se encontró la tarea.");
        }

        // Imprimir tareas restantes
        System.out.println("\nTareas restantes:");
        gestor.imprimirTareas();

        // Transferir tarea a completadas
        System.out.println("\nMarcando tarea como completada:");
        TareaActividad tareaCompletada = new TareaActividad("Desarrollar algoritmo cuántico", 1);
        if (gestor.transferirTareaACompletadas(tareaCompletada)) {
            System.out.println("Tarea completada: " + tareaCompletada);
        } else {
            System.out.println("No se encontró la tarea.");
        }

        // Imprimir tareas completadas
        System.out.println("\nTareas completadas:");
        gestor.mostrarTareasCompletadas();
    }
}

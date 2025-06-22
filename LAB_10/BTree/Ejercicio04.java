package LAB_10.BTree;

public class Ejercicio04{

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4: SISTEMA DE BÚSQUEDA Y ELIMINACIÓN DE ESTUDIANTES ===\n");

        // Crear árbol B de orden 4 para RegistroEstudiante
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        // Paso 1: Insertar estudiantes
        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(2021001, "Ana Torres"),
            new RegistroEstudiante(2021005, "Luis García"),
            new RegistroEstudiante(2021003, "María López"),
            new RegistroEstudiante(2021007, "Carlos Mendoza"),
            new RegistroEstudiante(2021002, "Julia Ríos"),
            new RegistroEstudiante(2021010, "Pedro Salas")
        };

        System.out.println("Insertando estudiantes:");
        for (RegistroEstudiante est : estudiantes) {
            System.out.println("- " + est);
            arbol.insert(est);
        }

        System.out.println("\nEstructura del árbol luego de las inserciones:");
        System.out.println(arbol);

        // Paso 2: Búsqueda de estudiantes por código
        int[] codigosBuscar = {2021003, 2021010, 2021020};

        System.out.println("\nConsultando estudiantes por código:\n");
        for (int codigo : codigosBuscar) {
            System.out.println("Buscando código: " + codigo);
            String nombre = arbol.buscarNombre(codigo);
            if (!nombre.equals("No encontrado")) {
                System.out.println("Resultado: " + codigo + " pertenece a " + nombre + "\n");
            } else {
                System.out.println("Resultado: Código " + codigo + " no está registrado.\n");
            }
        }

        // Paso 3: Eliminar estudiantes por código
        int[] codigosEliminar = {2021005, 2021001, 2021002};

        System.out.println("Eliminando estudiantes por código:\n");
        for (int codigo : codigosEliminar) {
            System.out.println("Eliminando estudiante con código: " + codigo);
            arbol.remove(new RegistroEstudiante(codigo, ""));
            System.out.println("Estado del árbol luego de eliminar " + codigo + ":\n");
            System.out.println(arbol);
        }

        System.out.println("=== FIN DEL EJERCICIO 4===");
    }
}

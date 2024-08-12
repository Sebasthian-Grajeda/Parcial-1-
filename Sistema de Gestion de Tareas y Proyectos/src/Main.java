import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

        Usuario usuario1 = new Usuario("Sebasthian Grajeda", "U001");
        sistema.registrarUsuario(usuario1);

        Usuario usuario2 = new Usuario("Bryan", "U002");
        sistema.registrarUsuario(usuario2);

        Proyecto proyecto1 = new Proyecto("Proyecto X", "Descripción del proyecto X", "2024-08-10", "2024-12-20");
        sistema.registrarProyecto(proyecto1);

        Proyecto proyecto2 = new Proyecto("Proyecto X", "Descripción del proyecto X", "2024-08-10", "2024-12-20");
        sistema.registrarProyecto(proyecto2);

        Tarea tarea1 = new Tarea("Parcial 1", "Crear los diagramas UML", "2024-09-15", "Alta");
        sistema.asignarTareaAProyecto(proyecto1.getNombre(), tarea1);
        sistema.asignarTareaAUsuario(usuario1.getId(), tarea1);
        Tarea tarea2 = new Tarea("Parcial 2" ,  "crear un programa basado", "2024-09-15", "Baja");
        sistema.asignarTareaAProyecto(proyecto2.getNombre(), tarea2);
        sistema.asignarTareaAUsuario(usuario2.getId(), tarea2);

        List<Tarea> tareasUsuario = sistema.consultarTareasDeUsuario(usuario1.getId());
        System.out.println("Tareas asignadas a " + usuario1.getNombre() + ":");

        List<Tarea> tareasUsuario2 = sistema.consultarTareasDeUsuario(usuario2.getId());
        System.out.println("Tareas asignadas a " + usuario2.getNombre() + ":");
for (Tarea tarea : tareasUsuario2) {
    System.out.println("- " + tarea.getTitulo() + " (" + tarea.getEstado() + ")");
}
        for (Tarea tarea : tareasUsuario) {
            System.out.println("- " + tarea.getTitulo() + " (" + tarea.getEstado() + ")");
        }
    }
}


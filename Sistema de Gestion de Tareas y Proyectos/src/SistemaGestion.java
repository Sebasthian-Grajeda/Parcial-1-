import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaGestion {
    private Map<String, Proyecto> proyectos;
    private Map<String, Usuario> usuarios;

    public SistemaGestion() {
        this.proyectos = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void registrarProyecto(Proyecto proyecto) {
        if (validarFechas(proyecto.getFechaInicio(), proyecto.getFechaFin())) {
            proyectos.put(proyecto.getNombre(), proyecto);
        } else {
            throw new IllegalArgumentException("Fechas inválidas: la fecha de inicio debe ser anterior a la fecha de fin.");
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void asignarTareaAProyecto(String nombreProyecto, Tarea tarea) {
        Proyecto proyecto = proyectos.get(nombreProyecto);
        if (proyecto != null) {
            proyecto.agregarTarea(tarea);
        } else {
            throw new ProyectoNoEncontradoException("Proyecto no encontrado: " + nombreProyecto);
        }
    }

    public void asignarTareaAUsuario(String idUsuario, Tarea tarea) {
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario != null) {
            usuario.asignarTarea(tarea);
        } else {
            throw new UsuarioNoEncontradoException("Usuario no encontrado: " + idUsuario);
        }
    }

    public List<Tarea> consultarTareasDeProyecto(String nombreProyecto) {
        Proyecto proyecto = proyectos.get(nombreProyecto);
        if (proyecto != null) {
            return proyecto.getTareas();
        } else {
            throw new ProyectoNoEncontradoException("Proyecto no encontrado: " + nombreProyecto);
        }
    }

    public List<Tarea> consultarTareasDeUsuario(String idUsuario) {
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario != null) {
            return usuario.getTareasAsignadas();
        } else {
            throw new UsuarioNoEncontradoException("Usuario no encontrado: " + idUsuario);
        }
    }

    private boolean validarFechas(String fechaInicio, String fechaFin) {
        return true;
    }
}

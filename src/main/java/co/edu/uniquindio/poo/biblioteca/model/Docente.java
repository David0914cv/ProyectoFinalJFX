package co.edu.uniquindio.poo.biblioteca.model;

public class Docente extends Usuario {
    private EstadoUsuario estadoUsuario;

    /**
     * constructor de la clase Docente
     * @param nombre
     * @param numeroIdentificacion
     * @param contrasenia
     */
    public Docente(String nombre, String numeroIdentificacion, String contrasenia) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.estadoUsuario = EstadoUsuario.PAZ_Y_SALVO;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}

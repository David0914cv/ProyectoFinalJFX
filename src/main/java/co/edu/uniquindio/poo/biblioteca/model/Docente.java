package co.edu.uniquindio.poo.biblioteca.model;

public class Docente extends Usuario {
    private EstadoUsuario estadoUsuario;

    public Docente(String nombre, String numeroIdentificacion, String contrasenia, EstadoUsuario estadoUsuario) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.estadoUsuario = estadoUsuario;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}

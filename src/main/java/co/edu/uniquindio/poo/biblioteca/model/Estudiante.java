package co.edu.uniquindio.poo.biblioteca.model;

public class Estudiante extends Usuario{
    private int cantidadlibrosPrestados;
    private EstadoUsuario estadoUsuario;

    public Estudiante(String nombre, String numeroIdentificacion, String contrasenia, EstadoUsuario estadoUsuario) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.cantidadlibrosPrestados = 0;
        this.estadoUsuario = estadoUsuario;
    }

    public int getCantidadlibrosPrestados() {
        return cantidadlibrosPrestados;
    }

    public void setCantidadlibrosPrestados(int cantidadlibrosPrestados) {
        this.cantidadlibrosPrestados = cantidadlibrosPrestados;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}

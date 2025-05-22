package co.edu.uniquindio.poo.biblioteca.model;

public class Estudiante extends Usuario{
    public int cantidadlibrosPrestados;
    public EstadoUsuario estadoUsuario;

    public Estudiante(String nombre, String numeroIdentificacion, String contrasenia, int cantidadlibrosPrestados, EstadoUsuario estadoUsuario) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.cantidadlibrosPrestados = 0;
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

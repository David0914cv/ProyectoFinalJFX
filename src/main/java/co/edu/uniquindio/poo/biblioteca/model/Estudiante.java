package co.edu.uniquindio.poo.biblioteca.model;

public class Estudiante extends Usuario{
    private int cantidadlibrosPrestados;
    private EstadoUsuario estadoUsuario;

    /**
     * constructor de la clase Estudiante
     * @param nombre
     * @param numeroIdentificacion
     * @param contrasenia
     */
    public Estudiante(String nombre, String numeroIdentificacion, String contrasenia) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.cantidadlibrosPrestados = 0;
        this.estadoUsuario = EstadoUsuario.PAZ_Y_SALVO;
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

    @Override
    public String toString() {
        return getNombre() + '\'' +
                ", con numero de identificacion='" + getNumeroIdentificacion();
    }
}

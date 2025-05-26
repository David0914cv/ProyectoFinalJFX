package co.edu.uniquindio.poo.biblioteca.model;

public class Estudiante extends Usuario{
    private int cantidadlibrosPrestados;
    private EstadoUsuario estadoUsuario;

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
        return "Estudiante{" +
                "nombre="+ getNombre()+
                "cantidadlibrosPrestados=" + cantidadlibrosPrestados +
                ", estadoUsuario=" + estadoUsuario +
                '}';
    }
}

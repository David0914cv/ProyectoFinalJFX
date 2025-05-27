package co.edu.uniquindio.poo.biblioteca.model;

public class Usuario {

    private String nombre,numeroIdentificacion,contrasenia;

    /**
     * constructor de la clase Usuario
     * @param nombre
     * @param numeroIdentificacion
     * @param contrasenia
     */
    public Usuario(String nombre, String numeroIdentificacion, String contrasenia){
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return nombre + '\'' +
                ", con numero de identificacion='" + numeroIdentificacion;
    }
}

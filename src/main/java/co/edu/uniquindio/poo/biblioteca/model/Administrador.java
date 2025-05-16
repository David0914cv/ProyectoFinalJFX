package co.edu.uniquindio.poo.biblioteca.model;

public class Administrador extends Usuario{

    private String credencial;

    public Administrador(String nombre, String numeroIdentificacion, String contrasenia, String credencial) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.credencial = credencial;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "credencial='" + credencial + '\'' +
                "nombre='" + getNombre() + '\'' +
                ", numeroIdentificacion='" + getNumeroIdentificacion() + '\'' +
                ", contrasenia='" + getContrasenia() + '\'' +
                '}';
    }
}

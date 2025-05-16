package co.edu.uniquindio.poo.biblioteca.model;

public class Bibliotecario extends Usuario {

    private String credencialBibliotecario;

    public Bibliotecario(String nombre, String numeroIdentificacion, String contrasenia, String credencialBibliotecario) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.credencialBibliotecario = credencialBibliotecario;
    }

    public String getCredencialBibliotecario() {
        return credencialBibliotecario;
    }

    public void setCredencialBibliotecario(String credencialBibliotecario) {
        this.credencialBibliotecario = credencialBibliotecario;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "credencialBibliotecario='" + credencialBibliotecario + '\'' +
                '}';
    }
}

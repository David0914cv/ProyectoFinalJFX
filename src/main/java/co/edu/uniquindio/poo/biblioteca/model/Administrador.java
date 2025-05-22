package co.edu.uniquindio.poo.biblioteca.model;

public class Administrador extends Usuario {

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

    public boolean agregarBibliotecario(Biblioteca biblioteca, Bibliotecario bibliotecario) {
        if (biblioteca == null || bibliotecario == null) {
            return false;
        }
        return biblioteca.agregarUsuario(bibliotecario);
    }

    public boolean eliminarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario) {
        if (biblioteca == null || numeroIdentificacionBibliotecario == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return biblioteca.eliminarUsuario(numeroIdentificacionBibliotecario);
        }
        return false;
    }

    public boolean actualizarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario, Bibliotecario bibliotecario) {
        if (biblioteca == null || bibliotecario == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return biblioteca.actualizarUsuario(numeroIdentificacionBibliotecario, bibliotecario);
        }
        return false;
    }

    public Bibliotecario mostrarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario) {
        if (biblioteca == null || numeroIdentificacionBibliotecario == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return (Bibliotecario) usuario;
        }
        return null;
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


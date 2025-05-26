package co.edu.uniquindio.poo.biblioteca.model;

public class Administrador extends Usuario {

    private String credencial;

    /**
     * constructor de la clase Administrador
     * @param nombre
     * @param numeroIdentificacion
     * @param contrasenia
     * @param credencial
     */
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

    /**
     * metodo para agregar un bibliotecario a una lista de usuarios de biblioteca
     * @param biblioteca
     * @param bibliotecario
     * @return boolean
     */
    public boolean agregarBibliotecario(Biblioteca biblioteca, Bibliotecario bibliotecario) {
        if (biblioteca == null || bibliotecario == null) {
            return false;
        }
        return biblioteca.agregarUsuario(bibliotecario);
    }

    /**
     * metodo para eliminar un bibliotecario de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionBibliotecario
     * @return boolean
     */
    public boolean eliminarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario) {
        if (biblioteca == null || numeroIdentificacionBibliotecario == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return biblioteca.eliminarUsuario(numeroIdentificacionBibliotecario);
        }
        return false;
    }

    /**
     * metodo para actualizar un bibliotecario de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionBibliotecario
     * @param bibliotecario
     * @return boolean
     */
    public boolean actualizarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario, Bibliotecario bibliotecario) {
        if (biblioteca == null || bibliotecario == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return biblioteca.actualizarUsuario(numeroIdentificacionBibliotecario, bibliotecario);
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un bibliotecario de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionBibliotecario
     * @return bibliotecario
     */
    public Bibliotecario mostrarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionBibliotecario) {
        if (biblioteca == null || numeroIdentificacionBibliotecario == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionBibliotecario);
        if (usuario instanceof Bibliotecario) {
            return (Bibliotecario) usuario;
        }
        return null;
    }

    /**
     * metodo para crear un reporte de administrador con la lista de solicitudes de préstamo de biblioteca,
     * la lista de préstamos de biblioteca y la lista de devoluciones de biblioteca
     * @param biblioteca
     * @return String
     */
    public String generarReporteAdministrador (Biblioteca biblioteca){
        StringBuilder reporteAdministrador = new StringBuilder();
        reporteAdministrador.append("Lista de solicitudes de préstamo:\n");
        for (SolicitudPrestamo solicitudPrestamo : biblioteca.getListSolicitudPrestamos()){
            reporteAdministrador.append(solicitudPrestamo).append("\n");
        }
        reporteAdministrador.append("\n").append("Lista de préstamos:\n");
        for (Prestamo prestamo : biblioteca.getListPrestamos()){
            reporteAdministrador.append(prestamo).append("\n");
        }
        reporteAdministrador.append("\n").append("Lista de devoluciones:\n");
        for (Devolucion devolucion : biblioteca.getListDevoluciones()){
            reporteAdministrador.append(devolucion).append("\n");
        }
        return reporteAdministrador.toString();
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


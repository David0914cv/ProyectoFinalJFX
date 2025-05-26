package co.edu.uniquindio.poo.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bibliotecario extends Usuario {

    private String credencialBibliotecario;

    /**
     * constructor de la clase Bibliotecario
     * @param nombre
     * @param numeroIdentificacion
     * @param contrasenia
     * @param credencialBibliotecario
     */
    public Bibliotecario(String nombre, String numeroIdentificacion, String contrasenia, String credencialBibliotecario) {
        super(nombre, numeroIdentificacion, contrasenia);
        this.credencialBibliotecario = credencialBibliotecario;
    }

    /**
     * metodo para agregar estudiantes a una lista de biblioteca
     * @param biblioteca
     * @param estudiante
     * @return boolean
     */
    public boolean agregarEstudiante(Biblioteca biblioteca, Estudiante estudiante) {
        if (biblioteca == null || estudiante == null) {
            return false;
        }
        return biblioteca.agregarUsuario(estudiante);
    }

    /**
     * metodo para agregar un estudiante a una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionEstudiante
     * @return boolean
     */
    public boolean eliminarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return biblioteca.eliminarUsuario(numeroIdentificacionEstudiante);
        }
        return false;
    }

    /**
     * metodo para actualizar un estudiante en una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionEstudiante
     * @param estudiante
     * @return boolean
     */
    public boolean actualizarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante, Estudiante estudiante) {
        if (biblioteca == null || estudiante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return biblioteca.actualizarUsuario(numeroIdentificacionEstudiante, estudiante);
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un estudiante de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionEstudiante
     * @return estudiante
     */
    public Estudiante mostrarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return (Estudiante) usuario;
        }
        return null;
    }

    /**
     * metodo para agregar un docente a una lista de usuarios de biblioteca
     * @param biblioteca
     * @param docente
     * @return boolean
     */
    public boolean agregarDocente(Biblioteca biblioteca, Docente docente) {
        if (biblioteca == null || docente == null) {
            return false;
        }
        return biblioteca.agregarUsuario(docente);
    }

    /**
     * metodo para agregar un docente a una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionDocente
     * @return boolean
     */
    public boolean eliminarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return biblioteca.eliminarUsuario(numeroIdentificacionDocente);
        }
        return false;
    }

    /**
     * metodo para actualizar un docente de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionDocente
     * @param docente
     * @return boolean
     */
    public boolean actualizarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente, Docente docente) {
        if (biblioteca == null || docente == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return biblioteca.actualizarUsuario(numeroIdentificacionDocente, docente);
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un docente de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionDocente
     * @return docente
     */
    public Docente mostrarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return (Docente) usuario;
        }
        return null;
    }

    /**
     * metodo para agregar un visitante a una lista de usuarios de biblioteca
     * @param biblioteca
     * @param visitante
     * @return boolean
     */
    public boolean agregarVisitante(Biblioteca biblioteca, Visitante visitante) {
        if (biblioteca == null || visitante == null) {
            return false;
        }
        return biblioteca.agregarUsuario(visitante);
    }

    /**
     * metodo para eliminar un visitante de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionVisitante
     * @return boolean
     */
    public boolean eliminarVisitante(Biblioteca biblioteca, String numeroIdentificacionVisitante) {
        if (biblioteca == null || numeroIdentificacionVisitante == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return biblioteca.eliminarUsuario(numeroIdentificacionVisitante);
        }
        return false;
    }

    /**
     * metodo para actualizar un visitante de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionVisitante
     * @param visitante
     * @return boolean
     */
    public boolean actualizarVisitante(Biblioteca biblioteca, String numeroIdentificacionVisitante, Visitante visitante) {
        if (biblioteca == null || visitante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return biblioteca.actualizarUsuario(numeroIdentificacionVisitante, visitante);
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un visitante de una lista de usuarios de biblioteca
     * @param biblioteca
     * @param numeroIdentificacionVisitante
     * @return visitante
     */
    public Visitante mostrarVisitante(Biblioteca biblioteca, String numeroIdentificacionVisitante) {
        if (biblioteca == null || numeroIdentificacionVisitante == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return (Visitante) usuario;
        }
        return null;
    }

    /**
     * metodo para agregar un libro a una lista de libros de biblioteca
     * @param biblioteca
     * @param libro
     * @return boolean
     */
    public boolean agregarLibro(Biblioteca biblioteca, Libro libro) {
        if (biblioteca == null || libro == null) {
            return false;
        }
        return biblioteca.agregarLibro(libro);
    }

    /**
     * metodo para eliminar un libro de una lista de libros de biblioteca
     * @param biblioteca
     * @param codigoLibro
     * @return boolean
     */
    public boolean eliminarLibro(Biblioteca biblioteca, String codigoLibro) {
        if (biblioteca == null || codigoLibro == null) {
            return false;
        }
        return biblioteca.eliminarLibro(codigoLibro);
    }

    /**
     * metodo para actualizar un libro de una lista de libros de biblioteca
     * @param biblioteca
     * @param codigoLibro
     * @param libro
     * @return boolean
     */
    public boolean actualizarLibro(Biblioteca biblioteca, String codigoLibro, Libro libro) {
        if (biblioteca == null || codigoLibro == null) {
            return false;
        }
        return biblioteca.actualizarLibro(codigoLibro, libro);
    }

    /**
     * metodo para mostrar los datos de un libro de una lista de libros de biblioteca
     * @param biblioteca
     * @param codigoLibro
     * @return libro
     */
    public Libro mostrarLibro(Biblioteca biblioteca, String codigoLibro) {
        if (biblioteca == null || codigoLibro == null) {
            return null;
        }
        return biblioteca.mostrarLibro(codigoLibro);
    }

    /**
     * metodo para validar la posibilidad de un estudiante de realizar un prestamo
     * dependiendo de su estado y su cantidad de libros prestados
     * @param biblioteca
     * @param numeroIdentificacionEstudiante
     * @return boolean
     */
    public boolean posibilidadPrestamoEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (estudiante.getCantidadlibrosPrestados() > 5 || estudiante.getEstadoUsuario() == EstadoUsuario.EN_MORA) {
                return false;
            }
        }
        return true;
    }

    /**
     * metodo para validar la posbilidad de un docente de realizar un prestamo dependiendo de su estado
     * @param biblioteca
     * @param numeroIdentificacionDocente
     * @return boolean
     */
    public boolean posibilidadPrestamoDocente(Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            if (docente.getEstadoUsuario() == EstadoUsuario.EN_MORA) {
                return false;
            }
        }
        return true;
    }

    /**
     * metodo para confirmar la posbilidad de un usuario de clase estudiante o docente para realizar un prestamo
     * @param biblioteca
     * @param usuario
     * @return boolean
     */
    public boolean validarPrestamo(Biblioteca biblioteca, Usuario usuario) {
        if (biblioteca == null || usuario == null) return false;
        if (usuario instanceof Docente) {
            return posibilidadPrestamoDocente(biblioteca, usuario.getNumeroIdentificacion());
        } else if (usuario instanceof Estudiante) {
            return posibilidadPrestamoEstudiante(biblioteca, usuario.getNumeroIdentificacion());
        }
        return false;
    }

    /**
     * metodo para asignar un id aleatorio mediante funciones propias
     * @return String
     */
    public String asignarId() {
        return UUID.randomUUID().toString();
    }

    /**
     * metodo para asignar la fecha actual mediante funciones propias
     * @return String
     */
    public String asignarFechaActual() {
        return LocalDate.now().toString();
    }

    /**
     * metodo para calcular la fecha de finalizacion mediante funciones propias y
     * operaciones aritmeticas basicas
     * @param fechaInicio
     * @param usuario
     * @return String
     */
    public String asignarFechaFin(String fechaInicio, Usuario usuario) {
        LocalDate inicio = LocalDate.parse(fechaInicio);
        if (usuario instanceof Estudiante) {
            int diasPrestamo = 5;
            return inicio.plusDays(diasPrestamo).toString();
        } else {
            int diasPrestamo = 10;
            return inicio.plusDays(diasPrestamo).toString();
        }
    }

    /**
     * metodo para actualizar el estado de un libro en una lista de libros de biblioteca
     * @param biblioteca
     * @param codigoLibro
     * @param nuevoEstado
     */
    public void actualizarlibro(Biblioteca biblioteca, String codigoLibro, EstadoLibro nuevoEstado) {
        Libro libro = biblioteca.mostrarLibro(codigoLibro);
        if (libro != null) {
            libro.setEstado(nuevoEstado);
            biblioteca.actualizarLibro(codigoLibro, libro);
        }
    }

    /**
     * metodo para verificar si un usuario se encuentra en deuda
     * @param biblioteca
     * @param usuario
     * @return boolean
     */
    public boolean tieneDeuda(Biblioteca biblioteca, Usuario usuario) {
        if (!(usuario instanceof Estudiante) && !(usuario instanceof Docente)) return false;
        boolean deuda = false;
        LocalDate actual = LocalDate.now();
        for (Prestamo prestamo : biblioteca.getListPrestamos()) {
            if (prestamo.getUsuario().equals(usuario)) {
                LocalDate fechaFin = LocalDate.parse(prestamo.getFechaFin());
                if (fechaFin.isBefore(actual)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo para actualizar el estado de un usuario en una lista de usuarios de biblioteca
     * @param biblioteca
     * @param usuario
     * @param deuda
     */
    public void actualizarEstadoUsuario(Biblioteca biblioteca, Usuario usuario, boolean deuda) {
        EstadoUsuario nuevoEstado = deuda ? EstadoUsuario.EN_MORA : EstadoUsuario.PAZ_Y_SALVO;
        if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            if (docente.getEstadoUsuario() != nuevoEstado) {
                docente.setEstadoUsuario(nuevoEstado);
                biblioteca.actualizarUsuario(docente.getNumeroIdentificacion(), docente);
            }
        } else if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (estudiante.getEstadoUsuario() != nuevoEstado) {
                estudiante.setEstadoUsuario(nuevoEstado);
                biblioteca.actualizarUsuario(estudiante.getNumeroIdentificacion(), estudiante);
            }
        }
    }

    /**
     * metodo para crear un prestamo y agregarlo a una lista de prestamos de biblioteca
     * @param biblioteca
     * @param usuario
     * @param libro
     * @return boolean
     */
    public boolean crearPrestamo(Biblioteca biblioteca, Usuario usuario, Libro libro) {
        if (libro instanceof LibroReferencia) return false;
        if (!validarPrestamo(biblioteca, usuario)) return false;
        if (!biblioteca.libroDisponible(libro.getCodigo())) return false;
        String id = asignarId();
        String fechaInicio = asignarFechaActual();
        String fechaFin = asignarFechaFin(fechaInicio, usuario);
        Prestamo prestamo = new Prestamo(id, fechaInicio, fechaFin, usuario, this, libro);
        boolean prestado = biblioteca.agregarPrestamo(prestamo);
        if (prestado) {
            actualizarlibro(biblioteca, libro.getCodigo(), EstadoLibro.PRESTADO);
            aumentarVecesPrestado(biblioteca, libro);
            aumentarLibrosPrestadosUsuario(biblioteca, usuario);

            boolean deuda = tieneDeuda(biblioteca, usuario);
            actualizarEstadoUsuario(biblioteca, usuario, deuda);
            actualizarListaUsuariosDeuda(biblioteca, usuario, deuda);

        }
        return prestado;
    }

    /**
     * metodo para eliminar o agregar un usuario a una lista de usuarios en mora de biblioteca
     * @param biblioteca
     * @param usuario
     * @param deuda
     */
    public void actualizarListaUsuariosDeuda(Biblioteca biblioteca, Usuario usuario, boolean deuda) {
        if (usuario instanceof Docente || usuario instanceof Estudiante) {
            if (deuda){
                biblioteca.agregarUsuarioEnMora(usuario);
        } else {
                biblioteca.eliminarUsuarioEnMora(usuario.getNumeroIdentificacion());
            }
        }
    }

    /**
     * metodo para aumentar la cantidad de veces que un libro ha sido prestado
     * @param biblioteca
     * @param libro
     */
    public void aumentarVecesPrestado(Biblioteca biblioteca, Libro libro) {
            libro.setCantidadVecesPrestado(libro.getCantidadVecesPrestado() + 1);
            biblioteca.actualizarLibro(libro.getCodigo(), libro);
    }

    /**
     * metodo para aumentar la cantidad de libros que un estudiante tiene prestados
     * @param biblioteca
     * @param usuario
     */
    public void aumentarLibrosPrestadosUsuario(Biblioteca biblioteca, Usuario usuario) {
            if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                estudiante.setCantidadlibrosPrestados(estudiante.getCantidadlibrosPrestados() + 1);
                biblioteca.actualizarUsuario(estudiante.getNumeroIdentificacion(), estudiante);
        }
    }

    /**
     * metodo para verificar si un prestamo se encuentra activo en una lista de prestamos de biblioteca
     * @param biblioteca
     * @param usuario
     * @param libro
     * @return boolean
     */
    public boolean verificarprestamoActivo(Biblioteca biblioteca, Usuario usuario, Libro libro) {
        for (Prestamo prestamo : biblioteca.getListPrestamos()) {
            if (prestamo.getUsuario().equals(usuario) && prestamo.getLibro().equals(libro)) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para crear una devolucion y agregarla a una lista de devoluciones de biblioteca
     * @param biblioteca
     * @param usuario
     * @param libro
     * @param observaciones
     * @return boolean
     */
    public boolean crearDevolucion(Biblioteca biblioteca, Usuario usuario, Libro libro, String observaciones) {
        if (biblioteca.libroDisponible(libro.getCodigo())) return false;

        if (verificarprestamoActivo(biblioteca, usuario, libro)) {
            Prestamo prestamoActivo = null;
            for (Prestamo prestamo : biblioteca.getListPrestamos()) {
                if (prestamo.getUsuario().equals(usuario) && prestamo.getLibro().equals(libro)) {
                    prestamoActivo = prestamo;
                    break;
                }
            }
            if (prestamoActivo == null) return false;
            String id = asignarId();
            String fechaDevolucion = asignarFechaActual();
            Devolucion devolucion = new Devolucion(id, fechaDevolucion, observaciones, prestamoActivo);

            actualizarlibro(biblioteca, libro.getCodigo(), EstadoLibro.DISPONIBLE);
            disminuirLibrosPrestado(usuario);

            biblioteca.eliminarLibroPrestado(libro.getCodigo());
            biblioteca.eliminarPrestamo(prestamoActivo.getId());

            boolean deuda = tieneDeuda(biblioteca, usuario);
            actualizarEstadoUsuario(biblioteca, usuario, deuda);
            actualizarListaUsuariosDeuda(biblioteca, usuario, deuda);

            return biblioteca.agregarDevolucion(devolucion);
        }
        return false;
    }

    /**
     * metodo para disminuir la cantidad de libros prestados de un estudiante
     * @param usuario
     */
    public void disminuirLibrosPrestado(Usuario usuario) {
        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            estudiante.setCantidadlibrosPrestados(estudiante.getCantidadlibrosPrestados() - 1);
        }
    }

    /**
     * metodo para obtener el libro con mayor numero de veces que ha sido prestado de una lista de libros de biblioteca
     * @param biblioteca
     * @return libro mas prestado
     */
    public Libro libroMasPrestado(Biblioteca biblioteca) {
        Libro libroMasPrestado = null;
        int masPrestado = 0;
        for (Libro libro : biblioteca.getListLibros()) {
            if (libro.getCantidadVecesPrestado() > masPrestado) {
                libroMasPrestado = libro;
                masPrestado = libro.getCantidadVecesPrestado();
            }

        }
        return libroMasPrestado;
    }

    /**
     * metodo para crear un reporte con el libro mas prestado, una lista de todos los libros prestados de biblioteca
     * y una lista con todos los usuarios en mora de biblioteca
     * @param biblioteca
     * @return String
     */
    public String crearReporte(Biblioteca biblioteca) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("\nLibro más prestado: ").append(libroMasPrestado(biblioteca));
        reporte.append("\nLibros prestados:");
        for (Libro libro : biblioteca.getListLibrosPrestados()) {
            reporte.append(libro.getTitulo()).append("\t").append(libro.getCodigo()).append("\n");
        }
        reporte.append("\nUsuarios en mora:");
        for (Usuario usuario : biblioteca.getListUsuariosEnMora()) {
            reporte.append(usuario.getNombre()).append("\t").append(usuario.getNumeroIdentificacion()).append("\n");
        }
        return reporte.toString();
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

package co.edu.uniquindio.poo.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public boolean agregarEstudiante(Biblioteca biblioteca, Estudiante estudiante) {
        if (biblioteca == null || estudiante == null) {
            return false;
        }
        return biblioteca.agregarUsuario(estudiante);
    }

    public boolean eliminarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return biblioteca.eliminarUsuario(numeroIdentificacionEstudiante);
        }
        return false;
    }

    public boolean actualizarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante, Estudiante estudiante) {
        if (biblioteca == null || estudiante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return biblioteca.actualizarUsuario(numeroIdentificacionEstudiante, estudiante);
        }
        return false;
    }

    public Estudiante mostrarEstudiante(Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            return (Estudiante) usuario;
        }
        return null;
    }

    public boolean agregarDocente(Biblioteca biblioteca, Docente docente) {
        if (biblioteca == null || docente == null) {
            return false;
        }
        return biblioteca.agregarUsuario(docente);
    }

    public boolean eliminarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return biblioteca.eliminarUsuario(numeroIdentificacionDocente);
        }
        return false;
    }

    public boolean actualizarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente, Docente docente) {
        if (biblioteca == null || docente == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return biblioteca.actualizarUsuario(numeroIdentificacionDocente, docente);
        }
        return false;
    }

    public Docente mostrarDocente(Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            return (Docente) usuario;
        }
        return null;
    }

    public boolean agregarVisitante(Biblioteca biblioteca, Visitante visitante) {
        if (biblioteca == null || visitante == null) {
            return false;
        }
        return biblioteca.agregarUsuario(visitante);
    }

    public boolean eliminarVisitante(Biblioteca biblioteca, String numeroIdentificacionVisitante) {
        if (biblioteca == null || numeroIdentificacionVisitante == null)
            return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return biblioteca.eliminarUsuario(numeroIdentificacionVisitante);
        }
        return false;
    }

    public boolean actualizarBibliotecario(Biblioteca biblioteca, String numeroIdentificacionVisitante, Visitante visitante) {
        if (biblioteca == null || visitante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return biblioteca.actualizarUsuario(numeroIdentificacionVisitante, visitante);
        }
        return false;
    }

    public Visitante mostrarVisitante(Biblioteca biblioteca, String numeroIdentificacionVisitante) {
        if (biblioteca == null || numeroIdentificacionVisitante == null) return null;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionVisitante);
        if (usuario instanceof Visitante) {
            return (Visitante) usuario;
        }
        return null;
    }

    public boolean agregarLibro(Biblioteca biblioteca, Libro libro) {
        if (biblioteca == null || libro == null) {
            return false;
        }
        return biblioteca.agregarLibro(libro);
    }

    public boolean eliminarLibro(Biblioteca biblioteca, String codigoLibro) {
        if (biblioteca == null || codigoLibro == null) {
            return false;
        }
        return biblioteca.eliminarLibro(codigoLibro);
    }

    public boolean actualizarLibro(Biblioteca biblioteca, String codigoLibro, Libro libro) {
        if (biblioteca == null || codigoLibro == null) {
            return false;
        }
        return biblioteca.actualizarLibro(codigoLibro, libro);
    }

    public Libro mostrarLibro(Biblioteca biblioteca, String codigoLibro) {
        if (biblioteca == null || codigoLibro == null) {
            return null;
        }
        return biblioteca.mostrarLibro(codigoLibro);
    }

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

    public boolean validarPrestamo(Biblioteca biblioteca, Usuario usuario) {
        if (biblioteca == null || usuario == null) return false;
        if (usuario instanceof Docente) {
            return posibilidadPrestamoDocente(biblioteca, usuario.getNumeroIdentificacion());
        } else if (usuario instanceof Estudiante) {
            return posibilidadPrestamoEstudiante(biblioteca, usuario.getNumeroIdentificacion());
        }
        return false;
    }

    public String asignarId() {
        return UUID.randomUUID().toString();
    }

    public String asignarFechaActual() {
        return LocalDate.now().toString();
    }

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

    public void actualizarlibro(Biblioteca biblioteca, String codigoLibro, EstadoLibro nuevoEstado) {
        Libro libro = biblioteca.mostrarLibro(codigoLibro);
        if (libro != null) {
            libro.setEstado(nuevoEstado);
            biblioteca.actualizarLibro(codigoLibro, libro);
        }
    }

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

    public void actualizarEstadoUsuario(Biblioteca biblioteca, Usuario usuario, Boolean deuda) {
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
            boolean deuda = tieneDeuda(biblioteca, usuario);
            actualizarEstadoUsuario(biblioteca, usuario, deuda);
            if (deuda) {
                biblioteca.agregarUsuarioEnMora(usuario);
            }
            libro.setCantidadVecesPrestado(libro.getCantidadVecesPrestado() + 1);
            biblioteca.actualizarLibro(libro.getCodigo(), libro);
            biblioteca.agregarLibroPrestado(libro);
            if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                estudiante.setCantidadlibrosPrestados(estudiante.getCantidadlibrosPrestados() + 1);
                biblioteca.actualizarUsuario(estudiante.getNumeroIdentificacion(), estudiante);
            }
        }
        return prestado;
    }


    public boolean verificarprestamoActivo(Biblioteca biblioteca, Usuario usuario, Libro libro) {
        for (Prestamo prestamo : biblioteca.getListPrestamos()) {
            if (prestamo.getUsuario().equals(usuario) && prestamo.getLibro().equals(libro)) {
                return true;
            }
        }
        return false;
    }


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
            if (prestamoActivo == null) {
                return false;
            }
            String id = asignarId();
            String fechaDevolucion = asignarFechaActual();
            Devolucion devolucion = new Devolucion(id, fechaDevolucion, observaciones, prestamoActivo);
            actualizarlibro(biblioteca, libro.getCodigo(), EstadoLibro.DISPONIBLE);

            if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                estudiante.setCantidadlibrosPrestados(estudiante.getCantidadlibrosPrestados() - 1);
                biblioteca.actualizarUsuario(estudiante.getNumeroIdentificacion(), estudiante);
            }

            biblioteca.eliminarLibroPrestado(libro.getCodigo());
            biblioteca.eliminarPrestamo(prestamoActivo.getId());
            boolean deuda = tieneDeuda(biblioteca, usuario);
            actualizarEstadoUsuario(biblioteca, usuario, deuda);
            return biblioteca.agregarDevolucion(devolucion);

        }

        return false;

    }

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

    public String crearReporte(Biblioteca biblioteca) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Libro más prestado: ").append(libroMasPrestado(biblioteca));
        reporte.append("Libros prestados:\n");
        for (Libro libro : biblioteca.getListLibrosPrestados()) {
            reporte.append(libro.getTitulo()).append("\t").append(libro.getCodigo()).append("\n");
        }
        reporte.append("Usuarios en mora:\n");
        for (Usuario usuario : biblioteca.getListUsuariosEnMora()) {
            reporte.append(usuario.getNombre()).append("\t").append(usuario.getNumeroIdentificacion()).append("\n");
        }
        return reporte.toString();
    }


    @Override
    public String toString() {
        return "Bibliotecario{" +
                "credencialBibliotecario='" + credencialBibliotecario + '\'' +
                '}';
    }
}

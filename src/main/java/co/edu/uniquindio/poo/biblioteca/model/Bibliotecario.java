package co.edu.uniquindio.poo.biblioteca.model;

import java.time.LocalDate;
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

    public boolean agregarLibro (Biblioteca biblioteca, Libro libro) {
        if (biblioteca == null || libro == null) {
            return false;
        }
        return biblioteca.agregarLibro(libro);
    }

    public boolean eliminarLibro (Biblioteca biblioteca, String codigoLibro) {
        if (biblioteca == null || codigoLibro == null) {
            return false;
        }
        return biblioteca.eliminarLibro(codigoLibro);
    }

    public boolean actualizarLibro (Biblioteca biblioteca,String codigoLibro, Libro libro) {
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

    public boolean posibilidadPrestamoEstudiante (Biblioteca biblioteca, String numeroIdentificacionEstudiante) {
        if (biblioteca == null || numeroIdentificacionEstudiante == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionEstudiante);
        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (estudiante.getCantidadlibrosPrestados() > 5 || estudiante.getEstadoUsuario() == EstadoUsuario.EN_MORA){
                return false;
            }
        } return true;
    }

    public boolean posibilidadPrestamoDocente (Biblioteca biblioteca, String numeroIdentificacionDocente) {
        if (biblioteca == null || numeroIdentificacionDocente == null) return false;
        Usuario usuario = biblioteca.mostrarUsuario(numeroIdentificacionDocente);
        if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            if (docente.getEstadoUsuario() == EstadoUsuario.EN_MORA){
                return false;
            }
        } return true;
    }

    public boolean validarPrestamo (Biblioteca biblioteca, Usuario usuario) {
        if (biblioteca == null || usuario == null) return false;
        if (usuario instanceof Docente) {
            return posibilidadPrestamoDocente(biblioteca, usuario.getNumeroIdentificacion());
        }
        else if (usuario instanceof Estudiante) {
            return posibilidadPrestamoEstudiante(biblioteca, usuario.getNumeroIdentificacion());
        }
        return false;
    }

    public String asignarId() {
        return UUID.randomUUID().toString();
    }

    public String asignarFechaInicio() {
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


    public boolean crearPrestamo (Biblioteca biblioteca, Usuario usuario, Libro libro) {
        if (!validarPrestamo(biblioteca, usuario)) return false;
        if (!biblioteca.libroDisponible(libro.getCodigo())) return false;
        String id = asignarId();
        String fechaInicio = asignarFechaInicio();
        String fechaFin = asignarFechaFin(fechaInicio, usuario);
        Prestamo prestamo = new Prestamo(id, fechaInicio, fechaFin, usuario, this, libro);
        return biblioteca.agregarPrestamo(prestamo);
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "credencialBibliotecario='" + credencialBibliotecario + '\'' +
                '}';
    }
}

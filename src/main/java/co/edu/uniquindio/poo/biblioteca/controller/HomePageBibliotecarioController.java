package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.*;

import java.util.List;
import java.util.UUID;

public class HomePageBibliotecarioController {
    Biblioteca biblioteca;

    public HomePageBibliotecarioController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<SolicitudPrestamo> getSolicitudesPrestamo(){
        return biblioteca.getListSolicitudPrestamos();
    }

    public boolean agregarPrestamoBiblioteca(String fechaInicio, String fechaFin, Usuario usuario, Bibliotecario bibliotecario,Libro libro) {
        String id = UUID.randomUUID().toString();
        Prestamo prestamo = new Prestamo(id,fechaInicio,fechaFin,usuario,bibliotecario,libro);
        return biblioteca.agregarPrestamo(prestamo);
    }

    public List<Usuario> getListaUsuarios(){
        return biblioteca.getListUsuarios();
    }

    public boolean actualizarEstudiante(Estudiante estudiante,Bibliotecario bibliotecario) {
        return bibliotecario.actualizarEstudiante(biblioteca, estudiante.getNumeroIdentificacion(), estudiante);
    }

    public boolean actualizarDocente(Docente docente,Bibliotecario bibliotecario) {
        return bibliotecario.actualizarDocente(biblioteca, docente.getNumeroIdentificacion(), docente);
    }

    public boolean actuaizarLibro(Bibliotecario bibliotecario,Libro libro){
        return bibliotecario.actualizarLibro(biblioteca,libro.getCodigo(),libro);
    }

    public boolean actuaizarSolicitud(SolicitudPrestamo solicitudPrestamo){
        return biblioteca.actualizarSolicitudPrestamo(solicitudPrestamo.getId(),solicitudPrestamo);
    }

    public String generarReporteBibliotecario(Bibliotecario bibliotecario){
        return bibliotecario.crearReporte(biblioteca);
    }

    public boolean agregarUsuarioMora(Usuario usuario) {
        return biblioteca.agregarUsuarioEnMora(usuario);
    }

    public boolean agregarlibroPrestado(Libro libro) {
        return biblioteca.agregarLibroPrestado(libro);
    }

}

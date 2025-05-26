package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.SolicitudPrestamo;

import java.util.List;

public class RequestsUserController {

    Biblioteca biblioteca;

    public RequestsUserController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<SolicitudPrestamo> getSolicitudes() {
        return biblioteca.getListSolicitudPrestamos();
    }

}

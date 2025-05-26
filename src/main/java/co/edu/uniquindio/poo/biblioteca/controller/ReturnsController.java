package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Prestamo;

import java.util.List;

public class ReturnsController {

    Biblioteca biblioteca;

    public ReturnsController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Prestamo> getPrestamos() {
        return biblioteca.getListPrestamos();
    }

}

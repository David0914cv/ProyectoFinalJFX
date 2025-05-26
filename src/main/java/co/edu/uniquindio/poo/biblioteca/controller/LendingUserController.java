package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Prestamo;

import java.util.List;

public class LendingUserController {
    Biblioteca biblioteca;

    public LendingUserController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Prestamo> getPrestamos() {
        return biblioteca.getListPrestamos();
    }
}

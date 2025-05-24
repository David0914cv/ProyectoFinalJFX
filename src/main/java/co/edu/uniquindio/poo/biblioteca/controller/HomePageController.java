package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Libro;

import java.util.List;

public class HomePageController {

    Biblioteca biblioteca;

    public HomePageController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Libro> getLibros() {
        return biblioteca.getListLibros();
    }
}
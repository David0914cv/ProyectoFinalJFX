package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Libro;

public class AddBookVirtualController {
    Biblioteca biblioteca;

    public AddBookVirtualController(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean agregarLibro(Libro libro) {
        return biblioteca.agregarLibro(libro);
    }
}

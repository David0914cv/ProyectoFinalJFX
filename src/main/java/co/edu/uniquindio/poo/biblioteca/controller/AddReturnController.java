package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.Usuario;

import java.util.List;

public class AddReturnController {
    Biblioteca biblioteca;

    public AddReturnController(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean addReturn(Bibliotecario bibliotecario, Usuario usuario, Libro libro,String observaciones) {
        return bibliotecario.crearDevolucion(biblioteca,usuario,libro,observaciones);
    }

    public List<Usuario> getUsuarios() {
        return biblioteca.getListUsuarios();
    }
}

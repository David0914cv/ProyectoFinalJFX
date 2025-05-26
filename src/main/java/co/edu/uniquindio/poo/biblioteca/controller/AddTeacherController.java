package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.*;

import java.util.List;

public class AddTeacherController {
    Biblioteca biblioteca;

    public AddTeacherController(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean agregarDocente(Docente docente, Bibliotecario bibliotecario) {
        return bibliotecario.agregarDocente(biblioteca, docente);
    }

    public List<Usuario> getListUsuarios(){
        return biblioteca.getListUsuarios();
    }
}

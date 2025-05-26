package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.*;

import java.util.List;

public class AddVisitantController {
    Biblioteca biblioteca;

    public AddVisitantController(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean agregarDocente(Visitante visitante, Bibliotecario bibliotecario) {
        return bibliotecario.agregarVisitante(biblioteca, visitante);
    }

    public List<Usuario> getListUsuarios(){
        return biblioteca.getListUsuarios();
    }
}

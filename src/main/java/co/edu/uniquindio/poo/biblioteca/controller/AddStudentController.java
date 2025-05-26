package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.*;

import java.util.List;

public class AddStudentController {
    Biblioteca biblioteca;

    public AddStudentController(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean agregarEstudiante(Estudiante estudiante, Bibliotecario bibliotecario) {
        return bibliotecario.agregarEstudiante(biblioteca, estudiante);
    }

    public List<Usuario> getListUsuarios(){
        return biblioteca.getListUsuarios();
    }
}

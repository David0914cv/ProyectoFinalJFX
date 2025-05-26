package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Administrador;
import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca.model.Usuario;

import java.util.List;

public class HomePageAdminController {
    Biblioteca biblioteca;
    public HomePageAdminController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Usuario> getListaUsuarios(){
        return biblioteca.getListUsuarios();
    }

    public String generarReporteAdministrador(Administrador administrador){
        return administrador.generarReporteAdministrador(biblioteca);
    }

    public boolean agregarUsuario(Administrador administrador, Bibliotecario bibliotecario){
        return administrador.agregarBibliotecario(biblioteca,bibliotecario);
    }

    public boolean actualizarUsuario(Administrador administrador,Bibliotecario bibliotecario,String id){
        return administrador.actualizarBibliotecario(biblioteca,id,bibliotecario);
    }
}

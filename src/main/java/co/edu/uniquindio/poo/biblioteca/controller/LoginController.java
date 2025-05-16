package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;
import java.util.Map;

public class LoginController {

    Biblioteca biblioteca;

    public LoginController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean login(Map<String,String> formLogin) {
        return biblioteca.loginUsuario(formLogin);
    }

}

package co.edu.uniquindio.poo.biblioteca.controller;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;

import java.util.Map;

public class LoginCredentialController {
    Biblioteca biblioteca;

    public LoginCredentialController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Map<String,String> login(Map<String,String> formLogin) {
        return biblioteca.loginUsuarioCredencial(formLogin);
    }
}

package co.edu.uniquindio.poo.biblioteca.viewController;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.LoginController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginViewController {


    LoginController loginController;

    @FXML
    private Label lblNoLogin;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private Button btbLogin;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onLogin() {
        login();
    }

    @FXML
    void initialize() {
        loginController = new LoginController(app.biblioteca);
    }

    private void login() {

        Map<String,String> infoLogin=buildUsuarioLogin();

        Map<String,String> login=loginController.login(infoLogin);

        if (login.get("message").equals("login correct")){
            app.setRol(login.get("rol"));
            app.setUser(infoLogin.get("cedula"));
            app.openHomePage();
            System.out.println("Login Exitoso");
            System.out.println(login.get("rol"));
        }
        if(login.get("message").equals("password incorrect")){
            System.out.println("Login Error");
            lblNoLogin.setText("Contraseña incorrecta");
            txtCedula.clear();
            txtContrasenia.clear();
        }
        if (login.get("message").equals("user not exist")){
            System.out.println("Login Error");
            lblNoLogin.setText("Usuario inexistente");
            txtCedula.clear();
            txtContrasenia.clear();
        }
        if (login.get("message").equals("type incorrect")){
            System.out.println("Login Error");
            lblNoLogin.setText("Tipo de usuario incorrecto");
            txtCedula.clear();
            txtContrasenia.clear();
        }
    }

    private Map<String,String> buildUsuarioLogin() {
        Map<String,String> formLogin = new HashMap<>();

        formLogin.put("cedula",txtCedula.getText());
        formLogin.put("contrasenia", txtContrasenia.getText());

        return formLogin;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.LoginController;
import co.edu.uniquindio.poo.biblioteca.controller.LoginCredentialController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class LoginCredentialViewController {
    LoginCredentialController loginCredentialController;
    @FXML
    private Label lblNoLogin;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private PasswordField txtCredencial;

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
    void onBack(){
        app.openTypeUser();
    }


    @FXML
    void initialize() {

        loginCredentialController = new LoginCredentialController(app.biblioteca);

    }

    private void login() {

        Map<String,String> infoLogin=buildUsuarioLogin();
        app.setRol("Admin");
        Map<String,String> login=loginCredentialController.login(infoLogin);
        if (login.get("message").equals("login correct")){
            app.setRol(login.get("rol"));
            app.setUser(infoLogin.get("cedula"));

            if (login.get("rol").equals("Administrador")){
                app.openHomePageAdmin();
            }
            if (login.get("rol").equals("Bibliotecario")){
                app.openHomePageBibliotecario();
            }
        }
        if(login.get("message").equals("password incorrect")){
            System.out.println("Login Error");
            lblNoLogin.setText("Contraseña o credencial incorrecta");
            txtCedula.clear();
            txtContrasenia.clear();
            txtCredencial.clear();
        }
        if (login.get("message").equals("user not exist")){
            System.out.println("Login Error");
            lblNoLogin.setText("Usuario inexistente");
            txtCedula.clear();
            txtContrasenia.clear();
            txtCredencial.clear();
        }
        if (login.get("message").equals("type incorrect")){
            System.out.println("Login Error");
            lblNoLogin.setText("Tipo de usuario incorrecto");
            txtCedula.clear();
            txtContrasenia.clear();
            txtCredencial.clear();
        }
    }

    private Map<String,String> buildUsuarioLogin() {
        Map<String,String> formLogin = new HashMap<>();

        formLogin.put("cedula",txtCedula.getText());
        formLogin.put("contrasenia", txtContrasenia.getText());
        formLogin.put("credencial",txtCredencial.getText());

        return formLogin;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
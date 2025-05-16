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
    private ChoiceBox tipoUsuario;

    @FXML
    private TextField txtContrasenia;

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
        this.app=app;
        loginController = new LoginController(app.biblioteca);

    }

    private void login() {

        Map<String,String> infoLogin=buildUsuarioLogin();

        boolean login=loginController.login(infoLogin);
        if (login){
            System.out.println("Login Exitoso");
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

package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class TypeUserViewController {

    App app;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void onOpenLogin(){
        openLogin();
    }

    public void openLogin(){
        if (buildOption().equals("Bibliotecario") || buildOption().equals("Administrador")){
            app.openLoginCredential();
        }
        if (buildOption().equals("Estudiante") || buildOption().equals("Docente") || buildOption().equals("Visitante")){
            app.openLogin();
        }
       /*app.openLogin();*/
    }

    private String buildOption(){

        return choiceBox.getValue();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }
}

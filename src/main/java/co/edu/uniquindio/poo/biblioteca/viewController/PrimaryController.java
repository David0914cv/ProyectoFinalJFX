package co.edu.uniquindio.poo.biblioteca.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.biblioteca.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    void onOpenTypeUser() {
        app.openTypeUser();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }
}


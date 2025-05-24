package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.RequestBookController;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RequestBookViewController {

    RequestBookController requestBookController;
    App app;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label lblMessage;

    public void setApp(App app) {
        this.app = app;
        System.out.println(app.getLibroSolicitud());
        lblMessage.setText("¿Seguro que quiere solicitar el prestamo del libro '"+app.getLibroSolicitud().getTitulo()+"'?");
    }

    public void onSolicitar(){
        System.out.println(buildOption());
        requestBookController.solicitarPrestamo(app.getUser(), app.getLibroSolicitud(),buildOption());
        app.openHomePage();
    }

    private String buildOption(){

        return choiceBox.getValue();
    }

    @FXML
    void initialize() {
        requestBookController=new RequestBookController(app.biblioteca);
    }
}

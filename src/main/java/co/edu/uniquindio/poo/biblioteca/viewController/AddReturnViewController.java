package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookVirtualController;
import co.edu.uniquindio.poo.biblioteca.controller.AddReturnController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddReturnViewController {
    AddReturnController addReturnController;

    @FXML
    private TextArea txtObservaciones;

    App app;

    @FXML
    void onBack(){
        app.openHomePageBibliotecario();
    }

    @FXML
    void onAgregarDevolucion(){
        agrgarDevolucion();
    }

    private void agrgarDevolucion() {
        Usuario usuario=null;
        Bibliotecario bibliotecario=null;
        for (Usuario usuario1:addReturnController.getUsuarios()){
            if (usuario1.getNumeroIdentificacion().equals(app.getPrestamo().getUsuario().getNumeroIdentificacion())){
                usuario=usuario1;
            }
        }
        for (Usuario usuario1:addReturnController.getUsuarios()){
            if (usuario1.getNumeroIdentificacion().equals(app.getUser())){
                bibliotecario=(Bibliotecario) usuario1;
            }
        }
        assert usuario != null;
        assert bibliotecario != null;
        addReturnController.addReturn(bibliotecario,usuario,app.getPrestamo().getLibro(),txtObservaciones.getText());
        app.openReturns();
    }


    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addReturnController =new AddReturnController(app.biblioteca);
    }
}

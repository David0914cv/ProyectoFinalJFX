package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddTeacherController;
import co.edu.uniquindio.poo.biblioteca.controller.AddVisitantController;
import co.edu.uniquindio.poo.biblioteca.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca.model.Docente;
import co.edu.uniquindio.poo.biblioteca.model.Usuario;
import co.edu.uniquindio.poo.biblioteca.model.Visitante;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddVisitantViewController {
    AddVisitantController addVisitantController;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtContrasenia;


    App app;

    @FXML
    void onAgregarVisitante(){
        agregarVisitante();
    }

    private void agregarVisitante() {
        Bibliotecario bibliotecario= null;
        for (Usuario usuario:addVisitantController.getListUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                bibliotecario=(Bibliotecario) usuario;
            }
        }
        Visitante visitante =new Visitante(txtNombre.getText(),txtId.getText(),txtContrasenia.getText());
        assert bibliotecario != null;
        boolean response = addVisitantController.agregarDocente(visitante,bibliotecario);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addVisitantController=new AddVisitantController(app.biblioteca);
    }
}

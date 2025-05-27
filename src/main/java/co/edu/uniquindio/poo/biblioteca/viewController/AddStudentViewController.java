package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddStudentController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddStudentViewController {
    AddStudentController addStudentController;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtContrasenia;


    App app;

    @FXML
    void onAgregarEstudiante(){
        agregarEstudiante();
    }

    @FXML
    void onBack(){
        app.openHomePageBibliotecario();
    }

    private void agregarEstudiante() {
        Bibliotecario bibliotecario= null;
        for (Usuario usuario:addStudentController.getListUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                bibliotecario=(Bibliotecario) usuario;
            }
        }
        Estudiante estudiante =new Estudiante(txtNombre.getText(),txtId.getText(),txtContrasenia.getText());
        assert bibliotecario != null;
        boolean response = addStudentController.agregarEstudiante(estudiante,bibliotecario);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addStudentController=new AddStudentController(app.biblioteca);
    }
}

package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddStudentController;
import co.edu.uniquindio.poo.biblioteca.controller.AddTeacherController;
import co.edu.uniquindio.poo.biblioteca.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca.model.Docente;
import co.edu.uniquindio.poo.biblioteca.model.Estudiante;
import co.edu.uniquindio.poo.biblioteca.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddTeacherViewController {
    AddTeacherController addTeacherController;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtContrasenia;


    App app;

    @FXML
    void onAgregarDocente(){
        agregarDocente();
    }

    private void agregarDocente() {
        Bibliotecario bibliotecario= null;
        for (Usuario usuario:addTeacherController.getListUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                bibliotecario=(Bibliotecario) usuario;
            }
        }
        Docente docente =new Docente(txtNombre.getText(),txtId.getText(),txtContrasenia.getText());
        assert bibliotecario != null;
        boolean response = addTeacherController.agregarDocente(docente,bibliotecario);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addTeacherController=new AddTeacherController(app.biblioteca);
    }
}

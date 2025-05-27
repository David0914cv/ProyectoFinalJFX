package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookController;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookReferenceController;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.LibroFisico;
import co.edu.uniquindio.poo.biblioteca.model.LibroReferencia;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddBookReferenceViewController {
    AddBookReferenceController addBookReferenceController;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAnioPublicacion;

    App app;

    @FXML
    void onBack(){
        app.openHomePageBibliotecario();
    }

    @FXML
    void onAgregarLibro(){
        agregarLibro();
    }

    private void agregarLibro() {
        Libro libro =new LibroReferencia(txtCodigo.getText(),txtTitulo.getText(),txtAutor.getText(),txtGenero.getText(),txtAnioPublicacion.getText());
        boolean response = addBookReferenceController.agregarLibro(libro);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addBookReferenceController=new AddBookReferenceController(app.biblioteca);
    }
}

package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookController;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.LibroFisico;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddBookViewController {

    AddBookController addBookController;

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

    @FXML
    private TextField txtNumeroPaginas;

    @FXML
    private TextField txtEditorial;

    @FXML
    private TextField txtUbicacion;

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
        Libro libro =new LibroFisico(txtCodigo.getText(),txtTitulo.getText(),txtAutor.getText(),txtGenero.getText(),txtAnioPublicacion.getText(),txtNumeroPaginas.getText(),txtEditorial.getText(),txtUbicacion.getText());
        boolean response = addBookController.agregarLibro(libro);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addBookController=new AddBookController(app.biblioteca);
    }
}

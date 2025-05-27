package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookController;
import co.edu.uniquindio.poo.biblioteca.controller.AddBookVirtualController;
import co.edu.uniquindio.poo.biblioteca.model.FormatoLibro;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.LibroDigital;
import co.edu.uniquindio.poo.biblioteca.model.LibroFisico;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddBookVirtualViewController {
    AddBookVirtualController addBookVirtualController;

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
    private TextField txtEnlace;

    @FXML
    private ChoiceBox<String> choiceBox;

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

        FormatoLibro formato = null;

        if (buildOption().equals("PDF")) {
            formato = FormatoLibro.PDF;
        }else if (buildOption().equals("EPUB")) {
            formato = FormatoLibro.EPUB;
        } else if (buildOption().equals("MOBI")) {
            formato = FormatoLibro.MOBI;
        }

        Libro libro =new LibroDigital(txtCodigo.getText(),txtTitulo.getText(),txtAutor.getText(),txtGenero.getText(),txtAnioPublicacion.getText(),formato,txtEnlace.getText());
        boolean response = addBookVirtualController.agregarLibro(libro);
        if(response){
            app.openHomePageBibliotecario();
        }
    }

    private String buildOption(){
        return choiceBox.getValue();
    }

    public void setApp(App app) {
        this.app = app;
    }



    @FXML
    void initialize() {
        addBookVirtualController =new AddBookVirtualController(app.biblioteca);
    }
}

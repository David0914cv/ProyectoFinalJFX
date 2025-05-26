package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.HomePageController;
import co.edu.uniquindio.poo.biblioteca.controller.ReturnsController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ReturnsViewController {
    ReturnsController returnsController;

    @FXML
    private TableView<Prestamo> tablaPrestamos;

    @FXML
    private TableColumn<Prestamo,String> collibro;

    @FXML
    private TableColumn<Prestamo,String> colUsuario;

    private App app;

    @FXML
    private TextField txtIdUser;

    @FXML
    void onBack(){
       app.openHomePageBibliotecario();
    }

    @FXML
    void initialize(){

        returnsController = new ReturnsController(app.biblioteca);

        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        collibro.setCellValueFactory(new PropertyValueFactory<>("libro"));

    }

    public void setApp(App app) {
        this.app = app;
        cargarPrestamos();
        eventTabla();
        if (txtIdUser != null) {
            txtIdUser.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals("")){
                    cargarPrestamos();
                }else{
                    cargarPrestamosId(newValue);
                }


            });
        } else {
            System.out.println("txtIdUser aún no está inicializado");
        }
    }

    private void eventTabla(){
        tablaPrestamos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Prestamo prestamo = tablaPrestamos.getSelectionModel().getSelectedItem();
                if (prestamo != null) {
                    app.setPrestamo(prestamo);
                    app.openAddReturn();
                }
            }
        });
    }

    private void cargarPrestamos() {

        List<Prestamo> listPrestamos = new ArrayList<>();

        for (Prestamo prestamo : returnsController.getPrestamos()) {
                if (prestamo.getLibro().getEstado() == EstadoLibro.PRESTADO){
                    listPrestamos.add(prestamo);
                }
        }

        tablaPrestamos.setItems(FXCollections.observableArrayList(listPrestamos));

    }

    private void cargarPrestamosId(String valor){
        List<Prestamo> listPrestamos = new ArrayList<>();

        for (Prestamo prestamo : returnsController.getPrestamos()) {
            if (prestamo.getUsuario().getNumeroIdentificacion().equals(valor)) {
                listPrestamos.add(prestamo);
            }
        }

        tablaPrestamos.setItems(FXCollections.observableArrayList(listPrestamos));
    }

}

package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.HomePageController;
import co.edu.uniquindio.poo.biblioteca.model.Libro;
import co.edu.uniquindio.poo.biblioteca.model.LibroDigital;
import co.edu.uniquindio.poo.biblioteca.model.LibroFisico;
import co.edu.uniquindio.poo.biblioteca.model.LibroReferencia;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HomePageViewController {
    HomePageController homePageController;

    @FXML
    private TableView<LibroFisico> tablaLibros;

    @FXML
    private TableView<LibroDigital> tablaLibrosDigitales;

    @FXML
    private TableView<LibroReferencia> tablaLibrosReferencia;

    @FXML
    private TableColumn<LibroFisico,String> colTitulo;

    @FXML
    private TableColumn<LibroFisico,String> colAutor;

    @FXML
    private TableColumn<LibroFisico,String> colGenero;

    @FXML
    private TableColumn<LibroDigital,String> colTituloD;

    @FXML
    private TableColumn<LibroDigital,String> colAutorD;

    @FXML
    private TableColumn<LibroDigital,String> colGeneroD;

    @FXML
    private TableColumn<LibroDigital,String> colEnlace;

    @FXML
    private TableColumn<LibroReferencia,String> colTituloR;

    @FXML
    private TableColumn<LibroReferencia,String> colAutorR;

    @FXML
    private TableColumn<LibroReferencia,String> colGeneroR;

    private App app;

    @FXML
    void onLogout(){
        logout();
    }

    @FXML
    void initialize(){

        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));

        colTituloD.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutorD.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEnlace.setCellValueFactory(new PropertyValueFactory<>("enlace"));
        colGeneroD.setCellValueFactory(new PropertyValueFactory<>("genero"));

        colTituloR.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutorR.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colGeneroR.setCellValueFactory(new PropertyValueFactory<>("genero"));

    }

    public void setApp(App app) {
        this.app = app;
        System.out.println(app.getRol()+"***"+app.getUser());
        System.out.println(app.biblioteca.getListSolicitudPrestamos());
        cargarLibros();
        tablaLibros.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                LibroFisico libroSeleccionado = tablaLibros.getSelectionModel().getSelectedItem();
                if (libroSeleccionado != null) {
                    System.out.println("Libro seleccionado: " + libroSeleccionado.getTitulo());
                    app.openRequestBook(libroSeleccionado);
                }
            }
        });
        tablaLibrosDigitales.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                LibroDigital libroSeleccionado = tablaLibrosDigitales.getSelectionModel().getSelectedItem();
                if (libroSeleccionado != null) {
                    System.out.println("Libro seleccionado: " + libroSeleccionado.getEnlace());
                    Stage stage = (Stage) tablaLibrosDigitales.getScene().getWindow(); // Obtenemos el Stage desde la tabla

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.initOwner(stage);
                    alert.initModality(Modality.WINDOW_MODAL);
                    alert.setTitle("Abrir libro digital");
                    alert.setHeaderText(null);
                    alert.setContentText("¿Deseas abrir el enlace del libro?\n" + libroSeleccionado.getEnlace());

                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            // Aquí podrías abrir el enlace en el navegador si quieres
                            System.out.println("Abriendo: " + libroSeleccionado.getEnlace());
                            // abrirEnlace(libroSeleccionado.getEnlace());
                        }
                    });
                }
            }
        });
    }

    private void logout(){
        app.setUser(null);
        app.setRol("");
        app.openTypeUser();
    }

    private void cargarLibros() {
        homePageController = new HomePageController(app.biblioteca);
        List<LibroFisico> listLibros = new ArrayList<>();
        List<LibroDigital> listLibrosDigital = new ArrayList<>();
        List<LibroReferencia> listLibrosReferencia = new ArrayList<>();

        for (Libro libro : homePageController.getLibros()) {
            if (libro instanceof LibroFisico) {
                listLibros.add((LibroFisico) libro);
            }
        }
        for (Libro libro : homePageController.getLibros()) {
            if (libro instanceof LibroDigital) {
                listLibrosDigital.add((LibroDigital) libro);
            }
        }
        for (Libro libro : homePageController.getLibros()) {
            if (libro instanceof LibroReferencia) {
                listLibrosReferencia.add((LibroReferencia) libro);
            }
        }
        tablaLibrosDigitales.setItems(FXCollections.observableArrayList(listLibrosDigital));
        tablaLibros.setItems(FXCollections.observableArrayList(listLibros));
        tablaLibrosReferencia.setItems(FXCollections.observableArrayList(listLibrosReferencia));
    }

}

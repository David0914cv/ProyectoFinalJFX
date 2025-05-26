package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.RequestsUserController;
import co.edu.uniquindio.poo.biblioteca.model.EstadoSolicitud;
import co.edu.uniquindio.poo.biblioteca.model.LibroFisico;
import co.edu.uniquindio.poo.biblioteca.model.LibroReferencia;
import co.edu.uniquindio.poo.biblioteca.model.SolicitudPrestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class RequestsUserViewController {

    RequestsUserController requestsUserController;

    @FXML
    private TableView<SolicitudPrestamo> tableRequestsProcessing;

    @FXML
    private TableColumn<SolicitudPrestamo,String> colLibro;

    @FXML
    private TableColumn<SolicitudPrestamo,String> colFecha;

    @FXML
    private TableColumn<SolicitudPrestamo,String> colTiempo;

    App app;

    @FXML
    void onBack() {
        app.openHomePage();
    }

    public void setApp(App app) {
        this.app = app;
        loadTableRequestsProcessing();
    }

    @FXML
    void initialize() {
        colLibro.setCellValueFactory(new PropertyValueFactory<>("libroSolicitado"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaSolicitud"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoPrestamo"));
    }

    private void loadTableRequestsProcessing() {
        requestsUserController = new RequestsUserController(app.biblioteca);
        List<SolicitudPrestamo> listRequestsProcessing = new ArrayList<>();

        for (SolicitudPrestamo solicitudPrestamo:requestsUserController.getSolicitudes()){
            if (solicitudPrestamo.getEstado() == EstadoSolicitud.PENDIENTE && solicitudPrestamo.getSolicitante().getNumeroIdentificacion().equals(app.getUser())){
                listRequestsProcessing.add(solicitudPrestamo);
            }
        }

        tableRequestsProcessing.setItems(FXCollections.observableList(listRequestsProcessing));
    }
}

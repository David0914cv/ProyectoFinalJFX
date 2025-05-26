package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.LendingUserController;
import co.edu.uniquindio.poo.biblioteca.controller.RequestsUserController;
import co.edu.uniquindio.poo.biblioteca.model.EstadoSolicitud;
import co.edu.uniquindio.poo.biblioteca.model.Prestamo;
import co.edu.uniquindio.poo.biblioteca.model.SolicitudPrestamo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class LendingUserViewController {
    LendingUserController lendingUserController;

    @FXML
    private TableView<Prestamo> tableViewLendings;

    @FXML
    private TableColumn<Prestamo,String> colLibro;

    @FXML
    private TableColumn<Prestamo,String> colFechaInicio;

    @FXML
    private TableColumn<Prestamo,String> colFechaFin;

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
        colLibro.setCellValueFactory(new PropertyValueFactory<>("libro"));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFechaFin.setCellValueFactory(new PropertyValueFactory<>("FechaFin"));
    }

    private void loadTableRequestsProcessing() {
        lendingUserController = new LendingUserController(app.biblioteca);
        List<Prestamo> listLendingsUser = new ArrayList<>();

        for (Prestamo prestamo:lendingUserController.getPrestamos()){
            if (prestamo.getUsuario().getNumeroIdentificacion().equals(app.getUser())){
                listLendingsUser.add(prestamo);
            }
        }

        tableViewLendings.setItems(FXCollections.observableList(listLendingsUser));
    }
}

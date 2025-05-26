package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.AddVisitantController;
import co.edu.uniquindio.poo.biblioteca.controller.HomePageAdminController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdminViewController {
    HomePageAdminController homePageAdminController;

    @FXML
    private TableView<Usuario> tablaUsuarios;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private PasswordField txtCredencial;

    App app;

    @FXML
    void onGenerarReporte(){
        generarReporte();
    }

    @FXML
    void onAgregar(){
        agregarUsuario();
    }

    @FXML
    void onActualizar(){
        actualizarUsuario();
    }

    public void setApp(App app) {
        this.app = app;
        cargarUsuarios();
        eventoUsuarios();
    }

    @FXML
    void initialize() {
        homePageAdminController=new HomePageAdminController(app.biblioteca);
        colId.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }

    private void agregarUsuario(){
        Bibliotecario bibliotecario=new Bibliotecario(txtNombre.getText(),txtId.getText(),txtContrasenia.getText(),txtCredencial.getText());
        Administrador administrador=null;
        for (Usuario usuario:homePageAdminController.getListaUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                administrador=(Administrador) usuario;
            }
        }
        assert administrador != null;
        boolean response=homePageAdminController.agregarUsuario(administrador,bibliotecario);

        if (response){
            txtNombre.clear();
            txtId.clear();
            txtContrasenia.clear();
            txtCredencial.clear();
            cargarUsuarios();
        }else{
            Stage stage = (Stage) tablaUsuarios.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(stage);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("Reporte");
            alert.setHeaderText(null);
            alert.setContentText("Error al agregar usuario");
            alert.showAndWait();
        }
    }

    private void cargarUsuarios(){
        List<Usuario> listUsuarios=new ArrayList<>();
        for (Usuario usuario:homePageAdminController.getListaUsuarios()){
            if (!usuario.getNumeroIdentificacion().equals(app.getUser()) && usuario instanceof Bibliotecario){
                listUsuarios.add(usuario);
            }
        }
        System.out.println(listUsuarios);
        tablaUsuarios.setItems(FXCollections.observableList(listUsuarios));
    }

    private void generarReporte(){
        Administrador administrador = null;
        for (Usuario usuario:homePageAdminController.getListaUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                administrador=(Administrador) usuario;
            }
        }

        Stage stage = (Stage) tablaUsuarios.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.initModality(Modality.WINDOW_MODAL);
        alert.setTitle("Reporte");
        alert.setHeaderText(null);
        alert.setContentText(homePageAdminController.generarReporteAdministrador(administrador));
        alert.showAndWait();
    }

    private void eventoUsuarios() {
        tablaUsuarios.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Usuario usuario = tablaUsuarios.getSelectionModel().getSelectedItem();
                if (usuario != null) {
                    Bibliotecario bibliotecario=(Bibliotecario) usuario;
                    txtNombre.setText(usuario.getNombre());
                    txtId.setText(usuario.getNumeroIdentificacion());
                    txtContrasenia.setText(usuario.getContrasenia());
                    txtCredencial.setText(bibliotecario.getCredencialBibliotecario());
                }
            }
        });
    }

    private void actualizarUsuario() {
        Bibliotecario bibliotecario=new Bibliotecario(txtNombre.getText(),txtId.getText(),txtContrasenia.getText(),txtCredencial.getText());
        Administrador administrador=null;
        for (Usuario usuario:homePageAdminController.getListaUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                administrador=(Administrador) usuario;
            }
        }
        assert administrador != null;
        boolean response=homePageAdminController.actualizarUsuario(administrador,bibliotecario,bibliotecario.getNumeroIdentificacion());

        if (response){
            txtNombre.clear();
            txtId.clear();
            txtContrasenia.clear();
            txtCredencial.clear();
            cargarUsuarios();
        }else{
            Stage stage = (Stage) tablaUsuarios.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(stage);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al actualizar usuario");
            alert.showAndWait();
        }
    }

}

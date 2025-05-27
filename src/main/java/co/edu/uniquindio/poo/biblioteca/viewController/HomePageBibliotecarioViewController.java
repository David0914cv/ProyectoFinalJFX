package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.HomePageBibliotecarioController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HomePageBibliotecarioViewController {
    HomePageBibliotecarioController homePageBibliotecarioController;

    @FXML
    private TableView<SolicitudPrestamo> tablaSolicitudes;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colLibro;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colUsuario;

    @FXML
    private TableColumn<SolicitudPrestamo, String> colTiempo;

    @FXML
    void onLogout(){
        logout();
    }

    @FXML
    void onRegistroLibros(){
       registrarLibro();
    }

    @FXML
    void onRegistrarUsuario(){
        registrarUsuario();
    }

    @FXML
    void onOpenReturns(){
        app.openReturns();
    }

    @FXML
    void onOpenReport(){
        cargarReporte();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
        System.out.println(homePageBibliotecarioController.getListaUsuarios());
        cargarSolicitudes();
        tablaSolicitudes.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                SolicitudPrestamo solicitudPrestamo = tablaSolicitudes.getSelectionModel().getSelectedItem();
                if (solicitudPrestamo != null) {
                    Stage stage = (Stage) tablaSolicitudes.getScene().getWindow();
                    ButtonType botonAceptar = new ButtonType("Aceptar préstamo");
                    ButtonType botonCancelar = new ButtonType("Cancelar préstamo", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.initOwner(stage);
                    alert.initModality(Modality.WINDOW_MODAL);
                    alert.setTitle("Abrir libro digital");
                    alert.setHeaderText(null);
                    alert.setContentText("¿Desea aceptar el prestamo del usuario "+solicitudPrestamo.getSolicitante().getNombre()+"?");
                    alert.getButtonTypes().setAll(botonAceptar, botonCancelar);

                    alert.showAndWait().ifPresent(response -> {
                        if (response == botonAceptar) {
                            System.out.println("se acepto");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate fechaInicio = LocalDate.now();
                            LocalDate fechaFin = null;
                            Bibliotecario bibliotecario = null;
                            if (solicitudPrestamo.getTiempoPrestamo() == TiempoPrestamo.MISMO_DIA){
                                fechaFin=LocalDate.now();
                            } else if (solicitudPrestamo.getTiempoPrestamo() == TiempoPrestamo.CINCO_DIAS) {
                                fechaFin= LocalDate.now().plusDays(5);
                            } else if (solicitudPrestamo.getTiempoPrestamo() == TiempoPrestamo.DIEZ_DIAS) {
                                fechaFin= LocalDate.now().plusDays(10);
                            }
                            for (Usuario usuario:homePageBibliotecarioController.getListaUsuarios()){
                                if (usuario.getNumeroIdentificacion().equals(app.getUser()) && usuario instanceof Bibliotecario){
                                    bibliotecario = (Bibliotecario) usuario;
                                }
                            }
                            String fechaInicioTexto=fechaInicio.format(formatter);
                            assert fechaFin != null;
                            String fechaFinTexto=fechaFin.format(formatter);
                            homePageBibliotecarioController.agregarUsuarioMora(solicitudPrestamo.getSolicitante());
                            homePageBibliotecarioController.agregarlibroPrestado(solicitudPrestamo.getLibroSolicitado());

                            boolean resp=homePageBibliotecarioController.agregarPrestamoBiblioteca(fechaInicioTexto,fechaFinTexto,solicitudPrestamo.getSolicitante(),bibliotecario,solicitudPrestamo.getLibroSolicitado());
                            if (resp){
                                System.out.println("se agrego el prestamo");
                                if (solicitudPrestamo.getSolicitante() instanceof Estudiante estudiante){
                                    assert bibliotecario != null;
                                    estudiante.setCantidadlibrosPrestados(estudiante.getCantidadlibrosPrestados()+1);
                                    estudiante.setEstadoUsuario(EstadoUsuario.EN_MORA);
                                    homePageBibliotecarioController.actualizarEstudiante(estudiante,bibliotecario);
                                    Libro libro=solicitudPrestamo.getLibroSolicitado();
                                    libro.setEstado(EstadoLibro.PRESTADO);
                                    libro.setCantidadVecesPrestado(libro.getCantidadVecesPrestado()+1);
                                    solicitudPrestamo.setEstado(EstadoSolicitud.APROBADA);
                                    homePageBibliotecarioController.actuaizarLibro(bibliotecario,libro);
                                    homePageBibliotecarioController.actuaizarSolicitud(solicitudPrestamo);
                                    cargarSolicitudes();
                                }
                                if (solicitudPrestamo.getSolicitante() instanceof Docente docente){
                                    assert bibliotecario != null;
                                    docente.setEstadoUsuario(EstadoUsuario.EN_MORA);
                                    homePageBibliotecarioController.actualizarDocente(docente,bibliotecario);
                                    Libro libro=solicitudPrestamo.getLibroSolicitado();
                                    libro.setEstado(EstadoLibro.PRESTADO);
                                    libro.setCantidadVecesPrestado(libro.getCantidadVecesPrestado()+1);
                                    solicitudPrestamo.setEstado(EstadoSolicitud.APROBADA);
                                    homePageBibliotecarioController.actuaizarLibro(bibliotecario,libro);
                                    homePageBibliotecarioController.actuaizarSolicitud(solicitudPrestamo);
                                    cargarSolicitudes();
                                }
                                System.out.println(homePageBibliotecarioController.getListaUsuarios());
                            }
                        }else {
                            System.out.println("no se acepto");
                        }
                    });
                }
            }
        });
    }

    @FXML
    void initialize() {
        colLibro.setCellValueFactory(new PropertyValueFactory<>("libroSolicitado"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempoPrestamo"));
        homePageBibliotecarioController=new HomePageBibliotecarioController(app.biblioteca);
    }

    private void cargarSolicitudes(){

        List<SolicitudPrestamo> listSolicitudesPrestamo=new ArrayList<>();
        for (SolicitudPrestamo solicitudPrestamo:homePageBibliotecarioController.getSolicitudesPrestamo()){
            if (solicitudPrestamo.getEstado() == EstadoSolicitud.PENDIENTE){
                listSolicitudesPrestamo.add(solicitudPrestamo);
            }
        }
        tablaSolicitudes.setItems(FXCollections.observableList(listSolicitudesPrestamo));
    }

    private void logout(){
        app.setUser(null);
        app.setRol("");
        app.openTypeUser();
    }

    private void registrarLibro(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de libros");
        alert.setHeaderText(null);
        alert.setContentText("¿Qué tipo libro desea crear?");

        ButtonType fisico = new ButtonType("Fisico");
        ButtonType virtual = new ButtonType("Virtual");
        ButtonType referencia = new ButtonType("De referencia");


        alert.getButtonTypes().setAll(fisico, virtual, referencia);


        alert.showAndWait().ifPresent(response -> {
            if (response == fisico) {
                app.openAddBook();
            } else if (response == virtual) {
                app.openAddBookVirtual();
            } else if (response == referencia) {
                app.openAddBookReference();
            }
        });

    }

    private void registrarUsuario(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de Usuarios");
        alert.setHeaderText(null);
        alert.setContentText("¿Qué tipo de Usuario desea crear?");

        ButtonType estudiante = new ButtonType("Estudiante");
        ButtonType docente = new ButtonType("Docente");
        ButtonType visitante = new ButtonType("Visitante");


        alert.getButtonTypes().setAll(estudiante, docente, visitante);


        alert.showAndWait().ifPresent(response -> {
            if (response == estudiante) {
                app.openAddStudent();
            } else if (response == docente) {
                app.openAddTeacher();
            } else if (response == visitante) {
                app.openAddVisitant();
            }
        });

    }

    private void cargarReporte() {
        Bibliotecario bibliotecario = null;
        for (Usuario usuario:homePageBibliotecarioController.getListaUsuarios()){
            if (usuario.getNumeroIdentificacion().equals(app.getUser())){
                bibliotecario=(Bibliotecario) usuario;
            }
        }
        Stage stage = (Stage) tablaSolicitudes.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.initModality(Modality.WINDOW_MODAL);
        alert.setTitle("Reporte");
        alert.setHeaderText(null);
        assert bibliotecario != null;
        alert.setContentText(homePageBibliotecarioController.generarReporteBibliotecario(bibliotecario));
        alert.showAndWait();
    }

}

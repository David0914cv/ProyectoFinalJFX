package co.edu.uniquindio.poo.biblioteca;

import co.edu.uniquindio.poo.biblioteca.controller.HomePageController;
import co.edu.uniquindio.poo.biblioteca.controller.LoginCredentialController;
import co.edu.uniquindio.poo.biblioteca.controller.RequestBookController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import co.edu.uniquindio.poo.biblioteca.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("UQ","123");
    private String rol="";
    private String user="";
    private LibroFisico libroSolicitud;

    public void setRol(String rol) {
        this.rol=rol;
    }
    public String getRol() {
        return rol;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Biblioteca UQ");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openTypeUser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("typeUser.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            TypeUserViewController typeUserViewController = loader.getController();
            typeUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("login.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginViewController loginViewController = loader.getController();
            loginViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openLoginCredential() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("loginCredential.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginCredentialViewController loginCredentialViewController = loader.getController();
            loginCredentialViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openHomePage() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("homePage.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HomePageViewController homePageController = loader.getController();
            homePageController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openRequestBook(LibroFisico libroFisico) {
        try{
            this.libroSolicitud=libroFisico;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("requestBook.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RequestBookViewController requestBookViewController = loader.getController();
            requestBookViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //servicios
    public void inicializarData(){
        Usuario admin1 = new Administrador("Raul yulbrainer","24158799","123","1234");
        biblioteca.agregarUsuario(admin1);
        Usuario estudiante1 = new Estudiante("David Cuellar","1091884350","456", EstadoUsuario.PAZ_Y_SALVO);
        biblioteca.agregarUsuario(estudiante1);
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943",EstadoLibro.DISPONIBLE,"300","qwerty","seccion2");
        Libro libro2 = new LibroFisico("2", "Don Quijote de La Mancha"," Miguel de Cervantes Saavedra","Aventura","1605",EstadoLibro.DISPONIBLE,"600","poiu","seccion1");
        Libro libro3 = new LibroDigital("3","La odisea","Homero","Epopeya","6.a.c",EstadoLibro.DISPONIBLE,FormatoLibro.PDF,"https://www.odisea.pdf");
        Libro libro4 = new LibroFisico("4","El señor de los anillos","J. R. R. Tolkien","Novela","1954",EstadoLibro.DISPONIBLE,"800","George Allen & Unwin HarperCollins","seccion4");
        Libro libro5 = new LibroReferencia("5","100 años de soledad","Gabriel García Márquez","Novela","1967",EstadoLibro.DISPONIBLE);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LibroFisico getLibroSolicitud() {
        return libroSolicitud;
    }
}

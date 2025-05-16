package co.edu.uniquindio.poo.biblioteca;

import co.edu.uniquindio.poo.biblioteca.controller.HomePageController;
import co.edu.uniquindio.poo.biblioteca.model.*;
import co.edu.uniquindio.poo.biblioteca.viewController.HomePageViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.biblioteca.viewController.LoginViewController;
import co.edu.uniquindio.poo.biblioteca.viewController.PrimaryController;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("UQ","123");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes");
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

    //servicios
    public void inicializarData(){
        Usuario admin1 = new Administrador("Raul yulbrainer","24158799","123","1234");
        biblioteca.agregarUsuario(admin1);
    }
}

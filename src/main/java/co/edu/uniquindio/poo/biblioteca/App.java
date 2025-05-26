package co.edu.uniquindio.poo.biblioteca;

import co.edu.uniquindio.poo.biblioteca.controller.AddReturnController;
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
    private Prestamo prestamo=null;
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

    public void openRequestsUser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("requestsUser.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RequestsUserViewController requestsUserViewController = loader.getController();
            requestsUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openLendingsUser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("lendingUser.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LendingUserViewController lendingUserViewController = loader.getController();
            lendingUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openHomePageBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("homePageBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HomePageBibliotecarioViewController homePageBibliotecarioViewController = loader.getController();
            homePageBibliotecarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddBook() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addBook.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddBookViewController addBookViewController = loader.getController();
            addBookViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddBookVirtual() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addBookVirtual.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddBookVirtualViewController addBookVirtualViewController = loader.getController();
            addBookVirtualViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddBookReference() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addBookReference.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddBookReferenceViewController addBookReferenceViewController = loader.getController();
            addBookReferenceViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddStudent() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addStudent.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddStudentViewController addStudentViewController = loader.getController();
            addStudentViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddTeacher() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addTeacher.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddTeacherViewController addTeacherViewController = loader.getController();
            addTeacherViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddVisitant() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addVisitant.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddVisitantViewController addVisitantViewController = loader.getController();
            addVisitantViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openReturns() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("returns.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReturnsViewController returnsViewController = loader.getController();
            returnsViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAddReturn() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("addReturn.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AddReturnViewController addReturnViewController = loader.getController();
            addReturnViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openHomePageAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("homePageAdmin.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HomePageAdminViewController homePageAdminViewController = loader.getController();
            homePageAdminViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //servicios
    public void inicializarData(){
        Usuario admin1 = new Administrador("Raul yulbrainer","24158799","123","1234");
        biblioteca.agregarUsuario(admin1);
        Estudiante estudiante1 = new Estudiante("David Cuellar","1091884350","456");
        biblioteca.agregarUsuario(estudiante1);
        Bibliotecario bibliotecario1 = new Bibliotecario("Juan Alberto","198770154","789","1112");
        biblioteca.agregarUsuario(bibliotecario1);
        Usuario docente1 = new Docente("Juan Camilo","25286446","147");
        biblioteca.agregarUsuario(docente1);
        Usuario visitante1 = new Visitante("Diego Jose","15697823","123");
        biblioteca.agregarUsuario(visitante1);
        Estudiante estudiante2= new Estudiante("Esteban","7894561","123");

        bibliotecario1.agregarEstudiante(biblioteca,estudiante2);
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Libro libro2 = new LibroFisico("2", "Don Quijote de La Mancha"," Miguel de Cervantes Saavedra","Aventura","1605","600","poiu","seccion1");
        Libro libro3 = new LibroDigital("3","La odisea","Homero","Epopeya","6.a.c",FormatoLibro.PDF,"https://www.odisea.pdf");
        Libro libro4 = new LibroFisico("4","El señor de los anillos","J. R. R. Tolkien","Novela","1954","800","George Allen & Unwin HarperCollins","seccion4");
        Libro libro5 = new LibroReferencia("5","100 años de soledad","Gabriel García Márquez","Novela","1967");

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

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LibroFisico getLibroSolicitud() {
        return libroSolicitud;
    }
}

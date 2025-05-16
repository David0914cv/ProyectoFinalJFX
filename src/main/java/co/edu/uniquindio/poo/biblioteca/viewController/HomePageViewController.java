package co.edu.uniquindio.poo.biblioteca.viewController;

import co.edu.uniquindio.poo.biblioteca.App;
import co.edu.uniquindio.poo.biblioteca.controller.HomePageController;
import javafx.fxml.FXML;

public class HomePageViewController {
    HomePageController homePageController;

    private App app;

    @FXML
    void initialize(){
        this.app=app;
        homePageController=new HomePageController(app.biblioteca);
    }

    public void setApp(App app) {
        this.app = app;
    }
}

package org.example.fuelconsumption;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fuel-calculator-view.fxml"), bundle);
        Scene scene = new Scene(fxmlLoader.load(), 320, 320);
        stage.setTitle("Amir Dirin!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
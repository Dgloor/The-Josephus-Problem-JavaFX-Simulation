package app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Iniciando Aplicación...");
        scene = new Scene(loadFXML("base"));
        stage.setTitle("Josephus Problem Simulation");
        stage.centerOnScreen();
        stage.setScene(scene);
//        stage.
        stage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Override
    public void stop() {
        System.out.println("Programa Finalizado.");
    }

    public static void main(String[] args) {
        launch();
    }

}

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
        scene = new Scene(loadFXML("baseScreen"));
        stage.setTitle("Josephus Problem Simulation");
//        stage.setOpacity(0.8);
        stage.centerOnScreen();
        stage.setScene(scene);
//        stage.setIconified(false);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
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

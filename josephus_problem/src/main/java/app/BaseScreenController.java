package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class BaseScreenController implements Initializable {

    @FXML
    BorderPane baseScreen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Pantalla base plantada.");
    }
}

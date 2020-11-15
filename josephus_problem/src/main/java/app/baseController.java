package app;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class baseController implements Initializable {

    @FXML
    BorderPane baseScreen;
    @FXML
    Circle btnClose;
    @FXML
    Circle btnMinimize;

    AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
    AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void handlePressed(MouseEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        xOffset.set(stage.getX() - e.getScreenX());
        yOffset.set(stage.getY() - e.getScreenY());
    }

    public void handleDragged(MouseEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setX(e.getScreenX() + xOffset.get());
        stage.setY(e.getScreenY() + yOffset.get());
    }

    @FXML
    public void handleVentanaClicks(MouseEvent event) {
        Stage stage = ((Stage) ((Circle) event.getSource()).getScene().getWindow());

        if (event.getSource().equals(btnMinimize)) {
            stage.setIconified(true);

        } else if (event.getSource().equals(btnClose)) {
            stage.setIconified(true);
            System.out.println("Programa Finalizado.");
            System.exit(0);
        }
    }

}

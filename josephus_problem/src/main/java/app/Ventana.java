package app;

import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author danny
 */
public class Ventana {

    Stage stage;
    AtomicReference<Double> xOffset;
    AtomicReference<Double> yOffset;

    public Ventana() {
        xOffset = new AtomicReference<>((double) 0);
        yOffset = new AtomicReference<>((double) 0);
    }

    public void setPosicion(MouseEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        xOffset.set(stage.getX() - e.getScreenX());
        yOffset.set(stage.getY() - e.getScreenY());
    }

    public void move(MouseEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setX(e.getScreenX() + xOffset.get());
        stage.setY(e.getScreenY() + yOffset.get());
    }

    public void minimize() {
        stage.setIconified(true);
    }

    public void close() {
        stage.setIconified(true);
        System.out.println("Programa Finalizado.");
        System.exit(0);
    }

}

package app;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.shape.Circle;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion {

    @FXML
    AnchorPane circleSpace;
    private int radio = 120;

    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 20;
    private SimulationState state;

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        this.state = SimulationState.STOPPED;
        //img = new ImageView(new Image("src/main/resources/icons/soldado.png"));

        //circleSpace.getChildren().add(img);
        for (int i = 0; i < defaultSize; i++) {
            String path = new File("src/main/resources/image/soldado.png").getAbsolutePath();
            ImageView img = new ImageView(new Image(path));
            Circle cr = new Circle(20);
            double angle = (((double) i) / defaultSize) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 320;
            img.setLayoutX(xpos);
            img.setLayoutY(ypos);
            img.setFitHeight(50);
            img.setFitWidth(50);
            circleSpace.getChildren().add(img);
        }
    }

    public void addSoldier() {
        deathCircle.addLast(new Soldier());
    }

    public void removeSoldier() {
        deathCircle.removeLast();
    }

    public void startSimulation() {
        this.state = SimulationState.RUNNING;
    }

    public void pauseSimulation() {
        this.state = SimulationState.PAUSED;
    }

    public void stopSimulation() {
        this.state = SimulationState.STOPPED;
    }

    public void updateSoldiersAmount(Integer n) {
        int diff = n - deathCircle.size();
        for (int i = 0; i < Math.abs(diff); i++) {
            if (diff > 0) {
                addSoldier();
            } else {
                removeSoldier();
            }
        }
    }
}

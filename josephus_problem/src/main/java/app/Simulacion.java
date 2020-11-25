package app;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
        Image img = new Image(App.class.getResourceAsStream(
                "/images/soldado.png"
        ), 50, 50, true, true);

        for (int i = 0; i < defaultSize; i++) {
            double angle = (((double) i) / defaultSize) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 320;
            ImageView soldierImg = new ImageView(img);
            soldierImg.setLayoutX(xpos);
            soldierImg.setLayoutY(ypos);
            circleSpace.getChildren().add(soldierImg);
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

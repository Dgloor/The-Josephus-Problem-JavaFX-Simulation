package app;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion {

    @FXML
    AnchorPane circleSpace;
    private int radio = 200;

    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 20;
    private SimulationState state;
    private int contadorSoldierhead = 1;

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        this.state = SimulationState.STOPPED;
        Image img = new Image(App.class.getResourceAsStream(
                "/images/soldado.png"
        ), 50, 50, true, true);

        for (int i = 0; i < defaultSize; i++) {
            deathCircle.addLast(new Soldier());
            double angle = (((double) i) / defaultSize) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 240;
            circleSpace.getChildren().add(MakeBox(img, xpos, ypos));
            contadorSoldierhead++;
        }
    }
    public VBox MakeBox(Image img, double xpos,double ypos) {
        ImageView soldierImg = new ImageView(img);
        Label lblHead = new Label("" + contadorSoldierhead);
        VBox vbSoldier = new VBox();
        vbSoldier.setLayoutX(xpos);
        vbSoldier.setLayoutY(ypos);
        vbSoldier.getChildren().addAll(lblHead, soldierImg);
        return vbSoldier;
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

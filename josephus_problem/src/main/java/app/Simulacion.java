package app;

import java.io.File;
import javafx.application.Platform;
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
    private final int radio = 230;
    Image img;
    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 20;
    public SimulationState state;

    public Simulacion(AnchorPane circleSpace) {
        this.circleSpace = circleSpace;
        deathCircle = new CircularDoublyLinkedList();
        state = SimulationState.STOPPED;
        img = new Image(App.class.getResourceAsStream("/images/soldado.png"), 50, 50, true, true);
        for (int i = 0; i < defaultSize; i++) {
            addSoldier();
        }
    }

    public VBox makeBox(Image img, double xpos, double ypos) {
        ImageView soldierImg = new ImageView(img);
        Label lblHead = new Label("" + deathCircle.size());
        lblHead.setStyle("-fx-text-fill: white;");
        VBox vbSoldier = new VBox();
        vbSoldier.setLayoutX(xpos);
        vbSoldier.setLayoutY(ypos);
        vbSoldier.getChildren().addAll(lblHead, soldierImg);
        return vbSoldier;
    }

    public void updateCircle() {
        for (int i = 0; i < deathCircle.size(); i++) {
            double angle = (((double) i) / deathCircle.size()) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 240;
            circleSpace.getChildren().get(i).setLayoutX(xpos);
            circleSpace.getChildren().get(i).setLayoutY(ypos);
        }
    }

    public void addSoldier() {
        deathCircle.addLast(new Soldier());
        circleSpace.getChildren().add(makeBox(img, 300, 240));
        updateCircle();
    }

    public void removeSoldier() {
        deathCircle.removeLast();
        circleSpace.getChildren().remove(deathCircle.size());
        updateCircle();
    }

    public void startSimulation() {
        this.state = SimulationState.RUNNING;
        Thread matanza = new Thread(new Matanza(1, true, deathCircle));
        matanza.start();
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

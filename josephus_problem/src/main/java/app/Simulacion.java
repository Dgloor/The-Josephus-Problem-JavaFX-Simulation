package app;

import javafx.fxml.FXML;
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
    private ImageView img;

    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 20;
    private SimulationState state;

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        this.state = SimulationState.STOPPED;
        //img = new ImageView("/resources/icons/soldado.png");
        //circleSpace.getChildren().add(img);
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
        for (int i = 0; i < Math.abs(diff); i++){
            if (diff > 0){
                addSoldier();
            }
            else {
                removeSoldier();
            }
        }
    }
}

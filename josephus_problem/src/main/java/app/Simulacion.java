package app;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion{
    @FXML
    AnchorPane circleSpace;
    
    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 20;
    private SimulationState state;
   

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        this.state = SimulationState.STOPPED;
    }
    
    
    public void addSoldier(){
        // creo nodo para interfaz grafica
        deathCircle.addLast(new Soldier());
    }
    
    public void startSimulation(){
        this.state = SimulationState.RUNNING;
    }
    
    public void pauseSimulation(){
        this.state = SimulationState.PAUSED;
    }
    
    public void stopSimulation() {
        this.state = SimulationState.STOPPED;
    }
    
}

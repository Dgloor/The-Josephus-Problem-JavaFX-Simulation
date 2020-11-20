package app;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion{
    @FXML
    AnchorPane circleSpace;
    
    private CircularDoublyLinkedList<Soldier> deathCircle;
    private final int defaultSize = 20;
    private SimulationState state;
   

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        
        this.state = SimulationState.STOPPED;
        
        for (int i = 0; i < defaultSize; i++) {
            deathCircle.addLast(new Soldier());
            Circle c = new Circle(20);
            c.setLayoutX(i*20);
            c.setLayoutY(i*30);
            c.setFill(Color.BLUE);
            circleSpace.getChildren().add(c);
        }
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

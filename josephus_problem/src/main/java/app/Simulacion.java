package app;

import Observer.Observer;
import java.io.File;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion implements Observer{
    @FXML
    AnchorPane circleSpace;
    CircularDoublyLinkedList<Soldier> deathCircle;
    private final int defaultSize = 20;

    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
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
    
    
    
    @Override
    public void update(String msg) {
        System.out.println("Desde simulacion" + msg);
    }
}

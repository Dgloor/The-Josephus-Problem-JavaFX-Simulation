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
    private int radio = 200;
    Image img = new Image(App.class.getResourceAsStream("/images/soldado.png"), 50, 50, true, true);
    private final CircularDoublyLinkedList<Soldier> deathCircle;
    public final int defaultSize = 30;
    private SimulationState state;
    
    
    public Simulacion(AnchorPane circleSpace) {
        deathCircle = new CircularDoublyLinkedList();
        this.circleSpace = circleSpace;
        this.state = SimulationState.STOPPED;
        for (int i = 0; i < defaultSize; i++) {
            addSoldier();
        }
        SetLayout();
    }

    public VBox MakeBox(Image img, double xpos, double ypos) {
        ImageView soldierImg = new ImageView(img);
        Label lblHead = new Label("" +deathCircle.size()+1 );
        VBox vbSoldier = new VBox();
        vbSoldier.setLayoutX(xpos);
        vbSoldier.setLayoutY(ypos);
        vbSoldier.getChildren().addAll(lblHead, soldierImg);
        return vbSoldier;
    }

    public void SetLayout() {
        for (int i = 0; i < deathCircle.size(); i++) {
            System.out.println("hagoe sto");
            double angle = (((double) i) / defaultSize) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 240;
            circleSpace.getChildren().get(i).setLayoutX(xpos);
            circleSpace.getChildren().get(i).setLayoutY(ypos);
        }

    }

    public void addSoldier() {
        deathCircle.addLast(new Soldier());
        circleSpace.getChildren().add(MakeBox(img, 300, 240));
    }

    public void removeSoldier() {
        deathCircle.removeLast();
        circleSpace.getChildren().remove(deathCircle.size() - 1);
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
        System.out.println(deathCircle);
        for (int i = 0; i < Math.abs(diff); i++) {
            System.out.println("entro aqui");
            if (diff > 0) {
                addSoldier();
            } else {
                removeSoldier();
            }
            SetLayout();
        }
        System.out.println("rnlaetr");
    }
}

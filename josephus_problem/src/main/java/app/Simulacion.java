package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import list.CircularDoublyLinkedList;
import model.Soldier;

/**
 *
 * @author danny
 */
public class Simulacion {

    @FXML
    AnchorPane circleSpace;
    public int defaultSize;
    private int radio;
    private int radioLbl;
    private Image img;
    public final CircularDoublyLinkedList<Soldier> deathCircle;

    private Matanza matanza;

    public Simulacion(AnchorPane circleSpace) {
        this.circleSpace = circleSpace;
        this.deathCircle = new CircularDoublyLinkedList();
        this.matanza = new Matanza(deathCircle, this.circleSpace);
        init();
    }

    private void init() {
        img = new Image(App.class.getResourceAsStream("/images/ninja.png"),
                50, 50, true, true);
        defaultSize = 21;
        radio = 230;
        radioLbl = 40;

        for (int i = 0; i < defaultSize; i++) {
            addSoldier();
        }
    }

    public void updateCircle() {
        for (int i = 0; i < deathCircle.size(); i++) {
            double angle = (((double) i) / deathCircle.size()) * 2 * Math.PI;
            double xpos = radio * Math.cos(angle) + 300;
            double ypos = radio * Math.sin(angle) + 260;
            double lblxpos = radioLbl * Math.cos(angle) + 15;
            double lblypos = radioLbl * Math.sin(angle) + 20;
            circleSpace.getChildren().get(i).setLayoutX(xpos);
            circleSpace.getChildren().get(i).setLayoutY(ypos);

            AnchorPane plx = (AnchorPane) circleSpace.getChildren().get(i);
            plx.getChildren().get(0).setLayoutX(lblxpos);
            plx.getChildren().get(0).setLayoutY(lblypos);
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
        matanza.start();
    }

    public void pauseSimulation() {
        matanza.pause();
    }

    public void stopSimulation() {
        matanza.stop();
    }

    public AnchorPane makeBox(Image img, double xpos, double ypos) {
        ImageView soldierImg = new ImageView(img);
        Label lblHead = new Label("" + deathCircle.size());
        lblHead.setStyle("-fx-text-fill: white;");
        lblHead.setFont(Font.font("", FontWeight.BOLD, 12));
        AnchorPane anchorSoldier = new AnchorPane();
        anchorSoldier.setLayoutX(xpos);
        anchorSoldier.setLayoutY(ypos);
        anchorSoldier.getChildren().addAll(lblHead, soldierImg);
        return anchorSoldier;
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

    public Matanza getMatanza() {
        return this.matanza;
    }
}

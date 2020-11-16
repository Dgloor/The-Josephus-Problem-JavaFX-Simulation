package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import model.DeathCircle;

public class baseController implements Initializable {

    @FXML
    BorderPane baseScreen;
    @FXML
    Circle btnClose;
    @FXML
    Circle btnMinimize;
    @FXML
    Button btnMusic;
    
    Ventana ventana;
    Audio audio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ventana = new Ventana();
        audio = new Audio();
     
        
    }

    public void handlePressed(MouseEvent e) {
        ventana.setPosicion(e);
    }

    public void handleDragged(MouseEvent e) {
        ventana.move(e);
    }

    public void handleMin(MouseEvent e) {
        ventana.minimize();
    }

    public void handleClose(MouseEvent e) {
        ventana.close();
    }

    public void toggleAudioState() {
        audio.switchState();
    }
    
//    public void startSimulation(){
//        controls.start();
//    }
    
}

package app;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class baseController implements Initializable {

    Ventana ventana;
    Audio audio;
    static Controles controles;
    static Simulacion simulacion;

    @FXML
    BorderPane baseScreen;
    @FXML
    Circle btnClose, btnMinimize;
    @FXML
    Button btnStart, btnPause, btnStop, btnReset, btnMusic;
    @FXML
    AnchorPane circleSpace;

    @FXML
    JFXSlider amountSlider;
    @FXML
    Spinner<Integer> startIndex;
    @FXML
    JFXRadioButton rbHorario;
    @FXML
    JFXRadioButton rbAntihorario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ventana = new Ventana();
        audio = new Audio();
        simulacion = new Simulacion(circleSpace);
        addControls();
    }

    public void addControls() {
        controles = new Controles();
        controles.setObserver(simulacion);
        controles.setAmountSlider(amountSlider);
        controles.setRbHorario(rbHorario);
        controles.setRbAntihorario(rbAntihorario);
        controles.setStartIndex(startIndex);
        controles.setBtnStart(btnStart);
        controles.setBtnPause(btnPause);
        controles.setBtnStop(btnStop);
        controles.setBtnReset(btnReset);
    }

    @FXML
    public void startSimulation() {
        controles.start();
    }

    @FXML
    public void pauseSimulation() {
        controles.pause();
    }

    @FXML
    public void stopSimulation() {
        controles.stop();
    }

    @FXML
    public void resetSettings() {
        controles.reset();
    }

    @FXML
    public void goHorario() {
        controles.updateHorario();
    }

    @FXML
    public void goAntihorario() {
        controles.updateAntihorario();
    }

    @FXML
    public void toggleAudioState() {
        audio.switchState();
    }

    @FXML
    public void handlePressed(MouseEvent e) {
        ventana.setPosicion(e);
    }

    @FXML
    public void handleDragged(MouseEvent e) {
        ventana.move(e);
    }

    @FXML
    public void handleMin(MouseEvent e) {
        ventana.minimize();
    }

    @FXML
    public void handleClose(MouseEvent e) {
        ventana.close();
    }

}

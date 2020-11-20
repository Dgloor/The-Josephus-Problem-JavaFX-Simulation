package app;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author danny
 */
public class Controles {

    @FXML
    private ToggleGroup sentido;
    @FXML
    private JFXSlider amountSlider;
    @FXML
    private Spinner<Integer> startIndex;
    @FXML
    private SpinnerValueFactory<Integer> valueFactory;
    @FXML
    private Button btnStart, btnPause, btnStop, btnReset;

    Simulacion observer;

    public void start() {
        observer.startSimulation();

        btnStart.setVisible(false);
        btnStart.setDisable(true);

        btnPause.setVisible(true);
        btnPause.setDisable(false);

        btnReset.setDisable(true);
        btnStop.setDisable(false);

        startIndex.setDisable(true);
        amountSlider.setDisable(true);
        sentido.getToggles().stream().map((t)
                -> (ToggleButton) t).forEach((btn)
                -> {
            btn.setDisable(true);
        });
    }

    public void pause() {
        observer.pauseSimulation();

        btnStart.setText("RESUME");
        btnStart.setVisible(true);
        btnStart.setDisable(false);

        btnPause.setVisible(false);
        btnPause.setDisable(true);
    }

    public void stop() {
        observer.stopSimulation();

        btnStart.setText("START");
        btnStart.setVisible(true);
        btnStart.setDisable(false);

        btnPause.setVisible(false);
        btnPause.setDisable(true);

        btnReset.setDisable(false);
        btnStop.setDisable(true);

        startIndex.setDisable(false);
        amountSlider.setDisable(false);

        sentido.getToggles().stream().map((t)
                -> (ToggleButton) t).forEach((btn)
                -> {
            btn.setDisable(false);
        });
    }

    public void reset() {
        this.btnStart.setText("START");

        btnStart.setVisible(true);
        btnStart.setDisable(false);

        btnPause.setVisible(false);
        btnPause.setDisable(true);

        btnStop.setDisable(true);
    }

    public void incrementAmount() {

    }

    public void changeStartIndex() {
    }

    public void setSentido(ToggleGroup sentido) {
        this.sentido = sentido;
    }

    public void setAmountSlider(JFXSlider amountSlider) {
        this.amountSlider = amountSlider;
    }

    public void setStartIndex(Spinner<Integer> startIndex) {
        this.startIndex = startIndex;
        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 1);
        startIndex.setValueFactory(valueFactory);
    }

    public void setBtnStart(Button btnStart) {
        this.btnStart = btnStart;
    }

    public void setBtnPause(Button btnPause) {
        this.btnPause = btnPause;
    }

    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
    }

    public void setObserver(Simulacion observer) {
        this.observer = observer;
    }

}

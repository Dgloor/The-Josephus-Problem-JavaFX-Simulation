package app;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;

/**
 *
 * @author danny
 */
public class Controles {

    @FXML
    private ToggleGroup toggleSentido;
    @FXML
    private JFXSlider amountSlider;
    @FXML
    private Spinner<Integer> startIndex;
    @FXML
    private  SpinnerValueFactory<Integer> valueFactory;
    @FXML
    private Button btnStart, btnPause, btnStop, btnReset;

    Simulacion observer;

    final Integer defaultSliderAmount = 20;

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
        toggleSentido.getToggles().stream().map((t)
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

        toggleSentido.getToggles().stream().map((t)
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

        amountSlider.setValue(defaultSliderAmount);
        toggleSentido.getToggles().get(0).setSelected(true);
        toggleSentido.getToggles().get(1).setSelected(false);
    }

    public void updateAmount() {
        observer.updateSoldiersAmount((int) amountSlider.getValue());
    }

    public void updateStartIndex() {
    }

    public void updateSentido() {

    }

    public void setToggleSentido(ToggleGroup toggleSentido) {
        this.toggleSentido = toggleSentido;
    }

    public void setAmountSlider(JFXSlider amountSlider) {
        this.amountSlider = amountSlider;
        this.amountSlider.valueProperty().addListener((
                ObservableValue<? extends Number> arg0,
                Number arg1, Number arg2)
                -> {
            updateAmount();
        });
    }

    public void setStartIndex(Spinner<Integer> startIndex) {
        this.startIndex = startIndex;
        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
                1, defaultSliderAmount);
        this.startIndex.setValueFactory(valueFactory);
    }

    public void setBtnStart(Button btnStart) {
        this.btnStart = btnStart;
    }

    public void setBtnPause(Button btnPause) {
        this.btnPause = btnPause;
    }

    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
        this.btnStop.setDisable(true);
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
    }

    public void setObserver(Simulacion observer) {
        this.observer = observer;
    }

}

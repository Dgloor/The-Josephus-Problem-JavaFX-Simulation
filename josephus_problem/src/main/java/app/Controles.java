package app;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author danny
 */
public class Controles {

    @FXML
    private JFXRadioButton rbHorario, rbAntihorario;
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

        rbHorario.setDisable(true);
        rbAntihorario.setDisable(true);
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

        rbHorario.setDisable(false);
        rbAntihorario.setDisable(false);
    }

    public void reset() {
        this.btnStart.setText("START");

        btnStart.setVisible(true);
        btnStart.setDisable(false);

        btnPause.setVisible(false);
        btnPause.setDisable(true);

        btnStop.setDisable(true);

        amountSlider.setValue(observer.defaultSize);

        rbHorario.setSelected(true);
        rbAntihorario.setSelected(false);
    }

    public void updateAmount() {
        observer.updateSoldiersAmount((int) amountSlider.getValue());
        setSpinnerLimits(1, (int) amountSlider.getValue());
    }

    public void updateStartIndex() {
        observer.getMatanza().setStartIndex(startIndex.getValue());
    }

    public void updateHorario() {
        observer.getMatanza().setHorario(true);
    }

    public void updateAntihorario() {
        observer.getMatanza().setHorario(false);
    }

    public void setRbHorario(JFXRadioButton rbHorario) {
        this.rbHorario = rbHorario;
    }

    public void setRbAntihorario(JFXRadioButton rbAntihorario) {
        this.rbAntihorario = rbAntihorario;
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
        setSpinnerLimits(1, observer.defaultSize);
    }

    public void setSpinnerLimits(int start, int end) {
        int currentValue = 1;
        if (this.startIndex.getValue() != null) {
            currentValue = this.startIndex.getValue();
        }
        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
                start, end);
        this.startIndex.setValueFactory(valueFactory);
        this.startIndex.getValueFactory().setValue(currentValue);
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

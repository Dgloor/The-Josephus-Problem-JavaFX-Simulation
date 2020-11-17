package app;

import com.jfoenix.controls.JFXSlider;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author danny
 */
public class Controles {

    private ToggleGroup sentido;
    private JFXSlider amountSlider;
    private Spinner<Integer> startIndex;
    private SpinnerValueFactory<Integer> valueFactory;
    private Button btnStart, btnStop, btnReset;

    public void start() {
        System.out.println("Start");
    }

    public void pause() {
        System.out.println("Pause");
    }

    public void stop() {
        System.out.println("Stop");
    }

    public void reset() {
        System.out.println("Reset");
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

    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
    }
    
    

}

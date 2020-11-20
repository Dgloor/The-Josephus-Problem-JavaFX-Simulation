package app;

import Observer.Observer;
import Observer.Subject;
import com.jfoenix.controls.JFXSlider;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author danny
 */
public class Controles implements Subject {

    private ToggleGroup sentido;
    private JFXSlider amountSlider;
    private Spinner<Integer> startIndex;
    private SpinnerValueFactory<Integer> valueFactory;
    private Button btnStart, btnStop, btnReset;
    
    Observer observer;

    public void start() {
        System.out.println("Start");
        notifyObserver();
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
    
    public void setObserver(Observer observer){
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        observer.update("Este es un mensaje de prueba");
    }
    
    

}

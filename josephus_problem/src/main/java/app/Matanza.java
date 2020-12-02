package app;

import java.util.ListIterator;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import list.CircularDoublyLinkedList;
import model.Soldier;

public class Matanza implements Runnable{
    private static int startIndex;
    private final boolean horario;
    private final CircularDoublyLinkedList<Soldier> deathCircle;
    private final ObservableList<Node> imgs = baseController.simulacion.circleSpace.getChildren();

    public Matanza(int startIndex, boolean horario, CircularDoublyLinkedList<Soldier> deathCircle) {
        Matanza.startIndex = startIndex-1;
        this.horario = horario;
        this.deathCircle = deathCircle;
    }
    
    private boolean lastAlive(){
        int n = 0;
        for (int i = 0; i < deathCircle.size(); i++){
            if (deathCircle.get(i).isAlive()){
                n++;
            }
        }
        return n == 1;
    }
    
    private void kill(int index){
        imgs.get(index).setOpacity(0.10);
    }
    
    private void updateBodies(){
        for (int i = 0; i<deathCircle.size(); i++){
            if (!deathCircle.get(i).isAlive()){
                this.kill(i);
            }
        }
    }
    
    @Override
    public void run() {
        ListIterator<Soldier> li = deathCircle.listIterator();
        for (int i = 0; i < startIndex; i++){
            li.next();
        }
        if (horario){
            while(baseController.simulacion.state == SimulationState.RUNNING && !lastAlive()){
                try {
                    Soldier s = li.next();
                    while (!s.isAlive()){
                        s = li.next();
                    }
                    Soldier v = li.next();
                    while (!v.isAlive()){
                        v = li.next();
                    }
                    s.kill(v);
                    Platform.runLater(()-> updateBodies());
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        else {
            while(baseController.simulacion.state == SimulationState.RUNNING && !lastAlive()){
                try {
                    Soldier s = li.previous();
                    while (!s.isAlive()){
                        s = li.previous();
                    }
                    Soldier v = li.previous();
                    while (!v.isAlive()){
                        v = li.previous();
                    }
                    s.kill(v);
                    Platform.runLater(()-> updateBodies());
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
}

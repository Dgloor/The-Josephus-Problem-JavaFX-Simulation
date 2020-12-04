package app;

import java.util.ListIterator;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import list.CircularDoublyLinkedList;
import model.Soldier;

public class Matanza implements Runnable {

    private final int startIndex;
    private final boolean horario;
    private final CircularDoublyLinkedList<Soldier> deathCircle;
    private final ObservableList<Node> imgs = baseController.simulacion.circleSpace.getChildren();
    private Thread t;
    private State state;

    public Matanza(int startIndex, boolean horario, CircularDoublyLinkedList<Soldier> deathCircle) {
        this.startIndex = startIndex - 1;
        this.horario = horario;
        this.deathCircle = deathCircle;
        this.state = State.STOPPED;
    }

    private boolean lastAlive() {
        int n = 0;
        for (int i = 0; i < deathCircle.size(); i++) {
            if (deathCircle.get(i).isAlive()) {
                n++;
            }
        }
        return n == 1;
    }

    private void kill(int index) {
        imgs.get(index).setOpacity(0.10);
    }

    private void updateBodies() {
        for (int i = 0; i < deathCircle.size(); i++) {
            if (!deathCircle.get(i).isAlive()) {
                this.kill(i);
            }
        }
    }

    public void start() {
        this.state = State.RUNNING;
        if (t==null){
            t = new Thread(this);        
            t.start();
        }
        else {
            t.resume();
        }
    }

    @Override
    public void run() {
        ListIterator<Soldier> li = deathCircle.listIterator();
        for (int i = 0; i < startIndex; i++) {
            li.next();
        }
        while (this.state == State.RUNNING && !lastAlive()) {
            if (horario) {
                Soldier s = li.next();
                while (!s.isAlive()) {
                    s = li.next();
                }
                Soldier v = li.next();
                while (!v.isAlive()) {
                    v = li.next();
                }
                s.kill(v);
                Platform.runLater(() -> updateBodies());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                Soldier s = li.previous();
                while (!s.isAlive()) {
                    s = li.previous();
                }
                Soldier v = li.previous();
                while (!v.isAlive()) {
                    v = li.previous();
                }
                s.kill(v);
                Platform.runLater(() -> updateBodies());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        baseController.controles.stop();
    }

    public void pause() {
        this.state = State.PAUSED;
        try {
            t.suspend();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void stop() {
        this.state = State.STOPPED;
        for (int i = 0; i<deathCircle.size(); i++){
            if (!deathCircle.get(i).isAlive()){
                imgs.get(i).setOpacity(1);
                deathCircle.get(i).revive();
            }
        }
        t = null;
    }

}

package model;

/**
 *
 * @author danny
 */
public class Soldier {
    private boolean isAlive;
    
    public Soldier(){
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void revive() {
        isAlive = true;
    }
    
    public void kill(Soldier s){
        s.isAlive = false;
    }
}

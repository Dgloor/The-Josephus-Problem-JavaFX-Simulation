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

    public void die() {
        isAlive = false;
    }
    
    public void kill(Soldier s){
        s.die();
    }
}

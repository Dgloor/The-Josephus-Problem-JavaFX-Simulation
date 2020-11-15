package model;

/**
 *
 * @author danny
 */
public class Soldier {
    private boolean alive;
    
    public Soldier(){
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }
    
    public void kill(Soldier s){
        s.die();
    }
}

package model;

import list.CircularDoublyLinkedList;

/**
 *
 * @author danny
 */
public class DeathCircle {
    private CircularDoublyLinkedList<Soldier> soldiers;
    
    
    public DeathCircle(){
        soldiers = new CircularDoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            this.addSoldier(new Soldier());
            
        }
    }
    
    
    public void addSoldier(Soldier s){
        soldiers.addLast(s);
    }
    

}

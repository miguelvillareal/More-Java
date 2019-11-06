
package rpg;

import java.util.*;

/**
 *
 * @author miguelvillareal, cassieprice, kaceymorris This is the superclass that
 * creates the array list for all the contestants
 */
// Smashing Damage is represented as a 0
// Slashing Damage is represented as a 1
// Fire Damage is represented as a 2
public class Contestant {

    ArrayList<Contestant> Contestants = new ArrayList<Contestant>();

    // all these methods do nothing, they are all overwritten in the specific
    // contestant subclasses
    // its purpose is so when an array list is made, it can contain all types of
    // contestants 
    public int getHP() {
        return 0;
    }

    public String takesDamage(int points, int damageType, Contestant attacker) {
        return "";
    }

    public void attack(ArrayList<Contestant> Contestants) {
    }

    public int playRound() {
        return 0;
    }

    public String getDescription() {
        return "";
    }

    public boolean isAlive() {
        return true;
    }

}

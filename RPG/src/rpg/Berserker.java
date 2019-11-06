package rpg;

import java.util.*;

/**
 * @author miguelvillareal, cassieprice, kaceymorris This class will fulfill the
 * requirements for the berserker characters
 */
public class Berserker extends Contestant {

    Random rand = new Random();
    public int healthPoints = 35;

    /**
     * This method returns the health points of the current berserker
     *
     * @param nothing parameters it is a getter with no parameters
     * @return healthPoints it will return the health points of the berserker
     */
    @Override
    public int getHP() {
        return healthPoints;
    }

    /**
     * This method tells whether the berserker is alive or not
     *
     * @param nothing parameters it tells weather the berserker has greater than
     * 0 health
     * @return boolean if there is health left, true is returned. if there is
     * none, false is returned
     */
    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * This method takes in an array list of other contestants in the arena and
     * attacks one of them based on rules for a berserker
     *
     * @param Contestants takes in an array list of contestants in the arena
     * @return nothing doesn't return anything, but does call the takesDamage
     * method on a chosen contestant
     */
    @Override
    public void attack(ArrayList<Contestant> Contestants) {
        // generate random number 0 and 5
        // index that number
        // call getHP() for that contestant at that index
        // if getHP() == 0, then generate another random number
        int randContHP;
        int randCont;
        do {
            randCont = rand.nextInt(6);
            randContHP = Contestants.get(randCont).getHP();
        } while (randContHP <= 0);
        // while loop until you find someone alive
        Contestant ourCont = Contestants.get(randCont);
        ourCont.takesDamage(20, 0, this);
    }

    /**
     * This method describes what kind of contestant it is and how much health
     * is left
     *
     * @param no parameters it simply returns a description
     * @return String returns a string which, if alive, tells the type and
     * amount of health left, and if dead, just the type and states death
     */
    @Override
    public String getDescription() {
        String returnStr;
        if (healthPoints > 0) {
            returnStr = "A raging Berserker (" + healthPoints + ")";
        } else {
            returnStr = "A slain Berserker";
        }
        return returnStr;
    }

    /**
     * This method inflicts damage on the berserker in question and prints who
     * is attacking and how much damage they deal, modified based on berserker
     * rules
     *
     * @param points is how many points will be subtracted from the health of
     * the berserker, which is manipulated based on what kind of attack it is
     * @param damageType based on the key previously defined, will treat attacks
     * according to what type they are
     * @param attacker is the actual contestant who is attacking, used to print
     * their description
     * @return attackStr which is a String that represents who is being
     * attacked, with what damage, and by who
     */
    @Override
    public String takesDamage(int points, int damageType, Contestant attacker) {
        int damagePoints;
        // determine who the attacker is
        // take away points from healthPoints based on who is attacking
        if (damageType == 0) {
            String attackStr = "A raging Berserker (" + healthPoints + ") takes 20 Smashing Damage from " + attacker.getDescription();
            healthPoints -= points; // take away points passed from berserker
            System.out.println(attackStr);
            return attackStr;
        }
        if (damageType == 1) {
            damagePoints = (2 * points);
            String attackStr = "A raging Berserker (" + healthPoints + ") takes " + damagePoints + " Slashing Damage from " + attacker.getDescription();
            healthPoints -= damagePoints; // take away double points from warrior
            System.out.println(attackStr);
            return attackStr;
        }
        if (damageType == 2) {
            damagePoints = (points / 2);
            String attackStr = "A raging Berserker (" + healthPoints + ") takes " + damagePoints + " Fire Damage from " + attacker.getDescription();
            healthPoints -= damagePoints; // take away half points from mage
            System.out.println(attackStr);
            return attackStr;
        }
        return null;
    }

}

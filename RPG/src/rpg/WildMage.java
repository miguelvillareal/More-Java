
package rpg;

import java.util.*;

/**
 * @author miguelvillareal, cassieprice, kaceymorris This class will fulfill the
 * requirements for the mage characters
 */
public class WildMage extends Contestant {

    Random rand = new Random();
    // generate a random value starting at 10 and going to 60, exclusive of 61
    public int healthPoints = rand.nextInt(51) + 10;

    /**
     * This method returns the health points of the current mage
     *
     * @param nothing parameters it is a getter with no parameters
     * @return healthPoints it will return the health points of the mage
     */
    @Override
    public int getHP() {
        return healthPoints;
    }

    /**
     * This method tells whether the mage is alive or not
     *
     * @param nothing parameters it tells weather the mage has greater than 0
     * health
     * @return boolean if there is health left, true is returned. if there is
     * none, false is returned
     */
    @Override
    public boolean isAlive() {
        return (healthPoints > 0);
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
            returnStr = "A wild Mage (" + healthPoints + ")";
        } else {
            returnStr = "A dead Mage";
        }
        return returnStr;
    }

    /**
     * This method takes in an array list of other contestants in the arena and
     * attacks one of them based on rules for a mage
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
        int randDamage = rand.nextInt(7);
        do {
            randCont = rand.nextInt(6);
            randContHP = Contestants.get(randCont).getHP();
        } while (randContHP <= 0);
        // while loop until you find someone alive
        Contestant ourCont = Contestants.get(randCont);
        ourCont.takesDamage(randDamage, 2, this);
    }

    /**
     * This method inflicts damage on the mage in question and prints who is
     * attacking and how much damage they deal, also deals damage if killed
     *
     * @param points is how many points will be subtracted from the health of
     * the mage
     * @param damageType based on the key previously defined, will treat attacks
     * according to what type they are
     * @param attacker is the actual contestant who is attacking, used to print
     * their description and attack them if they kill the mage
     * @return attackStr which is a String that represents who is being
     * attacked, with what damage, and by who
     */
    @Override
    public String takesDamage(int points, int damageType, Contestant attacker) {
        // determine who the attacker is
        // take away points from healthPoints based on who is attacking
        if (damageType == 0) {
            String attackStr = "A wild Mage (" + healthPoints + ") takes 20 Smashing Damage from " + attacker.getDescription();
            healthPoints -= 20; // take away points passed from berserker
            System.out.println(attackStr);
            if (healthPoints <= 0) {
                attacker.takesDamage(5, 2, this);
            }
            return attackStr;
        }
        if (damageType == 1) {
            String attackStr = "A wild Mage (" + healthPoints + ") takes " + points + " Slashing Damage from " + attacker.getDescription();
            healthPoints -= points; // take away double points from warrior
            System.out.println(attackStr);
            if (healthPoints <= 0) {
                attacker.takesDamage(5, 2, this);
            }
            return attackStr;
        }
        if (damageType == 2) {
            String attackStr = "A wild Mage (" + healthPoints + ") takes " + points + " Fire Damage from " + attacker.getDescription();
            healthPoints -= points; // take away half points from mage
            System.out.println(attackStr);
            if (healthPoints <= 0) {
                if (attacker == this) {
                } else {
                    attacker.takesDamage(5, 2, this);
                }
            }
            return attackStr;
        }
        return null;
    }

}

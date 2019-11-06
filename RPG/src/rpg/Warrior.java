
package rpg;

import java.util.*;

/**
 * @author miguelvillareal, cassieprice, kaceymorris This class will fulfill the
 * requirements for the warrior characters
 */
public class Warrior extends Contestant {

    Random rand = new Random();
    public int healthPoints = rand.nextInt(21) + 20;

    /**
     * This method returns the health points of the current warrior
     *
     * @param nothing parameters it is a getter with no parameters
     * @return healthPoints it will return the health points of the warrior
     */
    @Override
    public int getHP() {
        return healthPoints;
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
            returnStr = "A disciplined Warrior (" + healthPoints + ")";
        } else {
            returnStr = "A slain Warrior";
        }
        return returnStr;
    }

    /**
     * This method tells whether the warrior is alive or not
     *
     * @param nothing parameters it tells weather the warrior has greater than 0
     * health
     * @return boolean if there is health left, true is returned. if there is
     * none, false is returned
     */
    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * This method takes in an array list of other contestants in the arena and
     * attacks one of them based on rules for a warrior, excluding themselves
     *
     * @param Contestants takes in an array list of contestants in the arena
     * @return nothing doesn't return anything, but does call the takesDamage
     * method on the chosen contestant
     */
    @Override
    public void attack(ArrayList<Contestant> Contestants) {
        // generate random number 0 and 5
        // index that number
        // call getHP() for that contestant at that index
        // if getHP() == 0, then generate another random number

        ArrayList<Contestant> Manipulate = new ArrayList<Contestant>();
        // create a new array and just copy them so you can manipulate it
        // and not get an error for changing the arraylist you're looping 
        // through already

        for (Contestant cont : Contestants) {
            Manipulate.add(cont);
        }

        Manipulate.remove(this);
        Contestant topHealthCont = Contestants.get(0);
        // loop through array list of contestants
        for (Contestant cont : Manipulate) {
            if (cont.getHP() > topHealthCont.getHP()) {
                topHealthCont = cont;
            }
        }
        Manipulate.add(this);

        int randDamage = rand.nextInt(7) + 10;

        topHealthCont.takesDamage(randDamage, 1, this);
    }

    /**
     * This method inflicts damage on the warrior in question and prints who is
     * attacking and how much damage they deal
     *
     * @param points is how many points will be subtracted from the health of
     * the mage
     * @param damageType based on the key previously defined, will treat attacks
     * according to what type they are
     * @param attacker is the actual contestant who is attacking, used to print
     * their description and tell if the attack can be dodged
     * @return attackStr which is a String that represents who is being
     * attacked, with what damage, and by who
     */
    @Override
    public String takesDamage(int points, int damageType, Contestant attacker) {
        // determine who the attacker is
        // take away points from healthPoints based on who is attacking
        if (damageType == 0) {
            int doesDamage = rand.nextInt(4);
            if (doesDamage == 0) {
                System.out.println(this.getDescription() + " dodged the attack from " + attacker.getDescription());
                return "Dodged";
            } else {
                String attackStr = "A disciplined Warrior (" + healthPoints + ") takes 20 Smashing Damage from " + attacker.getDescription();
                healthPoints -= points; // take away points passed from berserker
                System.out.println(attackStr);
                return attackStr;
            }
        }
        if (damageType == 1) {
            int doesDamage = rand.nextInt(4);
            if (doesDamage == 0) {
                System.out.println(this.getDescription() + " dodged the attack from " + attacker.getDescription());
                return "Dodged";
            } else {
                String attackStr = "A disciplined Warrior (" + healthPoints + ") takes " + points + " Slashing Damage from " + attacker.getDescription();
                healthPoints -= points; // take away double points from warrior
                System.out.println(attackStr);
                return attackStr;
            }
        }
        if (damageType == 2) {
            String attackStr = "A disciplined Warrior (" + healthPoints + ") takes " + points + " Fire Damage from " + attacker.getDescription();
            healthPoints -= points; // take away half points from mage
            System.out.println(attackStr);
            return attackStr;
        }
        return null;
    }

}

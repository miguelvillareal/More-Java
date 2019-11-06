package rpg;

import java.util.ArrayList;
import java.util.*;

class Arena {

    Random rand = new Random();
    ArrayList<Contestant> Contestants;

    /**
     * This method creates an array list of contestant object types
     *
     * @param nothing it doesn't take any parameters
     * @return nothing it returns nothing
     */
    public Arena() {
        Contestants = new ArrayList<Contestant>();
    }

    /**
     * This method adds contestant objects to the array list
     *
     * @param contestant is one of the contestant subclasses and is added to the
     * array list
     * @return nothing doesn't return anything
     */
    public void add(Contestant contestant) {
        Contestants.add(contestant);
    }

    /**
     * This method loops through the contestants in the arena and, if they are
     * still alive, calls the attack method with the array list as a parameter
     *
     * @param nothing no parameters for this method
     * @return nothing doesn't return anything
     */
    public void playRound() {
        for (Contestant con : Contestants) {
            if (con.getHP() > 0) {
                con.attack(Contestants);
            }
        }
    }

    /**
     * This method prints out who is left in the arena and each of the contestants
     * descriptions
     *
     * @param nothing no parameters for this method
     * @return returnStr which is a string containing information about all the 
     * contestants in the arena
     */
    public String getDescription() {
        String returnStr = "";
        System.out.println("\nIn the arena...");
        for (Contestant cont : Contestants) {
            returnStr += cont.getDescription() + "\n";
        }
        return returnStr;
    }

    /**
     * This method gets the winner of the battle, so whoever is the last left
     * alive. If they are all killed, a random winner is picked
     *
     * @param nothing no parameters are needed for this method
     * @return Contestant returns a contestant if the battle is over, but null
     * if the battle must continue
     */
    public Contestant getWinner() {
        int aliveCounter = 0;
        Contestant alive = Contestants.get(0);
        for (Contestant cont : Contestants) {
            if (cont.isAlive()) {
                aliveCounter++;
                alive = cont;
            }
        }
        if (aliveCounter == 0) {
            // generate random contestant for winner
            Contestant randomWinner = Contestants.get(rand.nextInt(5));
            return randomWinner;
        }
        if (aliveCounter == 1) {
            return alive;
        } else {
            return null;
        }
    }

}

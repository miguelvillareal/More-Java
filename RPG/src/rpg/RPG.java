package rpg;

public class RPG {

    // Smashing Damage is represented as a 0
    // Slashing Damage is represented as a 1
    // Fire Damage is represented as a 2
    
    /**
     * This method runs the program, creates all the contestants, adds them to 
     * the arena, and plays a round
     *
     * @param String[] an array of strings which is always used for a main method
     * @return nothing just runs the role playing game
     */
    public static void main(String[] args) {
        Arena arena = new Arena();

        arena.add(new Berserker());
        arena.add(new Berserker());
        arena.add(new Warrior());
        arena.add(new Warrior());
        arena.add(new WildMage());
        arena.add(new WildMage());

        while (arena.getWinner() == null) {
            System.out.println(arena.getDescription());
            arena.playRound();
        }

        System.out.println();
        System.out.println(arena.getDescription());
        // I changed this back to get Description like how they have it in the original code
        System.out.println("Winner: " + arena.getWinner().getDescription());

    }

}

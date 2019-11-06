package lightsoutgame;
/**
 * This Class will drive our lights out video game
 * it handles the core game logic using standard practices
 * that take into consideration the desired outcome of the game play.
 *
 * @author Miguel Villareal
 */

class LightsOut
{
    // we avoid making these final, as the game will be changing.
    private int size;
    private boolean[][] grid;

    /**
     * This method sets the size of our game board based on a parameter
     * @param size determines the side length of our game board.
     */
    public LightsOut(int size)
    {
    // this method should initialize a nXn boolean array that represents our game board
    // assuming that later on it will be populated acording to an input file
    grid = new boolean [size][size];
    this.size = size;
    // make sure different sizes work for the game
    }

    /**
     * This is a standard getter, that simply returns the field variable
     * of interest.
     * @return the size of the game board.
     */
    public int getSize()
    {
        return size;
    }

    /**
     * This method handles the event in which the user toggles one of the lights
     * it toggles the light in question and also the 4 surrounding lights.
     * @param row The row of the light to toggle.
     * @param col  The column of the light to toggle.
     */
    public void press(int row, int col)
    {
        toggle(row,col);
        toggle(row-1,col);
        toggle(row+1,col);
        toggle(row,col-1);
        toggle(row,col+1);
    }

    /**
     * This method returns true or false based on whether or not a light is on.
     *
     * @param row The row of the square.
     * @param col The column of the square.
     * @return
     */
    public boolean isLit(int row, int col)
    {
        return grid[row][col];
    }

    /**
     * This method forces a square to be true/false without affecting the
     * surrounding squares. You should get a type error if value is
     * anything but boolean
     * @param row The row of the light to force light.
     * @param col The column of the light to force light.
     * @param value the boolean value to set it to.
     */
    public void forceLit(int row, int col, boolean value)
    {
        //set the puzzle to store the value at the given location
        grid[row][col] = value;
    }

    /**
     * This private method is the core of the logic behind the press method,
     * it includes the error handling that is left out of press() for simplicity
     * sake.
     * @param row the row of the square to toggle.
     * @param col the column of the square to toggle.
     */
    private void toggle(int row, int col)
    {

        // when we press a button, we should turn it on if its off
        //and change the state of all the neighbors.
       try
       {
        grid[row][col] = !grid[row][col];
       }
       catch (ArrayIndexOutOfBoundsException ex)
       {

       }

    }

}

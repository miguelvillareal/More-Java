package lightsoutgame;

/**
 * This file is the class file that will drive our lights out video game.
 *
 * @author Miguel Villareal
 *
 */
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

class LightsOutFileLoader {

    /**
     * This is the constructor for our LightsOutFileLoader class.
     */

    public LightsOutFileLoader() {

    }

    /**
     * This method takes in a file that will set the initial conditions of our
     * game so that we can have different starts. It parses the file for this
     * initial condition.
     *
     * @param lightsOut
     * @param infile
     * @throws FileNotFoundException
     * @throws IOException
     * @throws UnsupportedLightsOutFileException
     */
    public void load(LightsOut lightsOut, File inFile) throws FileNotFoundException, IOException, UnsupportedLightsOutFileException {
        Scanner fileScan = new Scanner(inFile);
        int row = 0;

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == 'X') {
                    lightsOut.forceLit(row, col, false);
                } else if (line.charAt(col) == '_') {
                    lightsOut.forceLit(row, col, true);
                } else {
                    UnsupportedLightsOutFileException ex = new UnsupportedLightsOutFileException();
                    throw ex;
                }
            }
            row++;
        }

    }
}

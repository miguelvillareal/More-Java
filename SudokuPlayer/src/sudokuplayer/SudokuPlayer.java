package sudokuplayer;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;

// Create a Sudoku class for the methods to be created in
class Sudoku{
    
    // Initialize puzzle
    public char[][]layout;
    
    // Sudoku method to initialize an empty puzzle layout
    public Sudoku(){
        layout = new char[9][9];
        for(int row = 0; row < 9;row++){
          for(int col = 0; col <9; col++){
              layout[row][col] = ' ';
          }
      }
    }
    
    // Methpod that takes in starting configuration and creates the puzzle 
    // with the given rows and columns
    public Sudoku(String starting_configuration){
      String[] begin = starting_configuration.split("\n");
      layout = new char[9][9];
      int col = 0;
      int row = 0;
      for(row = 0; row < 9;row++){
          for(col = 0; col <9; col++){
              layout[row][col] = begin[row].charAt(col);
              
          }
      }
           }
    
    // Takes in a row and column and returns the value in that element
    public char getSquare(int row, int col){
        return layout[row][col];
    }
    
    // Takes in a row and column and updates it with a new value
    public void setSquare(int row, int col, char value){
        layout[row][col] = value;
    }

    // Checks to see if the puzzle is valid
    public boolean isValid(){
        
        return true;
    }
    
    // If the puzzle is valid and there are no empty spots, this method
    // will return true that it is solved
    public boolean isSolved(){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if (layout[row][col] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    }

class SudokuPlayer extends JFrame {

    public SudokuPlayer(String start, String solution) {
        sudoku = new Sudoku(start);
        setSize(300, 350);
        setTitle("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3));
        add(grid, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel subgrid = new JPanel();
                subgrid.setLayout(new GridLayout(3, 3));
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        char preset = sudoku.getSquare(i * 3 + i2, j * 3 + j2);
                        JTextField tf = new JTextField();
                        tf.setHorizontalAlignment(SwingConstants.CENTER);
                        if (preset != ' ') {
                            tf.setEditable(false);
                            tf.setText("" + preset);
                        } else {
                            GridListener listener = new GridListener(i * 3 + i2, j * 3 + j2);
                            tf.getDocument().addDocumentListener(listener);
                        }
                        subgrid.add(tf);
                    }
                }
                grid.add(subgrid);
            }
        }

        statusLabel = new JLabel("Welcome to Sudoku!");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

    }

    private final Sudoku sudoku;
    private final JLabel statusLabel;

    class GridListener implements DocumentListener {

        private int row;
        private int col;

        public GridListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void changedUpdate(DocumentEvent e) {
            updateSudoku(e);
        }

        public void insertUpdate(DocumentEvent e) {
            updateSudoku(e);
        }

        public void removeUpdate(DocumentEvent e) {
            updateSudoku(e);
        }

        private void updateSudoku(DocumentEvent e) {
            Document document = e.getDocument();
            char val;
            if (document.getLength() == 0) {
                val = ' ';
            } else {
                try {
                    val = document.getText(0, 1).charAt(0);
                } catch (BadLocationException ex) {
                    // If I can't get character one, that means we are empty
                    val = ' ';
                }
            }

            sudoku.setSquare(row, col, val);
            if (sudoku.isSolved()) {
                statusLabel.setText("Congratulations!");
            } else if (sudoku.isValid()) {
                statusLabel.setText(" ");
            } else {
                statusLabel.setText("Invalid solution!");
            }
        }
    }

    public static void main(String[] args) {
        String solution = "";
        solution += "435269781\n";
        solution += "682571493\n";
        solution += "197834562\n";
        solution += "826195347\n";
        solution += "374682915\n";
        solution += "951743628\n";
        solution += "519326874\n";
        solution += "248957136\n";
        solution += "763418259\n";

        String start = "";
        start += "   26 7 1\n";
        start += "68  7  9 \n";
        start += "19   45  \n";
        start += "82 1   4 \n";
        start += "  46 29  \n";
        start += " 5   3 28\n";
        start += "  93   74\n";
        start += " 4  5  36\n";
        start += "7 3 18   \n";

        SudokuPlayer player = new SudokuPlayer(start, solution);
        player.setVisible(true);

    }
}

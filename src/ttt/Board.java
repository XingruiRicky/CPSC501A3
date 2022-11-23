package ttt;

/**
 * The overall purpose of this code: Most of game logic
 *
 * @author Xiangyu Liu
 * @version 1.0
 * @since Feb. 5, 2020  4:38:40 p.m.
 */

public class Board implements Constants{

    /**
     * A matrix of space to create a Play board
     */
    private char theBoard[][];
    /**
     * Recall the number of marks
     */
    private int markCount;

    /**
     * A constructor of Play board
     */
    public Board() {
        markCount = 0;
        theBoard = new char[3][];
        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = Constants.SPACE_CHAR;
        }
    }

    /**
     * A getter method for Mark
     *
     * @param row
     * @param col
     * @return theBoard[row][col]
     */

    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * update markCount to 9 when the board is full
     *
     * @return markCount == 9
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * To check if X win
     *
     * @return boolean
     */
    public boolean xWins() {
        return (checkWinner(Constants.LETTER_X));
    }

    /**
     * To check if O win
     *
     * @return boolean
     */

    public boolean oWins() {
        return (checkWinner(Constants.LETTER_O));
    }

    /**
     * To display the total broad
     */
    public void display() {
        displayColumnHeaders();
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            System.out.print("    row " + row + Constants.SPACE_CHAR);
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /**
     * Add a mark at specific location, mark increase for one
     *
     * @param row
     * @param col
     * @param mark
     */
    public void addMark(int row, int col, char mark) {

        theBoard[row][col] = mark;
        markCount++;
    }

    /**
     * Clean everything
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = Constants.SPACE_CHAR;
        markCount = 0;
    }

    /**
     * To check if the mark win the game
     *
     * @param mark
     * @return result the check winner result
     */
    boolean checkWinner(char mark) {
        return (checkHorizontal(mark)||checkVertical(mark))||checkDiagonal(mark);
    }

    public boolean checkHorizontal(char mark){
        boolean win = false;
        for (int row = 0; !win && row < 3; row++) {
            int row_result = 1;
            for (int col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                win = true;
        }
        return win;
    }

    public boolean checkVertical(char mark){
        boolean win = false;

        for (int col = 0; !win && col < 3; col++) {
            int col_result = 1;
            for (int row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                win = true;
        }
        return win;
    }

    public boolean checkDiagonal(char mark){
        boolean win = false;

        int diag1Result = 1;
        for (int row = 0; diag1Result != 0 && row < 3; row++)
            if (theBoard[row][row] != mark)
                diag1Result = 0;
        if (diag1Result != 0)
            win = true;

        if(win) return true;

        int diag2Result = 1;
        for (int row = 0; diag2Result != 0 && row < 3; row++)
            if (theBoard[row][3 - 1 - row] != mark)
                diag2Result = 0;
        if (diag2Result != 0)
            win = true;

        return win;
    }








    /**
     * To display column headers
     */
    void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * To display a Hyphen line
     */
    void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * To print Spaces
     */
    void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }


    public char[][] getTheBoard() {
        return theBoard;
    }

    public void decreaseNum() {
        markCount--;
    }


}

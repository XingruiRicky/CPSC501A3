package ttt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPlayerTest {

    Board board = new Board();
    RandomPlayer xRP = new RandomPlayer("xPR",Constants.LETTER_X);
    RandomPlayer oRP = new RandomPlayer("oPR",Constants.LETTER_O);

    public boolean testEqual(Board b1, Board b2){
        char[][] theB1 = b1.getTheBoard();
        char[][] theB2 = b2.getTheBoard();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(!(theB1[i][j]==theB2[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void xRP_makeMove_Test1() {
        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.LETTER_O);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.LETTER_O);
        board.addMark(2,2,Constants.LETTER_O);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_X);
        board1.addMark(0,1,Constants.SPACE_CHAR);
        board1.addMark(0,2,Constants.SPACE_CHAR);

        board1.addMark(1,0,Constants.LETTER_O);
        board1.addMark(1,1,Constants.LETTER_O);
        board1.addMark(1,2,Constants.LETTER_O);

        board1.addMark(2,0,Constants.LETTER_O);
        board1.addMark(2,1,Constants.LETTER_O);
        board1.addMark(2,2,Constants.LETTER_O);

        Board board2 = new Board();

        board2.addMark(0,0,Constants.SPACE_CHAR);
        board2.addMark(0,1,Constants.LETTER_X);
        board2.addMark(0,2,Constants.SPACE_CHAR);

        board2.addMark(1,0,Constants.LETTER_O);
        board2.addMark(1,1,Constants.LETTER_O);
        board2.addMark(1,2,Constants.LETTER_O);

        board2.addMark(2,0,Constants.LETTER_O);
        board2.addMark(2,1,Constants.LETTER_O);
        board2.addMark(2,2,Constants.LETTER_O);

        Board board3 = new Board();

        board3.addMark(0,0,Constants.SPACE_CHAR);
        board3.addMark(0,1,Constants.SPACE_CHAR);
        board3.addMark(0,2,Constants.LETTER_X);

        board3.addMark(1,0,Constants.LETTER_O);
        board3.addMark(1,1,Constants.LETTER_O);
        board3.addMark(1,2,Constants.LETTER_O);

        board3.addMark(2,0,Constants.LETTER_O);
        board3.addMark(2,1,Constants.LETTER_O);
        board3.addMark(2,2,Constants.LETTER_O);


        xRP.setBoard(board);
        xRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        } else if (testEqual(board,board2)) {
            assertTrue(true);
        } else if (testEqual(board,board3)) {
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in random play");
        }
    }

    @Test
    void xRP_makeMove_Test2() {
        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.LETTER_O);
        board.addMark(0,2,Constants.LETTER_X);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.LETTER_X);
        board.addMark(2,2,Constants.LETTER_O);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_O);
        board1.addMark(0,1,Constants.LETTER_O);
        board1.addMark(0,2,Constants.LETTER_X);

        board1.addMark(1,0,Constants.LETTER_X);
        board1.addMark(1,1,Constants.SPACE_CHAR);
        board1.addMark(1,2,Constants.SPACE_CHAR);

        board1.addMark(2,0,Constants.LETTER_O);
        board1.addMark(2,1,Constants.LETTER_X);
        board1.addMark(2,2,Constants.LETTER_O);

        Board board2 = new Board();

        board2.addMark(0,0,Constants.LETTER_O);
        board2.addMark(0,1,Constants.LETTER_O);
        board2.addMark(0,2,Constants.LETTER_X);

        board2.addMark(1,0,Constants.SPACE_CHAR);
        board2.addMark(1,1,Constants.LETTER_X);
        board2.addMark(1,2,Constants.SPACE_CHAR);

        board2.addMark(2,0,Constants.LETTER_O);
        board2.addMark(2,1,Constants.LETTER_X);
        board2.addMark(2,2,Constants.LETTER_O);

        Board board3 = new Board();

        board3.addMark(0,0,Constants.LETTER_O);
        board3.addMark(0,1,Constants.LETTER_O);
        board3.addMark(0,2,Constants.LETTER_X);

        board3.addMark(1,0,Constants.SPACE_CHAR);
        board3.addMark(1,1,Constants.SPACE_CHAR);
        board3.addMark(1,2,Constants.LETTER_X);

        board3.addMark(2,0,Constants.LETTER_O);
        board3.addMark(2,1,Constants.LETTER_X);
        board3.addMark(2,2,Constants.LETTER_O);


        xRP.setBoard(board);
        xRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        } else if (testEqual(board,board2)) {
            assertTrue(true);
        } else if (testEqual(board,board3)) {
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in random play");
        }

    }

    @Test
    void oRP_makeMove_Test1() {
        board.addMark(0,0,Constants.LETTER_X);
        board.addMark(0,1,Constants.LETTER_X);
        board.addMark(0,2,Constants.LETTER_X);

        board.addMark(1,0,Constants.LETTER_X);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.LETTER_X);

        board.addMark(2,0,Constants.LETTER_X);
        board.addMark(2,1,Constants.LETTER_X);
        board.addMark(2,2,Constants.LETTER_X);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_X);
        board1.addMark(0,1,Constants.LETTER_X);
        board1.addMark(0,2,Constants.LETTER_X);

        board1.addMark(1,0,Constants.LETTER_X);
        board1.addMark(1,1,Constants.LETTER_O);
        board1.addMark(1,2,Constants.LETTER_X);

        board1.addMark(2,0,Constants.LETTER_X);
        board1.addMark(2,1,Constants.LETTER_X);
        board1.addMark(2,2,Constants.LETTER_X);


        oRP.setBoard(board);
        oRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in random play");
        }

    }

    @Test
    void oRP_makeMove_Test2() {
        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.LETTER_O);
        board.addMark(0,2,Constants.LETTER_O);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.LETTER_O);

        board.addMark(2,0,Constants.LETTER_X);
        board.addMark(2,1,Constants.LETTER_X);
        board.addMark(2,2,Constants.LETTER_X);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_O);
        board1.addMark(0,1,Constants.LETTER_O);
        board1.addMark(0,2,Constants.LETTER_O);

        board1.addMark(1,0,Constants.LETTER_O);
        board1.addMark(1,1,Constants.SPACE_CHAR);
        board1.addMark(1,2,Constants.LETTER_O);

        board1.addMark(2,0,Constants.LETTER_X);
        board1.addMark(2,1,Constants.LETTER_X);
        board1.addMark(2,2,Constants.LETTER_X);

        Board board2 = new Board();

        board2.addMark(0,0,Constants.LETTER_O);
        board2.addMark(0,1,Constants.LETTER_O);
        board2.addMark(0,2,Constants.LETTER_O);

        board2.addMark(1,0,Constants.SPACE_CHAR);
        board2.addMark(1,1,Constants.LETTER_O);
        board2.addMark(1,2,Constants.LETTER_O);

        board2.addMark(2,0,Constants.LETTER_X);
        board2.addMark(2,1,Constants.LETTER_X);
        board2.addMark(2,2,Constants.LETTER_X);



        oRP.setBoard(board);
        oRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        } else if (testEqual(board,board2)) {
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in random play");
        }


    }


}
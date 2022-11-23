package ttt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();

    @Test
    void xWins() {
        board.addMark(0,0,Constants.LETTER_X);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_X);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_X);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkWinner(Constants.LETTER_X),"fail to check xWins");

        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_X);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_X);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertFalse(board.checkWinner(Constants.LETTER_X),"fail to check xWins");
    }

    @Test
    void oWins() {
        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.oWins(),"fail to check oWins");

        board.addMark(0,0,Constants.LETTER_X);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertFalse(board.oWins(),"fail to check oWins");
    }

    @Test
    void checkWinner() {
        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkWinner(Constants.LETTER_O),"fail to pass Winner test for Horizontal");

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.LETTER_O);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkWinner(Constants.LETTER_O),"fail to pass Winner test for vertical");

        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.LETTER_O);

        assertTrue(board.checkWinner(Constants.LETTER_O),"fail to pass winner test for diagonal case 1");

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.LETTER_O);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkWinner(Constants.LETTER_O),"fail to pass winner test for diagonal case 2");


    }

    @Test
    void checkHorizontal() {

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.LETTER_O);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkHorizontal(Constants.LETTER_O),"fail to pass Horizontal test");

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_X);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.LETTER_O);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertFalse(board.checkHorizontal(Constants.LETTER_O),"fail to pass Horizontal test");
    }

    @Test
    void checkVertical() {

        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        //board.display();

        assertTrue(board.checkVertical(Constants.LETTER_O),"fail to pass vertical test");

        board.addMark(0,0,Constants.LETTER_X);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.LETTER_O);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        //board.display();

        assertFalse(board.checkVertical(Constants.LETTER_O),"fail to pass vertical test");

    }

    @Test
    void checkDiagonal() {
        board.addMark(0,0,Constants.LETTER_O);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.LETTER_O);

        assertTrue(board.checkDiagonal(Constants.LETTER_O),"fail to pass diagonal test");

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.LETTER_O);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_O);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertTrue(board.checkDiagonal(Constants.LETTER_O),"fail to pass diagonal test");

        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.LETTER_O);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_O);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.LETTER_X);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        assertFalse(board.checkDiagonal(Constants.LETTER_O),"fail to pass diagonal test");

    }
}
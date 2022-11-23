package ttt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPlayerTest {

    Board board = new Board();
    SmartPlayer xRP = new SmartPlayer("xPR",Constants.LETTER_X);
    SmartPlayer oRP = new SmartPlayer("oPR",Constants.LETTER_O);

    SmartPlayerTest() throws Exception {
    }

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
    void makeMoveTest1() {
        board.addMark(0,0,Constants.SPACE_CHAR);
        board.addMark(0,1,Constants.SPACE_CHAR);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.LETTER_X);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.LETTER_X);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_X);
        board1.addMark(0,1,Constants.SPACE_CHAR);
        board1.addMark(0,2,Constants.SPACE_CHAR);

        board1.addMark(1,0,Constants.SPACE_CHAR);
        board1.addMark(1,1,Constants.LETTER_X);
        board1.addMark(1,2,Constants.SPACE_CHAR);

        board1.addMark(2,0,Constants.SPACE_CHAR);
        board1.addMark(2,1,Constants.SPACE_CHAR);
        board1.addMark(2,2,Constants.LETTER_X);


        xRP.setBoard(board);
        xRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        }
        else{
            board.display();
            board1.display();
            fail("Unexpected behavior in smart play");

        }
    }

    @Test
    void makeMoveTest2() {
        board.addMark(0,0,Constants.LETTER_X);
        board.addMark(0,1,Constants.LETTER_X);
        board.addMark(0,2,Constants.SPACE_CHAR);

        board.addMark(1,0,Constants.SPACE_CHAR);
        board.addMark(1,1,Constants.SPACE_CHAR);
        board.addMark(1,2,Constants.SPACE_CHAR);

        board.addMark(2,0,Constants.SPACE_CHAR);
        board.addMark(2,1,Constants.SPACE_CHAR);
        board.addMark(2,2,Constants.SPACE_CHAR);

        Board board1 = new Board();

        board1.addMark(0,0,Constants.LETTER_X);
        board1.addMark(0,1,Constants.LETTER_X);
        board1.addMark(0,2,Constants.LETTER_X);

        board1.addMark(1,0,Constants.SPACE_CHAR);
        board1.addMark(1,1,Constants.SPACE_CHAR);
        board1.addMark(1,2,Constants.SPACE_CHAR);

        board1.addMark(2,0,Constants.SPACE_CHAR);
        board1.addMark(2,1,Constants.SPACE_CHAR);
        board1.addMark(2,2,Constants.SPACE_CHAR);


        xRP.setBoard(board);
        xRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in smart play");
        }
    }


    @Test
    void opponentMarkTest1() {
        char opp = oRP.opponentMark();
        assertEquals(opp,Constants.LETTER_X);
    }

    @Test
    void opponentMarkTest2() {
        char opp = xRP.opponentMark();
        assertEquals(opp,Constants.LETTER_O);
    }
}
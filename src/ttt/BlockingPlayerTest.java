package ttt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockingPlayerTest implements Constants{

    Board board = new Board();
    BlockingPlayer xRP = new BlockingPlayer("xPR",Constants.LETTER_X);
    BlockingPlayer oRP = new BlockingPlayer("oPR",Constants.LETTER_O);

    BlockingPlayerTest() throws Exception {
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

        board1.addMark(0,0,Constants.LETTER_O);
        board1.addMark(0,1,Constants.SPACE_CHAR);
        board1.addMark(0,2,Constants.SPACE_CHAR);

        board1.addMark(1,0,Constants.SPACE_CHAR);
        board1.addMark(1,1,Constants.LETTER_X);
        board1.addMark(1,2,Constants.SPACE_CHAR);

        board1.addMark(2,0,Constants.SPACE_CHAR);
        board1.addMark(2,1,Constants.SPACE_CHAR);
        board1.addMark(2,2,Constants.LETTER_X);


        oRP.setBoard(board);
        oRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        }
        else{
            board.display();
            board1.display();
            fail("Unexpected behavior in blocking play");
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
        board1.addMark(0,2,Constants.LETTER_O);

        board1.addMark(1,0,Constants.SPACE_CHAR);
        board1.addMark(1,1,Constants.SPACE_CHAR);
        board1.addMark(1,2,Constants.SPACE_CHAR);

        board1.addMark(2,0,Constants.SPACE_CHAR);
        board1.addMark(2,1,Constants.SPACE_CHAR);
        board1.addMark(2,2,Constants.SPACE_CHAR);


        oRP.setBoard(board);
        oRP.makeMove();

        if(testEqual(board,board1)){
            assertTrue(true);
        }
        else{
            fail("Unexpected behavior in blocking play");
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
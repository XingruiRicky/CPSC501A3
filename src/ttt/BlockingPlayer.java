package ttt;

public class BlockingPlayer extends RandomPlayer implements Constants, Empty{


    public static int pfi = 2;
    private static String pss = "PUBLIC STATIC STRING";
    private static SomeObject so = new SomeObject(123);


    //RandomGenerator random;
    public BlockingPlayer(String name, char letter) throws Exception{
        super(name, letter);
    }

    private BlockingPlayer(char letter, String name, Integer num) throws Exception{
        super(name, letter);
    }


    public boolean noBlocking() {
        char m = opponentMark();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getMark(i, j) == Constants.SPACE_CHAR) {
                    board.addMark(i, j, m);
                    if (board.checkWinner(m)) {
                        board.decreaseNum();
                        board.addMark(i, j, mark);
                        return false;
                    }
                    board.decreaseNum();
                    board.decreaseNum();
                    board.addMark(i, j, Constants.SPACE_CHAR);
                }
            }
        }
        return true;
    }

    public void makeMove() {
        if (noBlocking()) {
            super.makeMove();
        }
    }


    synchronized char opponentMark() throws NullPointerException{
        if (mark == Constants.LETTER_O) {
            return Constants.LETTER_X;
        } else {
            return Constants.LETTER_O;
        }
    }

}

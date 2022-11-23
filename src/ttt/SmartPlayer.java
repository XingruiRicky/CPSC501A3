package ttt;

class SmartPlayer extends BlockingPlayer{

    //RandomGenerator random;

    public SmartPlayer(String name, char letter) throws Exception {
        super(name, letter);
    }

    public boolean noWinning() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getMark(i, j) == Constants.SPACE_CHAR) {
                    board.addMark(i, j, mark);
                    if (board.checkWinner(mark)) {
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
        if (noWinning()) {
            super.makeMove();
        }
    }

}

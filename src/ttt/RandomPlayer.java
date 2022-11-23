package ttt;

import java.util.Random;

public class RandomPlayer extends Player implements Constants, Empty{
    //RandomGenerator random;

    public RandomPlayer(String name, char letter) {
        super(name, letter);
    }

    public void makeMove() {
        while (true) {
            int r = discrete(0, 2);
            int c = discrete(0, 2);
            if (board.getMark(r, c) == Constants.SPACE_CHAR) {
                board.addMark(r, c, mark);
                break;
            }
        }
    }

    private int discrete(int lo, int hi) {
        if (lo >= hi) {
            System.out.println("Error discrete, lo >= hi");
            System.exit(0);
        }

        Random r = new Random();
        int d = r.nextInt(hi - lo + 1) + lo;
        return d;
    }
}

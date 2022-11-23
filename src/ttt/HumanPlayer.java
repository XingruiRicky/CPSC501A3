package ttt;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char letter) {
        super(name, letter);
    }

    public void makeMove() {
        boolean done = true;
        while (done) {
            System.out.println(name + ", what row should your next " + mark + " be placed in?");
            Scanner scan = new Scanner(System.in);
            int row = scan.nextInt();
            System.out.println(name + ", what column should your next " + mark + " be placed in?");
            int col = scan.nextInt();
            if (board.getMark(row, col) == Constants.SPACE_CHAR) {
                board.addMark(row, col, mark);
                done = false;
            } else {
                System.out.println("Sorry, there have been already exits a mark!!!\nPlease try again!!!");
            }
        }
    }

}

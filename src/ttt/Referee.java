package ttt;

/**
 * The overall purpose of this code: To create a referee to control game
 *
 * @author Xiangyu Liu
 * @version 1.0
 * @since Feb. 7, 2020  1:19:23 a.m.
 */
public class Referee {
    /**
     * Create a x mark player
     */
    Player xPlayer;
    /**
     * Create a o mark player
     */
    Player oPlayer;
    /**
     * play bpard
     */
    Board board;

    /**
     * to start the game
     */
    public void runTheGame() {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        board.display();
        xPlayer.play();
    }


    /**
     * A setter for oplayer
     *
     * @param oPlayer
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * A setter for xPlayer
     *
     * @param xPlayer
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    /**
     * Setter for board
     *
     * @param board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

}

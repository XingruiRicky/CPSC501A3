package ttt;

/**
 * The overall purpose of this code: To create the main players
 *
 * @author Xiangyu Liu
 * @version 1.0
 * @since Feb. 7, 2020  1:15:17 a.m.
 */
public abstract class Player implements Constants{
    /**
     * Player's name
     */
    String name;
    /**
     * create a board
     */
    Board board;
    /**
     * Create a opponent
     */
    Player opponent;
    /**
     * the mark that player hold
     */
    char mark;

    /**
     * Constructor of Player
     *
     * @param name
     * @param letter
     */
    public Player(String name, char letter) {
        this.name = name;
        this.mark = letter;
    }

    /**
     * A setter for opponent
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * A setter for Board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * The moment of player in the game
     */
    public abstract void makeMove();


    /**
     * The processing of play game
     */
    public void play() {
        while (true) {
            if (!board.oWins() && !board.xWins() && !board.isFull()) {
                makeMove();
            } else if (board.oWins() || board.xWins()) {
                System.out.println("Congratulation!!! " + opponent.name + " win the game!!!");
                break;
            } else if (board.isFull()) {
                System.out.println("The game is end.");
                break;
            }
            board.display();
            board.checkWinner(mark);
            setOpponent(opponent);

            if (!board.oWins() && !board.xWins() && !board.isFull()) {
                opponent.makeMove();
            } else if (board.oWins() || board.xWins()) {
                System.out.println("Congratulation!!! " + name + " win the game!!!");
                break;
            } else if (board.isFull()) {
                System.out.println("The game is end.");
                break;
            }
            board.display();
            board.checkWinner(mark);
            setOpponent(opponent);
        }

    }

}









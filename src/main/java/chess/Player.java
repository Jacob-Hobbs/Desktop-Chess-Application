
package chess;

/**
 * @author Jacob
 */

/**
 * Player class utilized to instantiate and define player objects.
 * */
public class Player {
    
    private String currentPlayer;

    /**
     * Player constructor. Default currentPlayer set to white in keeping with
     * rules of chess.
     * */
    public Player() {
        this.currentPlayer = "WHITE";
    }

    /**
     * Setter method for current player.
     * */
    public void setCurrentPlayer(String player) {
        this.currentPlayer = player;
    }

    /**
     * Getter method for current player.
     * */
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

}

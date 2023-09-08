
package chess;

/**
 *
 * @author Jacob
 */
public class Player {
    
    private String currentPlayer;

    
    public Player() {
        this.currentPlayer = "WHITE";
    }
    
    public void setCurrentPlayer(String player) {
        this.currentPlayer = player;
    }
    
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }

    
}

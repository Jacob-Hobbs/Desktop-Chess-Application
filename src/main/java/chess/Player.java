
package chess;

/**
 *
 * @author Jacob
 */
public class Player {
    
    private String currentPlayer;
    private String winner;
    
    public Player() {
        this.currentPlayer = "WHITE";
        this.winner = "NONE";
    }
    
    public void setCurrentPlayer(String player) {
        this.currentPlayer = player;
    }
    
    public String getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getWinner() {
        return this.winner;
    }
    
}

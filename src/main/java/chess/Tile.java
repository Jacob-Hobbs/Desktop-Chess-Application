
package chess;

import javafx.scene.control.Button;

/**
 *
 * @author Jacob
 */
public class Tile {
    
    private Button button;
    private int xCoordinate;
    private int yCoordinate;
    private int pieceOccupyID;
    private String pieceColor;
    
    
    public Tile(Button button, int xCoordinate, int yCoordinate, int pieceOccupyID, String pieceColor) {
        this.button = button;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pieceOccupyID = pieceOccupyID;
        this.pieceColor = pieceColor;
    }
    
    public Button getTileButton() {
        return this.button;
    }
 
    public int getXCoordinate() {
        return this.xCoordinate;
    }
    
    public int getYCoordinate() {
        return this.yCoordinate;
    }
    
    public int getPieceID() {
        return this.pieceOccupyID;
    }
    
    public void setPieceID(int idNum) {
        this.pieceOccupyID = idNum;
    }
    
    public String getPieceColor() {
        return this.pieceColor;
    }
    
    public void setPieceColor(String color) {
        this.pieceColor = color;
    }
    
    
    
    
    
    
    
}

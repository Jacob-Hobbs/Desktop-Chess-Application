
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
    private Boolean enPassantDanger;
    private Boolean checkDangerWhite;
    private Boolean checkDangerBlack;
    
    
    public Tile(Button button, int xCoordinate, int yCoordinate, int pieceOccupyID, String pieceColor, boolean enPassantDanger, boolean checkDangerWhite, 
            boolean checkDangerBlack) {
        this.button = button;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pieceOccupyID = pieceOccupyID;
        this.pieceColor = pieceColor;
        this.enPassantDanger = false;
        this.checkDangerWhite = false;
        this.checkDangerBlack = false;
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
    
    public void setEnPassantDanger(Boolean trueOrFalse) {
        this.enPassantDanger = trueOrFalse;
    }
    
    public Boolean getEnPassantDanger() {
        return this.enPassantDanger;
    }
    
    public void setCheckDangerWhite(Boolean trueOrFalse) {
        this.checkDangerWhite = trueOrFalse;
    }
    
    public Boolean getCheckDangerWhite() {
        return this.checkDangerWhite;
    }
    
    public void setCheckDangerBlack(Boolean trueOrFalse) {
        this.checkDangerBlack = trueOrFalse;
    }
    
    public Boolean getCheckDangerBlack() {
        return this.checkDangerBlack;
    }
    
    
    
    
    
    
    
    
}

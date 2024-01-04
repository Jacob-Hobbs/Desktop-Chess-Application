/**
 * @author Jacob Hobbs
 */

package chess;

import javafx.scene.control.Button;

/**
 * Tile class for instantiating tile objects.
 *
 * Tile objects contain the intractable buttons, coordinates of piece, pieceID, piece color,
 * en passant danger boolean, white danger boolean, and the black danger boolean.
 * */
public class Tile {
    
    private Button button;
    private int xCoordinate;
    private int yCoordinate;
    private int pieceOccupyID;
    private String pieceColor;

    /**
     * enPassantDanger (True = pawn is in danger of being taken via en passant)
     * */
    private Boolean enPassantDanger;
    /**
     * checkDangerWhite (True = white piece is in danger of being taken by opposing black piece)
     * */
    private Boolean checkDangerWhite;
    /**
     * checkDangerBlack (True = black piece is in danger of being taken by opposing white piece)
     * */
    private Boolean checkDangerBlack;

    /**
     * Tile constructor. Defines default tile object attributes.
     * */
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

    /**
     * Tile Button getter method
     * */
    public Button getTileButton() {
        return this.button;
    }

    /**
     * x-coordinate getter method
     * */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * y-coordinate getter method
     * */
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Piece ID getter method
     * */
    public int getPieceID() {
        return this.pieceOccupyID;
    }

    /**
     * Piece ID setter method
     * */
    public void setPieceID(int idNum) {
        this.pieceOccupyID = idNum;
    }

    /**
     * Piece color getter method
     * */
    public String getPieceColor() {
        return this.pieceColor;
    }

    /**
     * Piece color setter method
     * */
    public void setPieceColor(String color) {
        this.pieceColor = color;
    }

    /**
     * En Passant Danger setter method
     * */
    public void setEnPassantDanger(Boolean trueOrFalse) {
        this.enPassantDanger = trueOrFalse;
    }

    /**
     * En Passant Danger getter method
     * */
    public Boolean getEnPassantDanger() {
        return this.enPassantDanger;
    }

    /**
     * White Check Danger setter method
     * */
    public void setCheckDangerWhite(Boolean trueOrFalse) {
        this.checkDangerWhite = trueOrFalse;
    }

    /**
     * White Check Danger getter method
     * */
    public Boolean getCheckDangerWhite() {
        return this.checkDangerWhite;
    }

    /**
     * Black Check Danger setter method
     * */
    public void setCheckDangerBlack(Boolean trueOrFalse) {
        this.checkDangerBlack = trueOrFalse;
    }

    /**
     * Black Check Danger getter method
     * */
    public Boolean getCheckDangerBlack() {
        return this.checkDangerBlack;
    }

}

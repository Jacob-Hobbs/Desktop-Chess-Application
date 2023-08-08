
package chessPieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jacob
 */
public abstract class Piece {
    
    // BLACK or WHITE
    public String color;
    // Image of piece
    public Pane pane;
    // Piece is on board (FALSE), opposite (TRUE)
    public boolean captured;
    // ID number
    public int pieceID;
    // Position
    public int[][] position;
    public int xPosition;
    public int yPosition;
    
    // Constructor
    public void Piece() {
        this.color = color;
        this.pane = new Pane();
        this.captured = false;
        this.pieceID = 1;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.position = new int[xPosition][yPosition];
    }
    
    //public void setPosition(Piece piece, int xPosition, int yPosition) {
        //piece = position[xPosition][yPosition];
    //}
    
    // Sets piece to captured
    public void setCaptured(Piece piece) {
        piece.captured = true;
    }
    
    public void setNotCaptured(Piece piece) {
        piece.captured = false;
    }
    
    public boolean isCaptured(Piece piece) {
        return piece.captured;
    }
    
    public void setPieceID(Piece piece, int newID) {
        piece.pieceID = newID;
    }
    
    public int getPieceID(Piece piece, int ID) {
        return piece.pieceID;
    }
    
    public void setColor(Piece piece, String assignedColor) {
        piece.color = assignedColor;
    }
    
    public String getColor(Piece piece) {
        return piece.color;
    }
    
    public void setImage(String color) {

    }
    
    public Pane getImage(String color) {
        return pane;
    }
    
    public void move() {
        
    }
    
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whitePawn.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackPawn.png");
            image = new ImageView(imageFile);
        }
        return image;
    }
    
    
    
    
    
   
    
    
    
    
}

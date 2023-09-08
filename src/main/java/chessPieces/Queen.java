
package chessPieces;

import chess.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jacob
 */
public class Queen implements Piece {
    private Bishop bishop;
    private Rook rook;
    private Boolean blackQueenHasMoved;
    private Boolean whiteQueenHasMoved;
    
    public Queen() {
        this.bishop = new Bishop();
        this.rook = new Rook();
        this.blackQueenHasMoved = false;
        this.whiteQueenHasMoved = false;
    }
    
     public void setCheckDangerTile(Tile[][] tile2DArray, int x, int y, String color) {
        
        if (color.equals("WHITE")) {
            bishop.setCheckDangerTile(tile2DArray, x, y, color);
            rook.setCheckDangerTile(tile2DArray, x, y, color);
        } else if (color.equals("BLACK")) {
            bishop.setCheckDangerTile(tile2DArray, x, y, color);
            rook.setCheckDangerTile(tile2DArray, x, y, color);
        }
    }
    
    public Boolean getBlackQueenHasMoved() {
        return this.blackQueenHasMoved;
    }
    
    public void setBlackQueenHasMoved(Boolean trueOrFalse) {
        this.blackQueenHasMoved = trueOrFalse;
    }
    
    public Boolean getWhiteQueenHasMoved() {
        return this.whiteQueenHasMoved;
    }
    
    public void setWhiteQueenHasMoved(Boolean trueOrFalse) {
        this.whiteQueenHasMoved = trueOrFalse;
    }

    @Override  
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
            image = new ImageView(imageFile);
        }
        return image;
    }
    
    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
    
        if (bishop.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile) || 
        rook.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile)) {
            
            if (xFirstTile == 4 && yFirstTile == 1) {
                setBlackQueenHasMoved(true);
            }
            if (xFirstTile == 4 && yFirstTile == 8) {
                setWhiteQueenHasMoved(true);
            }
            
            return true;
        }
        return false;
        
    }
    
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
    
        if (bishop.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile) || 
        rook.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile)) {
            
            return true;
        }
        return false;
        
    }
}

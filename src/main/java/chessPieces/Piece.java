/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public interface Piece {    
    
    ImageView getImageView(String color);
    
    boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile);

}

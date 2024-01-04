/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import javafx.scene.image.ImageView;

/**
 * Pieces interface used as contract for individual piece classes.
 * */
public interface Piece {    

    /**
     * Every piece must override method signature to retrieve its image view.
     * */
    ImageView getImageView(String color);

    /**
     * Every piece must override method signature to determine if proposed piece movement
     * is valid.
     * */
    boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile);

}

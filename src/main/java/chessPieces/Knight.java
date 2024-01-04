/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Knight class used to instantiate Knight piece objects for manipulation.
 * */
public class Knight implements Piece {
    
    private Boolean leftBlackHasMoved;
    private Boolean rightBlackHasMoved;
    private Boolean leftWhiteHasMoved;
    private Boolean rightWhiteHasMoved;

    /**
     * Knight constructor.
     * */
    public Knight() {
        this.leftBlackHasMoved = false;
        this.rightBlackHasMoved = false;
        this.leftWhiteHasMoved = false;
        this.rightWhiteHasMoved = false;
    }

    /**
     * setCheckDangerTile method used to set corresponding danger boolean for pieces after knight moves.
     * */
    public void setCheckDangerTile(Tile[][] tile2DArray, int x1, int y1, String color) {

        if (color.equals("WHITE")) {
            
            if (x1 == 1 && y1 == 1) {
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (2,1)
            } else if (x1 == 2 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (3,1), (4,1), (5,1), or (6,1)
            } else if ((x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) || (x1 == 5 && y1 == 1) ||
                    (x1 == 6 && y1 == 1)) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (7,1)
            } else if (x1 == 7 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (8,1)
            } else if (x1 == 8 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (1,2)
            } else if (x1 == 1 && y1 == 2) {
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (2,2)
            } else if (x1 == 2 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (3,2), (4,2), (5,2), or (6,2)
            } else if ((x1 == 3 && y1 == 2) || (x1 == 4 && y1 == 2) || (x1 == 5 && y1 == 2) ||
                    (x1 == 6 && y1 == 2)) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (7,2)
            } else if (x1 == 7 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (8,2)
            } else if (x1 == 8 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (1,3), (1,4), (1,5), or (1,6)
            } else if ((x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) || (x1 == 1 && y1 == 5) ||
                    (x1 == 1 && y1 == 6)) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (2,3), (2,4), (2,5), or (2,6)
            } else if ((x1 == 2 && y1 == 3) || (x1 == 2 && y1 == 4) || (x1 == 2 && y1 == 5) ||
                    (x1 == 2 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (7,3), (7,4), (7,5), or (7,6)
            } else if ((x1 == 7 && y1 == 3) || (x1 == 7 && y1 == 4) || (x1 == 7 && y1 == 5) ||
                    (x1 == 7 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (8,3), (8,4), (8,5), or (8,6)
            } else if ((x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) || (x1 == 8 && y1 == 5) ||
                    (x1 == 8 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (1,7)
            } else if (x1 == 1 && y1 == 7) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (2,7)
            } else if (x1 == 2 && y1 == 7) {
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (3,7), (4,7), (5,7), or (6,7)
            } else if ((x1 == 3 && y1 == 7) || (x1 == 4 && y1 == 7) || (x1 == 5 && y1 == 7) ||
                    (x1 == 6 && y1 == 7)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (7,7)
            } else if (x1 == 7 && y1 == 7) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (8,7)
            } else if (x1 == 8 && y1 == 7) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (1,8)
            } else if (x1 == 1 && y1 == 8) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (2,8)
            } else if (x1 == 2 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (3,8), (4,8), (5,8), or (6,8)
            } else if ((x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) || (x1 == 5 && y1 == 8) ||
                    (x1 == 6 && y1 == 8)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (7,8)
            } else if (x1 == 7 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            // if knight is at tile (8,8)
            } else if (x1 == 8 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            // all other knight origin tiles
            } else {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            }

        } else if (color.equals("BLACK")) {
            
            if (x1 == 1 && y1 == 1) {
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (2,1)
            } else if (x1 == 2 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (3,1), (4,1), (5,1), or (6,1)
            } else if ((x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) || (x1 == 5 && y1 == 1) ||
                    (x1 == 6 && y1 == 1)) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (7,1)
            } else if (x1 == 7 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (8,1)
            } else if (x1 == 8 && y1 == 1) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (1,2)
            } else if (x1 == 1 && y1 == 2) {
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (2,2)
            } else if (x1 == 2 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (3,2), (4,2), (5,2), or (6,2)
            } else if ((x1 == 3 && y1 == 2) || (x1 == 4 && y1 == 2) || (x1 == 5 && y1 == 2) ||
                    (x1 == 6 && y1 == 2)) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (7,2)
            } else if (x1 == 7 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (8,2)
            } else if (x1 == 8 && y1 == 2) {
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (1,3), (1,4), (1,5), or (1,6)
            } else if ((x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) || (x1 == 1 && y1 == 5) ||
                    (x1 == 1 && y1 == 6)) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (2,3), (2,4), (2,5), or (2,6)
            } else if ((x1 == 2 && y1 == 3) || (x1 == 2 && y1 == 4) || (x1 == 2 && y1 == 5) ||
                    (x1 == 2 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (7,3), (7,4), (7,5), or (7,6)
            } else if ((x1 == 7 && y1 == 3) || (x1 == 7 && y1 == 4) || (x1 == 7 && y1 == 5) ||
                    (x1 == 7 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (8,3), (8,4), (8,5), or (8,6)
            } else if ((x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) || (x1 == 8 && y1 == 5) ||
                    (x1 == 8 && y1 == 6)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (1,7)
            } else if (x1 == 1 && y1 == 7) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (2,7)
            } else if (x1 == 2 && y1 == 7) {
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (3,7), (4,7), (5,7), or (6,7)
            } else if ((x1 == 3 && y1 == 7) || (x1 == 4 && y1 == 7) || (x1 == 5 && y1 == 7) ||
                    (x1 == 6 && y1 == 7)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (7,7)
            } else if (x1 == 7 && y1 == 7) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (8,7)
            } else if (x1 == 8 && y1 == 7) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (1,8)
            } else if (x1 == 1 && y1 == 8) {
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (2,8)
            } else if (x1 == 2 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (3,8), (4,8), (5,8), or (6,8)
            } else if ((x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) || (x1 == 5 && y1 == 8) ||
                    (x1 == 6 && y1 == 8)) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (7,8)
            } else if (x1 == 7 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            // if knight is at tile (8,8)
            } else if (x1 == 8 && y1 == 8) {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            // all other knight origin tiles
            } else {
                tile2DArray[(x1-1) - 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 2].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 2][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            }
        }
    }

    /**
     * getLeftBlackHasMoved getter method for left black knight movement.
     * */
    public Boolean getLeftBlackHasMoved() {
        return this.leftBlackHasMoved;
    }

    /**
     * setLeftBlackHasMoved setter method for left black knight movement.
     * */
    public void setLeftBlackHasMoved(Boolean trueOrFalse) {
        this.leftBlackHasMoved = trueOrFalse;
    }

    /**
     * getRightBlackHasMoved getter method for right black knight movement.
     * */
    public Boolean getRightBlackHasMoved() {
        return this.rightBlackHasMoved;
    }

    /**
     * setRightBlackHasMoved setter method for right black knight movement.
     * */
    public void setRightBlackHasMoved(Boolean trueOrFalse) {
        this.rightBlackHasMoved = trueOrFalse;
    }

    /**
     * getLeftWhiteHasMoved getter method for left white knight movement.
     * */
    public Boolean getLeftWhiteHasMoved() {
        return this.leftWhiteHasMoved;
    }

    /**
     * setLeftWhiteHasMoved setter method for left white knight movement.
     * */
    public void setLeftWhiteHasMoved(Boolean trueOrFalse) {
        this.leftWhiteHasMoved = trueOrFalse;
    }

    /**
     * getRightWhiteHasMoved getter method for right white knight movement.
     * */
    public Boolean getRightWhiteHasMoved() {
        return this.rightWhiteHasMoved;
    }

    /**
     * setRightWhiteHasMoved setter method for right white knight movement.
     * */
    public void setRightWhiteHasMoved(Boolean trueOrFalse) {
        this.rightWhiteHasMoved = trueOrFalse;
    }

    /**
     * getImageView method retrieves image view of black/white knight sprite.
     * */
    @Override
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackKnight.png");
            image = new ImageView(imageFile);
        }
        return image;
    }

    /**
     * canPieceMove method checks if movement is valid for a knight type.
     * Exceptions are manually handled through program logic.
     * */
    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int x1, int y1, int x2, int y2) {
        
        int returnNum = 0;
        int moveOne = knightMoveOne(x1, y1, x2, y2);
        int moveTwo = knightMoveTwo(x1, y1, x2, y2);
        int moveThree = knightMoveThree(x1, y1, x2, y2);
        int moveFour = knightMoveFour(x1, y1, x2, y2);
        int moveFive = knightMoveFive(x1, y1, x2, y2);
        int moveSix = knightMoveSix(x1, y1, x2, y2);
        int moveSeven = knightMoveSeven(x1, y1, x2, y2);
        int moveEight = knightMoveEight(x1, y1, x2, y2);
        
        // if knight is moving from tile (1,1)
        if (x1 == 1 && y1 == 1) {
            returnNum += moveFour + moveEight;
        // if knight is moving from tile (2,1)
        } else if (x1 == 2 && y1 == 1) {
            returnNum += moveThree + moveFour + moveEight;
        // if knight is moving from tile (3,1), (4,1), (5,1), or (6,1)
        } else if ((x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) || (x1 == 5 && y1 == 1) ||
                (x1 == 6 && y1 == 1)) {
            returnNum += moveThree + moveFour + moveSix + moveEight;
        // if knight is moving from tile (7,1)
        } else if (x1 == 7 && y1 == 1) {
            returnNum += moveThree + moveFour + moveSix;
        // if knight is moving from tile (8,1)
        } else if (x1 == 8 && y1 == 1) {
            returnNum += moveThree + moveSix;
        // if knight is moving from tile (1,2)
        } else if (x1 == 1 && y1 == 2) {
            returnNum += moveFour + moveSeven + moveEight;
        // if knight is moving from tile (2,2)
        } else if (x1 == 2 && y1 == 2) {
            returnNum += moveThree + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (3,2), (4,2), (5,2), or (6,2)
        } else if ((x1 == 3 && y1 == 2) || (x1 == 4 && y1 == 2) || (x1 == 5 && y1 == 2) ||
                (x1 == 6 && y1 == 2)) {
            returnNum += moveThree + moveFour + moveFive + moveSix + moveSeven + moveEight;
        // if knight is moving from tile (7,2)
        } else if (x1 == 7 && y1 == 2) {
            returnNum += moveThree + moveFour + moveFive + moveSix;
        // if knight is moving from tile (8,2)
        } else if (x1 == 8 && y1 == 2) {
            returnNum += moveThree + moveFive + moveSix;
        // if knight is moving from tile (1,3), (1,4), (1,5), or (1,6)
        } else if ((x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) || (x1 == 1 && y1 == 5) ||
                (x1 == 1 && y1 == 6)) {
            returnNum += moveTwo + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (2,3), (2,4), (2,5), or (2,6)
        } else if ((x1 == 2 && y1 == 3) || (x1 == 2 && y1 == 4) || (x1 == 2 && y1 == 5) ||
                (x1 == 2 && y1 == 6)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (7,3), (7,4), (7,5), or (7,6)
        } else if ((x1 == 7 && y1 == 3) || (x1 == 7 && y1 == 4) || (x1 == 7 && y1 == 5) ||
                (x1 == 7 && y1 == 6)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix;
        // if knight is moving from tile (8,3), (8,4), (8,5), or (8,6)
        } else if ((x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) || (x1 == 8 && y1 == 5) ||
                (x1 == 8 && y1 == 6)) {
            returnNum += moveOne + moveThree + moveFive + moveSix;
        // if knight is moving from tile (1,7)
        } else if (x1 == 1 && y1 == 7) {
            returnNum += moveTwo + moveSeven + moveEight;
        // if knight is moving from tile (2,7)
        } else if (x1 == 2 && y1 == 7) {
            returnNum += moveOne + moveTwo + moveSeven + moveEight;
        // if knight is moving from tile (3,7), (4,7), (5,7), or (6,7)
        } else if ((x1 == 3 && y1 == 7) || (x1 == 4 && y1 == 7) || (x1 == 5 && y1 == 7) ||
                (x1 == 6 && y1 == 7)) {
            returnNum += moveOne + moveTwo + moveFive + moveSix + moveSeven + moveEight;
        // if knight is moving from tile (7,7)
        } else if (x1 == 7 && y1 == 7) {
            returnNum += moveOne + moveTwo + moveFive + moveSix;
        // if knight is moving from tile (8,7)
        } else if (x1 == 8 && y1 == 7) {
            returnNum += moveOne + moveFive + moveSix;
        // if knight is moving from tile (1,8)
        } else if (x1 == 1 && y1 == 8) {
            returnNum += moveTwo + moveSeven;
        // if knight is moving from tile (2,8)
        } else if (x1 == 2 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveSeven;
        // if knight is moving from tile (3,8), (4,8), (5,8), or (6,8)
        } else if ((x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) || (x1 == 5 && y1 == 8) ||
                (x1 == 6 && y1 == 8)) {
            returnNum += moveOne + moveTwo + moveFive + moveSeven;
        // if knight is moving from tile (7,8)
        } else if (x1 == 7 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveFive;
        // if knight is moving from tile (8,8)
        } else if (x1 == 8 && y1 == 8) {
            returnNum += moveOne + moveFive;
        // all other knight origin tiles
        } else {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix + 
                    moveSeven + moveEight;
        }
        
        if (returnNum == -1) {
            
            // if left black knight has moved, note that it has moved
            if (x1 == 2 && y1 == 1) {
                setLeftBlackHasMoved(true);     
            }
            // if right black knight has moved, note that it has moved
            if (x1 == 7 && y1 == 1) {
                setRightBlackHasMoved(true);
            }
            // if left white knight has moved, note that it has moved
            if (x1 == 2 && y1 == 8) {
                setLeftWhiteHasMoved(true);
            }
            // if right white knight has moved, note that it has moved
            if (x1 == 7 && y1 == 8) {
                setRightWhiteHasMoved(true);
            }

            return true;
        }
        //System.out.println("Failed due to: outside knight moveset");
        return false;
    }

    /**
     * The below methods define the 8 valid moves of a knight type
     * */
    private int knightMoveOne(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 1) && ySecondTile == (yFirstTile - 2)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveTwo(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 1) && ySecondTile == (yFirstTile - 2)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveThree(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 1) && ySecondTile == (yFirstTile + 2)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveFour(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 1) && ySecondTile == (yFirstTile + 2)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveFive(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 2) && ySecondTile == (yFirstTile - 1)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveSix(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 2) && ySecondTile == (yFirstTile + 1)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveSeven(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 2) && ySecondTile == (yFirstTile - 1)) {
            return -1;
        }
        return 0;
    }
    
    private int knightMoveEight(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 2) && ySecondTile == (yFirstTile + 1)) {
            return -1;
        }
        return 0;
    }

    /**
     * canPieceMoveCheckmateCheck method is specific method that determines if knight can move to prevent King
     * checkmate/check scenario.
     * */
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int x1, int y1, int x2, int y2) {
        
        int returnNum = 0;
        int moveOne = knightMoveOne(x1, y1, x2, y2);
        int moveTwo = knightMoveTwo(x1, y1, x2, y2);
        int moveThree = knightMoveThree(x1, y1, x2, y2);
        int moveFour = knightMoveFour(x1, y1, x2, y2);
        int moveFive = knightMoveFive(x1, y1, x2, y2);
        int moveSix = knightMoveSix(x1, y1, x2, y2);
        int moveSeven = knightMoveSeven(x1, y1, x2, y2);
        int moveEight = knightMoveEight(x1, y1, x2, y2);
        
        // if knight is moving from tile (1,1)
        if (x1 == 1 && y1 == 1) {
            returnNum += moveFour + moveEight;
        // if knight is moving from tile (2,1)
        } else if (x1 == 2 && y1 == 1) {
            returnNum += moveThree + moveFour + moveEight;
        // if knight is moving from tile (3,1), (4,1), (5,1), or (6,1)
        } else if ((x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) || (x1 == 5 && y1 == 1) ||
                (x1 == 6 && y1 == 1)) {
            returnNum += moveThree + moveFour + moveSix + moveEight;
        // if knight is moving from tile (7,1)
        } else if (x1 == 7 && y1 == 1) {
            returnNum += moveThree + moveFour + moveSix;
        // if knight is moving from tile (8,1)
        } else if (x1 == 8 && y1 == 1) {
            returnNum += moveThree + moveSix;
        // if knight is moving from tile (1,2)
        } else if (x1 == 1 && y1 == 2) {
            returnNum += moveFour + moveSeven + moveEight;
        // if knight is moving from tile (2,2)
        } else if (x1 == 2 && y1 == 2) {
            returnNum += moveThree + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (3,2), (4,2), (5,2), or (6,2)
        } else if ((x1 == 3 && y1 == 2) || (x1 == 4 && y1 == 2) || (x1 == 5 && y1 == 2) ||
                (x1 == 6 && y1 == 2)) {
            returnNum += moveThree + moveFour + moveFive + moveSix + moveSeven + moveEight;
        // if knight is moving from tile (7,2)
        } else if (x1 == 7 && y1 == 2) {
            returnNum += moveThree + moveFour + moveFive + moveSix;
        // if knight is moving from tile (8,2)
        } else if (x1 == 8 && y1 == 2) {
            returnNum += moveThree + moveFive + moveSix;
        // if knight is moving from tile (1,3), (1,4), (1,5), or (1,6)
        } else if ((x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) || (x1 == 1 && y1 == 5) ||
                (x1 == 1 && y1 == 6)) {
            returnNum += moveTwo + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (2,3), (2,4), (2,5), or (2,6)
        } else if ((x1 == 2 && y1 == 3) || (x1 == 2 && y1 == 4) || (x1 == 2 && y1 == 5) ||
                (x1 == 2 && y1 == 6)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveSeven + moveEight;
        // if knight is moving from tile (7,3), (7,4), (7,5), or (7,6)
        } else if ((x1 == 7 && y1 == 3) || (x1 == 7 && y1 == 4) || (x1 == 7 && y1 == 5) ||
                (x1 == 7 && y1 == 6)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix;
        // if knight is moving from tile (8,3), (8,4), (8,5), or (8,6)
        } else if ((x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) || (x1 == 8 && y1 == 5) ||
                (x1 == 8 && y1 == 6)) {
            returnNum += moveOne + moveThree + moveFive + moveSix;
        // if knight is moving from tile (1,7)
        } else if (x1 == 1 && y1 == 7) {
            returnNum += moveTwo + moveSeven + moveEight;
        // if knight is moving from tile (2,7)
        } else if (x1 == 2 && y1 == 7) {
            returnNum += moveOne + moveTwo + moveSeven + moveEight;
        // if knight is moving from tile (3,7), (4,7), (5,7), or (6,7)
        } else if ((x1 == 3 && y1 == 7) || (x1 == 4 && y1 == 7) || (x1 == 5 && y1 == 7) ||
                (x1 == 6 && y1 == 7)) {
            returnNum += moveOne + moveTwo + moveFive + moveSix + moveSeven + moveEight;
        // if knight is moving from tile (7,7)
        } else if (x1 == 7 && y1 == 7) {
            returnNum += moveOne + moveTwo + moveFive + moveSix;
        // if knight is moving from tile (8,7)
        } else if (x1 == 8 && y1 == 7) {
            returnNum += moveOne + moveFive + moveSix;
        // if knight is moving from tile (1,8)
        } else if (x1 == 1 && y1 == 8) {
            returnNum += moveTwo + moveSeven;
        // if knight is moving from tile (2,8)
        } else if (x1 == 2 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveSeven;
        // if knight is moving from tile (3,8), (4,8), (5,8), or (6,8)
        } else if ((x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) || (x1 == 5 && y1 == 8) ||
                (x1 == 6 && y1 == 8)) {
            returnNum += moveOne + moveTwo + moveFive + moveSeven;
        // if knight is moving from tile (7,8)
        } else if (x1 == 7 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveFive;
        // if knight is moving from tile (8,8)
        } else if (x1 == 8 && y1 == 8) {
            returnNum += moveOne + moveFive;
        // all other knight origin tiles
        } else {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix + 
                    moveSeven + moveEight;
        }
        
        if (returnNum == -1) {
            
            return true;
        }
        //System.out.println("Failed due to: outside knight moveset");
        return false;
    }
    
}

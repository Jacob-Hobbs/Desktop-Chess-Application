
package chessPieces;

import chess.Tile;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jacob
 */
public class Bishop implements Piece {
    
    private Boolean leftBlackHasMoved;
    private Boolean rightBlackHasMoved;
    private Boolean leftWhiteHasMoved;
    private Boolean rightWhiteHasMoved;
    
    public Bishop() {
        this.leftBlackHasMoved = false;
        this.rightBlackHasMoved = false;
        this.leftWhiteHasMoved = false;
        this.rightWhiteHasMoved = false;
    }
    
    public void setCheckDangerTile(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, String color) {
        
        if (color.equals("WHITE")) {
            
            int xTileOne = xFirstTile - 1;
            int yTileOne = yFirstTile - 1;
        
            // Creation of list to store diagonal tile considerations
            ArrayList<Integer> tilePairs = new ArrayList<>();
            // maximum number of tiles a bishop can transervse from each direction
        
            int topLeftDiagonalMax = getTopLeftTiles(xFirstTile, yFirstTile);
            int topRightDiagonalMax = getTopRightTiles(xFirstTile, yFirstTile);
            int bottomLeftDiagonalMax = getBottomLeftTiles(xFirstTile, yFirstTile);
            int bottomRightDiagonalMax = getBottomRightTiles(xFirstTile, yFirstTile);
            
            
            
                
            // setting first tile x and y to local variables
            int x = xFirstTile;
            int y = yFirstTile;

            // Check if move is within the maximum tile distribution of the top left diagonal
            for (int i = topLeftDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x -= 1;
                y -= 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x - 1][y - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x);
                    tilePairs.add(y);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x - 1][y - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x - 1][y - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x);
                    tilePairs.add(y);
                    i = 0;
                } else {
                    // no other possibility.
                }   
            }
            // if selected tile is within the tilePairs list, set white check danger to true!
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
                
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x2 = xFirstTile;
            int y2 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the top right diagonal
            for (int i = topRightDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x2 += 1;
                y2 -= 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x2);
                    tilePairs.add(y2);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x2);
                    tilePairs.add(y2);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                // THROWING ERROR
                // > OUT OF BOUNDS ERROR????
                //System.out.println(tilePairs.get(i) + ", " + tilePairs.get(i + 1));
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x3 = xFirstTile;
            int y3 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the bottom left diagonal
            for (int i = bottomLeftDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x3 -= 1;
                y3 += 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x3);
                    tilePairs.add(y3);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x3);
                    tilePairs.add(y3);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x4 = xFirstTile;
            int y4 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the bottom right diagonal
            for (int i = bottomRightDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x4 += 1;
                y4 += 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x4);
                    tilePairs.add(y4);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x4);
                    tilePairs.add(y4);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
            // clear out tilePairs list
            tilePairs.clear();
            
            
            
        } else if (color.equals("BLACK")) {
            
            int xTileOne = xFirstTile - 1;
            int yTileOne = yFirstTile - 1;
        
            // Creation of list to store diagonal tile considerations
            ArrayList<Integer> tilePairs = new ArrayList<>();
            // maximum number of tiles a bishop can transervse from each direction
        
            int topLeftDiagonalMax = getTopLeftTiles(xFirstTile, yFirstTile);
            int topRightDiagonalMax = getTopRightTiles(xFirstTile, yFirstTile);
            int bottomLeftDiagonalMax = getBottomLeftTiles(xFirstTile, yFirstTile);
            int bottomRightDiagonalMax = getBottomRightTiles(xFirstTile, yFirstTile);
            
            
            
                
            // setting first tile x and y to local variables
            int x = xFirstTile;
            int y = yFirstTile;

            // Check if move is within the maximum tile distribution of the top left diagonal
            for (int i = topLeftDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x -= 1;
                y -= 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x - 1][y - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x);
                    tilePairs.add(y);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x - 1][y - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x - 1][y - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x);
                    tilePairs.add(y);
                    i = 0;
                } else {
                    // no other possibility.
                }   
            }
            // if selected tile is within the tilePairs list, set white check danger to true!
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
                
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x2 = xFirstTile;
            int y2 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the top right diagonal
            for (int i = topRightDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x2 += 1;
                y2 -= 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x2);
                    tilePairs.add(y2);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x2);
                    tilePairs.add(y2);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                // THROWING ERROR
                // > OUT OF BOUNDS ERROR????
                //System.out.println(tilePairs.get(i) + ", " + tilePairs.get(i + 1));
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x3 = xFirstTile;
            int y3 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the bottom left diagonal
            for (int i = bottomLeftDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x3 -= 1;
                y3 += 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x3);
                    tilePairs.add(y3);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x3);
                    tilePairs.add(y3);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            // clear out tilePairs list for next diagonal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x4 = xFirstTile;
            int y4 = yFirstTile;
                
            // Check if move is within the maximum tile distribution of the bottom right diagonal
            for (int i = bottomRightDiagonalMax; i > 0; i--) {
                // move to next diagonal tile
                x4 += 1;
                y4 += 1;
                // if tile piece color is "NONE" then add x & y to tilePairs list.
                if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == "NONE") {
                    tilePairs.add(x4);
                    tilePairs.add(y4);
                // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    i = 0;
                // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                    tilePairs.add(x4);
                    tilePairs.add(y4);
                    i = 0;
                } else {
                    // no other possibility.
                }
            }
            // if selected tile (second tile) is within the tilePairs list, return true
            for (int i = 0; i < tilePairs.size() - 1; i+=2) {
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            // clear out tilePairs list
            tilePairs.clear();
            
        }
    }
    
    public Boolean getLeftBlackHasMoved() {
        return this.leftBlackHasMoved;
    }
    
    public void setLeftBlackHasMoved(Boolean trueOrFalse) {
        this.leftBlackHasMoved = trueOrFalse;
    }
    
    public Boolean getRightBlackHasMoved() {
        return this.rightBlackHasMoved;
    }
    
    public void setRightBlackHasMoved(Boolean trueOrFalse) {
        this.rightBlackHasMoved = trueOrFalse;
    }
    
    public Boolean getLeftWhiteHasMoved() {
        return this.leftWhiteHasMoved;
    }
    
    public void setLeftWhiteHasMoved(Boolean trueOrFalse) {
        this.leftWhiteHasMoved = trueOrFalse;
    }
    
    public Boolean getRightWhiteHasMoved() {
        return this.rightWhiteHasMoved;
    }
    
    public void setRightWhiteHasMoved(Boolean trueOrFalse) {
        this.rightWhiteHasMoved = trueOrFalse;
    }
    
    public void checkForMovement(int x, int y) {
        // if left black bishop has moved, note that it has moved
        if (x == 3 && y == 1) {
            setLeftBlackHasMoved(true);     
        }
        // if right black bishop has moved, note that it has moved
        if (x == 6 && y == 1) {
            setRightBlackHasMoved(true);
        }
        // if left white bishop has moved, note that it has moved
        if (x == 3 && y == 8) {
            setLeftWhiteHasMoved(true);
        }
        // if right white bishop has moved, note that it has moved
        if (x == 6 && y == 8) {
            setRightWhiteHasMoved(true);
        }
    }
    
    @Override
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
            image = new ImageView(imageFile);
        }
        return image;
    }
    
    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        
        // Creation of list to store diagonal tile considerations
        ArrayList<Integer> tilePairs = new ArrayList<>();
        // maximum number of tiles a bishop can transervse from each direction
        
        int topLeftDiagonalMax = getTopLeftTiles(xFirstTile, yFirstTile);
        int topRightDiagonalMax = getTopRightTiles(xFirstTile, yFirstTile);
        int bottomLeftDiagonalMax = getBottomLeftTiles(xFirstTile, yFirstTile);
        int bottomRightDiagonalMax = getBottomRightTiles(xFirstTile, yFirstTile);
                
        // setting first tile x and y to local variables
        int x = xFirstTile;
        int y = yFirstTile;

        // Check if move is within the maximum tile distribution of the top left diagonal
        for (int i = topLeftDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x -= 1;
            y -= 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x - 1][y - 1].getPieceColor() == "NONE") {
                tilePairs.add(x);
                tilePairs.add(y);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x - 1][y - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x - 1][y - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x);
                tilePairs.add(y);
                i = 0;
            } else {
                // no other possibility.
            }   
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {  
                checkForMovement(xFirstTile, yFirstTile);
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x2 = xFirstTile;
        int y2 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the top right diagonal
        for (int i = topRightDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x2 += 1;
            y2 -= 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x2);
                tilePairs.add(y2);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x2);
                tilePairs.add(y2);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {
                checkForMovement(xFirstTile, yFirstTile);
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x3 = xFirstTile;
        int y3 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the bottom left diagonal
        for (int i = bottomLeftDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x3 -= 1;
            y3 += 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x3);
                tilePairs.add(y3);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x3);
                tilePairs.add(y3);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {  
                checkForMovement(xFirstTile, yFirstTile);
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x4 = xFirstTile;
        int y4 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the bottom right diagonal
        for (int i = bottomRightDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x4 += 1;
            y4 += 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x4);
                tilePairs.add(y4);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x4);
                tilePairs.add(y4);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {   
                checkForMovement(xFirstTile, yFirstTile);
                return true;
            }
        }
        // clear out tilePairs list
        tilePairs.clear();
                
        //System.out.println("Failed due to: outside bishop moveset.");
        return false;
    
    }
    
    /**
    Bishop diagonal move calculation methods.
    * These methods calculate the maximum number of tiles a bishop can transverse diagonally
    */
    public int getTopLeftTiles(int column, int row) {
        return Math.min(row, column) - 1;
    }
    
    public int getBottomLeftTiles(int column, int row) {
        return 8 - Math.max(row, 9 - column);
    }
    
    public int getTopRightTiles(int column, int row) {
        return Math.min(row, 9 - column) - 1;
    }
    
    public int getBottomRightTiles(int column, int row) {
        return 8 - Math.max(row, column);
    }
    
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        
        // Creation of list to store diagonal tile considerations
        ArrayList<Integer> tilePairs = new ArrayList<>();
        // maximum number of tiles a bishop can transervse from each direction
        
        int topLeftDiagonalMax = getTopLeftTiles(xFirstTile, yFirstTile);
        int topRightDiagonalMax = getTopRightTiles(xFirstTile, yFirstTile);
        int bottomLeftDiagonalMax = getBottomLeftTiles(xFirstTile, yFirstTile);
        int bottomRightDiagonalMax = getBottomRightTiles(xFirstTile, yFirstTile);
                
        // setting first tile x and y to local variables
        int x = xFirstTile;
        int y = yFirstTile;

        // Check if move is within the maximum tile distribution of the top left diagonal
        for (int i = topLeftDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x -= 1;
            y -= 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x - 1][y - 1].getPieceColor() == "NONE") {
                tilePairs.add(x);
                tilePairs.add(y);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x - 1][y - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x - 1][y - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x);
                tilePairs.add(y);
                i = 0;
            } else {
                // no other possibility.
            }   
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {  
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x2 = xFirstTile;
        int y2 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the top right diagonal
        for (int i = topRightDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x2 += 1;
            y2 -= 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x2);
                tilePairs.add(y2);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x2 - 1][y2 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x2);
                tilePairs.add(y2);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x3 = xFirstTile;
        int y3 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the bottom left diagonal
        for (int i = bottomLeftDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x3 -= 1;
            y3 += 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x3);
                tilePairs.add(y3);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x3 - 1][y3 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x3);
                tilePairs.add(y3);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {  
                return true;
            }
        }
        // clear out tilePairs list for next diagonal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x4 = xFirstTile;
        int y4 = yFirstTile;
                
        // Check if move is within the maximum tile distribution of the bottom right diagonal
        for (int i = bottomRightDiagonalMax; i > 0; i--) {
            // move to next diagonal tile
            x4 += 1;
            y4 += 1;
            // if tile piece color is "NONE" then add x & y to tilePairs list.
            if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == "NONE") {
                tilePairs.add(x4);
                tilePairs.add(y4);
            // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
            } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() == tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                i = 0;
            // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
            } else if (tile2DArray[x4 - 1][y4 - 1].getPieceColor() != tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                tilePairs.add(x4);
                tilePairs.add(y4);
                i = 0;
            } else {
                // no other possibility.
            }
        }
        // if selected tile (second tile) is within the tilePairs list, return true
        for (int i = 0; i < tilePairs.size() - 1; i+=2) {
            if (xSecondTile == tilePairs.get(i) && ySecondTile == tilePairs.get(i + 1)) {   
                return true;
            }
        }
        // clear out tilePairs list
        tilePairs.clear();
                
        //System.out.println("Failed due to: outside bishop moveset.");
        return false;
    
    }
    
}

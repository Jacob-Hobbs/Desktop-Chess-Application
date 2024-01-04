/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Rook class used to instantiate Rook piece objects for manipulation.
 * */
public class Rook implements Piece {
    
    private Boolean leftBlackHasMoved;
    private Boolean rightBlackHasMoved;
    private Boolean leftWhiteHasMoved;
    private Boolean rightWhiteHasMoved;

    /**
     * Rook constructor.
     * */
    public Rook() {
        this.leftBlackHasMoved = false;
        this.rightBlackHasMoved = false;
        this.leftWhiteHasMoved = false;
        this.rightWhiteHasMoved = false;
    }

    /**
     * setCheckDangerTile method used to set corresponding danger boolean for pieces after rook moves.
     * */
    public void setCheckDangerTile(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, String color) {
        
        if (color.equals("WHITE")) {
            
            int xTileOne = xFirstTile - 1;
            int yTileOne = yFirstTile - 1;
        
            // Creation of list to store diagonal tile considerations
            ArrayList<Integer> tilePairs = new ArrayList<>();
            // maximum number of tiles a rook can transverse from each direction
            int leftMax = getLeftTiles(xFirstTile, yFirstTile);
            int rightMax = getRightTiles(xFirstTile, yFirstTile);
            int upMax = getUpTiles(xFirstTile, yFirstTile);
            int downMax = getDownTiles(xFirstTile, yFirstTile);
                
            // setting first tile x and y to local variables
            int x = xFirstTile;
            int y = yFirstTile;

            // Check if move is within the maximum tile distribution to the left of the rook
            for (int i = leftMax; i > 0; i--) {
                // move to next horizontal tile
                    
                if (x != 1) {
                    x -= 1; 
                }

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
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x2 = xFirstTile;
            int y2 = yFirstTile;
                
            // Check if move is within the maximum tile distribution to the right of the rook
            for (int i = rightMax; i > 0; i--) {
                // move to next horizontal tile
                    
                if (x2 != 8) {
                    x2 += 1;
                }

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
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x3 = xFirstTile;
            int y3 = yFirstTile;
                
            // Check if move is within the maximum tile distribution above the rook
            for (int i = upMax; i > 0; i--) {
                // move to next horizontal tile

                if (y3 != 1) {
                    y3 -= 1;
                }

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
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x4 = xFirstTile;
            int y4 = yFirstTile;
                
            // Check if move is within the maximum tile distribution below the rook
            for (int i = downMax; i > 0; i--) {
                // move to next horizontal tile

                if (y4 != 8) {
                    y4 += 1;
                }
                    
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
            // maximum number of tiles a rook can transervse from each direction
            int leftMax = getLeftTiles(xFirstTile, yFirstTile);
            int rightMax = getRightTiles(xFirstTile, yFirstTile);
            int upMax = getUpTiles(xFirstTile, yFirstTile);
            int downMax = getDownTiles(xFirstTile, yFirstTile);
                
            // setting first tile x and y to local variables
            int x = xFirstTile;
            int y = yFirstTile;

            // Check if move is within the maximum tile distribution to the left of the rook
            for (int i = leftMax; i > 0; i--) {
                // move to next horizontal tile
                    
                if (x != 1) {
                    x -= 1; 
                }

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
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x2 = xFirstTile;
            int y2 = yFirstTile;
                
            // Check if move is within the maximum tile distribution to the right of the rook
            for (int i = rightMax; i > 0; i--) {
                // move to next horizontal tile
                    
                if (x2 != 8) {
                    x2 += 1;
                }

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
                tile2DArray[(tilePairs.get(i)) - 1][(tilePairs.get(i + 1)) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x3 = xFirstTile;
            int y3 = yFirstTile;
                
            // Check if move is within the maximum tile distribution above the rook
            for (int i = upMax; i > 0; i--) {
                // move to next horizontal tile

                if (y3 != 1) {
                    y3 -= 1;
                }

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
            // clear out tilePairs list for next horizontal check
            tilePairs.clear();
                
            // setting first tile x and y to local variables
            int x4 = xFirstTile;
            int y4 = yFirstTile;
                
            // Check if move is within the maximum tile distribution below the rook
            for (int i = downMax; i > 0; i--) {
                // move to next horizontal tile

                if (y4 != 8) {
                    y4 += 1;
                }
                    
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

    /**
     * getLeftBlackHasMoved getter method for left black rook movement.
     * */
    public Boolean getLeftBlackHasMoved() {
        return this.leftBlackHasMoved;
    }

    /**
     * setLeftBlackHasMoved setter method for left black rook movement.
     * */
    public void setLeftBlackHasMoved(Boolean trueOrFalse) {
        this.leftBlackHasMoved = trueOrFalse;
    }

    /**
     * getRightBlackHasMoved getter method for right black rook movement.
     * */
    public Boolean getRightBlackHasMoved() {
        return this.rightBlackHasMoved;
    }

    /**
     * setRightBlackHasMoved setter method for right black rook movement.
     * */
    public void setRightBlackHasMoved(Boolean trueOrFalse) {
        this.rightBlackHasMoved = trueOrFalse;
    }

    /**
     * getLeftWhiteHasMoved getter method for left white rook movement.
     * */
    public Boolean getLeftWhiteHasMoved() {
        return this.leftWhiteHasMoved;
    }

    /**
     * setLeftWhiteHasMoved setter method for left white rook movement.
     * */
    public void setLeftWhiteHasMoved(Boolean trueOrFalse) {
        this.leftWhiteHasMoved = trueOrFalse;
    }

    /**
     * getRightWhiteHasMoved getter method for right white rook movement.
     * */
    public Boolean getRightWhiteHasMoved() {
        return this.rightWhiteHasMoved;
    }

    /**
     * setRightWhiteHasMoved setter method for right white rook movement.
     * */
    public void setRightWhiteHasMoved(Boolean trueOrFalse) {
        this.rightWhiteHasMoved = trueOrFalse;
    }

    /**
     * checkForMovement method actually tracks rook movement for castling potential.
     * */
    public void checkForMovement(int x, int y) {
        // if left black rook has moved, note that it has moved
        if (x == 1 && y == 1) {
            setLeftBlackHasMoved(true);     
        }
        // if right black rook has moved, note that it has moved
        if (x == 8 && y == 1) {
            setRightBlackHasMoved(true);
        }
        // if left white rook has moved, note that it has moved
        if (x == 1 && y == 8) {
            setLeftWhiteHasMoved(true);
        }
        // if right white rook has moved, note that it has moved
        if (x == 8 && y == 8) {
            setRightWhiteHasMoved(true);
        }
    }

    /**
     * getImageView method retrieves image view of black/white rook sprite.
     * */
    @Override
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
            image = new ImageView(imageFile);
        }
        return image;
    }

    /**
     * canPieceMove method checks if movement is valid for a rook type.
     * Exceptions are manually handled through program logic.
     * */
    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
    
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        
        // Creation of list to store diagonal tile considerations
        ArrayList<Integer> tilePairs = new ArrayList<>();
        // maximum number of tiles a rook can transervse from each direction
        int leftMax = getLeftTiles(xFirstTile, yFirstTile);
        int rightMax = getRightTiles(xFirstTile, yFirstTile);
        int upMax = getUpTiles(xFirstTile, yFirstTile);
        int downMax = getDownTiles(xFirstTile, yFirstTile);
                
        // setting first tile x and y to local variables
        int x = xFirstTile;
        int y = yFirstTile;

        // Check if move is within the maximum tile distribution to the left of the rook
        for (int i = leftMax; i > 0; i--) {
            // move to next horizontal tile
                    
            if (x != 1) {
                x -= 1; 
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x2 = xFirstTile;
        int y2 = yFirstTile;
                
        // Check if move is within the maximum tile distribution to the right of the rook
        for (int i = rightMax; i > 0; i--) {
            // move to next horizontal tile
                    
            if (x2 != 8) {
                x2 += 1;
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x3 = xFirstTile;
        int y3 = yFirstTile;
                
        // Check if move is within the maximum tile distribution above the rook
        for (int i = upMax; i > 0; i--) {
            // move to next horizontal tile

            if (y3 != 1) {
                y3 -= 1;
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x4 = xFirstTile;
        int y4 = yFirstTile;
                
        // Check if move is within the maximum tile distribution below the rook
        for (int i = downMax; i > 0; i--) {
            // move to next horizontal tile

            if (y4 != 8) {
                y4 += 1;
            }
                    
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
                
        //System.out.println("Failed due to: outside rook moveset.");
        return false;
        
    }
    
    /**
    Rook horizontal move calculation methods.
    * These methods calculate the maximum number of tiles a rook can transverse horizontally
    */
    public int getUpTiles(int column, int row) {
        return ((column - 1) + row) - column;
    }
    
    public int getDownTiles(int column, int row) {
        return ((column - 1) + 8) - row;
    }
    
    public int getLeftTiles(int column, int row) {
        return column - 1;
    }
    
    public int getRightTiles(int column, int row) {
        return 8 - column;
    }

    /**
     * canPieceMoveCheckmateCheck method is specific method that determines if rook can move to prevent King
     * checkmate/check scenario.
     * */
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
    
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        
        // Creation of list to store diagonal tile considerations
        ArrayList<Integer> tilePairs = new ArrayList<>();
        // maximum number of tiles a rook can transervse from each direction
        int leftMax = getLeftTiles(xFirstTile, yFirstTile);
        int rightMax = getRightTiles(xFirstTile, yFirstTile);
        int upMax = getUpTiles(xFirstTile, yFirstTile);
        int downMax = getDownTiles(xFirstTile, yFirstTile);
                
        // setting first tile x and y to local variables
        int x = xFirstTile;
        int y = yFirstTile;

        // Check if move is within the maximum tile distribution to the left of the rook
        for (int i = leftMax; i > 0; i--) {
            // move to next horizontal tile
                    
            if (x != 1) {
                x -= 1; 
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x2 = xFirstTile;
        int y2 = yFirstTile;
                
        // Check if move is within the maximum tile distribution to the right of the rook
        for (int i = rightMax; i > 0; i--) {
            // move to next horizontal tile
                    
            if (x2 != 8) {
                x2 += 1;
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x3 = xFirstTile;
        int y3 = yFirstTile;
                
        // Check if move is within the maximum tile distribution above the rook
        for (int i = upMax; i > 0; i--) {
            // move to next horizontal tile

            if (y3 != 1) {
                y3 -= 1;
            }

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
        // clear out tilePairs list for next horizontal check
        tilePairs.clear();
                
        // setting first tile x and y to local variables
        int x4 = xFirstTile;
        int y4 = yFirstTile;
                
        // Check if move is within the maximum tile distribution below the rook
        for (int i = downMax; i > 0; i--) {
            // move to next horizontal tile

            if (y4 != 8) {
                y4 += 1;
            }
                    
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
                
        //System.out.println("Failed due to: outside rook moveset.");
        return false;
        
    }
}

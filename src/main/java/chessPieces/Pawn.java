/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Pawn class used to instantiate Pawn piece objects for manipulation.
 * */
public class Pawn implements Piece {
    
    public void setCheckDangerTile(Tile[][] tile2DArray, int x, int y, String color) {
        
        if (color.equals("WHITE")) {
            if (y == 1) {
                // do nothing.
            } else if (x == 1) {
                tile2DArray[(x-1) + 1][(y-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            } else if (x == 8) {
                tile2DArray[(x-1) - 1][(y-1) - 1].setCheckDangerWhite(Boolean.TRUE); 
            } else {
                tile2DArray[(x-1) + 1][(y-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x-1) - 1][(y-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            }
        } else if (color.equals("BLACK")) {
            if (y == 8) {
                // do nothing.
            } else if (x == 1) {
                tile2DArray[(x-1) + 1][(y-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            } else if (x == 8) {
                tile2DArray[(x-1) - 1][(y-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            } else {
                tile2DArray[(x-1) + 1][(y-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x-1) - 1][(y-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            }
        }
    }

    @Override
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

    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        int xTileTwo = xSecondTile - 1;
        int yTileTwo = ySecondTile - 1;

        // if pawn is white
        if (tile2DArray[xTileOne][yTileOne].getPieceColor() == "WHITE") {   
            // if pawn is in white starting position (y = 7)
            if (yFirstTile == 7) {
                // if pawn wants to move one space ahead.
                if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn wants to move two spaces ahead.    
                } else if ((xTileOne == xTileTwo) && (yTileOne - 2 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 2].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 2] == tile2DArray[xTileTwo][yTileTwo])) {
                        // pawn has moved ahead two spaces and is now in danger of en Passant
                        tile2DArray[xTileOne][yTileOne - 2].setEnPassantDanger(Boolean.TRUE);
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                        
                    
                    } 
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");

                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;
                            
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                    
                    
                // if pawn wants to move diagonal one space (right or left) to take black piece via en passant. (Pass to Left diagonal)
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
                    
            // if pawn is in any other position (y = 1, 2, 3, 4, 5, 6, or 8)    
            } else {
                // if pawn wants to move one space ahead. 
            if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    // if pawn wants to move diagonal one space (right) to take black piece via en passant. (Pass to right diagonal)
                    } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        tile2DArray[xTileOne + 1][yTileOne].setPieceColor("NONE");
                        tile2DArray[xTileOne + 1][yTileOne].setPieceID(0);
                        Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                        ImageView imageNothing = new ImageView(imageFile);
                        tile2DArray[xTileOne + 1][yTileOne].getTileButton().setGraphic(imageNothing);
                        tile2DArray[xTileOne + 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    // if pawn wants to move diagonal one space (left) to take black piece via en passant. (Pass to left diagonal)
                    } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        tile2DArray[xTileOne - 1][yTileOne].setPieceColor("NONE");
                        tile2DArray[xTileOne - 1][yTileOne].setPieceID(0);
                        Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                        ImageView imageNothing = new ImageView(imageFile);
                        tile2DArray[xTileOne - 1][yTileOne].getTileButton().setGraphic(imageNothing);
                        tile2DArray[xTileOne - 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;
                            
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                // if pawn wants to move diagonal one space (left) to take black piece via en passant. (Pass to left diagonal)
                } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                    System.out.println("EN PASSANT (WHITE/LEFT)!");
                    tile2DArray[xTileOne - 1][yTileOne].setPieceColor("NONE");
                    tile2DArray[xTileOne - 1][yTileOne].setPieceID(0);
                    Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                    ImageView imageNothing = new ImageView(imageFile);
                    tile2DArray[xTileOne - 1][yTileOne].getTileButton().setGraphic(imageNothing);
                    tile2DArray[xTileOne - 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                    return true;
                // if pawn wants to move diagonal one space (right) to take black piece via en passant. (Pass to right diagonal)
                } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                    System.out.println("EN PASSANT (WHITE/RIGHT)!");
                    tile2DArray[xTileOne + 1][yTileOne].setPieceColor("NONE");
                    tile2DArray[xTileOne + 1][yTileOne].setPieceID(0);
                    Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                    ImageView imageNothing = new ImageView(imageFile);
                    tile2DArray[xTileOne + 1][yTileOne].getTileButton().setGraphic(imageNothing);
                    tile2DArray[xTileOne + 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("SEVEN");
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            }  
                    
        // if pawn is black    
        } else if (tile2DArray[xTileOne][yTileOne].getPieceColor() == "BLACK") {
                    
            // if pawn is in black starting position (y = 2)
            if (yFirstTile == 2) {
                // if pawn wants to move one space ahead.
                if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn wants to move two spaces ahead.    
                } else if ((xTileOne == xTileTwo) && (yTileOne + 2 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 2].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 2] == tile2DArray[xTileTwo][yTileTwo])) {
                        // pawn has moved ahead two spaces and is now in danger of en Passant
                        tile2DArray[xTileOne][yTileOne + 2].setEnPassantDanger(Boolean.TRUE);
                        //System.out.println("Tile: (" + (xTileTwo) + ", " + (yTileTwo) + ") now in danger of en passant!");
                        //System.out.println("Tile: (" + (xTileTwo) + ", " + (yTileTwo) + ") en passant: " + tile2DArray[xTileOne][yTileOne + 2].getEnPassantDanger());
                        //System.out.println("Tile: (" + (xTileOne) + ", " + (yTileOne + 2) + ") en passant: " + tile2DArray[xTileOne][yTileOne + 2].getEnPassantDanger());
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;  
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                           
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            } else {
                if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        System.out.println("1: EN PASSANT (BLACK/RIGHT)!");
                        tile2DArray[xTileOne + 1][yTileOne].setPieceColor("NONE");
                        tile2DArray[xTileOne + 1][yTileOne].setPieceID(0);
                        Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                        ImageView imageNothing = new ImageView(imageFile);
                        tile2DArray[xTileOne + 1][yTileOne].getTileButton().setGraphic(imageNothing);
                        tile2DArray[xTileOne + 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                        return true; 
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        System.out.println("EN PASSANT (BLACK/LEFT)!");
                        tile2DArray[xTileOne - 1][yTileOne].setPieceColor("NONE");
                        tile2DArray[xTileOne - 1][yTileOne].setPieceID(0);
                        Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                        ImageView imageNothing = new ImageView(imageFile);
                        tile2DArray[xTileOne - 1][yTileOne].getTileButton().setGraphic(imageNothing);
                        tile2DArray[xTileOne - 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false; 
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {    
                    System.out.println("EN PASSANT (BLACK/LEFT)!");
                    tile2DArray[xTileOne - 1][yTileOne].setPieceColor("NONE");
                    tile2DArray[xTileOne - 1][yTileOne].setPieceID(0);
                    Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                    ImageView imageNothing = new ImageView(imageFile);
                    tile2DArray[xTileOne - 1][yTileOne].getTileButton().setGraphic(imageNothing);
                    tile2DArray[xTileOne - 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                    return true;
                } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {    
                    System.out.println("2: EN PASSANT (BLACK/RIGHT)!");
                    tile2DArray[xTileOne + 1][yTileOne].setPieceColor("NONE");
                    tile2DArray[xTileOne + 1][yTileOne].setPieceID(0);
                    Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
                    ImageView imageNothing = new ImageView(imageFile);
                    tile2DArray[xTileOne + 1][yTileOne].getTileButton().setGraphic(imageNothing);
                    tile2DArray[xTileOne + 1][yTileOne].setEnPassantDanger(Boolean.FALSE);
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            }   
        }
        //System.out.println("Failed due to: unmet condition.");
        return false;
    }
    
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        int xTileTwo = xSecondTile - 1;
        int yTileTwo = ySecondTile - 1;

        // if pawn is white
        if (tile2DArray[xTileOne][yTileOne].getPieceColor() == "WHITE") {   
            // if pawn is in white starting position (y = 7)
            if (yFirstTile == 7) {
                // if pawn wants to move one space ahead.
                if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn wants to move two spaces ahead.    
                } else if ((xTileOne == xTileTwo) && (yTileOne - 2 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 2].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 2] == tile2DArray[xTileTwo][yTileTwo])) {
                        // pawn has moved ahead two spaces and is now in danger of en Passant
                        tile2DArray[xTileOne][yTileOne - 2].setEnPassantDanger(Boolean.TRUE);
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                        
                    
                    } 
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");

                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;
                            
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                    
                    
                // if pawn wants to move diagonal one space (right or left) to take black piece via en passant. (Pass to Left diagonal)
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
                    
            // if pawn is in any other position (y = 1, 2, 3, 4, 5, 6, or 8)    
            } else {
                // if pawn wants to move one space ahead. 
            if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    // if pawn wants to move diagonal one space (right) to take black piece via en passant. (Pass to right diagonal)
                    } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    // if pawn wants to move diagonal one space (left) to take black piece via en passant. (Pass to left diagonal)
                    } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;
                            
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne - 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && tile2DArray[xTileOne + 1][yTileOne - 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                // if pawn wants to move diagonal one space (left) to take black piece via en passant. (Pass to left diagonal)
                } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                    
                    return true;
                // if pawn wants to move diagonal one space (right) to take black piece via en passant. (Pass to right diagonal)
                } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "BLACK")
                && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "BLACK") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                    
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("SEVEN");
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            }  
                    
        // if pawn is black    
        } else if (tile2DArray[xTileOne][yTileOne].getPieceColor() == "BLACK") {
                    
            // if pawn is in black starting position (y = 2)
            if (yFirstTile == 2) {
                // if pawn wants to move one space ahead.
                if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn wants to move two spaces ahead.    
                } else if ((xTileOne == xTileTwo) && (yTileOne + 2 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 2].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 2] == tile2DArray[xTileTwo][yTileTwo])) {
                        // pawn has moved ahead two spaces and is now in danger of en Passant
                        tile2DArray[xTileOne][yTileOne + 2].setEnPassantDanger(Boolean.TRUE);
                        //System.out.println("Tile: (" + (xTileTwo) + ", " + (yTileTwo) + ") now in danger of en passant!");
                        //System.out.println("Tile: (" + (xTileTwo) + ", " + (yTileTwo) + ") en passant: " + tile2DArray[xTileOne][yTileOne + 2].getEnPassantDanger());
                        //System.out.println("Tile: (" + (xTileOne) + ", " + (yTileOne + 2) + ") en passant: " + tile2DArray[xTileOne][yTileOne + 2].getEnPassantDanger());
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false;  
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                           
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            } else {
                if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                    // if there is no piece directly in front of the pawn.
                    if((tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (tile2DArray[xTileOne][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    }
                    //System.out.println("Failed due to: a piece blocks the pawn.");
                    return false;
                // if pawn is in column x = 1.
                } else if (xFirstTile == 1) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        
                        return true; 
                    }
                    //System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                    return false;
                // if pawn is in column x = 8.    
                } else if (xFirstTile == 8) {
                    // if suitable diagonal has enemy.
                    if (((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                        return true;
                    } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {
                        
                        return true;
                    }
                    //System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                    return false; 
                // if pawn wants to move diagonal one space (right or left) to take black piece.    
                } else if (((tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne + 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])
                        || ((tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && tile2DArray[xTileOne - 1][yTileOne + 1] == tile2DArray[xTileTwo][yTileTwo])) {
                    return true;
                } else if ((tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne - 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne - 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne - 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {    
                    
                    return true;
                } else if ((tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "NONE" || tile2DArray[xTileTwo][yTileTwo].getPieceColor() == "WHITE")
                    && ((tile2DArray[xTileOne + 1][yTileOne].getPieceID() == 1) && (tile2DArray[xTileOne + 1][yTileOne].getPieceColor() == "WHITE") && (tile2DArray[xTileOne + 1][yTileOne].getEnPassantDanger() == Boolean.TRUE))) {    
                    
                    return true;
                // no other valid move can be made.
                } else {
                    //System.out.println("Failed due to: invalid pawn move.");
                    return false;
                }
            }   
        }
        //System.out.println("Failed due to: unmet condition.");
        return false;
    }
    
}

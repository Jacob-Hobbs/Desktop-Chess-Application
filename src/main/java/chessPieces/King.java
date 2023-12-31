/**
 * @author Jacob Hobbs
 */
package chessPieces;

import chess.Tile;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * King class used to instantiate King piece objects for manipulation.
 * */
public class King implements Piece {
    
    private Boolean whiteKingInCheck;
    private Boolean blackKingInCheck;
    
    private Boolean whiteKingHasMoved;
    private Boolean blackKingHasMoved; 
    
    private Boolean whiteKingCheckmate;
    private Boolean blackKingCheckmate;
    
    private Boolean whiteKingStalemate;
    private Boolean blackKingStalemate;
    
    private Rook rook;

    /**
     * King constructor.
     * */
    public King() {
        this.whiteKingInCheck = false;
        this.blackKingInCheck = false;
        
        this.whiteKingHasMoved = false;
        this.blackKingHasMoved = false;
        
        this.whiteKingCheckmate = false;
        this.blackKingCheckmate = false;
        
        this.whiteKingStalemate = false;
        this.blackKingStalemate = false;
        
        this.rook = new Rook();
    }

    /**
     * setCheckDangerTile method used to set corresponding danger boolean for pieces after king moves.
     * */
    public void setCheckDangerTile(Tile[][] tile2DArray, int x1, int y1, String color) {

        if (color.equals("WHITE")) {
            
            if (x1 == 1 && y1 == 1) {
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            } else if ((x1 == 1 && y1 == 2) || (x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) ||
                    (x1 == 1 && y1 == 5) || (x1 == 1 && y1 == 6) || (x1 == 1 && y1 == 7)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
            } else if (x1 == 1 && y1 == 8) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
            } else if ((x1 == 2 && y1 == 8) || (x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) ||
                    (x1 == 5 && y1 == 8) || (x1 == 6 && y1 == 8) || (x1 == 7 && y1 == 8)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            } else if (x1 == 8 && y1 == 8) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            } else if ((x1 == 8 && y1 == 2) || (x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) ||
                    (x1 == 8 && y1 == 5) || (x1 == 8 && y1 == 6) || (x1 == 8 && y1 == 7)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
            } else if (x1 == 8 && y1 == 1) {
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
            } else if ((x1 == 2 && y1 == 1) || (x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) ||
                 (x1 == 5 && y1 == 1) || (x1 == 6 && y1 == 1) || (x1 == 7 && y1 == 1)) {
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
            } else {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerWhite(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerWhite(Boolean.TRUE);
        }

        } else if (color.equals("BLACK")) {
            
            if (x1 == 1 && y1 == 1) {
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            } else if ((x1 == 1 && y1 == 2) || (x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) ||
                    (x1 == 1 && y1 == 5) || (x1 == 1 && y1 == 6) || (x1 == 1 && y1 == 7)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
            } else if (x1 == 1 && y1 == 8) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
            } else if ((x1 == 2 && y1 == 8) || (x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) ||
                    (x1 == 5 && y1 == 8) || (x1 == 6 && y1 == 8) || (x1 == 7 && y1 == 8)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            } else if (x1 == 8 && y1 == 8) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            } else if ((x1 == 8 && y1 == 2) || (x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) ||
                    (x1 == 8 && y1 == 5) || (x1 == 8 && y1 == 6) || (x1 == 8 && y1 == 7)) {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            } else if (x1 == 8 && y1 == 1) {
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
            } else if ((x1 == 2 && y1 == 1) || (x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) ||
                 (x1 == 5 && y1 == 1) || (x1 == 6 && y1 == 1) || (x1 == 7 && y1 == 1)) {
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
            } else {
                tile2DArray[(x1-1)][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) + 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1)][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) + 1].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1)].setCheckDangerBlack(Boolean.TRUE);
                tile2DArray[(x1-1) - 1][(y1-1) - 1].setCheckDangerBlack(Boolean.TRUE);
            }
            
        }
    }

    /**
     * Getter method to determine if black king has moved for castling purposes.
     * */
    public Boolean getBlackKingHasMoved() {
        return this.blackKingHasMoved;
    }

    /**
     * Setter method to determine if black king has moved for castling purposes.
     * */
    public void setBlackKingHasMoved(Boolean trueOrFalse) {
        this.blackKingHasMoved = trueOrFalse;
    }

    /**
     * Getter method to determine if white king has moved for castling purposes.
     * */
    public Boolean getWhiteKingHasMoved() {
        return this.whiteKingHasMoved;
    }

    /**
     * Setter method to determine if white king has moved for castling purposes.
     * */
    public void setWhiteKingHasMoved(Boolean trueOrFalse) {
        this.whiteKingHasMoved = trueOrFalse;
    }

    /**
     * getImageView method retrieves image view of black/white king sprite.
     * */
    @Override
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteKing.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackKing.png");
            image = new ImageView(imageFile);
        }
        return image;
    }

    /**
     * Setter method for check status of king.
     * */
    public void setCheckStatus(boolean trueOrFalse, String kingColor) {
        if (kingColor == "WHITE") {
            this.whiteKingInCheck = trueOrFalse;
        } else if (kingColor == "BLACK") {
            this.blackKingInCheck = trueOrFalse;
        }
    }

    /**
     * Getter method for check status of king.
     * */
    public boolean getCheckStatus(String kingColor) {
        
        if (kingColor == "WHITE") {
            return this.whiteKingInCheck;
        } else if (kingColor == "BLACK") {
            return this.blackKingInCheck;
        }
        
        return false;
    }

    /**
     * Getter method for checkmate status of king.
     * */
    public boolean getKingCheckmate(String kingColor) {
        if (kingColor == "WHITE") {
            return this.whiteKingCheckmate;
        } else if (kingColor == "BLACK") {
            return this.blackKingCheckmate;
        }
        return false;
    }

    /**
     * Setter method for checkmate status of king.
     * */
    public void setKingCheckmate(boolean trueOrFalse, String kingColor) {
        if (kingColor == "WHITE") {
            this.whiteKingCheckmate = trueOrFalse;
        } else if (kingColor == "BLACK") {
            this.blackKingCheckmate = trueOrFalse;
        }
    }

    /**
     * Getter method for stalemate status of king.
     * */
    public boolean getKingStalemate(String kingColor) {
        if (kingColor == "WHITE") {
            return this.whiteKingStalemate;
        } else if (kingColor == "BLACK") {
            return this.blackKingStalemate;
        }
        return false;
    }

    /**
     * Setter method for stalemate status of king.
     * */
    public void setKingStalemate(boolean trueOrFalse, String kingColor) {
        if (kingColor == "WHITE") {
            this.whiteKingStalemate = trueOrFalse;
        } else if (kingColor == "BLACK") {
            this.blackKingStalemate = trueOrFalse;
        }
    }

    /**
     * canPieceMove method checks if movement is valid for a king type.
     * Exceptions are manually handled through program logic.
     * */
    @Override
    public boolean canPieceMove(Tile[][] tile2DArray, int x1, int y1, int x2, int y2) {
    
        int returnNum = 0;
        int moveOne = kingMoveOne(x1, y1, x2, y2);
        int moveTwo = kingMoveTwo(x1, y1, x2, y2);
        int moveThree = kingMoveThree(x1, y1, x2, y2);
        int moveFour = kingMoveFour(x1, y1, x2, y2);
        int moveFive = kingMoveFive(x1, y1, x2, y2);
        int moveSix = kingMoveSix(x1, y1, x2, y2);
        int moveSeven = kingMoveSeven(x1, y1, x2, y2);
        int moveEight = kingMoveEight(x1, y1, x2, y2);
        
        Image wrFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
        ImageView whiteRook = new ImageView(wrFile);
        Image brFile = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
        ImageView blackRook = new ImageView(brFile);
        Image nothingFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
        ImageView nothing = new ImageView(nothingFile);
        
        // IF THE SPACE A KING WANTS TO MOVE TO HAS CHECK DANGER = TRUE, KING CANNOT MOVE THERE!
        if (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE" && tile2DArray[x2-1][y2-1].getCheckDangerBlack() == Boolean.TRUE) {
            //System.out.println("Moving here would put the white king in check!!");
            return false;
        } else if (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK" && tile2DArray[x2-1][y2-1].getCheckDangerWhite() == Boolean.TRUE) {
            //System.out.println("Moving here would put the black king in check!!");
            return false;
        }
        
        
        // Check for acceptable castling conditions
        // BLACK KING CASTLE RIGHT
        if ((!(tile2DArray[8-1][1-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK") && (x2 == 7 && y2 == 1) && (tile2DArray[7-1][1-1].getPieceID() == 0 && tile2DArray[6-1][1-1].getPieceID() == 0) 
                && (getBlackKingHasMoved() == Boolean.FALSE) && (rook.getRightBlackHasMoved() == Boolean.FALSE)) {
            setBlackKingHasMoved(true);
            rook.setRightBlackHasMoved(false);
            tile2DArray[6-1][1-1].setPieceColor("BLACK");
            tile2DArray[6-1][1-1].setPieceID(4);
            tile2DArray[6-1][1-1].getTileButton().setGraphic(blackRook);
            tile2DArray[8-1][1-1].setPieceColor("NONE");
            tile2DArray[8-1][1-1].setPieceID(0);
            tile2DArray[8-1][1-1].getTileButton().setGraphic(nothing);
            
            returnNum += -1;
        }
        // BLACK KING CASTLE LEFT
        if ((!(tile2DArray[1-1][1-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK") && (x2 == 3 && y2 == 1) && (tile2DArray[2-1][1-1].getPieceID() == 0 && tile2DArray[3-1][1-1].getPieceID() == 0 
                && tile2DArray[4-1][1-1].getPieceID() == 0) && (getBlackKingHasMoved() == Boolean.FALSE) && (rook.getLeftBlackHasMoved() == Boolean.FALSE)) {
            setBlackKingHasMoved(true);
            rook.setLeftBlackHasMoved(false);
            tile2DArray[4-1][1-1].setPieceColor("BLACK");
            tile2DArray[4-1][1-1].setPieceID(4);
            tile2DArray[4-1][1-1].getTileButton().setGraphic(blackRook);
            tile2DArray[1-1][1-1].setPieceColor("NONE");
            tile2DArray[1-1][1-1].setPieceID(0);
            tile2DArray[1-1][1-1].getTileButton().setGraphic(nothing);
            
            returnNum += -1;
        }
        // WHITE KING CASTLE RIGHT
        if ((!(tile2DArray[8-1][8-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE") && (x2 == 7 && y2 == 8) && (tile2DArray[7-1][8-1].getPieceID() == 0 && tile2DArray[6-1][8-1].getPieceID() == 0) 
                && (getWhiteKingHasMoved() == Boolean.FALSE) && (rook.getRightWhiteHasMoved() == Boolean.FALSE)) {
            setWhiteKingHasMoved(true);
            rook.setRightWhiteHasMoved(false);
            tile2DArray[6-1][8-1].setPieceColor("WHITE");
            tile2DArray[6-1][8-1].setPieceID(4);
            tile2DArray[6-1][8-1].getTileButton().setGraphic(whiteRook);
            tile2DArray[8-1][8-1].setPieceColor("NONE");
            tile2DArray[8-1][8-1].setPieceID(0);
            tile2DArray[8-1][8-1].getTileButton().setGraphic(nothing);
            
            returnNum += -1;
        }
        // WHITE KING CASTLE LEFT
        if ((!(tile2DArray[1-1][8-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE") && (x2 == 3 && y2 == 8) && (tile2DArray[2-1][8-1].getPieceID() == 0 && tile2DArray[3-1][8-1].getPieceID() == 0 
                && tile2DArray[4-1][8-1].getPieceID() == 0) && (getWhiteKingHasMoved() == Boolean.FALSE) && (rook.getLeftWhiteHasMoved() == Boolean.FALSE)) {
            setWhiteKingHasMoved(true);
            rook.setLeftWhiteHasMoved(false);
            tile2DArray[4-1][8-1].setPieceColor("WHITE");
            tile2DArray[4-1][8-1].setPieceID(4);
            tile2DArray[4-1][8-1].getTileButton().setGraphic(whiteRook);
            tile2DArray[1-1][8-1].setPieceColor("NONE");
            tile2DArray[1-1][8-1].setPieceID(0);
            tile2DArray[1-1][8-1].getTileButton().setGraphic(nothing);
            
            returnNum += -1;
        }

        if (x1 == 1 && y1 == 1) {
            returnNum =+ moveThree + moveFour + moveFive;
        } else if ((x1 == 1 && y1 == 2) || (x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) ||
                (x1 == 1 && y1 == 5) || (x1 == 1 && y1 == 6) || (x1 == 1 && y1 == 7)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive;
        } else if (x1 == 1 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveThree;
        } else if ((x1 == 2 && y1 == 8) || (x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) ||
                (x1 == 5 && y1 == 8) || (x1 == 6 && y1 == 8) || (x1 == 7 && y1 == 8)) {
            returnNum += moveOne + moveTwo + moveThree + moveSeven + moveEight;
        } else if (x1 == 8 && y1 == 8) {
            returnNum += moveOne + moveSeven + moveEight;
        } else if ((x1 == 8 && y1 == 2) || (x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) ||
                (x1 == 8 && y1 == 5) || (x1 == 8 && y1 == 6) || (x1 == 8 && y1 == 7)) {
            returnNum += moveOne + moveFive + moveSix + moveSeven + moveEight;
        } else if (x1 == 8 && y1 == 1) {
            returnNum += moveFive + moveSix + moveSeven;
        } else if ((x1 == 2 && y1 == 1) || (x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) ||
                (x1 == 5 && y1 == 1) || (x1 == 6 && y1 == 1) || (x1 == 7 && y1 == 1)) {
            returnNum += moveThree + moveFour + moveFive + moveSix + moveSeven;
        } else {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix + 
                    moveSeven + moveEight;
        }
        
        if (returnNum == -1) {
            
            if (x1 == 5 && y1 == 1) {
                setBlackKingHasMoved(true);
            }
            if (x1 == 5 && y1 == 8) {
                setWhiteKingHasMoved(true);
            }
            
            return true;
        }
        //System.out.println("Failed due to: outside king moveset");
        return false;
    
    }

    /**
     * The below methods define the 8 possible moves of a king piece type.
     * */
    private int kingMoveOne(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile) && ySecondTile == (yFirstTile - 1)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveTwo(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 1) && ySecondTile == (yFirstTile - 1)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveThree(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 1) && ySecondTile == (yFirstTile)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveFour(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile + 1) && ySecondTile == (yFirstTile + 1)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveFive(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile) && ySecondTile == (yFirstTile + 1)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveSix(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 1) && ySecondTile == (yFirstTile + 1)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveSeven(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 1) && ySecondTile == (yFirstTile)) {
            return -1;
        }
        return 0;
    }
    
    private int kingMoveEight(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        
        if (xSecondTile == (xFirstTile - 1) && ySecondTile == (yFirstTile - 1)) {
            return -1;
        }
        return 0;
    }

    /**
     * canPieceMoveCheckmateCheck method is specific method that determines if king can move to prevent itself
     * from entering checkmate/check scenario.
     * */
    public boolean canPieceMoveCheckmateCheck(Tile[][] tile2DArray, int x1, int y1, int x2, int y2) {
    
        int returnNum = 0;
        int moveOne = kingMoveOne(x1, y1, x2, y2);
        int moveTwo = kingMoveTwo(x1, y1, x2, y2);
        int moveThree = kingMoveThree(x1, y1, x2, y2);
        int moveFour = kingMoveFour(x1, y1, x2, y2);
        int moveFive = kingMoveFive(x1, y1, x2, y2);
        int moveSix = kingMoveSix(x1, y1, x2, y2);
        int moveSeven = kingMoveSeven(x1, y1, x2, y2);
        int moveEight = kingMoveEight(x1, y1, x2, y2);
        
        Image wrFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
        ImageView whiteRook = new ImageView(wrFile);
        Image brFile = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
        ImageView blackRook = new ImageView(brFile);
        Image nothingFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
        ImageView nothing = new ImageView(nothingFile);
        
        // IF THE SPACE A KING WANTS TO MOVE TO HAS CHECK DANGER = TRUE, KING CANNOT MOVE THERE!
        if (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE" && tile2DArray[x2-1][y2-1].getCheckDangerBlack() == Boolean.TRUE) {
            //System.out.println("Moving here would put the white king in check!!");
            return false;
        } else if (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK" && tile2DArray[x2-1][y2-1].getCheckDangerWhite() == Boolean.TRUE) {
            //System.out.println("Moving here would put the black king in check!!");
            return false;
        }
        
        
        // Check for acceptable castling conditions
        // BLACK KING CASTLE RIGHT
        if ((!(tile2DArray[8-1][1-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK") && (x2 == 7 && y2 == 1) && (tile2DArray[7-1][1-1].getPieceID() == 0 && tile2DArray[6-1][1-1].getPieceID() == 0) 
                && (getBlackKingHasMoved() == Boolean.FALSE) && (rook.getRightBlackHasMoved() == Boolean.FALSE)) {
            
            returnNum += -1;
        }
        // BLACK KING CASTLE LEFT
        if ((!(tile2DArray[1-1][1-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK") && (x2 == 3 && y2 == 1) && (tile2DArray[2-1][1-1].getPieceID() == 0 && tile2DArray[3-1][1-1].getPieceID() == 0 
                && tile2DArray[4-1][1-1].getPieceID() == 0) && (getBlackKingHasMoved() == Boolean.FALSE) && (rook.getLeftBlackHasMoved() == Boolean.FALSE)) {
            
            returnNum += -1;
        }
        // WHITE KING CASTLE RIGHT
        if ((!(tile2DArray[8-1][8-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE") && (x2 == 7 && y2 == 8) && (tile2DArray[7-1][8-1].getPieceID() == 0 && tile2DArray[6-1][8-1].getPieceID() == 0) 
                && (getWhiteKingHasMoved() == Boolean.FALSE) && (rook.getRightWhiteHasMoved() == Boolean.FALSE)) {
            
            returnNum += -1;
        }
        // WHITE KING CASTLE LEFT
        if ((!(tile2DArray[1-1][8-1].getPieceColor() == "NONE")) && (tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE") && (x2 == 3 && y2 == 8) && (tile2DArray[2-1][8-1].getPieceID() == 0 && tile2DArray[3-1][8-1].getPieceID() == 0 
                && tile2DArray[4-1][8-1].getPieceID() == 0) && (getWhiteKingHasMoved() == Boolean.FALSE) && (rook.getLeftWhiteHasMoved() == Boolean.FALSE)) {
            
            returnNum += -1;
        }

        if (x1 == 1 && y1 == 1) {
            returnNum =+ moveThree + moveFour + moveFive;
        } else if ((x1 == 1 && y1 == 2) || (x1 == 1 && y1 == 3) || (x1 == 1 && y1 == 4) ||
                (x1 == 1 && y1 == 5) || (x1 == 1 && y1 == 6) || (x1 == 1 && y1 == 7)) {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive;
        } else if (x1 == 1 && y1 == 8) {
            returnNum += moveOne + moveTwo + moveThree;
        } else if ((x1 == 2 && y1 == 8) || (x1 == 3 && y1 == 8) || (x1 == 4 && y1 == 8) ||
                (x1 == 5 && y1 == 8) || (x1 == 6 && y1 == 8) || (x1 == 7 && y1 == 8)) {
            returnNum += moveOne + moveTwo + moveThree + moveSeven + moveEight;
        } else if (x1 == 8 && y1 == 8) {
            returnNum += moveOne + moveSeven + moveEight;
        } else if ((x1 == 8 && y1 == 2) || (x1 == 8 && y1 == 3) || (x1 == 8 && y1 == 4) ||
                (x1 == 8 && y1 == 5) || (x1 == 8 && y1 == 6) || (x1 == 8 && y1 == 7)) {
            returnNum += moveOne + moveFive + moveSix + moveSeven + moveEight;
        } else if (x1 == 8 && y1 == 1) {
            returnNum += moveFive + moveSix + moveSeven;
        } else if ((x1 == 2 && y1 == 1) || (x1 == 3 && y1 == 1) || (x1 == 4 && y1 == 1) ||
                (x1 == 5 && y1 == 1) || (x1 == 6 && y1 == 1) || (x1 == 7 && y1 == 1)) {
            returnNum += moveThree + moveFour + moveFive + moveSix + moveSeven;
        } else {
            returnNum += moveOne + moveTwo + moveThree + moveFour + moveFive + moveSix + 
                    moveSeven + moveEight;
        }
        
        if (returnNum == -1) {
            
            return true;
        }
        //System.out.println("Failed due to: outside king moveset");
        return false;
    
    }

}

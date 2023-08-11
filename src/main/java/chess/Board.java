
package chess;

import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Queen;
import chessPieces.Rook;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class Board {
    
    private Button button;
    private int rows;
    private int columns;
    private Pawn pawn;
    private Knight knight;
    private Bishop bishop;
    private Rook rook;
    private Queen queen;
    private King king;
    
    private int holderID;
    private String holderColor;

    private Tile[][] tile2DArray;
    private GridPane chessBoard;
    private ArrayList<Integer> tileList;
    
    public Board() {
        this.button = button;
        this.rows = 8;
        this.columns = 8;
        this.pawn = new Pawn();
        this.knight = new Knight();
        this.bishop = new Bishop();
        this.rook = new Rook();
        this.queen = new Queen();
        this.king = new King();

        // > Going to try to switch the rows and columns
        this.tile2DArray = new Tile[columns][rows];
        this.chessBoard = new GridPane();
        this.holderID = 0;
        this.holderColor = "NONE";
        this.tileList = new ArrayList<>();
    }
    
    
    public void startGame(Stage stage) {

        /**
         GridPane chessBoard creation and styling.
         * You can style the chessBoard here. 
         * Tile objects, drawn from the tile2DArray will populate the chessBoard
         */
        //GridPane chessBoard = new GridPane(); 
        chessBoard.setStyle(" -fx-background-color: #fefefe; -fx-border-color: black; -fx-border-width: 3 ; "
                + "-fx-background-insets: 0; -fx-background-radius:0;");
        //chessBoard.setAlignment(Pos.CENTER);
        
        Button resetButton = new Button("Start Game");
        resetButton.setFont(Font.font("Cooper Black", 14));
        Button testButton = new Button("TEST");

        HBox gameMenu = new HBox();
        gameMenu.setStyle("-fx-border-color: black; -fx-border-width: 5 ;");
        gameMenu.setPadding(new Insets(15, 15, 15, 15));
        gameMenu.getChildren().add(resetButton);
        gameMenu.getChildren().add(testButton);
        
        /**
         Adds tiles to tile2DArray.
         * A Tile object is composed of a button, an x-coordinate, a y-coordinate, a pieceID, and pieceColor.
         * We will use this data structure to access/change tiles, and to refresh the board.
         */
        initializeBlankBoard(chessBoard);   
        
        /**
         Action Event for Start Game Button
         * Places pieces in starting location.
         */
        resetButton.setOnMouseClicked((event) -> {
            initializeStartingBoard(chessBoard);
            resetButton.setText("Reset Game");
        });
        
        
        testButton.setOnMouseClicked((event) -> {
            tile2DArray[4][4].setPieceID(6);
            tile2DArray[4][4].setPieceColor("BLACK");
            
            initializeUpdatedBoard();
        });
        

        

            
        
        
        
        
        
        
        
        
        
        
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gameMenu);
        borderPane.setBottom(chessBoard);
        
        var scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Java-Chess");
        stage.setResizable(false);
        stage.show();
        
        
            
    }
    
    public void empty2DArray(Tile[][] array) {
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array, null);
        }
    }
    

    
    public void initializeUpdatedBoard() {
        chessBoard.getChildren().clear();
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button boardButton = new Button();
                setButtonStyle(boardButton, colorCount, x);
                colorCount++;
                
                // We need to get new information from the 2D array
                
                Tile tile = new Tile(tile2DArray[x-1][y-1].getTileButton(), tile2DArray[x-1][y-1].getXCoordinate(), 
                        tile2DArray[x-1][y-1].getYCoordinate(), tile2DArray[x-1][y-1].getPieceID(), 
                        tile2DArray[x-1][y-1].getPieceColor());
                setTileGraphic(tile2DArray[x-1][y-1]);

                chessBoard.add(tile.getTileButton(), x, y);
            }
        } 
    }
    
    public int convertLayoutX(int x) {
        if (x == 3) {
            return 1;
        } else if (x == 68) {
            return 2;
        } else if (x == 133) {
            return 3;
        } else if (x == 198) {
            return 4;
        } else if (x == 263) {
            return 5;
        } else if (x == 328) {
            return 6;
        } else if (x == 393) {
            return 7;
        } else {
            return 8;
        }
    }
    
    public int convertLayoutY(int y) {
        if (y == 3) {
            return 1;
        } else if (y == 68) {
            return 2;
        } else if (y == 133) {
            return 3;
        } else if (y == 198) {
            return 4;
        } else if (y == 263) {
            return 5;
        } else if (y == 328) {
            return 6;
        } else if (y == 393) {
            return 7;
        } else {
            return 8;
        }
    }
    
    public void setButtonStyle(Button boardButton, int colorCount, int x) {
        
        boardButton.setOnMouseClicked((event) -> {
            
            if (this.tileList.isEmpty()) {

                int xLayout = (int) boardButton.getLayoutX();
                int yLayout = (int) boardButton.getLayoutY();
                System.out.println(xLayout + ", " + yLayout);

                this.tileList.add(convertLayoutX(xLayout));
                this.tileList.add(convertLayoutY(yLayout));
                
                System.out.println("First button layout x: " + xLayout);
                System.out.println("First button layout y: " + yLayout);
                System.out.println("First button tile x: " + this.tileList.get(0));
                System.out.println("First button tile y: " + this.tileList.get(1));
                System.out.println("First button piece: " + tile2DArray[convertLayoutX(xLayout)-1][convertLayoutY(yLayout)-1].getPieceID() + ", " + 
                        tile2DArray[convertLayoutX(xLayout)-1][convertLayoutY(yLayout)-1].getPieceColor());
                System.out.println("-------------------------");

            } else {
                // Retrieves coordinates of first button from arraylist
                int xCoor = this.tileList.get(0);
                int yCoor = this.tileList.get(1);
                
                // Gets layoutX and layoutY from second button as int (3-458).
                int xLayoutSecond = (int) boardButton.getLayoutX();
                int yLayoutSecond = (int) boardButton.getLayoutY();
                
                System.out.println("Second button layout x: " + xLayoutSecond);
                System.out.println("Second button layout y: " + yLayoutSecond);
                System.out.println("Second button x: " + convertLayoutX(xLayoutSecond));
                System.out.println("Second button y: " + convertLayoutY(yLayoutSecond));
                System.out.println("Second button piece: " + tile2DArray[xCoor-1][yCoor-1].getPieceID() + ", " + 
                        tile2DArray[xCoor-1][yCoor-1].getPieceColor());
                System.out.println("***************************");
                System.out.println();
                
                if (pieceCanMove(xCoor, yCoor, convertLayoutX(xLayoutSecond), convertLayoutY(yLayoutSecond))) {
                    // set second button graphic to the graphic that is currently on first button.
                    boardButton.setGraphic(getTileGraphic(tile2DArray[xCoor-1][yCoor-1]));
                
                    //Sets array pieceID and pieceColor of second button to that of the first button
                    tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceID(tile2DArray[xCoor-1][yCoor-1].getPieceID());
                    tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceColor(tile2DArray[xCoor-1][yCoor-1].getPieceColor());
                
                    //Sets array pieceID and pieceColor of first button to blank:
                    tile2DArray[xCoor-1][yCoor-1].setPieceID(0);
                    tile2DArray[xCoor-1][yCoor-1].setPieceColor("NONE");
                    setTileGraphic(tile2DArray[xCoor-1][yCoor-1]);
                }
                
                
                
                //Clear list so first button can collect coordinates. 
                this.tileList.clear();
            }
            
        });
        
        boardButton.setMinHeight(65);
        boardButton.setMaxHeight(65);
        boardButton.setMinWidth(65);
        boardButton.setMaxWidth(65);
        boardButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        boardButton.setContentDisplay(ContentDisplay.CENTER);
        boardButton.setStyle(" -fx-background-color: #fefefe; -fx-border-color: black; -fx-border-width: 2 ; "
                            + "-fx-background-insets: 0; -fx-background-radius:0; ");
        if (colorCount % 2 == 1 && x % 2 == 1) {
            boardButton.setStyle("-fx-background-color: #01965c; -fx-border-color: black; -fx-border-width: 2 ; "
                    + "-fx-background-insets: 0; -fx-background-radius:0; ");
        }
        if (colorCount % 2 == 0 && x % 2 == 0) {
            boardButton.setStyle("-fx-background-color: #01965c; -fx-border-color: black; -fx-border-width: 2 ; "
                    + "-fx-background-insets: 0; -fx-background-radius:0; ");
        }
        
        if (boardButton.getStyle().contains("-fx-background-color: #01965c;")) {
            boardButton.setOnMouseEntered((event) -> {
                boardButton.setStyle(" -fx-background-color: #014329; -fx-border-color: black; -fx-border-width: 2 ; "
                            + "-fx-background-insets: 0; -fx-background-radius:0; ");
            });
            boardButton.setOnMouseExited((event) -> {
                boardButton.setStyle(" -fx-background-color: #01965c; -fx-border-color: black; -fx-border-width: 2 ; "
                            + "-fx-background-insets: 0; -fx-background-radius:0; ");
            });
        } else {
            boardButton.setOnMouseEntered((event) -> {
                boardButton.setStyle(" -fx-background-color: #b6d7a8; -fx-border-color: black; -fx-border-width: 2 ; "
                            + "-fx-background-insets: 0; -fx-background-radius:0; ");
            });
            boardButton.setOnMouseExited((event) -> {
                boardButton.setStyle(" -fx-background-color: #fefefe; -fx-border-color: black; -fx-border-width: 2 ; "
                            + "-fx-background-insets: 0; -fx-background-radius:0; ");
            });
        }
        

        
        
        
        
    }
    
    public boolean pieceCanMove(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        // This method will determine if a piece can move. If can return true, if cannot return false.
        String firstColor = this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor();
        String secondColor = this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor();
        System.out.println("&&&&&&&&&&&&&&&&&");
        System.out.println(firstColor + " + " + secondColor);
        System.out.println("&&&&&&&&&&&&&&&&&");
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        int xTileTwo = xSecondTile - 1;
        int yTileTwo = ySecondTile - 1;
        
        // if second tile contains a king, return false;
        if (tile2DArray[xTileTwo][yTileTwo].getPieceID() == 6) {
            System.out.println("Failed due to: you cannot capture a king!");
            return false;
        }

        // if moving piece color is not the same as piece occupying tile being moved to.
        if (!(this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor() == this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor())) {
            
            // ****** if piece is a pawn *******
            if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 1) {
                
                // if pawn is white
                if (this.tile2DArray[xTileOne][yTileOne].getPieceColor() == "WHITE") {   
                    // if pawn is in white starting position (y = 7)
                    if (yFirstTile == 7) {
                        // if pawn wants to move one space ahead.
                        if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn wants to move two spaces ahead.    
                        } else if ((xTileOne == xTileTwo) && (yTileOne - 2 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne - 2] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn is in column x = 1.
                        } else if (xFirstTile == 1) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne + 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                            return false;
                        // if pawn is in column x = 8.    
                        } else if (xFirstTile == 8) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne - 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                            return false;
                            
                        // if pawn wants to move diagonal one space (right or left) to take black piece.    
                        } else if (((this.tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne - 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])
                                || ((this.tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne + 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                            System.out.println("THREE");
                            return true;
                        // no other valid move can be made.
                        } else {
                            System.out.println("FOUR");
                            System.out.println("Failed due to: invalid pawn move.");
                            return false;
                        }
                    
                    // if pawn is in any other position (y = 1, 2, 3, 4, 5, 6, or 8)    
                    } else {
                        // if pawn wants to move one space ahead. 
                        if ((xTileOne == xTileTwo) && (yTileOne - 1 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne - 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn is in column x = 1.
                        } else if (xFirstTile == 1) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne + 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                            return false;
                        // if pawn is in column x = 8.    
                        } else if (xFirstTile == 8) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne - 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                            return false;
                            
                        // if pawn wants to move diagonal one space (right or left) to take black piece.    
                        } else if (((this.tile2DArray[xTileOne - 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne - 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])
                                || ((this.tile2DArray[xTileOne + 1][yTileOne - 1].getPieceColor() == "BLACK") && this.tile2DArray[xTileOne + 1][yTileOne - 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                            System.out.println("THREE");
                            return true;
                        // no other valid move can be made.
                        } else {
                            System.out.println("SEVEN");
                            System.out.println("Failed due to: invalid pawn move.");
                            return false;
                        }
                    }  
                    
                // if pawn is black    
                } else if (this.tile2DArray[xTileOne][yTileOne].getPieceColor() == "BLACK") {
                    
                    // if pawn is in black starting position (y = 2)
                    if (yFirstTile == 2) {
                        // if pawn wants to move one space ahead.
                        if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn wants to move two spaces ahead.    
                        } else if ((xTileOne == xTileTwo) && (yTileOne + 2 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne + 2] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn is in column x = 1.
                        } else if (xFirstTile == 1) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne + 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                            return false;
                        // if pawn is in column x = 8.    
                        } else if (xFirstTile == 8) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne - 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                            return false;  
                        // if pawn wants to move diagonal one space (right or left) to take black piece.    
                        } else if (((this.tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne + 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])
                                || ((this.tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne - 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                           
                            return true;
                        // no other valid move can be made.
                        } else {
                            System.out.println("Failed due to: invalid pawn move.");
                            return false;
                        }
                    } else {
                        if ((xTileOne == xTileTwo) && (yTileOne + 1 == yTileTwo)) {
                            // if there is no piece directly in front of the pawn.
                            if((this.tile2DArray[xTileOne][yTileOne + 1].getPieceID() == 0) && (this.tile2DArray[xTileOne][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: a piece blocks the pawn.");
                            return false;
                        // if pawn is in column x = 1.
                        } else if (xFirstTile == 1) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne + 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 1 and would cause error.");
                            return false;
                        // if pawn is in column x = 8.    
                        } else if (xFirstTile == 8) {
                            // if suitable diagonal has enemy.
                            if (((this.tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne - 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                                return true;
                            }
                            System.out.println("Failed due to: pawn is on x = 8 and would cause error.");
                            return false; 
                        // if pawn wants to move diagonal one space (right or left) to take black piece.    
                        } else if (((this.tile2DArray[xTileOne + 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne + 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])
                                || ((this.tile2DArray[xTileOne - 1][yTileOne + 1].getPieceColor() == "WHITE") && this.tile2DArray[xTileOne - 1][yTileOne + 1] == this.tile2DArray[xTileTwo][yTileTwo])) {
                            
                            return true;
                        // no other valid move can be made.
                        } else {
                            System.out.println("Failed due to: invalid pawn move.");
                            return false;
                        }
                    }   
                }
                
                
                
                
                
                
                
            // if piece is a knight
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 2) {
                return true;
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            // if piece is a bishop    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 3) {
                
                // Creation of list to store diagonal tile considerations
                ArrayList<Integer> tilePairs = new ArrayList<>();
                // maximum number of tiles a bishop can transervse from each direction
                int topLeftDiagonalMax = topLeftTiles(xFirstTile, yFirstTile);
                int topRightDiagonalMax = topRightTiles(xFirstTile, yFirstTile);
                int bottomLeftDiagonalMax = bottomLeftTiles(xFirstTile, yFirstTile);
                int bottomRightDiagonalMax = bottomRightTiles(xFirstTile, yFirstTile);
                
                // setting first tile x and y to local variables
                int x = xFirstTile;
                int y = yFirstTile;

                // Check if move is within the maximum tile distribution of the top left diagonal
                for (int i = topLeftDiagonalMax; i > 0; i--) {
                    // move to next diagonal tile
                    x -= 1;
                    y -= 1;
                    // if tile piece color is "NONE" then add x & y to tilePairs list.
                    if (this.tile2DArray[x - 1][y - 1].getPieceColor() == "NONE") {
                        tilePairs.add(x);
                        tilePairs.add(y);
                    // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                    } else if (this.tile2DArray[x - 1][y - 1].getPieceColor() == this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                        i = 0;
                    // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                    } else if (this.tile2DArray[x - 1][y - 1].getPieceColor() != this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
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
                    if (this.tile2DArray[x2 - 1][y2 - 1].getPieceColor() == "NONE") {
                        tilePairs.add(x2);
                        tilePairs.add(y2);
                    // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                    } else if (this.tile2DArray[x2 - 1][y2 - 1].getPieceColor() == this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                        i = 0;
                    // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                    } else if (this.tile2DArray[x2 - 1][y2 - 1].getPieceColor() != this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
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
                    if (this.tile2DArray[x3 - 1][y3 - 1].getPieceColor() == "NONE") {
                        tilePairs.add(x3);
                        tilePairs.add(y3);
                    // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                    } else if (this.tile2DArray[x3 - 1][y3 - 1].getPieceColor() == this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                        i = 0;
                    // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                    } else if (this.tile2DArray[x3 - 1][y3 - 1].getPieceColor() != this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
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
                    if (this.tile2DArray[x4 - 1][y4 - 1].getPieceColor() == "NONE") {
                        tilePairs.add(x4);
                        tilePairs.add(y4);
                    // if tile piece color is the same as the current tile, stop adding tile to tilePairs list.
                    } else if (this.tile2DArray[x4 - 1][y4 - 1].getPieceColor() == this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
                        i = 0;
                    // if tile piece color is different from the current tile, add x & y to tilePairs list and continue.
                    } else if (this.tile2DArray[x4 - 1][y4 - 1].getPieceColor() != this.tile2DArray[xTileOne][yTileOne].getPieceColor()) {
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
                
                System.out.println("Failed due to: A bishop cannot move to this space.");
                return false;
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

            // if piece is a rook    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 4) {
                return true;
                
            // if piece is a queen    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 5) {
                return true;
            // if piece is a king    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 6) {
                return true;
            // if piece is a nothing    
            } else {
                return false;
            }   
        }
        System.out.println("Failed due to: pieces are the same color!");
        return false;
    }
    

    public void initializeBlankBoard(GridPane chessBoard) {
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button boardButton = new Button();
                setButtonStyle(boardButton, colorCount, x);
                colorCount++;
                
                Tile tile = new Tile(boardButton, x, y, assignPieceID(x, y), assignPieceColor(x, y));
                addTileToArray(tile, tile.getXCoordinate(), tile.getYCoordinate(), tile.getPieceID(), tile.getPieceColor());  
               
                
                chessBoard.add(tile2DArray[x-1][y-1].getTileButton(), x, y);
            }
        } 
    }
    
    public void initializeStartingBoard(GridPane chessBoard) {
        chessBoard.getChildren().clear();
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button boardButton = new Button();
                setButtonStyle(boardButton, colorCount, x);
                colorCount++;
                
                Tile tile = new Tile(boardButton, x, y, assignPieceID(x, y), assignPieceColor(x, y));
                addTileToArray(tile, tile.getXCoordinate(), tile.getYCoordinate(), tile.getPieceID(), tile.getPieceColor());
                setTileGraphic(tile2DArray[x-1][y-1]);
                
                //System.out.println(x + ", " + y + ": " + tile2DArray[x-1][y-1]);
                
                chessBoard.add(tile2DArray[x-1][y-1].getTileButton(), x, y);
            }
        }
    }
    
    private ImageView getTileGraphic(Tile tile) {
        int pieceID = tile.getPieceID();
        String pieceColor = tile.getPieceColor();
        ImageView image = new ImageView();
        
        if (pieceID == 1) {
            if (pieceColor.equals("WHITE")) {
                image = pawn.getImageView("WHITE");    
            } else {
                image = pawn.getImageView("BLACK");
            }
        } else if (pieceID == 2) {
            if (pieceColor.equals("WHITE")) {
                image = knight.getImageView("WHITE");
            } else {
                image = knight.getImageView("BLACK");
            }
            
        } else if (pieceID == 3) {
            if (pieceColor.equals("WHITE")) {
                image = bishop.getImageView("WHITE");
            } else {
                image = bishop.getImageView("BLACK");
            }
        } else if (pieceID == 4) {
            if (pieceColor.equals("WHITE")) {
                image = rook.getImageView("WHITE");
            } else {
                image = rook.getImageView("BLACK");
            }
        } else if (pieceID == 5) {
            if (pieceColor.equals("WHITE")) {
                image = queen.getImageView("WHITE");
            } else {
                image = queen.getImageView("BLACK");
            }
        } else if (pieceID == 6) {
            if (pieceColor.equals("WHITE")) {
                image = king.getImageView("WHITE");
            } else {
                image = king.getImageView("BLACK");
            }
        } else {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
            image = new ImageView(imageFile);

        }
        return image;
    }
    
    private void setTileGraphic(Tile tile) {
        int pieceID = tile.getPieceID();
        String pieceColor = tile.getPieceColor();
        
        if (pieceID == 1) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(pawn.getImageView("WHITE"));    
            } else {
                tile.getTileButton().setGraphic(pawn.getImageView("BLACK"));
            }
        } else if (pieceID == 2) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(knight.getImageView("WHITE"));
            } else {
                tile.getTileButton().setGraphic(knight.getImageView("BLACK"));
            }
            
        } else if (pieceID == 3) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(bishop.getImageView("WHITE"));
            } else {
                tile.getTileButton().setGraphic(bishop.getImageView("BLACK"));
            }
        } else if (pieceID == 4) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(rook.getImageView("WHITE"));
            } else {
                tile.getTileButton().setGraphic(rook.getImageView("BLACK"));
            }
        } else if (pieceID == 5) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(queen.getImageView("WHITE"));
            } else {
                tile.getTileButton().setGraphic(queen.getImageView("BLACK"));
            }
        } else if (pieceID == 6) {
            if (pieceColor.equals("WHITE")) {
                tile.getTileButton().setGraphic(king.getImageView("WHITE"));
            } else {
                tile.getTileButton().setGraphic(king.getImageView("BLACK"));
            }
        } else {
            ImageView image = new ImageView();
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/nothing.png");
            image = new ImageView(imageFile);

            tile.getTileButton().setGraphic(image);
        }

   
    }
    
    public String assignPieceColor(int x, int y) {
        String pieceColor = "NONE";
        if (y == 2 || y == 7) {
            if (y == 2) {
                pieceColor = "BLACK";
            } else {
                pieceColor = "WHITE";
            }
        } else if (y == 1) {
            pieceColor = "BLACK";
        } else if (y == 8) {
            pieceColor = "WHITE";
   
        } 
        return pieceColor;
    }
    
    public int assignPieceID(int x, int y) {
        
        int pieceID = 0;
        if (y == 2 || y == 7) {
            pieceID = 1;
        } else if (y == 1 || y == 8) {
            if (x == 1 || x == 8) {
                pieceID = 4;
            } else if (x == 2 || x == 7) {
                pieceID = 2;
            } else if (x == 3 || x == 6) {
                pieceID = 3;
            } else if (x == 5) {
                pieceID = 6;
            } else {
                pieceID = 5;
            }
        
        } 
        return pieceID;
    }
    
    public void addTileToArray(Tile tile, int x, int y, int pieceID, String color) {
        tile2DArray[x-1][y-1] = tile;    
    }
    
    
    /**
    Bishop diagonal move calculation methods.
    * These methods calculate the maximum number of tiles a bishop can transverse diagonally
    */
    public int topLeftTiles(int column, int row) {
        return Math.min(row, column) - 1;
    }
    
    public int bottomLeftTiles(int column, int row) {
        return 8 - Math.max(row, 9 - column);
    }
    
    public int topRightTiles(int column, int row) {
        return Math.min(row, 9 - column) - 1;
    }
    
    public int bottomRightTiles(int column, int row) {
        return 8 - Math.max(row, column);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    

    
    

    
}

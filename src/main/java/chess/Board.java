/**
 * @author Jacob Hobbs
 */
package chess;

import chessPieces.Bishop;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Queen;
import chessPieces.Rook;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Board class defines how the data structure of the chess game is manipulated and how it is
 * visually presented.
 * */
public class Board {

    private int rows;
    private int columns;
    private Pawn pawn;
    private Knight knight;
    private Bishop bishop;
    private Rook rook;
    private Queen queen;
    private King king;
    private Tile[][] tile2DArray;
    private GridPane chessBoard;
    private ArrayList<Integer> tileList;
    private Label playerLabel;
    private Button queenButton;
    private Button rookButton;
    private Button bishopButton;
    private Button knightButton;
    private int enPassantCount;
    private Player player;
    private Boolean promotionActive;
    
    /**
     * Board constructor.
     * Defines default attribute values upon Board instantiation.
     * */
    public Board() {
        this.rows = 8;
        this.columns = 8;
        this.pawn = new Pawn();
        this.knight = new Knight();
        this.bishop = new Bishop();
        this.rook = new Rook();
        this.queen = new Queen();
        this.king = new King();
        this.tile2DArray = new Tile[columns][rows];
        this.chessBoard = new GridPane();
        this.tileList = new ArrayList<>();
        this.playerLabel = new Label("PLAYER:\n WHITE");
        this.queenButton = new Button();
        this.rookButton = new Button();
        this.bishopButton = new Button();
        this.knightButton = new Button();
        this.enPassantCount = 0;
        this.player = new Player();
        this.promotionActive = Boolean.FALSE;
        
    }

    /**
     * startGame method presents initial visual board details at runtime. This includes
     * a blank board with no chess pieces and the option to begin a new game.
     * */
    public void startGame(Stage stage) {

        chessBoard.setStyle(" -fx-background-color: #fefefe; -fx-border-color: black; -fx-border-width: 3 ; "
                + "-fx-background-insets: 0; -fx-background-radius:0;");
        
        Button resetButton = new Button("Start Game");
        resetButton.setFont(Font.font("Cooper Black", 14));
        
        setPromotionButtons(queenButton, rookButton, bishopButton, knightButton);
        
        playerLabel.setFont(Font.font("Cooper Black", 14));

        HBox gameMenu = new HBox();
        gameMenu.setStyle("-fx-border-color: black; -fx-border-width: 5 ;");
        gameMenu.setPadding(new Insets(15, 15, 15, 15));
        gameMenu.setAlignment(Pos.CENTER);
        gameMenu.setSpacing(25);
        gameMenu.getChildren().add(resetButton);
        gameMenu.getChildren().add(this.playerLabel);
        gameMenu.getChildren().add(queenButton);
        gameMenu.getChildren().add(rookButton);
        gameMenu.getChildren().add(bishopButton);
        gameMenu.getChildren().add(knightButton);
        
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
            
            king.setBlackKingHasMoved(false);
            king.setWhiteKingHasMoved(false);
            
            rook.setLeftBlackHasMoved(false);
            rook.setRightBlackHasMoved(false);
            rook.setLeftWhiteHasMoved(false);
            rook.setRightWhiteHasMoved(false);
            player.setCurrentPlayer("WHITE");
            setPromotionButtons(queenButton, rookButton, bishopButton, knightButton);
            playerLabel.setText("PLAYER: \n WHITE");
            king.setCheckStatus(false, "BLACK");
            king.setCheckStatus(false, "WHITE");
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

    /**
     * setPromotionButtons method sets each promotion button with its respective chess piece image.
     * */
    public void setPromotionButtons(Button queenButton, Button rookButton, Button bishopButton, Button knightButton) {
        queenButton.setMinSize(40, 40);
        queenButton.setMaxSize(40, 40);
        Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
        ImageView image = new ImageView(imageFile);
        image.setScaleX(0.65);
        image.setScaleY(0.65);
        queenButton.setGraphic(image);
        queenButton.setDisable(true);
        
        rookButton.setMinSize(40, 40);
        rookButton.setMaxSize(40, 40);
        Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
        ImageView image2 = new ImageView(imageFile2);
        image2.setScaleX(0.65);
        image2.setScaleY(0.65);
        rookButton.setGraphic(image2);
        rookButton.setDisable(true);
        
        bishopButton.setMinSize(40, 40);
        bishopButton.setMaxSize(40, 40);
        Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
        ImageView image3 = new ImageView(imageFile3);
        image3.setScaleX(0.65);
        image3.setScaleY(0.65);
        bishopButton.setGraphic(image3);
        bishopButton.setDisable(true);
        
        knightButton.setMinSize(40, 40);
        knightButton.setMaxSize(40, 40);
        Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
        ImageView image4 = new ImageView(imageFile4);
        image4.setScaleX(0.65);
        image4.setScaleY(0.65);
        knightButton.setGraphic(image4);
        knightButton.setDisable(true);
    }

    /**
     * initializeUpdatedBoard method is utilized at the end of each turn. The visual grid of buttons
     * presented in the JavaFX window is cleared, the two-dimensional array is updated to reflect a
     * player's move, and then each updated tile object is placed back into the grid.
     *
     * Check and checkmate conditions are assessed. Checkmate locks up move selection.
     * */
    public void initializeUpdatedBoard() {
        chessBoard.getChildren().clear();
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button updatedButton = new Button();
                setButtonStyle(updatedButton, colorCount, x);
                colorCount++;
                
                // We need to get new information from the 2D array
                Tile tile = new Tile(tile2DArray[x-1][y-1].getTileButton(), tile2DArray[x-1][y-1].getXCoordinate(), 
                        tile2DArray[x-1][y-1].getYCoordinate(), tile2DArray[x-1][y-1].getPieceID(), 
                        tile2DArray[x-1][y-1].getPieceColor(), tile2DArray[x-1][y-1].getEnPassantDanger(), 
                        tile2DArray[x-1][y-1].getCheckDangerWhite(), tile2DArray[x-1][y-1].getCheckDangerBlack());
                setTileGraphic(tile2DArray[x-1][y-1]);

                chessBoard.add(tile.getTileButton(), x, y);
                
                // SETS ALL ON BOARD TO FALSE AND THEN RE-ADDS THEM!
                tile2DArray[x-1][y-1].setCheckDangerWhite(Boolean.FALSE);
                tile2DArray[x-1][y-1].setCheckDangerBlack(Boolean.FALSE);
            }
        }

        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                
                // PLACE CHECK DANGER FOR EACH PIECE ON BOARD
                if (tile2DArray[x-1][y-1].getPieceID() == 1) {
                    pawn.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 2) {
                    knight.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 3) {
                    bishop.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 4) {
                    rook.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 5) {
                    queen.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 6) {
                    king.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                }

            }
        }

        // For every tile on the board...
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                
                if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getPieceColor() == "WHITE") {
                    
                    if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getCheckDangerBlack() == true) {
                        
                        // set the white check danger on this tile to true;
                        king.setCheckStatus(Boolean.TRUE, "WHITE");
                        playerLabel.setText(player.getCurrentPlayer() + "\nCHECK");
                        //System.out.println(this.tile2DArray[x-1][y-1].getPieceColor());
                        //System.out.println("3: CHECK STATUS SET AS TRUE FOR WHITE KING");
                        
                        //CHECK FOR CHECKMATE WHITE
                        if (player.getCurrentPlayer() == "WHITE") {
                            if (king.getKingCheckmate("WHITE") == Boolean.TRUE) {
                                playerLabel.setText("CHECKMATE" + "\nBLACK WINS!");
                                playerLabel.setFont(Font.font("Cooper Black", 13));
            
                                for (int x1 = 1; x1 <= 8; x1++) {
                                    for (int y1 = 1; y1 <= 8; y1++) {
                                        this.tile2DArray[x1-1][y1-1].getTileButton().setDisable(true);
                                    }
                                }    
                        
                            } 
                        }

                    } else if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getCheckDangerBlack() == Boolean.FALSE) {
                        // set the white check danger on this tile to false;
                        king.setCheckStatus(Boolean.FALSE, "WHITE");
                        //System.out.println(this.tile2DArray[x-1][y-1].getPieceColor());
                        //System.out.println("4: CHECK STATUS SET AS FALSE FOR WHITE KING");
                        
                        // CHECK FOR STALEMATE WHITE
                        if (king.getKingStalemate("WHITE") == Boolean.TRUE) {
                                playerLabel.setText("STALEMATE!");
            
                                for (int x1 = 1; x1 <= 8; x1++) {
                                    for (int y1 = 1; y1 <= 8; y1++) {
                                        this.tile2DArray[x1-1][y1-1].getTileButton().setDisable(true);
                                    }
                                }   
            
                        }
                    }

                } else if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getPieceColor() == "BLACK") {
                    
                    if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getCheckDangerWhite() == Boolean.TRUE) {
                        
                        System.out.println("IT'S TRUE! IT'S TRUE!");
                        // set the black check danger on this tile to true;
                        king.setCheckStatus(Boolean.TRUE, "BLACK");
                        playerLabel.setText(player.getCurrentPlayer() + "\nCHECK");
                        //System.out.println(this.tile2DArray[x-1][y-1].getPieceColor());
                        //System.out.println("1: CHECK STATUS SET AS TRUE FOR BLACK KING");
                        
                        // CHECK FOR CHECKMATE BLACK
                        if (player.getCurrentPlayer() == "BLACK") {
                            if (king.getKingCheckmate("BLACK") == Boolean.TRUE) {
                                playerLabel.setText("CHECKMATE" + "\nWHITE WINS!");
                                playerLabel.setFont(Font.font("Cooper Black", 13));
            
                                for (int x1 = 1; x1 <= 8; x1++) {
                                    for (int y1 = 1; y1 <= 8; y1++) {
                                        this.tile2DArray[x1-1][y1-1].getTileButton().setDisable(true);
                                    }
                                }    
                        
                            } 
                        }

                    // if tile is a king and the king's white check danger is false...
                    } else if (this.tile2DArray[x-1][y-1].getPieceID() == 6 && this.tile2DArray[x-1][y-1].getCheckDangerWhite() == Boolean.FALSE) {
                        // set the black check danger on this tile to false;
                        king.setCheckStatus(Boolean.FALSE, "BLACK");
                        //System.out.println(this.tile2DArray[x-1][y-1].getPieceColor());
                        //System.out.println("2: CHECK STATUS SET AS FALSE FOR BLACK KING");
                        
                        // CHECK FOR STALEMATE BLACK
                        if (king.getKingStalemate("BLACK") == Boolean.TRUE) {
                                playerLabel.setText("STALEMATE!");
            
                                for (int x1 = 1; x1 <= 8; x1++) {
                                    for (int y1 = 1; y1 <= 8; y1++) {
                                        this.tile2DArray[x1-1][y1-1].getTileButton().setDisable(true);
                                    }
                                }
                        }
                    } 
                    
                }
            }
        } 
        
    }

    /**
     * checkForCheckmate method assesses for checkmate of next player.
     *
     * In order to save on execution time, only tiles containing the parameterized players' pieces
     * have their danger values assessed. If a players pieces cannot move and the king is in check, checkmate occurs.
     * */
    public void checkForCheckmate(String playerColor) {
        
        // used to hold number of pieces that player currently has on board
        int pieceCount = 0;
        // user to hold the number of pieces that are able to currently move
        int piecesThatCannotMove = 0;
        // used to hold the number of possible tiles checked
        int tilesChecked = 0;
        
        int canMoveTiles = 0;

        // For all tiles on board...
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                // if tile contains a piece of the player's color...
                if (this.tile2DArray[x-1][y-1].getPieceColor() == playerColor) { 
                    pieceCount++;
                    // if selected piece cannot move...
                    for (int i = 1; i <= 8; i++) {
                        for (int j = 1; j <= 8; j++) {
                            
                            // need to make sterile "piece can move" method that does not actually alter variables or the tile2DArray.
                            if (pieceCanMoveCheckmateCheckMaster(x, y, i, j)) {
                                
                                // ACTUALLY CHANGE tile2DArray
                                String pieceColor1 = tile2DArray[x-1][y-1].getPieceColor();
                                int pieceID1 = tile2DArray[x-1][y-1].getPieceID();
                                String pieceColor2 = tile2DArray[i-1][j-1].getPieceColor();
                                int pieceID2 = tile2DArray[i-1][j-1].getPieceID();

                                // Sets array pieceID and pieceColor of second button to that of the first button
                                tile2DArray[i-1][j-1].setPieceID(tile2DArray[x-1][y-1].getPieceID());
                                tile2DArray[i-1][j-1].setPieceColor(tile2DArray[x-1][y-1].getPieceColor());
                    
                    
                                // Sets array pieceID and pieceColor of first button to blank:
                                tile2DArray[x-1][y-1].setPieceID(0);
                                tile2DArray[x-1][y-1].setPieceColor("NONE");
                    
                                // Push pieces through and update tile check danger spots
                                initializeUpdatedBoard(); 
                                
                                
                                // CHECK TO SEE IF KING IS STILL IN CHECK
                                if (king.getCheckStatus(playerColor) == Boolean.TRUE) {
                                    tilesChecked++;
                                } else if (king.getCheckStatus(playerColor) == Boolean.FALSE) {
                                    tile2DArray[x-1][y-1].setPieceID(pieceID1);
                                    tile2DArray[x-1][y-1].setPieceColor(pieceColor1);
                                    tile2DArray[i-1][j-1].setPieceID(pieceID2);
                                    tile2DArray[i-1][j-1].setPieceColor(pieceColor2);
                                
                                    setTileGraphic(tile2DArray[x-1][y-1]);
                                    setTileGraphic(tile2DArray[i-1][j-1]);

                                    canMoveTiles++;

                                }

                                // CHANGE TILES BACK
                                    // update tile board
                                tile2DArray[x-1][y-1].setPieceID(pieceID1);
                                tile2DArray[x-1][y-1].setPieceColor(pieceColor1);
                                tile2DArray[i-1][j-1].setPieceID(pieceID2);
                                tile2DArray[i-1][j-1].setPieceColor(pieceColor2);
                                
                                setTileGraphic(tile2DArray[x-1][y-1]);
                                setTileGraphic(tile2DArray[i-1][j-1]);
                    
                                // Push pieces through and update tile check danger spots
                                initializeUpdatedBoard();  
                                
                                tilesChecked++;
      
                            } else {
                                
                                tilesChecked++;
                            }    
                        }
                    }
                }
            }
        }
        
        if (king.getCheckStatus(playerColor) == Boolean.FALSE && canMoveTiles == 0) {
            king.setKingStalemate(true, playerColor);
        } else if (king.getCheckStatus(playerColor) == Boolean.TRUE && canMoveTiles == 0) {
            king.setKingCheckmate(true, playerColor);
        } else {
            // do nothing
        }
    }

    /**
     * convertLayoutX method used to convert pixel x-position to grid place.
     * */
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

    /**
     * convertLayoutY method used to convert pixel y-position to grid place.
     * */
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

    /**
     * setButtonStyle intakes each grid button and sets its style and tile information.
     * This includes position, chess piece image, and danger/en passant signals.
     * */
    public void setButtonStyle(Button boardButton, int colorCount, int x) {
        
        boardButton.setOnMouseClicked((event) -> {
            
            if (this.tileList.isEmpty()) {

                int xLayout = (int) boardButton.getLayoutX();
                int yLayout = (int) boardButton.getLayoutY();
                //System.out.println(xLayout + ", " + yLayout);

                this.tileList.add(convertLayoutX(xLayout));
                this.tileList.add(convertLayoutY(yLayout));

            } else {
                // Retrieves coordinates of first button from arraylist
                int xCoor = this.tileList.get(0);
                int yCoor = this.tileList.get(1);

                // Gets layoutX and layoutY from second button as int (3-458).
                int xLayoutSecond = (int) boardButton.getLayoutX();
                int yLayoutSecond = (int) boardButton.getLayoutY();

                // IF PIECE CAN MOVE...
                if (pieceCanMove(xCoor, yCoor, convertLayoutX(xLayoutSecond), convertLayoutY(yLayoutSecond)) 
                        && tile2DArray[xCoor-1][yCoor-1].getPieceColor() == player.getCurrentPlayer() && 
                        this.promotionActive == Boolean.FALSE) {
                    
                    // RECORD THIS INFO IN CASE YOU NEED TO SWAP BACK:
                    String pieceColor1 = tile2DArray[xCoor-1][yCoor-1].getPieceColor();
                    int pieceID1 = tile2DArray[xCoor-1][yCoor-1].getPieceID();
                    String pieceColor2 = tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].getPieceColor();
                    int pieceID2 = tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].getPieceID();
                    
                    
                    // MAKE PIECE CHANGE TO CHECK AND SEE IF KING IS IN CHECK IN HYPOTHETICAL PIECE MOVE
                    // Set second button graphic to the graphic that is currently on first button.
                    boardButton.setGraphic(getTileGraphic(tile2DArray[xCoor-1][yCoor-1]));
                
                    // Sets array pieceID and pieceColor of second button to that of the first button
                    tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceID(tile2DArray[xCoor-1][yCoor-1].getPieceID());
                    tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceColor(tile2DArray[xCoor-1][yCoor-1].getPieceColor());

                    // Sets array pieceID and pieceColor of first button to blank:
                    tile2DArray[xCoor-1][yCoor-1].setPieceID(0);
                    tile2DArray[xCoor-1][yCoor-1].setPieceColor("NONE");
                    setTileGraphic(tile2DArray[xCoor-1][yCoor-1]);
                    
                    // Push pieces through and update tile check danger spots
                    initializeUpdatedBoard(); 

                    //System.out.println("CURRENT PLAYER: " + player.getCurrentPlayer());
                    if (king.getCheckStatus(player.getCurrentPlayer()) == Boolean.FALSE) {


                        // Set en passant settings
                        // If enPassantCount = 1, set enPassantCount back to 0 and for each tile on the board in en passant danger, set it to false.
                        if (this.enPassantCount == 1) {
                            this.enPassantCount = 0;
                            for (int xColumn = 1; xColumn <= 8; xColumn++) {
                                for (int yRow = 1; yRow <= 8; yRow++) {
                                    tile2DArray[xColumn-1][yRow-1].setEnPassantDanger(Boolean.FALSE);
                                }
                            }
                        }
                        // FINAL RETURN TRUE
                        // For each tile on the board, if there is a tile in en passant danger, set enPassantCount to 1.
                        for (int xColumn = 1; xColumn <= 8; xColumn++) {
                            for (int yRow = 1; yRow <= 8; yRow++) {
                                if (tile2DArray[xColumn-1][yRow-1].getEnPassantDanger() == Boolean.TRUE) {
                                    if (this.enPassantCount == 0) {
                                        this.enPassantCount = 1;
                                    }
                                }   
                            }
                        }

                        // FINAL RETURN TRUE
                        int promotionAlert = 0;
                    
                        // FINAL RETURN TRUE
                        // Checking for pawn promotion
                        if ((tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].getPieceID()== 1) && 
                                (convertLayoutY(yLayoutSecond) == 1 || convertLayoutY(yLayoutSecond) == 8)) {
                        
                            this.promotionActive = Boolean.TRUE;
                        
                            getPromotionBoard(convertLayoutX(xLayoutSecond)-1, convertLayoutY(yLayoutSecond)-1);
                        
                            if (player.getCurrentPlayer() == "WHITE") {
                                // add to black statements
                                promotionAlert = 2;
                            } else if (player.getCurrentPlayer() == "BLACK") {
                                // add to white 
                                promotionAlert = 1;
                            }

                        // FINAL RETURN TRUE    
                        initializeUpdatedBoard();  
   
                        }
                        // SWITCH PLAYERS AFTER SUCCESSFUL PIECE MOVE
                        if (player.getCurrentPlayer() == "WHITE") {
                            player.setCurrentPlayer("BLACK");
                            playerLabel.setText("PLAYER: \n BLACK");
                        } else if (player.getCurrentPlayer() == "BLACK") {
                            player.setCurrentPlayer("WHITE");
                            playerLabel.setText("PLAYER: \n WHITE");
                        }
                    
                        // ADDED TO SWITCH IMAGES OF PROMOTION BUTTONS
                        String imageFileDirectory = "None";
                        if (player.getCurrentPlayer() == "WHITE" || player.getCurrentPlayer() == "NONE") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteQueen.png";
                            if (promotionAlert == 1) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackQueen.png";
                            
                            }
            
                        } else if (player.getCurrentPlayer() == "BLACK") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackQueen.png";
                            if (promotionAlert == 2) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteQueen.png";
                            
                            }
                        }
                        Image imageFile = new Image(imageFileDirectory);
                        ImageView image = new ImageView(imageFile);
                        image.setScaleX(0.65);
                        image.setScaleY(0.65);
                        queenButton.setGraphic(image);
                    
                        if (player.getCurrentPlayer() == "WHITE" || player.getCurrentPlayer() == "NONE") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteRook.png";
                            if (promotionAlert == 1) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackRook.png";
                            
                            }
                        } else if (player.getCurrentPlayer() == "BLACK") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackRook.png";
                            if (promotionAlert == 2) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteRook.png";
                            
                            }
                        }
                        Image imageFile2 = new Image(imageFileDirectory);
                        ImageView image2 = new ImageView(imageFile2);
                        image2.setScaleX(0.65);
                        image2.setScaleY(0.65);
                        rookButton.setGraphic(image2);
                    
                        if (player.getCurrentPlayer() == "WHITE" || player.getCurrentPlayer() == "NONE") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteBishop.png";
                            if (promotionAlert == 1) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackBishop.png";
                            
                            }
                        } else if (player.getCurrentPlayer() == "BLACK") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackBishop.png";
                            if (promotionAlert == 2) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteBishop.png";
                            
                            }
                        }
                        Image imageFile3 = new Image(imageFileDirectory);
                        ImageView image3 = new ImageView(imageFile3);
                        image3.setScaleX(0.65);
                        image3.setScaleY(0.65);
                        bishopButton.setGraphic(image3);
                    
                        if (player.getCurrentPlayer() == "WHITE" || player.getCurrentPlayer() == "NONE") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteKnight.png";
                            if (promotionAlert == 1) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackKnight.png";
                                playerLabel.setText("PLAYER: \n BLACK");
                                promotionAlert = 0;
                            }
                        } else if (player.getCurrentPlayer() == "BLACK") {
                            imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/blackKnight.png";
                            if (promotionAlert == 2) {
                                imageFileDirectory = "file:src/main/java/chessPieces/pieceImages/whiteKnight.png";
                                playerLabel.setText("PLAYER: \n WHITE");
                                promotionAlert = 0;
                            }
                        }
                        Image imageFile4 = new Image(imageFileDirectory);
                        ImageView image4 = new ImageView(imageFile4);
                        image4.setScaleX(0.65);
                        image4.setScaleY(0.65);
                        knightButton.setGraphic(image4);
                
                        
                        
                    } else if (king.getCheckStatus(player.getCurrentPlayer()) == Boolean.TRUE) {
                        
                        
                
                        //System.out.println("THE " + player.getCurrentPlayer() + " KING IS IN CHECK!");
                
                        // REVERSE PIECE MOVES because the player's king is still in check!!
                        // Set second button graphic to the graphic that is currently on first button.
                        
                        //boardButton.setGraphic(getTileGraphic(tile2DArray[xCoor-1][yCoor-1]));
                
                        tile2DArray[xCoor-1][yCoor-1].setPieceID(pieceID1);
                        tile2DArray[xCoor-1][yCoor-1].setPieceColor(pieceColor1);
                        tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceID(pieceID2);
                        tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1].setPieceColor(pieceColor2);
                        setTileGraphic(tile2DArray[xCoor-1][yCoor-1]);
                        setTileGraphic(tile2DArray[convertLayoutX(xLayoutSecond)-1][convertLayoutY(yLayoutSecond)-1]);
                    
                        // Push pieces through and update tile check danger spots
                        initializeUpdatedBoard();
                
                    }

                }

                // FINAL RETURN TRUE
                //Clear list so first button can collect coordinates. 
                this.tileList.clear();
            }
            
            int whiteKingX = 0;
            int whiteKingY = 0;
            int blackKingX = 0;
            int blackKingY = 0;
            
            // for all tiles...
            for (int x1 = 1; x1 <= 8; x1++) {
                for (int y1 = 1; y1 <= 8; y1++) {
                    
                    if (tile2DArray[x1-1][y1-1].getPieceID() == 6 && tile2DArray[x1-1][y1-1].getPieceColor() == "WHITE") {
                        whiteKingX = x1;
                        whiteKingY = y1;
                    } else if (tile2DArray[x1-1][y1-1].getPieceID() == 6 && tile2DArray[x1-1][y1-1].getPieceColor() == "BLACK") {
                        blackKingX = x1;
                        blackKingY = y1;
                    }
                    
                }
            }

            if (king.getCheckStatus(player.getCurrentPlayer()) == Boolean.TRUE) {
                checkForCheckmate(player.getCurrentPlayer());
            } 

            initializeUpdatedBoard();
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

    /**
     * getPromotionBoard method intakes position of pawn being promoted and then responds to
     * player selection of piece to replace pawn. This method contains event definitions for
     * each promotion button and handles them.
     * */
    public void getPromotionBoard(int xTile, int yTile) {
        
        // Store color of pawn being promoted.
        String copyColor = tile2DArray[xTile][yTile].getPieceColor();
        
        queenButton.setDisable(false);
        rookButton.setDisable(false);
        bishopButton.setDisable(false);
        knightButton.setDisable(false);
        
        queenButton.setOnMouseClicked((event) -> {

            queenButton.setDisable(true);
            rookButton.setDisable(true);
            bishopButton.setDisable(true);
            knightButton.setDisable(true);
            
            if (copyColor == "BLACK") {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n WHITE");
            } else {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/blackKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n BLACK");
            }

            tile2DArray[xTile][yTile].setPieceColor(copyColor);
            tile2DArray[xTile][yTile].setPieceID(5);
            initializeUpdatedBoard();
            this.promotionActive = Boolean.FALSE;
 
        });
        rookButton.setOnMouseClicked((event) -> {

            queenButton.setDisable(true);
            rookButton.setDisable(true);
            bishopButton.setDisable(true);
            knightButton.setDisable(true);
            
            if (copyColor == "BLACK") {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n WHITE");
            } else {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/blackKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n BLACK");
            }
            
            tile2DArray[xTile][yTile].setPieceColor(copyColor);
            tile2DArray[xTile][yTile].setPieceID(4);
            initializeUpdatedBoard();
            this.promotionActive = Boolean.FALSE;
 
        });
        bishopButton.setOnMouseClicked((event) -> {

            queenButton.setDisable(true);
            rookButton.setDisable(true);
            bishopButton.setDisable(true);
            knightButton.setDisable(true);
            
            if (copyColor == "BLACK") {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n WHITE");
            } else {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/blackKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n BLACK");
            }
            
            tile2DArray[xTile][yTile].setPieceColor(copyColor);
            tile2DArray[xTile][yTile].setPieceID(3);
            initializeUpdatedBoard();
            this.promotionActive = Boolean.FALSE;
 
        });
        knightButton.setOnMouseClicked((event) -> {

            queenButton.setDisable(true);
            rookButton.setDisable(true);
            bishopButton.setDisable(true);
            knightButton.setDisable(true);
            
            if (copyColor == "BLACK") {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/whiteKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n WHITE");
            } else {
                Image imageFile1 = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
                ImageView image = new ImageView(imageFile1);
                image.setScaleX(0.65);
                image.setScaleY(0.65);
                queenButton.setGraphic(image);
                Image imageFile2 = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
                ImageView image2 = new ImageView(imageFile2);
                image2.setScaleX(0.65);
                image2.setScaleY(0.65);
                rookButton.setGraphic(image2);
                Image imageFile3 = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
                ImageView image3 = new ImageView(imageFile3);
                image3.setScaleX(0.65);
                image3.setScaleY(0.65);
                bishopButton.setGraphic(image3);
                Image imageFile4 = new Image("file:src/main/java/chessPieces/pieceImages/blackKnight.png");
                ImageView image4 = new ImageView(imageFile4);
                image4.setScaleX(0.65);
                image4.setScaleY(0.65);
                knightButton.setGraphic(image4);
                playerLabel.setText("PLAYER: \n BLACK");
            }
            
            tile2DArray[xTile][yTile].setPieceColor(copyColor);
            tile2DArray[xTile][yTile].setPieceID(2);
            initializeUpdatedBoard();
            this.promotionActive = Boolean.FALSE;
 
        });
        initializeUpdatedBoard();
    }

    /**
     * pieceCanMoveCheckmateCheckMaster method utilizes canPieceMoveCheckMateCheck for each individual
     * piece type. There must be an individual move analysis method for each piece type as each type has
     * its unique moveset.
     * */
    public boolean pieceCanMoveCheckmateCheckMaster(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        // This method will determine if a piece can move. If can return true, if cannot return false.
        String firstColor = this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor();
        String secondColor = this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor();
        
        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        int xTileTwo = xSecondTile - 1;
        int yTileTwo = ySecondTile - 1;
        
        // if second tile contains a king, return false;
        if (tile2DArray[xTileTwo][yTileTwo].getPieceID() == 6) {
            //System.out.println("Failed due to: you cannot capture a king!");
            return false;
        }
        
        Boolean returnBoolean = Boolean.FALSE;

        // if moving piece color is not the same as piece occupying tile being moved to.
        if (!(this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor() == this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor())) {
            
            // if piece is a pawn 
            if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 1) {
                
                return pawn.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = pawn.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a knight
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 2) {
                
                return knight.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = knight.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a bishop    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 3) {
                
                return bishop.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = bishop.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a rook    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 4) {
                
                return rook.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = rook.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                  
            // if piece is a queen    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 5) {
                
                return queen.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = queen.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a king    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 6) {
                
                return king.canPieceMoveCheckmateCheck(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = king.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a nothing    
            } else {
                
                return false;
            }
        }
        return false;
    }

    /**
     * pieceCanMove is the most atomized of the three move methods. This method determines in
     * granularity if a piece can move depending on its type.
     *
     * While canPieceMoveCheckmateCheck and canPieceMoveCheckmateCheckMaster works as a pair when
     * check and checkmate conditions are being assessed, pieceCanMove is used for every piece movement
     * attempt as a baseline before considering more time-consuming methods.
     * */
    public boolean pieceCanMove(int xFirstTile, int yFirstTile, int xSecondTile, int ySecondTile) {
        // This method will determine if a piece can move. If can return true, if cannot return false.
        String firstColor = this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor();
        String secondColor = this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor();

        int xTileOne = xFirstTile - 1;
        int yTileOne = yFirstTile - 1;
        int xTileTwo = xSecondTile - 1;
        int yTileTwo = ySecondTile - 1;
        
        // if second tile contains a king, return false;
        if (tile2DArray[xTileTwo][yTileTwo].getPieceID() == 6) {
            //System.out.println("Failed due to: you cannot capture a king!");
            return false;
        }

        // if moving piece color is not the same as piece occupying tile being moved to.
        if (!(this.tile2DArray[xFirstTile-1][yFirstTile-1].getPieceColor() == this.tile2DArray[xSecondTile-1][ySecondTile-1].getPieceColor())) {
            
            // if piece is a pawn 
            if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 1) {
                
                return pawn.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = pawn.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a knight
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 2) {
                
                return knight.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = knight.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a bishop    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 3) {
                
                return bishop.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = bishop.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a rook    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 4) {
                
                return rook.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = rook.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                  
            // if piece is a queen    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 5) {
                
                return queen.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = queen.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a king    
            } else if (this.tile2DArray[xTileOne][yTileOne].getPieceID() == 6) {
                
                return king.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                //returnBoolean = king.canPieceMove(tile2DArray, xFirstTile, yFirstTile, xSecondTile, ySecondTile);
                
            // if piece is a nothing    
            } else {
                
                return false;
            }
        }
        
        //System.out.println("Failed due to: pieces are the same color!");
        return false;
    }

    /**
     * initializeBlankBoard is used to initialize the blank grid of buttons when a new game starts.
     * */
    public void initializeBlankBoard(GridPane chessBoard) {
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button boardButton = new Button();
                setButtonStyle(boardButton, colorCount, x);
                colorCount++;
                
                Tile tile = new Tile(boardButton, x, y, assignPieceID(x, y), assignPieceColor(x, y), Boolean.FALSE, Boolean.FALSE, 
                        Boolean.FALSE);
                addTileToArray(tile, tile.getXCoordinate(), tile.getYCoordinate(), tile.getPieceID(), tile.getPieceColor());  
               
                
                chessBoard.add(tile2DArray[x-1][y-1].getTileButton(), x, y);
            }
        } 
    }

    /**
     * initializeStartingBoard method is used to initialize the grid of buttons with default tiles for
     * a new game. Visually, default tiles will contain the starting positions the chess pieces.
     * */
    public void initializeStartingBoard(GridPane chessBoard) {
        
        chessBoard.getChildren().clear();
        int colorCount = 0;
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                Button boardButton = new Button();
                setButtonStyle(boardButton, colorCount, x);
                colorCount++;
                
                Tile tile = new Tile(boardButton, x, y, assignPieceID(x, y), assignPieceColor(x, y), Boolean.FALSE, Boolean.FALSE, 
                        Boolean.FALSE);
                addTileToArray(tile, tile.getXCoordinate(), tile.getYCoordinate(), tile.getPieceID(), tile.getPieceColor());
                setTileGraphic(tile2DArray[x-1][y-1]);
                
                //System.out.println(x + ", " + y + ": " + tile2DArray[x-1][y-1]);
                
                chessBoard.add(tile2DArray[x-1][y-1].getTileButton(), x, y);
                
            }
        }
        
        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                
                // PLACE CHECK DANGER FOR EACH PIECE ON BOARD
                if (tile2DArray[x-1][y-1].getPieceID() == 1) {
                    pawn.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 2) {
                    knight.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 3) {
                    bishop.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 4) {
                    rook.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 5) {
                    queen.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                } else if (tile2DArray[x-1][y-1].getPieceID() == 6) {
                    king.setCheckDangerTile(tile2DArray, x, y, tile2DArray[x-1][y-1].getPieceColor());
                }
            }
        }
        
        king.setCheckStatus(false, "WHITE");
        king.setCheckStatus(false, "BLACK");
        king.setKingCheckmate(false, "WHITE");
        king.setKingCheckmate(false, "BLACK");
        king.setKingStalemate(false, "WHITE");
        king.setKingStalemate(false, "BLACK");
        king.setBlackKingHasMoved(false);
        king.setWhiteKingHasMoved(false);
    }

    /**
     * The getTileGraphic method is used to retrieve the correct chess sprite for
     * each tile according to assigned pieceID.
     * */
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

    /**
     * The setTileGraphic method is used to set the correct chess sprite for
     * each tile according to assigned pieceID.
     * */
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

    /**
     * The assignPieceColor method is used to set default piece colors for starting tiles.
     * */
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

    /**
     * The assignPieceID method is used to set default piece ids for starting tiles.
     * */
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

    /**
     * The addTileToArray method is used to add tiles to the two-dimensional array.
     * */
    public void addTileToArray(Tile tile, int x, int y, int pieceID, String color) {
        tile2DArray[x-1][y-1] = tile;    
    }

}

/**
 * @author Jacob Hobbs
 */
package chess;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * App class overrides the start method and launches the chess application at runtime.
 * */
public class App extends Application {

    /**
     *  Overrides the start method of the Application superclass.
     *  Instantiates new board object that utilizes startGame method of Board class.
     * */
    @Override
    public void start(Stage stage) {
        Board chessBoard = new Board();
        chessBoard.startGame(stage);
    }

    /**
     * Main application method that launches new chess game at runtime.
     * */
    public static void main(String[] args) {
        launch();
    }

}
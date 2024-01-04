package chess;


import javafx.application.Application;
import javafx.stage.Stage;

/**
 * App class overrides the start method and launches the chess application at runtime.
 * */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        Board chessBoard = new Board();
        chessBoard.startGame(stage);
        
    }

    public static void main(String[] args) {
        launch();
    }

}
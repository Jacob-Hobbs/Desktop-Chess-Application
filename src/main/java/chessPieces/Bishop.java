
package chessPieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jacob
 */
public class Bishop extends Piece {
    
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
    
    @Override
    public Pane getImage(String color) {
        Pane frame = new Pane();
        
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteBishop.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackBishop.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        }
        return frame;
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
    
}

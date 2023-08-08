
package chessPieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jacob
 */
public class Queen extends Piece {
    
    @Override
    public Pane getImage(String color) {
        Pane frame = new Pane();
        
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        }
        return frame;
    }
    
    @Override  
    public ImageView getImageView(String color) {
        
        ImageView image = new ImageView();
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteQueen.png");
            image = new ImageView(imageFile);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackQueen.png");
            image = new ImageView(imageFile);
        }
        return image;
    }
    
}

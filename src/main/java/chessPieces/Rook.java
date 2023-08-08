
package chessPieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jacob
 */
public class Rook extends Piece {
    
    @Override
    public Pane getImage(String color) {
        Pane frame = new Pane();
        
        if (color.equals("WHITE")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/whiteRook.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        } else if (color.equals("BLACK")) {
            Image imageFile = new Image("file:src/main/java/chessPieces/pieceImages/blackRook.png");
            ImageView image = new ImageView(imageFile);
            frame.getChildren().add(image);
        }
        return frame;
    }
    
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
    
}

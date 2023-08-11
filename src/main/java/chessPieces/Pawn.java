
package chessPieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jacob
 */
public class Pawn extends Piece {
    
    
    
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
    
    
    
}

# ♚♛♜♝♞ Desktop-Chess-Application ♘♗♖♕♔
This Java Desktop Chess Application is a feature-rich, interactive, and visually appealing chess game designed and developed using JavaFX and following the principles of Object-Oriented programming (OOP). This application provides a seamless and enjoyable chess-playing experience for both novice and experienced players.

## Highlighted Features

In order to facilitate the logic of chess, Tile objects are organized within an 8 x 8 two-dimensional array. These Tile objects are composed of various parameters that track the current position and status of the chess pieces, as well as the JavaFX buttons that 
are used for piece interaction. Below, you will find examples of some of the more challenging features implemented in this project:

### Check Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/check.gif)

As pieces traverse the board, they emit a danger signal (matching their color) to Tiles located along the potential paths of their movement. Typically, this is inconsequential, except when it involves a king. Following any piece's movement, the game inspects the Tile objects holding each king to determine if there is an impending danger from an opponent piece. If this condition evaluates as true, the king is declared in check, and the available moves for the respective player are constrained to those that can move the king out of harm's way.

### Checkmate Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/checkmate.gif)

If the moveset of the checked king's player cannot resolve the check condition to false, checkmate is declared and the attacking player is declared the winner. All buttons contained within the Tile objects are then disabled, discouraging any additional piece maneuvers.

### Castling Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/castling.gif)

King and Rook objects implement the Piece interface, as do all "Piece" objects, however these specific pieces maintain logical declarations of movement, specific to each game. The moveset of a player contains the possibility of castling the king
if and only if:
* The participating rook has not moved
* The participating king has not moved
* All tiles between the participating king/rook are free
* The King may not castle out of, through, or into check.

### En Passant Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/enPassant.gif)

A pawn can advance two squares forward from its starting row. If an opposing pawn stands on an adjacent square, it has the unique opportunity, on the next move only, to move diagonally forward and capture the advancing pawn. This distinctive capture rule is referred to as "en passant," a term derived from the French phrase meaning "in passing."

### Promotion Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/promotion.gif)

When a pawn advances to the opposite side of the board, the pawn can be promoted to that of a Queen, Rook, Bishop, or Knight. This selection is made possible by the row of buttons on the menu above the game board. 

## Getting Started

### Dependencies

* Compatible with Windows 10
* Java JDK 17.0.8 [(Download)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* JavaFX SDK 18.0.1 [(Download)](https://gluonhq.com/products/javafx/)

### Installation and Execution

1. Install the above listed dependencies.
1. Download the _chess.jar_ file from the master branch.
1. Run the _chess.jar_ file on your local machine.


> Java Runtime Environment must be installed correctly in order for the _chess.jar_ file to execute.
  
## Author

Author can be contacted via the following link:

[Jacob Hobbs](https://www.linkedin.com/in/jacobrayhobbs/)

## Acknowledgments

* [Chess Sprites](https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces)

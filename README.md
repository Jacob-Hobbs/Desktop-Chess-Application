# ♚♛♜♝♞ Desktop-Chess-Application ♘♗♖♕♔
This Java Desktop Chess Application is a feature-rich, interactive, and visually appealing chess game designed and developed using JavaFX and following the principles of Object-Oriented programming (OOP). This application provides a seamless and enjoyable chess-playing experience for both novice and experienced players.

## Highlighted Features

In order to facilitate the logic of chess, Tile objects are organized within an 8 x 8 two-dimensional array. These Tile objects are composed of various parameters that track the current position and status of the chess pieces, as well as the JavaFX buttons that 
are used for piece interaction. Below, you will find examples of some of the more challenging features implemented in this project:

### Checkmate Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/checkmate.gif)

As pieces traverse the board, they emit a danger signal (matching their color) to Tiles located along the potential paths of their movement. Typically, this is inconsequential, except when it involves a king. Following any piece's movement, the game inspects the Tile objects holding each king to determine if there is an impending danger from an opponent piece. If this condition evaluates as true, the king is declared in check, and the available moves for the respective player are constrained to those that can move the king out of harm's way.

### Check Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/check.gif)

### Castling Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/castling.gif)

### En Passant Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/enPassant.gif)

### Promotion Implementation 

![](https://github.com/Jacob-Hobbs/Desktop-Chess-Application/blob/master/chessGIFs/promotion.gif)

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing program.
* ex. Windows 10

### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program

* How to run the program
* Step-by-step bullets
```
code blocks for commands
```

## Help

Any advise for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributors names and contact info

ex. Dominique Pizzie  
ex. [@DomPizzie](https://twitter.com/dompizzie)

## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)

package A00990753;

import A00990753.Chess_Pieces.Pawn;

public class ChessBoard extends Board{

  ChessBoard(int rows, int columns) {
    super(rows, columns);
    createBoard(rows, columns);
  }

  // Creates game board made up of tiles
  private void createBoard(int rows, int columns) {
    boolean isWhiteTile = true;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (isWhiteTile) {
          tiles[i][j] = new Tile(null, ColorSide.WHITE, i, j);
        } else {
          tiles[i][j] = new Tile(null, ColorSide.BLACK, i, j);
        }
        isWhiteTile = !isWhiteTile;
      }
      isWhiteTile = !isWhiteTile;
    }
  } 
}

package A00990753;

public class ChessBoard extends Board{

  ChessBoard(int rows, int columns, int boardId) {
    super(rows, columns, boardId);
    createBoard(rows, columns, boardId);
  }

  // Creates game board made up of tiles
  private void createBoard(int rows, int columns, int boardId) {
    boolean isWhiteTile = true;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (isWhiteTile) {
          tiles[i][j] = new Tile(null, ColorSide.WHITE, i, j, boardId);
        } else {
          tiles[i][j] = new Tile(null, ColorSide.BLACK, i, j, boardId);
        }
        isWhiteTile = !isWhiteTile;
      }
      isWhiteTile = !isWhiteTile;
    }
  } 
}

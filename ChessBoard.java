package A00990753;

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
          tiles[i][j] = new Tile(null, ColorSide.WHITE);
        } else {
          tiles[i][j] = new Tile(null, ColorSide.BLACK);
        }
        isWhiteTile = !isWhiteTile;
      }
      isWhiteTile = !isWhiteTile;
    }
  } 

  /*
   * Handles moving pieces of the 2d Piece array by setting and removing 
   * pieces from tiles.
   * Return true if piece has been succesfully moved, false otherwise/
   */
  public boolean movePiece(Tile fromThisTile, Tile toThisTile) {
    // If piece has been selected to move
    if (fromThisTile != null && fromThisTile.getPiece() != null) {
      ColorSide fromThisTileColor = fromThisTile.getPiece().getColor();

      // If tile to move to is unoccupied
      if (toThisTile.getPiece() == null || 
          fromThisTileColor != toThisTile.getPiece().getColor()) { 
        // If tile to move to has a piece of the opposite color.
        if (fromThisTileColor != toThisTile.getPiece().getColor()) {
          toThisTile.getPiece().kill();
        }
        toThisTile.setPiece(fromThisTile.getPiece());
        fromThisTile.removePiece();
        return true;
      }

    }
    return false;
  }
}

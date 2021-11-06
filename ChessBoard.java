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

  /*
   * Handles moving pieces of the 2d Piece array by setting and removing 
   * pieces from tiles.
   * Return true if piece has been succesfully moved, false otherwise/
   */
  public boolean movePiece(Tile fromThisTile, Tile toThisTile) {
    // If piece has been selected to move
    if (fromThisTile != null && fromThisTile.getPiece() != null) {
      ColorSide fromThisTileColor = fromThisTile.getPiece().getColor();
      
      if (fromThisTile.getPiece().getClass() == Pawn.class) {
        ((Pawn) fromThisTile.getPiece()).firstMoveDone();
      }
      // If tile to move to is unoccupied
      if (toThisTile.getPiece() == null) { 
        toThisTile.setPiece(fromThisTile.getPiece());
        fromThisTile.removePiece();
        return true;
      }

      // If tile to move to has a piece of the opposite color.
      if (fromThisTileColor != toThisTile.getPiece().getColor()) {
        toThisTile.getPiece().kill();
        toThisTile.setPiece(fromThisTile.getPiece());
        fromThisTile.removePiece();
        return true;
      }
    }
    return false;
  }

  public boolean isValidPieceMovement(Tile fromThisTile, Tile toThisTile) {
    if (fromThisTile == null || toThisTile == null) {
      return false;
    }
    Piece pieceToMove = fromThisTile.getPiece();
    return pieceToMove.isValidMovement(this, fromThisTile, toThisTile);
  }
}

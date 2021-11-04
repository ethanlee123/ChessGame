package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Pawn extends Piece{
  private boolean isFirstMove = true;

  public Pawn(ColorSide color, int row, int column) {
    super(color, row, column, "P");
  }

  @Override
  public boolean isValidMovement(Board board, Tile fromThisTile, Tile toThisTile) {
    int[][] possibleValidMoves = this.generateValidMovements(board, fromThisTile);

    if (possibleValidMoves[toThisTile.getRow()][toThisTile.getColumn()] == 1) {
      this.firstMoveDone();
      return true;
    }
    return false;
  }

  public boolean promoteTo(Piece piece) {
    // TODO
    return true;
  }

  public void firstMoveDone() {
    this.isFirstMove = false;
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
    int endRow = 0;
    Tile oneTileAhead;
    Tile twoTilesAhead;
    // Set endRow, used to check which way is forward
    if (super.getDefaultRow() >= validMoves.length / 2) {
      endRow = validMoves.length - 1;
    }
    // Set oneTileAhead by using endRow
    if (endRow == 0) {
      oneTileAhead = board.getTile(
        fromThisTile.getRow() + 1, fromThisTile.getColumn());
      twoTilesAhead = board.getTile(
        fromThisTile.getRow() + 2, fromThisTile.getColumn());
    } else {
      oneTileAhead = board.getTile(
        fromThisTile.getRow() - 1, fromThisTile.getColumn());
      twoTilesAhead = board.getTile(
        fromThisTile.getRow() - 2, fromThisTile.getColumn());
    }
    // If tile ahead by one is unoccupied, set corresponding index to 1
    if (oneTileAhead != null && oneTileAhead.getPiece() == null) {
      validMoves[oneTileAhead.getRow()][oneTileAhead.getColumn()] = 1;
    }
    // If tile ahead by two is unoccupied AND this is our first move
    // AND no piece is blocking, set corresponding index to 1
    if (isFirstMove == true && oneTileAhead.getPiece() == null &&
      twoTilesAhead != null && twoTilesAhead.getPiece() == null) {
      validMoves[twoTilesAhead.getRow()][twoTilesAhead.getColumn()] = 1;
    }
    return validMoves;
  }

}

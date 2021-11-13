package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Game;
import A00990753.Piece;
import A00990753.Tile;

public class Pawn extends Piece{
  private boolean isFirstMove = true;

  public Pawn(ColorSide color, int row, int column) {
    super(color, row, column, "P");
  }

  public boolean promoteTo(Piece piece) {
    // TODO
    return true;
  }

  public void firstMoveDone() {
    this.isFirstMove = false;
  }

  @Override
  public int[][] generateValidMovements(Game chessGame, Tile fromThisTile) {
    Board board = chessGame.getBoardAt(0);
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
    int endRow = 0;
    Tile oneTileAhead;
    Tile twoTilesAhead;

    // If tiles directly above or below are empty
    if (board.getTile(fromThisTile.getRow(), fromThisTile.getColumn()).getPiece() == null) {
      validMoves[fromThisTile.getRow()][fromThisTile.getColumn()] = 1;
    }


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

    // If first move and moving to second level
    // if (isFirstMove == true && )
    return validMoves;
  }
}

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

  public boolean promoteTo(Piece piece) {
    // TODO
    return true;
  }

  public void firstMoveDone() {
    this.isFirstMove = false;
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile, 
  Tile toThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];

    // If moving to a board which pawn is not currently on
    if (fromThisTile.getBoardId() != board.getBoardId()) {
      if (isFirstMove) {
        allowForwardMoveOnOtherBoard(fromThisTile, board, validMoves, 
        board.getBoardId() - 1);
      } else {
        allowForwardMoveOnOtherBoard(fromThisTile, board, validMoves, 1);
      }
    } else {
      allowValidMovesOnSameBoard(board, fromThisTile, validMoves);
    }
    return validMoves;
  }
  private int findForwardDirection(int[][] validMoves) {
    int endRow = 0;
    if (super.getDefaultRow() >= validMoves.length / 2) {
      endRow = validMoves.length - 1;
    }
    return endRow;
  }
  private void allowForwardMoveOnOtherBoard(Tile fromThisTile, Board board, 
  int[][] validMoves, int numberOfTilesAhead) {
    int endRow = findForwardDirection(validMoves);
    Tile tileAhead;

    // Set oneTileAhead by using endRow
    if (endRow == 0) {
      tileAhead = board.getTile(
        fromThisTile.getRow() + numberOfTilesAhead, fromThisTile.getColumn());
    } else {
      tileAhead = board.getTile(
        fromThisTile.getRow() - numberOfTilesAhead, fromThisTile.getColumn());
    }
    if (tileAhead != null && tileAhead.getPiece() == null) {
      validMoves[tileAhead.getRow()][tileAhead.getColumn()] = 1;
    }
  }

  private void allowValidMovesOnSameBoard(Board board, Tile fromThisTile, 
  int[][] validMoves) {
    // Set endRow, used to check which way is forward
    int endRow = findForwardDirection(validMoves);
    Tile oneTileAhead;
    Tile twoTilesAhead;

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
  }
}

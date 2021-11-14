package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Rook extends Piece{

  public Rook(ColorSide color, int row, int column) {
    super(color, row, column, "R");
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile, 
                                        Tile toThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];

    // If identifying valid moves on a different board than what the rook
    // is currently on.
    if (fromThisTile.getBoardId() != board.getBoardId()) {
      allowFBLRMovement(board, fromThisTile, validMoves);
    } else {
      allowValidMovesOnSameBoard(board, fromThisTile, validMoves);
    }

    return validMoves;
  }
  /*
   * Sets valid move to be one tile forward, backward, left, and right.
   */
  private void allowFBLRMovement(Board board, Tile fromThisTile, int[][] validMoves) {
    Tile forwardTile = board.getTile(fromThisTile.getRow() - 1, 
                                     fromThisTile.getColumn());
    Tile backwardTile = board.getTile(fromThisTile.getRow() + 1, 
                                     fromThisTile.getColumn());
    Tile leftTile = board.getTile(fromThisTile.getRow(), 
                                     fromThisTile.getColumn() - 1);
    Tile rightTile = board.getTile(fromThisTile.getRow(), 
                                     fromThisTile.getColumn() + 1);
    if (fromThisTile.getRow() + 1 <= 7 && 
        !nextTileHasPieceOfSameColor(fromThisTile, backwardTile)) {
      validMoves[fromThisTile.getRow() + 1][fromThisTile.getColumn()] = 1;
    }
    if (fromThisTile.getRow() - 1 >= 0 &&
        !nextTileHasPieceOfSameColor(fromThisTile, forwardTile)) {
      validMoves[fromThisTile.getRow() - 1][fromThisTile.getColumn()] = 1;
    }
    if (fromThisTile.getColumn() + 1 <= 7 &&
        !nextTileHasPieceOfSameColor(fromThisTile, rightTile)) {
      validMoves[fromThisTile.getRow()][fromThisTile.getColumn() + 1] = 1;
    }
    if (fromThisTile.getColumn() - 1 >= 0 &&
        !nextTileHasPieceOfSameColor(fromThisTile, leftTile)) {
      validMoves[fromThisTile.getRow()][fromThisTile.getColumn() - 1] = 1;
    }
  }
  private void allowValidMovesOnSameBoard(Board board, Tile fromThisTile, int[][] validMoves) {
    int increasingVerticalIndex = 1;
    int decreasingVerticalIndex = -1;
    int increasingHorizontalIndex = 1;
    int decreasingHorizontalIndex = -1;
    while (validVerticalMovementCheck(board, fromThisTile, validMoves, 
      decreasingVerticalIndex)) {
      decreasingVerticalIndex--;
    }
    while (validVerticalMovementCheck(board, fromThisTile, validMoves, 
      increasingVerticalIndex)) {
      increasingVerticalIndex++;
    }
    while (validHorizontalMovementCheck(board, fromThisTile, validMoves, 
      decreasingHorizontalIndex)) {
      decreasingHorizontalIndex--;
      }
    while (validHorizontalMovementCheck(board, fromThisTile, validMoves, 
      increasingHorizontalIndex)) {
      increasingHorizontalIndex++;
    }
  }
}

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
      allowFBLRMovesOnOtherBoard(board, fromThisTile, validMoves);
    } else {
      allowValidMovesOnSameBoard(board, fromThisTile, validMoves);
    }

    return validMoves;
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

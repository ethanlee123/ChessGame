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
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
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
    return validMoves;
  }

}

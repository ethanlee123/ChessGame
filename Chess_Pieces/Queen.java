package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Queen extends Piece{
  public Queen(ColorSide color, int row, int column) {
    super(color, row, column, "Q");
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile, Tile toThisTile) {
    int[][] validMoves = 
      new int[board.getTiles().length][board.getTiles()[0].length];

    // If identifying valid moves on a different board than what the rook
    // is currently on.
    if (fromThisTile.getBoardId() != board.getBoardId()) {
      int numberOfTilesOffset = 
      Math.abs(fromThisTile.getBoardId() - board.getBoardId());
      allowDiagonalMovesOnOtherBoard(board, fromThisTile, toThisTile, validMoves, numberOfTilesOffset);
      allowFBLRMovesOnOtherBoard(board, fromThisTile, validMoves, numberOfTilesOffset);
    } else {
      generateVerticalMovements(board, fromThisTile, validMoves);
      generateHorizontalMovements(board, fromThisTile, validMoves);
      generateDiagonalMovements(board, fromThisTile, validMoves);
    }

    return validMoves;
  }
  // Helper method for generating valid movements.
  private void generateVerticalMovements(Board board, Tile fromThisTile, 
                                         int[][] validMoves) {
      int increasingVerticalIndex = 1;
      int decreasingVerticalIndex = -1;
      while (validVerticalMovementCheck(board, fromThisTile, validMoves, 
      decreasingVerticalIndex)) {
      decreasingVerticalIndex--;
    }
    while (validVerticalMovementCheck(board, fromThisTile, validMoves, 
      increasingVerticalIndex)) {
      increasingVerticalIndex++;
    }
  }
  // Helper method for generating valid movements.
  private void generateHorizontalMovements(Board board, Tile fromThisTile, 
                                           int[][] validMoves) {
    int increasingHorizontalIndex = 1;
    int decreasingHorizontalIndex = -1;

    while (validHorizontalMovementCheck(board, fromThisTile, validMoves, 
      decreasingHorizontalIndex)) {
      decreasingHorizontalIndex--;
      }
    while (validHorizontalMovementCheck(board, fromThisTile, validMoves, 
      increasingHorizontalIndex)) {
      increasingHorizontalIndex++;
    }
  }
  // Helper method for generating valid movements.
  private void generateDiagonalMovements(Board board, Tile fromThisTile, 
                                 int[][] validMoves) {
    int startingRow = fromThisTile.getRow();
    int startingCol = fromThisTile.getColumn();
    // Check if piece can be moved to bottom right
    for (int i = 1, j = 1; 
      startingRow + i < validMoves.length && 
      startingCol + j < validMoves[i].length; 
      i++, j++) {
      if (!validDiagonalMovement(board, fromThisTile, validMoves, i, j)) break;
    }
    // Check if piece can be moved to bottom left
    for (int i = 1, j = -1; startingRow + i < validMoves.length && 
      startingCol + j >= 0; i++, j--) {
      if (!validDiagonalMovement(board, fromThisTile, validMoves, i, j)) break;
    }
    // Check if piece can be moved to top left
    for (int i = -1, j = -1; startingRow + i >= 0 && startingCol + j >= 0; 
      i--, j--) {
      if (!validDiagonalMovement(board, fromThisTile, validMoves, i, j)) break;
    }
    // Check if piece can be moved to top right
    for (int i = -1, j = 1; startingRow + i >= 0 && 
      startingCol + j < validMoves[startingRow + i].length; i--, j++) {
      if (!validDiagonalMovement(board, fromThisTile, validMoves, i, j)) break;
    }
  }
}

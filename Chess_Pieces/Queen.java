package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ChessBoard;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Queen extends Piece{
  public Queen(ColorSide color, int row, int column) {
    super(color, row, column, "Q");
  }

  @Override
  public boolean isValidMovement(Board board, Tile fromThisTile, 
                                 Tile toThisTile) {
    int[][] possibleValidMoves = this.generateValidMovements(board, fromThisTile);

    if (possibleValidMoves[toThisTile.getRow()][toThisTile.getColumn()] == 1) {
      return true;
    }
    return false;
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
    int increasingVerticalIndex = 1;
    int decreasingVerticalIndex = -1;
    int increasingHorizontalIndex = 1;
    int decreasingHorizontalIndex = -1;
    int startingRow = fromThisTile.getRow();
    int startingCol = fromThisTile.getColumn();
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
    return validMoves;
  }

}

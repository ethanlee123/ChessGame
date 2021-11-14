package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Bishop extends Piece{
  public Bishop(ColorSide color, int row, int column) {
    super(color, row, column, "B");
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile, 
  Tile toThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];

    // If identifying valid moves on a different board than what the rook
    // is currently on.
    if (fromThisTile.getBoardId() != board.getBoardId()) {
      int numberOfTilesOffset = 
      Math.abs(fromThisTile.getBoardId() - board.getBoardId());
      allowDiagonalMovesOnOtherBoard(board, fromThisTile, toThisTile, validMoves, numberOfTilesOffset);
    } else {
      allowValidMovesOnSameBoard(board, fromThisTile, toThisTile, validMoves);
    }

    return validMoves;
  }
  private void allowValidMovesOnSameBoard(Board board, Tile fromThisTile, 
  Tile toThisTile, int[][] validMoves) {
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


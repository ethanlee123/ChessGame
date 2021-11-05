package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ChessBoard;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class Bishop extends Piece{
  public Bishop(ColorSide color, int row, int column) {
    super(color, row, column, "B");
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
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
    return validMoves;
  }
}


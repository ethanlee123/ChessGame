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
      generateDiagonalMovements(board, fromThisTile, validMoves);
    }

    return validMoves;
  }
}


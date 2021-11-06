package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Piece;
import A00990753.Tile;

public class King extends Piece{
  private boolean isCastlingDone = false;
  private boolean isChecked = false;

  public King(ColorSide color, int row, int column) {
    super(color, row, column, "K");
  }

  public void castleMove() {
    // TODO
  }

  public void isChecked(boolean checked) {
    this.isChecked = checked;
  }
  public boolean isChecked() {
    return this.isChecked;
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    int[][] validMoves = 
      new int[board.getTiles().length][board.getTiles()[0].length];
    int[][] diagonalCoordinates = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    validVerticalMovementCheck(board, fromThisTile, validMoves, 1);
    validVerticalMovementCheck(board, fromThisTile, validMoves, -1);
    validHorizontalMovementCheck(board, fromThisTile, validMoves, 1);
    validHorizontalMovementCheck(board, fromThisTile, validMoves, -1);

    for (int i = 0; i < diagonalCoordinates.length; i++) {
      validDiagonalMovement(board, fromThisTile, validMoves, 
                            diagonalCoordinates[i][0], 
                            diagonalCoordinates[i][1]);
    }
    
    return validMoves;
  }
}

package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ChessBoard;
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
  public boolean isValidMovement(Board board, Tile fromThisTile, Tile toThisTile) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile) {
    // TODO Auto-generated method stub
    return null;
  }
}

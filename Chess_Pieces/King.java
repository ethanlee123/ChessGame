package A00990753.Chess_Pieces;

import A00990753.ColorSide;
import A00990753.Piece;

public class King extends Piece{
  private boolean isCastlingDone = false;
  private boolean isChecked = false;

  public King(ColorSide color, int row, int column) {
    super(color, row, column, "K");
  }

  @Override
  public void isValidMovement(int[][] start, int[][] end) {
    // TODO Auto-generated method stub
    
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
}

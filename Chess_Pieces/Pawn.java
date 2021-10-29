package A00990753.Chess_Pieces;

import A00990753.ColorSide;
import A00990753.Piece;

public class Pawn extends Piece{
  private boolean isFirstMove = true;

  public Pawn(ColorSide color, int row, int column) {
    super(color, row, column, "P");
  }

  @Override
  public void isValidMovement(int[][] start, int[][] end) {
    // TODO Auto-generated method stub
    
  }

  public boolean promoteTo(Piece piece) {
    // TODO
    return true;
  }

  public void firstMoveDone() {
    this.isFirstMove = true;
  }
}

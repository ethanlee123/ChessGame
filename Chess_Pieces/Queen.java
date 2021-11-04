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

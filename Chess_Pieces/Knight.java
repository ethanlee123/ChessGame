package A00990753.Chess_Pieces;

import A00990753.Board;
import A00990753.ColorSide;
import A00990753.Game;
import A00990753.Piece;
import A00990753.Tile;

public class Knight extends Piece{
  public Knight(ColorSide color, int row, int column) {
    super(color, row, column, "N");
  }

  @Override
  public int[][] generateValidMovements(Board board, Tile fromThisTile, Tile toThisTile) {
    int[][] validMoves = new int[board.getTiles().length][board.getTiles()[0].length];
    int startingRow = fromThisTile.getRow();
    int startingColumn = fromThisTile.getColumn();
    int[] verticalStep = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] horizontalStep = {1, 2, 2, 1, -1, -2, -2, -1};

    for (int i = 0; i < 8; i++) {
      int destinationRow = startingRow + verticalStep[i];
      int destinationColumn = startingColumn + horizontalStep[i];
      Tile destination = board.getTile(destinationRow, destinationColumn);

      if (nextTileHasPieceOfOppositeColor(fromThisTile, destination) ||
        nextTileIsOpen(fromThisTile, destination)) {
          validMoves[destinationRow][destinationColumn] = 1;
        }
    }
    return validMoves;
  }

}


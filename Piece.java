package A00990753;

import java.util.List;

public abstract class Piece implements Movement {
  private String name;
  private ColorSide color;
  private boolean isKilled = false;
  private int defaultRow;
  private int defaultColumn;
  
  protected Piece(ColorSide color, int row, int column, String name) {
    this.color = color;
    this.defaultRow = row;
    this.defaultColumn = column;
    this.name = name;
  }

  public int getDefaultRow() {
    return this.defaultRow;
  }
  public int getDefaultColumn() {
    return this.defaultColumn;
  }
  public String getName() {
    return this.name;
  }
  public ColorSide getColor() {
    return this.color;
  }
  public void kill() {
    this.isKilled = true;
  }
  public boolean isKilled() {
    return this.isKilled;
  }
  @Override
  public boolean isValidMovement(Game game, Tile fromThisTile, 
                                 Tile toThisTile) {
    List<Board> allBoards = game.getAllBoards();
    for (int i = 0; i < allBoards.size(); i++) {
      int[][] possibleValidMoves = 
        this.generateValidMovements(allBoards.get(i), fromThisTile, toThisTile);
  
      if (possibleValidMoves[toThisTile.getRow()][toThisTile.getColumn()] == 1) {
        return true;
      }
    }
    return false;
  }
  public boolean validVerticalMovementCheck(Board board, Tile fromThisTile, 
                                            int[][] validMoves, int tileIncrementor) {
    // Check if out of board boundaries
    if (fromThisTile.getRow() + tileIncrementor < 0 || 
        fromThisTile.getRow() + tileIncrementor >= board.getTiles().length) {
      return false;
    }

    Tile nextTile = board.getTile(fromThisTile.getRow() + tileIncrementor, 
    fromThisTile.getColumn());

    if (nextTileHasPieceOfOppositeColor(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return false;
    }
    if (nextTileIsOpen(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return true;
    }
    return !nextTileHasPieceOfSameColor(fromThisTile, nextTile);
  }
  public boolean validHorizontalMovementCheck(Board board, Tile fromThisTile, 
                                              int[][] validMoves, int tileIncrementor) {
    // Check if out of board boundaries
    if (fromThisTile.getColumn() + tileIncrementor < 0 ||
        fromThisTile.getColumn() + tileIncrementor >= board.getTiles()[0].length) {
      return false;
    }

    Tile nextTile = board.getTile(fromThisTile.getRow(), 
    fromThisTile.getColumn() + tileIncrementor);

    if (nextTileHasPieceOfOppositeColor(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return false;
    }
    if (nextTileIsOpen(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return true;
    }
    return !nextTileHasPieceOfSameColor(fromThisTile, nextTile);
  }
  public boolean validDiagonalMovement(Board board, Tile fromThisTile, 
                                       int[][] validMoves, int incrementRow, int incrementColumn) {
    int toThisRow = fromThisTile.getRow() + incrementRow;
    int toThisColumn = fromThisTile.getColumn() + incrementColumn;
    // Check if out of board boundaries
    if (toThisRow < 0 || toThisRow >= board.getTiles().length ||
      toThisColumn < 0 || toThisColumn >= board.getTiles()[0].length) {
      return false;
    }

    Tile nextTile = board.getTile(toThisRow, toThisColumn);

    if (nextTileHasPieceOfOppositeColor(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return false;
    }
    if (nextTileIsOpen(fromThisTile, nextTile)) {
      validMoves[nextTile.getRow()][nextTile.getColumn()] = 1;
      return true;
    }
    return !nextTileHasPieceOfSameColor(fromThisTile, nextTile);
  }
  /*
   * Helper method. Check if nextTile has a piece of same color 
   */
  public boolean nextTileHasPieceOfSameColor(Tile fromThisTile, Tile nextTile) {
    return (nextTile != null && nextTile.getPiece() != null && 
      nextTile.getPiece().getColor() == fromThisTile.getPiece().getColor())
      ? true
      : false; 
  }
  /*
   * Helper method. Check if next tile is unoccupied
   */
  public boolean nextTileIsOpen(Tile fromThisTile, Tile nextTile) {
    return (nextTile != null && nextTile.getPiece() == null) ? true : false;
  }
  /*
   * Helper method. Check if next tile has piece of opposite color
   */
  public boolean nextTileHasPieceOfOppositeColor(Tile fromThisTile, 
                                                 Tile nextTile) {
    return (nextTile != null && nextTile.getPiece() != null &&
      nextTile.getPiece().getColor() != fromThisTile.getPiece().getColor())
      ? true 
      : false;
  }
  public void allowDiagonalMovesOnOtherBoard(Board board, Tile fromThisTile, Tile toThisTile, int[][] validMoves, int numberOfTilesOffset) {
    validDiagonalMovement(board, fromThisTile, validMoves, numberOfTilesOffset, numberOfTilesOffset);
    validDiagonalMovement(board, fromThisTile, validMoves, -numberOfTilesOffset, -numberOfTilesOffset);
    validDiagonalMovement(board, fromThisTile, validMoves, numberOfTilesOffset, -numberOfTilesOffset);
    validDiagonalMovement(board, fromThisTile, validMoves, -numberOfTilesOffset, numberOfTilesOffset);
  }
    /*
   * Sets valid move to be one tile forward, backward, left, and right.
   */
  public void allowFBLRMovesOnOtherBoard(Board board, Tile fromThisTile, int[][] validMoves, int numberOfTilesOffset) {
    Tile forwardTile = board.getTile(fromThisTile.getRow() - 1, 
                                     fromThisTile.getColumn());
    Tile backwardTile = board.getTile(fromThisTile.getRow() + 1, 
                                     fromThisTile.getColumn());
    Tile leftTile = board.getTile(fromThisTile.getRow(), 
                                     fromThisTile.getColumn() - 1);
    Tile rightTile = board.getTile(fromThisTile.getRow(), 
                                     fromThisTile.getColumn() + 1);
    if (fromThisTile.getRow() + numberOfTilesOffset <= 7 && 
        !nextTileHasPieceOfSameColor(fromThisTile, backwardTile)) {
      validMoves[fromThisTile.getRow() + numberOfTilesOffset][fromThisTile.getColumn()] = 1;
    }
    if (fromThisTile.getRow() - numberOfTilesOffset >= 0 &&
        !nextTileHasPieceOfSameColor(fromThisTile, forwardTile)) {
      validMoves[fromThisTile.getRow() - numberOfTilesOffset][fromThisTile.getColumn()] = 1;
    }
    if (fromThisTile.getColumn() + numberOfTilesOffset <= 7 &&
        !nextTileHasPieceOfSameColor(fromThisTile, rightTile)) {
      validMoves[fromThisTile.getRow()][fromThisTile.getColumn() + numberOfTilesOffset] = 1;
    }
    if (fromThisTile.getColumn() - numberOfTilesOffset >= 0 &&
        !nextTileHasPieceOfSameColor(fromThisTile, leftTile)) {
      validMoves[fromThisTile.getRow()][fromThisTile.getColumn() - numberOfTilesOffset] = 1;
    }
  }
}

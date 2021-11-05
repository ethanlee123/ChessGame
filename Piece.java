package A00990753;

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
  public boolean isValidMovement(Board board, Tile fromThisTile, 
                                 Tile toThisTile) {
    int[][] possibleValidMoves = 
      this.generateValidMovements(board, fromThisTile);

    if (possibleValidMoves[toThisTile.getRow()][toThisTile.getColumn()] == 1) {
      return true;
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
}

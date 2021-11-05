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
  /*
   * Helper method for validVerticalMovementCheck and validHorizontalMovementCheck. 
   */
  public boolean nextTileHasPieceOfSameColor(Tile fromThisTile, Tile nextTile) {
    // Check if nextTile has a piece of same color 
    return (nextTile != null && nextTile.getPiece() != null && 
      nextTile.getPiece().getColor() == fromThisTile.getPiece().getColor())
      ? true
      : false; 
  }
  /*
   * Helper method for validVerticalMovementCheck and validHorizontalMovementCheck. 
   */
  public boolean nextTileIsOpen(Tile fromThisTile, Tile nextTile) {
    // Check if next tile is unoccupied
    return (nextTile != null && nextTile.getPiece() == null) ? true : false;
  }
  /*
   * Helper method for validVerticalMovementCheck and validHorizontalMovementCheck. 
   */
  public boolean nextTileHasPieceOfOppositeColor(Tile fromThisTile, Tile nextTile) {
    // Check if next tile has piece of opposite color
    return (nextTile != null && nextTile.getPiece() != null &&
      nextTile.getPiece().getColor() != fromThisTile.getPiece().getColor())
      ? true 
      : false;
  }
}

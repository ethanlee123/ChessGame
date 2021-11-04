package A00990753;

public abstract class Board {
  protected Tile[][] tiles;
  
  Board(int rows, int columns) {
    this.tiles = new Tile[rows][columns];
  }
  public Tile getTile(int row, int column) {
    return this.tiles[row][column];
  }
  public Tile[][] getTiles() {
    return this.tiles;
  }
  abstract public boolean movePiece(Tile fromThisTile, Tile currentlySelectedTile);
  abstract public boolean isValidPieceMovement(Tile fromThisTile, Tile currentlySelectedTile);
}

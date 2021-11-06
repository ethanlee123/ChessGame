package A00990753;

public abstract class Board {
  protected Tile[][] tiles;
  
  Board(int rows, int columns) {
    this.tiles = new Tile[rows][columns];
  }

  abstract public boolean movePiece(Tile fromThisTile, Tile currentlySelectedTile);
  abstract public boolean isValidPieceMovement(Tile fromThisTile, Tile currentlySelectedTile);
  
  public Tile getTile(int row, int column) {
    if (row < 0 || column < 0 || 
        row >= tiles.length || column >= tiles[0].length) {
          return null;
        }
    return this.tiles[row][column];
  }
  public Tile[][] getTiles() {
    return this.tiles;
  }

}

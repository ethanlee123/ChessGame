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
}

package A00990753;

import javax.swing.JButton;

public class Tile extends JButton{
  private Piece piece;
  private final ColorSide color;
  private final int row;
  private final int column;
  private final int boardId;

  Tile(Piece piece, ColorSide color, int row, int column, int boardId) {
    this.piece = piece;
    this.color = color;
    this.row = row;
    this.column = column;
    this.boardId = boardId;
  }

  public ColorSide getColor() {
    return color;
  }
  public void setPiece(Piece piece) {
    this.piece = piece;
  }
  public Piece getPiece() {
    return this.piece;
  }
  public void removePiece() {
    this.piece = null;
  }
  public int getRow() {
    return this.row;
  }
  public int getColumn() {
    return this.column;
  }
  public int getBoardId() {
    return this.boardId;
  }
}

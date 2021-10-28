package A00990753;

import javax.swing.JButton;

public class Tile extends JButton{
  private Piece piece;
  private final ColorSide color;

  Tile(Piece piece, ColorSide color) {
    this.piece = piece;
    this.color = color;
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
}

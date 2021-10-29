package A00990753;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final ColorSide color;
  private final List<Piece> pieces;

  Player(ColorSide color) {

    this.color = color;
    this.pieces = new ArrayList<>();
  }

  public List<Piece> getPieces() {
    return this.pieces;
  }
  public ColorSide getColor() {
    return this.color;
  }
}

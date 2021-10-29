package A00990753;


public class Result {
  private ColorSide winningColor;
  private boolean isStaleMate;

  public void setWinningColor(ColorSide color) {
    this.winningColor = color;
  }
  public void setStaleMate(boolean isStaleMate) {
    this.isStaleMate = isStaleMate;
  }
  public ColorSide getWinningColor() {
    return this.winningColor;
  }
  public boolean isStaleMate() {
    return this.isStaleMate;
  }
}

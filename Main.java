package A00990753;

public class Main {
  private Main() {};
  public static void main(String[] args) {
    Game game = new ChessGame();
    ChessGame chessGame = (ChessGame) game;
    chessGame.startGame();
  } 
}
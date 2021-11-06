package A00990753;

import java.util.ArrayList;
import java.util.List;
abstract class Game {
  GameStatus gameStatus;
  Board board;
  Result latestResult;
  Player currentPlayersTurn;
  List<Player> listOfPlayers;

  protected Game() {
    this.gameStatus = GameStatus.ACTIVE;
    this.latestResult = new Result();
    this.listOfPlayers = new ArrayList<Player>();
  }

  abstract void startGame();
  abstract void resignFromGame(Player... player);
  abstract Player nextPlayersTurn(Player currentPlayer);

  /*
   * Add new player to list. Cannot have duplicate colors.
   * Returns true if player succesfully added, false otherwise.
   */
  public boolean addNewPlayer(ColorSide color) {
    for (Player p : listOfPlayers) {
      if (color == p.getColor()) {
        return false;
      }
    }
    listOfPlayers.add(new Player(color));
    return true;
  }
  public void setPlayersTurn(Player player) {
    this.currentPlayersTurn = player;
  }
  public Player getCurrentPlayersTurn() {
    return this.currentPlayersTurn;
  }
  public Board getBoard() {
    return this.board;
  }
}

package A00990753;

import java.util.ArrayList;
import java.util.List;
abstract class Game {
  GameStatus gameStatus;
  Board board;
  Result latestResult;
  Player playersTurn;
  List<Player> listOfPlayers;

  protected Game() {
    this.gameStatus = GameStatus.ACTIVE;
    this.latestResult = new Result();
    this.listOfPlayers = new ArrayList<Player>();
  }

  abstract void startGame();
  abstract void resignFromGame(Player... player);


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
    this.playersTurn = player;
  }
  public Player getPlayersTurn() {
    return this.playersTurn;
  }
}

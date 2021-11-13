package A00990753;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
  GameStatus gameStatus;
  List<Board> listOfBoards;
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
  abstract List<Board> createBoards(int rows, int columns, int numberOfBoardsToCreate);
  abstract public boolean isValidPieceMovement(Tile fromThisTile, Tile currentlySelectedTile);
  abstract public boolean movePiece(Tile fromThisTile, Tile currentlySelectedTile);

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
  public Board getBoardAt(int index) {
    return this.listOfBoards.get(index);
  }
  public void setListOfBoards(List<Board> listOfBoards) {
    this.listOfBoards = listOfBoards;
  }
  public List<Board> getAllBoards() {
    return this.listOfBoards;
  }
}

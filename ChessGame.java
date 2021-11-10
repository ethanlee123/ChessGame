package A00990753;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import A00990753.Chess_Pieces.*;

public class ChessGame extends Game {
  private List<Piece> pieces = new LinkedList<Piece>();
  private ChessGui gui;

  public ChessGame() {
    setListOfBoards(createBoards(8, 8, 3));
    createPieces();
    setPiecesOnTiles(super.getBoardAt(0));
  }
  @Override
  List<Board> createBoards(int rows, int columns, int numberOfBoardsToCreate) {
    List<Board> listOfBoard = new ArrayList<Board>();
    for (int i = 1; i <= numberOfBoardsToCreate; i++) {
      listOfBoard.add(new ChessBoard(rows, columns));
    }
    return listOfBoard;
  }

  @Override
  void startGame() {
    this.gui = new ChessGui(this);
    this.gui.displayGame();
    addNewPlayer(ColorSide.WHITE);
    addNewPlayer(ColorSide.BLACK);
    setPlayersTurn(super.listOfPlayers.get(0));
  }
  @Override
  public Player nextPlayersTurn(Player currentPlayer) {
    Player nextPlayer = null;
    int indexOfCurrentPlayer = listOfPlayers.indexOf(currentPlayer);

    if (indexOfCurrentPlayer + 1 >= listOfPlayers.size()) {
      nextPlayer = listOfPlayers.get(0);
    } else {
      nextPlayer = listOfPlayers.get(indexOfCurrentPlayer + 1);
    }
    super.setPlayersTurn(nextPlayer);
    return nextPlayer;
  }

  // Create chess pieces with default position and add to pieces List
  private void createPieces() {
    pieces.clear();

    // Create all pawn pieces
    for (int i = 0; i < 8; i++) {
      Piece pawn = new Pawn(ColorSide.WHITE, 1, i);
      pieces.add(pawn);
    }
    for (int i = 0; i < 8; i++) {
      Piece pawn = new Pawn(ColorSide.BLACK, 6, i);
      pieces.add(pawn);
    }

    createNonPawnPieces(ColorSide.WHITE);
    createNonPawnPieces(ColorSide.BLACK);
  }
  private void createNonPawnPieces(ColorSide color) {
    String[] nonPawns = {"R", "N", "B", "K", "Q", "B", "N", "R"};
    int[] column = {0, 1, 2, 3, 4, 5, 6, 7};
    int row = 0;
    Piece piece;
    if (color == ColorSide.BLACK) {
      row = 7;
    }
    for (int i = 0; i < 8; i++) {
      switch (nonPawns[i]) {
        case "R":
          piece = new Rook(color, row, column[i]);
          pieces.add(piece);
          break;
        case "N":
          piece = new Knight(color, row, column[i]);
          pieces.add(piece);
          break;
        case "B":
          piece = new Bishop(color, row, column[i]);
          pieces.add(piece);
          break;
        case "K":
          piece = new King(color, row, column[i]);
          pieces.add(piece);
          break;
        case "Q":
          piece = new Queen(color, row, column[i]);
          pieces.add(piece);
          break;
        default:
          break;
      }
    }
  }

  // Set chess pieces on the given board
  private void setPiecesOnTiles(Board board) {
    for (Piece piece : pieces) {
      board.tiles[piece.getDefaultRow()][piece.getDefaultColumn()].setPiece(piece);
    }
  }

  public List<Piece> getPieces() {
    return this.pieces;
  }

  @Override
  void resignFromGame(Player... player) {
    // TODO Auto-generated method stub
  }

}

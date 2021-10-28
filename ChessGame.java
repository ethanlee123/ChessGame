package A00990753;

import java.util.LinkedList;
import java.util.List;

import A00990753.Chess_Pieces.*;

public class ChessGame extends Game {
  private List<Piece> pieces = new LinkedList<Piece>();
  private ChessGui gui;

  ChessGame() {
    board = new ChessBoard(8, 8);
    createPieces();
    setPiecesOnTiles(board);
    this.gui = new ChessGui(board);
  }

  @Override
  void startGame() {
    this.gui.displayGame();
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

    // Create white pieces
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
}

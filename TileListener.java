package A00990753;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TileListener implements ActionListener {
  private final Board board;
  private Tile fromThisTile = null;

  TileListener(ChessGui gui, Board board) {
    this.board = board;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    JButton tile = (JButton)e.getSource();
    Tile currentlySelectedTile = (Tile) tile;
    
    // If piece can be moved to currentlySelectedTile
    if (board.isValidPieceMovement(fromThisTile, currentlySelectedTile)) { 
      board.movePiece(fromThisTile, currentlySelectedTile);
      movePieceOnGui(fromThisTile, currentlySelectedTile);
      fromThisTile = null;
      revertAllTileColors(board);
      // If current tile selected has piece.
    } else if (currentlySelectedTile.getPiece() != null) { 
      // If reselecting current to move.
      if (fromThisTile != null) {
        revertTileColor(fromThisTile);
        revertAllTileColors(board);
      }
      fromThisTile = currentlySelectedTile;
      fromThisTile.setBackground(new Color(255, 127, 127));
      showValidMoves(fromThisTile);
    } 
  }

  private void movePieceOnGui(Tile fromThisTile, Tile toThisTile) {
    revertTileColor(fromThisTile);
    revertTileColor(toThisTile);
    toThisTile.setText(toThisTile.getPiece().getName());
    if (toThisTile.getPiece().getColor() == ColorSide.WHITE) {
      toThisTile.setForeground(PieceGraphics.white);
    } else {
      toThisTile.setForeground(PieceGraphics.black);
    }
    fromThisTile.setText("");
  }

  private void revertTileColor(Tile tile) {
    if (tile.getColor() == ColorSide.WHITE) {
      tile.setBackground(TileColors.white);
    } else {
      tile.setBackground(TileColors.black);
    }
  }
  private void revertAllTileColors(Board board) {
    for (int i = 0; i < board.getTiles().length; i++) {
      for (int j = 0; j < board.getTiles()[i].length; j++) {
        revertTileColor(board.getTile(i, j));
      }
    }
  }

  private void showValidMoves(Tile fromThisTile) {
    if (fromThisTile == null) {
      return;
    }
    int[][] possibleValidMoves = 
      fromThisTile.getPiece().generateValidMovements(board, fromThisTile);
    for (int i = 0; i < possibleValidMoves.length; i++) {
      for (int j = 0; j < possibleValidMoves[i].length; j++) {
        if (possibleValidMoves[i][j] == 1) {
          board.getTile(i, j).setBackground(new Color(255, 127, 127));
        }
      }
    }
  }
}

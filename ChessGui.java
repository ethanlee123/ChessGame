package A00990753;

import java.awt.*;
import javax.swing.*;

public class ChessGui {
  private Board board;
  private JFrame frame = new JFrame();
  private JPanel panel = new JPanel(new GridLayout(0, 8));
  private TileListener listener;

  ChessGui(Board board) {
    this.board = board;
    listener = new TileListener(this, board);
  }

  public void displayGame() {
    frame.setBounds(10, 10, 530, 550);
    frame.add(panel);

    createChessPiecesAndTiles();
    addButtonsToPanel();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  void createChessPiecesAndTiles() {
    Tile[][] tiles = board.getTiles();
    for (int i = 0; i < tiles.length; i++) {
      for (int j = 0; j < tiles[i].length; j++) {
          Tile tile = tiles[i][j];
          tile.setPreferredSize(new Dimension(64, 64));
          tile.setFont(PieceGraphics.font);

          if (tile.getColor() == ColorSide.WHITE) {
            tile.setBackground(TileColors.white);
          } else { // else tile color is BLACK 
            tile.setBackground(TileColors.black);
          }

          if (tile.getPiece() != null) {
            tile.setText(tile.getPiece().getName());
            setPieceTextColor(tile);
          }
          tile.addActionListener(listener);
      }
    }
  }

  public static void setPieceTextColor(Tile tile) {
    ColorSide color = tile.getPiece().getColor();
    if (color == ColorSide.WHITE) {
      tile.setForeground(PieceGraphics.white);
    } else {
      tile.setForeground(PieceGraphics.black);
    }
  }
  private void addButtonsToPanel() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        panel.add(board.getTile(i, j));
      }
    }
  }
}
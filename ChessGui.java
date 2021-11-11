package A00990753;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
public class ChessGui {
  private List<Board> listOfBoards;
  private JFrame frame = new JFrame();
  private JPanel mainPanel = new JPanel(new GridLayout(0, 3));
  private List<JPanel> listOfPanels;
  private TileListener listener;

  ChessGui(Game chessGame) {
    this.listOfBoards = chessGame.getAllBoards();
    listener = new TileListener(this, chessGame);
    listOfPanels = createPanels(chessGame.getAllBoards().size());
  }
  private List<JPanel> createPanels(int numberOfJPanelsToCreate) {
    List<JPanel> listOfPanels = new ArrayList<JPanel>();
    for (int i = 1; i <= numberOfJPanelsToCreate; i++) {
      JPanel jpanel = new JPanel(new GridLayout(0, 8));
      setRandomBorderColor(jpanel);
      listOfPanels.add(jpanel);
    }
    return listOfPanels;
  }
  private void setRandomBorderColor(JPanel panel) {
    panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color((int) (Math.random() * 0x1000000))));
  }
  public void displayGame() {
    frame.setBounds(10, 10, 530, 550);
    mainPanel.add(listOfPanels.get(0));
    mainPanel.add(listOfPanels.get(1));
    mainPanel.add(listOfPanels.get(2));
    frame.add(mainPanel);

    createChessPiecesAndTiles();

    addButtonsToPanels();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  void createChessPiecesAndTiles() {
    for (int k = 0; k < listOfBoards.size(); k++) {
      Tile[][] tiles = listOfBoards.get(k).getTiles();
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
  }
  public static void setPieceTextColor(Tile tile) {
    ColorSide color = tile.getPiece().getColor();
    if (color == ColorSide.WHITE) {
      tile.setForeground(PieceGraphics.white);
    } else {
      tile.setForeground(PieceGraphics.black);
    }
  }
  private void addButtonsToPanels() {
    for (int k = 0; k < listOfBoards.size(); k++) {
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          listOfPanels.get(k).add(listOfBoards.get(k).getTile(i, j));
        }
      }
    }
  }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BattleshipGUI extends JFrame {
    private JButton[][] buttons = new JButton[10][10];
    private JLabel missCounterLabel, strikeCounterLabel, totalMissesLabel, totalHitsLabel;
    private JButton playAgainButton, quitButton;
    private GameController controller;

    public BattleshipGUI() {
        controller = new GameController();

        setTitle("Battleship Game");
        setSize(800, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel(new GridLayout(10, 10));
        Font cellFont = new Font("SansSerif", Font.BOLD, 16);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton btn = new JButton("~");
                btn.setBackground(Color.CYAN);
                btn.setFont(cellFont);
                final int r = row;
                final int c = col;
                btn.addActionListener(e -> handleClick(r, c));
                buttons[row][col] = btn;
                boardPanel.add(btn);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new GridLayout(2, 2));
        missCounterLabel = new JLabel("Misses in a row: 0");
        strikeCounterLabel = new JLabel("Strikes: 0");
        totalMissesLabel = new JLabel("Total Misses: 0");
        totalHitsLabel = new JLabel("Total Hits: 0");

        statusPanel.add(missCounterLabel);
        statusPanel.add(strikeCounterLabel);
        statusPanel.add(totalMissesLabel);
        statusPanel.add(totalHitsLabel);

        add(statusPanel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel();
        playAgainButton = new JButton("Play Again");
        quitButton = new JButton("Quit");

        playAgainButton.addActionListener(e -> playAgain());
        quitButton.addActionListener(e -> quitGame());

        controlPanel.add(playAgainButton);
        controlPanel.add(quitButton);

        add(controlPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void handleClick(int row, int col) {
        JButton btn = buttons[row][col];
        if (!btn.isEnabled()) return;

        boolean hit = controller.fire(row, col);
        btn.setEnabled(false);

        if (hit) {
            btn.setText("X");
            btn.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Hit!");
            updateStatus();

            for (Ship ship : controller.getBoard().getShips()) {
                if (ship.isSunk()) {
                    boolean allHit = ship.getCoordinates().stream()
                            .allMatch(coord -> controller.getBoard().getCell(coord[0], coord[1]).isHit());
                    if (allHit) {
                        JOptionPane.showMessageDialog(this, "Ship Sunk!");
                    }
                }
            }

            if (controller.isWin()) {
                JOptionPane.showMessageDialog(this, "You Win!");
                int option = JOptionPane.showConfirmDialog(this, "Play again?", "Victory", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    playAgain();
                } else {
                    System.exit(0);
                }
            }
        } else {
            btn.setText("M");
            btn.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Miss!");
            updateStatus();

            if (controller.isLoss()) {
                JOptionPane.showMessageDialog(this, "You lost the game!");
                int option = JOptionPane.showConfirmDialog(this, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    playAgain();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    private void updateStatus() {
        Player player = controller.getPlayer();
        missCounterLabel.setText("Misses in a row: " + player.getMissCounter());
        strikeCounterLabel.setText("Strikes: " + player.getStrikeCounter());
        totalMissesLabel.setText("Total Misses: " + player.getTotalMisses());
        totalHitsLabel.setText("Total Hits: " + player.getTotalHits());
    }

    private void playAgain() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to restart?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.reset();
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    buttons[r][c].setText("~");
                    buttons[r][c].setEnabled(true);
                    buttons[r][c].setBackground(Color.CYAN);
                }
            }
            updateStatus();
        }
    }

    private void quitGame() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattleshipGUI::new);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGUI extends JFrame {
    private TTTTileButton[][] buttons;
    private TTTGame game;
    private TTTBoard board;

    public TTTGUI(TTTGame game, TTTBoard board) {
        this.game = game;
        this.board = board;

        setTitle("Tic Tac Toe - OOP");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new TTTTileButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TTTTileButton button = new TTTTileButton(i, j);
                button.addActionListener(new ButtonHandler());
                buttons[i][j] = button;
                add(button);
            }
        }

        setVisible(true);
    }

    public void resetButtons() {
        for (TTTTileButton[] row : buttons) {
            for (TTTTileButton button : row) {
                button.reset();
            }
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TTTTileButton button = (TTTTileButton) e.getSource();
            int row = button.getRow();
            int col = button.getCol();
            char player = game.getCurrentPlayer();

            if (board.placeMark(row, col, player)) {
                button.setText(String.valueOf(player));
                button.setEnabled(false);

                if (game.checkForWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + player + " wins!");
                    game.resetGame();
                } else if (game.checkForDraw()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    game.resetGame();
                } else {
                    game.switchPlayer();
                }
            }
        }
    }
}

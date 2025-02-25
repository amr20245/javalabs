import javax.swing.*;

public class TicTacToeButton extends JButton {
    private int row, col;

    public TicTacToeButton(int row, int col) {
        this.row = row;
        this.col = col;
        setFont(getFont().deriveFont(30.0f)); // Bigger font for visibility
    }
}

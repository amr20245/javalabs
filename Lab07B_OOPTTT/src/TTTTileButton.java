import javax.swing.JButton;

public class TTTTileButton extends JButton {
    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        super("");
        this.row = row;
        this.col = col;
        setFont(getFont().deriveFont(40f));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void reset() {
        setText("");
        setEnabled(true);
    }
}

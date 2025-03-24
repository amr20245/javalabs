public class TTTGame {
    private char currentPlayer;
    private TTTBoard board;
    private TTTGUI gui;

    public TTTGame() {
        currentPlayer = 'X';
        board = new TTTBoard();
        gui = new TTTGUI(this, board);
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkForWin() {
        return board.checkWin(currentPlayer);
    }

    public boolean checkForDraw() {
        return board.isFull();
    }

    public void resetGame() {
        board.clearBoard();
        gui.resetButtons();
        currentPlayer = 'X';
    }
}

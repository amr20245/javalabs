public class GameController {
    private GameBoard board;
    private Player player;

    public GameController() {
        board = new GameBoard();
        player = new Player();
    }

    public boolean fire(int row, int col) {
        boolean hit = board.fire(row, col);
        if (hit) {
            player.hit();
        } else {
            player.miss();
        }
        return hit;
    }

    public boolean isWin() {
        return player.getTotalHits() >= 17;
    }

    public boolean isLoss() {
        return player.lost();
    }

    public GameBoard getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public void reset() {
        board = new GameBoard();
        player.reset();
    }
}

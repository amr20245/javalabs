import java.util.Scanner;

public class Main {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            clearBoard();
            currentPlayer = "X";
            int moveCount = 0;
            boolean gameWon = false;

            while (moveCount < ROWS * COLS && !gameWon) {
                displayBoard();
                int row = SafeInput.getRangedInt(scanner, "Enter row (1-3): ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(scanner, "Enter column (1-3): ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moveCount++;
                    gameWon = isWin(currentPlayer);

                    if (gameWon) {
                        displayBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else if (isTie()) {
                        displayBoard();
                        System.out.println("It's a tie!");
                        break;
                    }

                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            playAgain = SafeInput.getYNConfirm(scanner, "Do you want to play again? (Y/N): ");
        } while (playAgain);
    }

    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                if (j < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (i < ROWS - 1) System.out.println("  -----");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) return false;
            }
        }
        return true;
    }
}

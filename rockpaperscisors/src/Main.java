import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerA, playerB;
        String playAgain;

        do {
            // Get Player A's move
            playerA = getValidMove(scanner, "Player A");

            // Get Player B's move
            playerB = getValidMove(scanner, "Player B");

            // Display the result
            displayResult(playerA, playerB);

            // Ask if they want to play again
            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getValidMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.println(player + ", enter your move (R, P, S): ");
            move = scanner.nextLine().toUpperCase();
        } while (!isValidMove(move));

        return move;
    }

    private static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    private static void displayResult(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println("It's a tie!");
        } else if (playerA.equals("R") && playerB.equals("S") ||
                playerA.equals("P") && playerB.equals("R") ||
                playerA.equals("S") && playerB.equals("P")) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}

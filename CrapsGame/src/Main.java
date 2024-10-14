import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Rolling the dice...");
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            } else {
                int point = sum;
                System.out.println("The point is now: " + point);
                boolean pointAchieved = false;

                while (!pointAchieved) {
                    System.out.println("Rolling again...");
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7! You lost.");
                        break;
                    } else if (sum == point) {
                        System.out.println("You made the point! You won.");
                        pointAchieved = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = input.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing Craps!");
    }
}

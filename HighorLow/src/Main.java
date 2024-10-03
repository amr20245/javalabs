import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
        int randomNum = generator.nextInt(10) + 1;
        int guess = 0;
        boolean validGuess = false;

        do {
            System.out.print("Guess a number between 1 and 10: ");
            if (in.hasNextInt()) {
                guess = in.nextInt();
                if (guess >= 1 && guess <= 10) {
                    validGuess = true;
                } else {
                    System.out.println("Guess must be between 1 and 10!");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                in.next(); // Clear invalid input
            }
        } while (!validGuess);

        System.out.println("Random number: " + randomNum);
        if (guess < randomNum) {
            System.out.println("Your guess is too low!");
        } else if (guess > randomNum) {
            System.out.println("Your guess is too high!");
        } else {
            System.out.println("You guessed it right!");
        }
    }
}

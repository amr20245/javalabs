import java.util.Scanner;

public class SafeInput {

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!console.hasNextInt()) {
                System.out.println("Invalid input. Enter an integer.");
                console.next();
            }
            input = console.nextInt();
            if (input < low || input > high) {
                System.out.println("Input out of range. Enter a value between " + low + " and " + high + ".");
            }
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = console.next().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input. Enter 'Y' for yes or 'N' for no.");
        }
    }
}

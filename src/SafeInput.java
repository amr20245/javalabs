import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int result = 0;
        boolean valid;
        do {
            System.out.print(prompt + ": ");
            valid = pipe.hasNextInt();
            if (valid) {
                result = pipe.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        } while (!valid);
        pipe.nextLine();
        return result;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double result = 0.0;
        boolean valid;
        do {
            System.out.print(prompt + ": ");
            valid = pipe.hasNextDouble();
            if (valid) {
                result = pipe.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        } while (!valid);
        pipe.nextLine();
        return result;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result;
        do {
            result = getInt(pipe, prompt + " [" + low + "-" + high + "]");
        } while (result < low || result > high);
        return result;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result;
        do {
            result = getDouble(pipe, prompt + " [" + low + "-" + high + "]");
        } while (result < low || result > high);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toLowerCase();
        } while (!response.equals("y") && !response.equals("n"));
        return response.equals("y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if (!response.matches(regEx)) {
                System.out.println("Input does not match the pattern. Try again.");
            }
        } while (!response.matches(regEx));
        return response;
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int padding = (width - msg.length() - 6) / 2;
        System.out.println("*".repeat(width));
        System.out.println("***" + " ".repeat(padding) + msg + " ".repeat(padding) + "***");
        System.out.println("*".repeat(width));
    }
}

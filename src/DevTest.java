import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Test getNonZeroLenString
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("You entered: " + name);

        // Test getInt
        int number = SafeInput.getInt(in, "Enter an integer");
        System.out.println("You entered: " + number);

        // Test getDouble
        double value = SafeInput.getDouble(in, "Enter a double");
        System.out.println("You entered: " + value);

        // Test getRangedInt
        int rangedInt = SafeInput.getRangedInt(in, "Enter an integer between 1 and 10", 1, 10);
        System.out.println("You entered: " + rangedInt);

        // Test getRangedDouble
        double rangedDouble = SafeInput.getRangedDouble(in, "Enter a double between 0.5 and 10.0", 0.5, 10.0);
        System.out.println("You entered: " + rangedDouble);

        // Test getYNConfirm
        boolean confirm = SafeInput.getYNConfirm(in, "Do you want to continue?");
        System.out.println("You entered: " + confirm);

        // Test getRegExString
        String ssn = SafeInput.getRegExString(in, "Enter a valid SSN", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("You entered: " + ssn);

        // Test prettyHeader
        SafeInput.prettyHeader("Welcome to Lab 8!");
    }
}

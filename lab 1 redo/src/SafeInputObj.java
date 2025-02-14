import java.util.Scanner;

/**
 * SafeInputObj provides user input validation methods.
 * This is an object-oriented version with an instance Scanner.
 */
public class SafeInputObj {

    private Scanner pipe;

    // Constructors
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    // Methods

    /**
     * Get a String with at least one character
     * @param prompt User prompt
     * @return A non-empty string
     */
    public String getNonZeroLenString(String prompt) {
        String retString;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.isEmpty());
        return retString;
    }

    /**
     * Get an int within a specified range
     * @param prompt User prompt
     * @param low Low end of range
     * @param high High end of range
     * @return Valid int within range
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number out of range!");
                }
            } else {
                System.out.println("Invalid input. Enter an integer.");
                pipe.nextLine(); // Clear buffer
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get an int without range
     * @param prompt User prompt
     * @return Valid int
     */
    public int getInt(String prompt) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid input. Enter an integer.");
                pipe.nextLine(); // Clear buffer
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double without range
     * @param prompt User prompt
     * @return Valid double
     */
    public double getDouble(String prompt) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid input. Enter a double.");
                pipe.nextLine(); // Clear buffer
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get Y/N confirmation
     * @param prompt User prompt
     * @return true if 'Y', false if 'N'
     */
    public boolean getYNConfirm(String prompt) {
        String response;
        boolean validInput = false;
        boolean result = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                result = true;
                validInput = true;
            } else if (response.equals("N")) {
                result = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Enter Y or N.");
            }
        } while (!validInput);

        return result;
    }
}

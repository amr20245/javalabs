import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Task 1: Declare an array of 100 integers
        int[] dataPoints = new int[100];

        // Task 2: Initialize array with random values between 1 and 100
        Random rnd = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Task 3: Display array values in a single line separated by " | "
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + (i < dataPoints.length - 1 ? " | " : "\n"));
        }

        // Task 4: Calculate and display sum and average of array values
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = sum / (double) dataPoints.length;
        System.out.println("The sum of the array is: " + sum);
        System.out.println("The average of the array is: " + average);

        // Task 5: Prompt the user for an integer between 1 and 100
        int userValue = SafeInput.getRangedInt("Enter an integer between 1 and 100", 1, 100);

        // Task 6: Count occurrences of user's value in array
        int count = 0;
        for (int val : dataPoints) {
            if (val == userValue) {
                count++;
            }
        }
        System.out.println("The value " + userValue + " appears " + count + " times in the array.");

        // Task 7: Find the first occurrence of user's value
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValue + " was found at index " + position + ".");
        } else {
            System.out.println("The value " + userValue + " was not found in the array.");
        }

        // Task 8: Find minimum and maximum values in the array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int val : dataPoints) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        // Task 9: Display the average using the getAverage method
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    // Task 9: Static method to calculate the average of an integer array
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum / (double) values.length;
    }
}

// SafeInput.java (Place this in the same package or src folder for use)
class SafeInput {
    private static Scanner in = new Scanner(System.in);

    public static int getRangedInt(String prompt, int low, int high) {
        int userInput;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            userInput = in.nextInt();
        } while (userInput < low || userInput > high);
        return userInput;
    }
}

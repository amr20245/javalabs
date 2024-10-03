import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double gallons = 0, efficiency = 0, price = 0;

        do {
            System.out.print("Enter number of gallons of gas: ");
            if (in.hasNextDouble()) {
                gallons = in.nextDouble();
                if (gallons > 0) {
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a positive number.");
                in.next();
            }
        } while (true);

        do {
            System.out.print("Enter fuel efficiency (miles per gallon): ");
            if (in.hasNextDouble()) {
                efficiency = in.nextDouble();
                if (efficiency > 0) {
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a positive number.");
                in.next();
            }
        } while (true);

        do {
            System.out.print("Enter price of gas per gallon: ");
            if (in.hasNextDouble()) {
                price = in.nextDouble();
                if (price > 0) {
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a positive number.");
                in.next();
            }
        } while (true);

        double costToDrive100Miles = (100 / efficiency) * price;
        double maxDistance = gallons * efficiency;
        System.out.printf("Cost to drive 100 miles: $%.2f%n", costToDrive100Miles);
        System.out.printf("Max distance with a full tank: %.2f miles%n", maxDistance);
    }
}

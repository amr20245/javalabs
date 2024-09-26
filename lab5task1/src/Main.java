import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double price, shippingCost = 0, totalPrice;

        System.out.print("Enter the price of the item: ");
        if (in.hasNextDouble()) {
            price = in.nextDouble();
            in.nextLine(); // clear buffer

            if (price >= 100) {
                shippingCost = 0;
            } else {
                shippingCost = price * 0.02;
            }

            totalPrice = price + shippingCost;

            System.out.println("Shipping cost: $" + shippingCost);
            System.out.println("Total price: $" + totalPrice);
        } else {
            System.out.println("Invalid input! Please enter a valid price.");
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double width = 0, height = 0;

        do {
            System.out.print("Enter width of the rectangle: ");
            if (in.hasNextDouble()) {
                width = in.nextDouble();
                if (width > 0) {
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a positive number.");
                in.next();
            }
        } while (true);

        do {
            System.out.print("Enter height of the rectangle: ");
            if (in.hasNextDouble()) {
                height = in.nextDouble();
                if (height > 0) {
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a positive number.");
                in.next();
            }
        } while (true);

        double area = width * height;
        double perimeter = 2 * (width + height);
        double diagonal = Math.sqrt((width * width) + (height * height));

        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
        System.out.printf("Diagonal: %.2f%n", diagonal);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your party affiliation (D, R, I): ");
        String affiliation = in.next().toUpperCase();

        if (affiliation.equals("D")) {
            System.out.println("You get a Democratic Donkey.");
        } else if (affiliation.equals("R")) {
            System.out.println("You get a Republican Elephant.");
        } else if (affiliation.equals("I")) {
            System.out.println("You get an Independent Person.");
        } else {
            System.out.println("Other.");
        }
    }
}

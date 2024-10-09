import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int die1, die2, die3;
        int rollCount = 0;

        System.out.printf("%-10s%-10s%-10s%-10s%-10s%n", "Roll", "Die1", "Die2", "Die3", "Sum");
        System.out.println("----------------------------------------------------------");

        do {
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            die3 = rand.nextInt(6) + 1;
            int sum = die1 + die2 + die3;
            rollCount++;

            System.out.printf("%-10d%-10d%-10d%-10d%-10d%n", rollCount, die1, die2, die3, sum);
        } while (!(die1 == die2 && die2 == die3));
    }
}

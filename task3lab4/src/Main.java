public class Main {
    public static void main(String[] args) {
        double balance = 5000.00;
        double interestRate = 0.17;

        // Calculate interest for one and two months
        double oneMonthInterest = balance * interestRate / 12;
        double twoMonthInterest = oneMonthInterest * 2;

        // Output the results
        System.out.println("Initial balance: $" + balance);
        System.out.println("Interest after one month: $" + oneMonthInterest);
        System.out.println("Interest after two months: $" + twoMonthInterest);
    }
}

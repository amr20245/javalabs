public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        int age = input.getRangedInt("Enter your age", 18, 120);
        int number = input.getInt("Enter a number");
        double price = input.getDouble("Enter a price");
        boolean confirm = input.getYNConfirm("Do you confirm?");

        System.out.println("\nCollected Data:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Confirmed: " + confirm);
    }
}

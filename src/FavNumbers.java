import java.util.Scanner;

public class FavNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int favInt = SafeInput.getInt(in, "Enter your favorite integer");
        double favDouble = SafeInput.getDouble(in, "Enter your favorite double");
        System.out.println("Favorite integer: " + favInt);
        System.out.println("Favorite double: " + favDouble);
    }
}


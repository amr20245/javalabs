import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        boolean done = false;
        while (!done) {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            products.add(new Product(id, name, description, cost));

            done = !SafeInput.getYNConfirm(in, "Add another product?");
        }

        String filename = SafeInput.getNonZeroLenString(in, "Enter filename to save (e.g., ProductTestData.txt)");

        try (FileWriter writer = new FileWriter(filename)) {
            for (Product p : products) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

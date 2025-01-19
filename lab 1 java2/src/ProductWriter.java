import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> productData = new ArrayList<>();
        String fileName;

        System.out.println("Welcome to Product Data Generator!");
        do {
            String id = SafeInput.getRegExString(in, "Enter ID (6 digits)", "\\d{6}");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getRangedDouble(in, "Enter Product Cost", 0, 10000);

            productData.add(id + ", " + name + ", " + description + ", " + cost);

        } while (SafeInput.getYNConfirm(in, "Do you want to add another product?"));

        fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save data");
        try (FileWriter writer = new FileWriter(fileName + ".txt")) {
            for (String record : productData) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}

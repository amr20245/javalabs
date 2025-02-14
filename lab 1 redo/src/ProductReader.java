import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    products.add(new Product(parts[0].trim(), parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim())));
                }
                reader.close();

                System.out.printf("%-8s %-15s %-20s %-8s%n", "ID", "Name", "Description", "Cost");
                for (Product p : products) {
                    System.out.printf("%-8s %-15s %-20s $%-8.2f%n", p.getID(), p.getName(), p.getDescription(), p.getCost());
                }
            }
        } catch (Exception e) {
            System.out.println("File Error.");
        }
    }
}

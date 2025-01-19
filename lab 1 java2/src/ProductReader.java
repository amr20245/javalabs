import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (Scanner reader = new Scanner(file)) {
                System.out.printf("%-10s %-20s %-30s %-10s\n", "ID#", "Name", "Description", "Cost");
                System.out.println("==================================================================");
                while (reader.hasNextLine()) {
                    String[] parts = reader.nextLine().split(",\\s*");
                    System.out.printf("%-10s %-20s %-30s $%-10.2f\n", parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
    }
}

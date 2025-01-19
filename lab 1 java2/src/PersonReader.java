import javax.swing.*;
        import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (Scanner reader = new Scanner(file)) {
                System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", "ID#", "First Name", "Last Name", "Title", "YOB");
                System.out.println("=========================================================");
                while (reader.hasNextLine()) {
                    String[] parts = reader.nextLine().split(",\\s*");
                    System.out.printf("%-10s %-15s %-15s %-10s %-5s\n", parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
    }
}

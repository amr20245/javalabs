import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;

        while (true) {
            System.out.println("Enter the following information (type 'done' to finish):");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            if (firstName.equalsIgnoreCase("done")) break;

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            String id = String.format("%06d", idCounter++);
            records.add(String.format("%s, %s, %s, %s, %s", firstName, lastName, id, email, yearOfBirth));
        }

        System.out.print("Enter a file name to save (with .csv extension): ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}

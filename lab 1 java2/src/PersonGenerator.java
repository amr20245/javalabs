import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> personData = new ArrayList<>();
        String fileName;

        System.out.println("Welcome to Person Data Generator!");
        do {
            String id = SafeInput.getRegExString(in, "Enter ID (6 digits)", "\\d{6}");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g., Mr., Mrs., Ms., Dr.)");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            personData.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

        } while (SafeInput.getYNConfirm(in, "Do you want to add another person?"));

        fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save data");
        try (FileWriter writer = new FileWriter(fileName + ".txt")) {
            for (String record : personData) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}

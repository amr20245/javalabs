import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        boolean done = false;
        while (!done) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 1940, 2010);

            people.add(new Person(id, firstName, lastName, title, yob));

            done = !SafeInput.getYNConfirm(in, "Add another person?");
        }

        String filename = SafeInput.getNonZeroLenString(in, "Enter filename to save (e.g., PersonTestData.txt)");

        try (FileWriter writer = new FileWriter(filename)) {
            for (Person p : people) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        try {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    people.add(new Person(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), Integer.parseInt(parts[4].trim())));
                }
                reader.close();

                System.out.printf("%-8s %-10s %-10s %-5s %-5s%n", "ID", "FirstName", "LastName", "Title", "YOB");
                for (Person p : people) {
                    System.out.printf("%-8s %-10s %-10s %-5s %-5d%n", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYearOfBirth());
                }
            }
        } catch (Exception e) {
            System.out.println("File Error.");
        }
    }
}

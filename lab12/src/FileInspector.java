import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Set to src directory
        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Processing file: " + selectedFile.getName());

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = Files.newBufferedReader(selectedFile.toPath())) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }

            // Summary report
            System.out.println("Summary Report:");
            System.out.println("File Name: " + selectedFile.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } else {
            System.out.println("No file selected.");
        }
    }
}

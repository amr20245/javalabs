import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        try {
            File file;

            if (args.length > 0) {
                // Use the file name passed as a command-line argument
                file = new File(args[0]);
                if (!file.exists()) {
                    System.out.println("File not found: " + args[0]);
                    return;
                }
            } else {
                // Open JFileChooser if no argument is provided
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                } else {
                    System.out.println("No file selected.");
                    return;
                }
            }

            // Read and analyze the file
            try (Scanner scanner = new Scanner(file)) {
                int lines = 0, words = 0, characters = 0;

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines++;
                    characters += line.length();
                    words += line.split("\\s+").length; // Split by whitespace
                }

                // Display results
                System.out.println("File: " + file.getName());
                System.out.println("Lines: " + lines);
                System.out.println("Words: " + words);
                System.out.println("Characters: " + characters);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

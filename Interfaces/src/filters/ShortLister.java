package filters;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ShortWordFilter filter = new ShortWordFilter();

            try (Scanner scanner = new Scanner(selectedFile)) {
                System.out.println("Short words (length < 5):");
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (filter.accept(word)) {
                        System.out.println(word);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}

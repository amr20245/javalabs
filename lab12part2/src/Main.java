import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> list = new ArrayList<>();
    private static boolean needsToBeSaved = false;
    private static String currentFileName = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("A - Add an item");
            System.out.println("D - Delete an item");
            System.out.println("I - Insert an item");
            System.out.println("M - Move an item");
            System.out.println("V - View the list");
            System.out.println("O - Open a list file");
            System.out.println("S - Save the list");
            System.out.println("C - Clear the list");
            System.out.println("Q - Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addItem(scanner);
                    break;
                case "D":
                    deleteItem(scanner);
                    break;
                case "I":
                    insertItem(scanner);
                    break;
                case "M":
                    moveItem(scanner);
                    break;
                case "V":
                    viewList();
                    break;
                case "O":
                    openFile(scanner);
                    break;
                case "S":
                    saveFile(scanner);
                    break;
                case "C":
                    clearList();
                    break;
                case "Q":
                    running = quitProgram(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        list.add(item);
        needsToBeSaved = true;
    }

    private static void deleteItem(Scanner scanner) {
        viewList();
        System.out.print("Enter the index of the item to delete: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            needsToBeSaved = true;
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void insertItem(Scanner scanner) {
        System.out.print("Enter the index to insert at: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the item to insert: ");
        String item = scanner.nextLine();
        if (index >= 0 && index <= list.size()) {
            list.add(index, item);
            needsToBeSaved = true;
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void moveItem(Scanner scanner) {
        viewList();
        System.out.print("Enter the index of the item to move: ");
        int fromIndex = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the new index: ");
        int toIndex = Integer.parseInt(scanner.nextLine());
        if (fromIndex >= 0 && fromIndex < list.size() && toIndex >= 0 && toIndex <= list.size()) {
            String item = list.remove(fromIndex);
            list.add(toIndex, item);
            needsToBeSaved = true;
        } else {
            System.out.println("Invalid indices.");
        }
    }

    private static void viewList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ": " + list.get(i));
            }
        }
    }

    private static void openFile(Scanner scanner) {
        if (needsToBeSaved) {
            System.out.print("You have unsaved changes. Do you want to save them? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                saveFile(scanner);
            }
        }
        System.out.print("Enter the file name to open: ");
        String fileName = scanner.nextLine() + ".txt";
        try {
            list.clear();
            list.addAll(Files.readAllLines(Paths.get(fileName)));
            currentFileName = fileName;
            needsToBeSaved = false;
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private static void saveFile(Scanner scanner) {
        if (currentFileName == null) {
            System.out.print("Enter a file name to save as: ");
            currentFileName = scanner.nextLine() + ".txt";
        }
        try {
            Files.write(Paths.get(currentFileName), list);
            needsToBeSaved = false;
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static void clearList() {
        list.clear();
        needsToBeSaved = true;
    }

    private static boolean quitProgram(Scanner scanner) {
        if (needsToBeSaved) {
            System.out.print("You have unsaved changes. Do you want to save them? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                saveFile(scanner);
            }
        }
        return false;
    }
}

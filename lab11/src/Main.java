import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean quit = false;

        while (!quit) {
            displayMenu();
            String choice = getInput("Enter your choice: ").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(list);
                    break;
                case "D":
                    deleteItem(list);
                    break;
                case "I":
                    insertItem(list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    quit = quitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void addItem(ArrayList<String> list) {
        String item = getInput("Enter the item to add: ");
        list.add(item);
        System.out.println("Item added!");
    }

    private static void deleteItem(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        printList(list);
        int index = getIndex(list.size(), "Enter the item number to delete: ");
        list.remove(index);
        System.out.println("Item deleted!");
    }

    private static void insertItem(ArrayList<String> list) {
        String item = getInput("Enter the item to insert: ");
        int index = getIndex(list.size() + 1, "Enter the position to insert the item: ");
        list.add(index, item);
        System.out.println("Item inserted!");
    }

    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }

    private static boolean quitProgram() {
        String confirm = getInput("Are you sure you want to quit? (Y/N): ").toUpperCase();
        return confirm.equals("Y");
    }

    private static int getIndex(int max, String prompt) {
        int index;
        while (true) {
            try {
                System.out.print(prompt);
                index = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (index >= 0 && index < max) {
                    break;
                } else {
                    System.out.println("Invalid index. Please enter a value between 1 and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return index;
    }
}

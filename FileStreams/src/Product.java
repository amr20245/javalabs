import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public static final int NAME_LENGTH = 35;
    public static final int DESC_LENGTH = 75;
    public static final int ID_LENGTH = 6;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public static String padString(String input, int length) {
        if (input.length() > length) {
            return input.substring(0, length);
        } else {
            return String.format("%-" + length + "s", input);
        }
    }

    public String getFixedName() {
        return padString(name, NAME_LENGTH);
    }

    public String getFixedDescription() {
        return padString(description, DESC_LENGTH);
    }

    public String getFixedID() {
        return padString(ID, ID_LENGTH);
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return name.trim() + " | " + description.trim() + " | " + ID.trim() + " | $" + cost;
    }
}

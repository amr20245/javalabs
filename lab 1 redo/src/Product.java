public class Product {
    private final String ID;
    private String name;
    private String description;
    private double cost;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    // Getters
    public String getID() { return ID; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    // Setters (except ID)
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

    // Methods
    public String toCSV() {
        return ID + "," + name + "," + description + "," + cost;
    }

    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"name\":\"%s\",\"description\":\"%s\",\"cost\":%.2f}",
                ID, name, description, cost);
    }

    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost></Product>",
                ID, name, description, cost);
    }

    @Override
    public String toString() {
        return name + " (" + description + ") - $" + cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return ID.equals(product.ID);
    }
}

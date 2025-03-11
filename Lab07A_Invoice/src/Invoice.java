import java.util.ArrayList;

public class Invoice {
    private String title;
    private String customerAddress;
    private ArrayList<LineItem> lineItems;

    public Invoice(String title, String customerAddress) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for(LineItem item : lineItems) {
            total += item.getLineTotal();
        }
        return total;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
}

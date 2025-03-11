import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvoiceGUI extends JFrame {
    private Invoice invoice;
    private JTextField titleField;
    private JTextField addressField;
    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea invoiceArea;

    public InvoiceGUI() {
        setTitle("Invoice Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Invoice header input
        JLabel titleLabel = new JLabel("Invoice Title:");
        titleField = new JTextField(20);
        JLabel addressLabel = new JLabel("Customer Address:");
        addressField = new JTextField(20);

        JPanel headerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        headerPanel.add(titleLabel);
        headerPanel.add(titleField);
        headerPanel.add(addressLabel);
        headerPanel.add(addressField);

        // Product details input
        JLabel productNameLabel = new JLabel("Product Name:");
        productNameField = new JTextField(20);
        JLabel unitPriceLabel = new JLabel("Unit Price:");
        unitPriceField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(5);

        JPanel productPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        productPanel.setBorder(BorderFactory.createTitledBorder("Add Line Item"));
        productPanel.add(productNameLabel);
        productPanel.add(productNameField);
        productPanel.add(unitPriceLabel);
        productPanel.add(unitPriceField);
        productPanel.add(quantityLabel);
        productPanel.add(quantityField);

        // Buttons for actions
        JButton addItemButton = new JButton("Add Line Item");
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addLineItem();
            }
        });

        JButton displayInvoiceButton = new JButton("Display Invoice");
        displayInvoiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayInvoice();
            }
        });

        // Text area to display invoice output
        invoiceArea = new JTextArea(15, 40);
        invoiceArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(invoiceArea);

        // Layout setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(productPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(addItemButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(displayInvoiceButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(scrollPane);

        add(mainPanel);
    }

    private void addLineItem() {
        try {
            String productName = productNameField.getText();
            double unitPrice = Double.parseDouble(unitPriceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            // If the invoice header hasn’t been set, create the invoice.
            if (invoice == null) {
                String title = titleField.getText();
                String address = addressField.getText();
                invoice = new Invoice(title, address);
            }

            Product product = new Product(productName, unitPrice);
            LineItem lineItem = new LineItem(product, quantity);
            invoice.addLineItem(lineItem);

            // Clear product input fields
            productNameField.setText("");
            unitPriceField.setText("");
            quantityField.setText("");

            JOptionPane.showMessageDialog(this, "Line item added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for unit price and quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayInvoice() {
        if (invoice == null) {
            JOptionPane.showMessageDialog(this, "No invoice data available. Please add line items.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("====================================\n");
        sb.append("Invoice Title: ").append(invoice.getTitle()).append("\n");
        sb.append("Customer Address: ").append(invoice.getCustomerAddress()).append("\n");
        sb.append("====================================\n");
        sb.append("Line Items:\n");
        for (LineItem item : invoice.getLineItems()) {
            sb.append("Product: ").append(item.getProduct().getName())
                    .append(", Unit Price: ").append(item.getProduct().getUnitPrice())
                    .append(", Quantity: ").append(item.getQuantity())
                    .append(", Line Total: ").append(item.getLineTotal()).append("\n");
        }
        sb.append("====================================\n");
        sb.append("Total Amount Due: ").append(invoice.getTotalAmount()).append("\n");
        sb.append("====================================\n");

        invoiceArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGUI().setVisible(true);
            }
        });
    }
}

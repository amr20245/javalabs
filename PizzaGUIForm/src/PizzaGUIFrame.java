import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame {

    // Radio buttons for crust
    private JRadioButton thinCrustRadio;
    private JRadioButton regularCrustRadio;
    private JRadioButton deepDishCrustRadio;
    private ButtonGroup crustGroup;

    // Combo box for size
    private JComboBox<String> sizeComboBox;

    // Check boxes for toppings
    private JCheckBox toppingPepperoni;
    private JCheckBox toppingMushrooms;
    private JCheckBox toppingExtraCheese;
    private JCheckBox toppingOlives;
    private JCheckBox toppingOnions;
    private JCheckBox toppingBananaPeppers;

    // Text area (inside a scroll pane) for the receipt
    private JTextArea receiptTextArea;

    // Buttons
    private JButton orderButton;
    private JButton clearButton;
    private JButton quitButton;

    public PizzaGUIFrame() {
        super("Pizza Order Form");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // ============= 1. Crust Panel (Radio Buttons) =============
        JPanel crustPanel = new JPanel();
        crustPanel.setBorder(new TitledBorder("Crust Type"));
        crustPanel.setLayout(new GridLayout(3, 1));

        thinCrustRadio = new JRadioButton("Thin Crust");
        regularCrustRadio = new JRadioButton("Regular Crust");
        deepDishCrustRadio = new JRadioButton("Deep-Dish Crust");

        crustGroup = new ButtonGroup();
        crustGroup.add(thinCrustRadio);
        crustGroup.add(regularCrustRadio);
        crustGroup.add(deepDishCrustRadio);

        crustPanel.add(thinCrustRadio);
        crustPanel.add(regularCrustRadio);
        crustPanel.add(deepDishCrustRadio);

        // ============= 2. Size Panel (Combo Box) =============
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(new TitledBorder("Pizza Size"));
        sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large", "Super"});
        sizePanel.add(sizeComboBox);

        // ============= 3. Toppings Panel (Check Boxes) =============
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setBorder(new TitledBorder("Toppings"));
        toppingsPanel.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns

        toppingPepperoni = new JCheckBox("Pepperoni");
        toppingMushrooms = new JCheckBox("Mushrooms");
        toppingExtraCheese = new JCheckBox("Extra Cheese");
        toppingOlives = new JCheckBox("Black Olives");
        toppingOnions = new JCheckBox("Onions");
        toppingBananaPeppers = new JCheckBox("Banana Peppers");

        toppingsPanel.add(toppingPepperoni);
        toppingsPanel.add(toppingMushrooms);
        toppingsPanel.add(toppingExtraCheese);
        toppingsPanel.add(toppingOlives);
        toppingsPanel.add(toppingOnions);
        toppingsPanel.add(toppingBananaPeppers);

        // ============= 4. Receipt Panel (Text Area) =============
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBorder(new TitledBorder("Receipt"));
        receiptPanel.setLayout(new BorderLayout());

        receiptTextArea = new JTextArea(10, 40);
        receiptTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        receiptPanel.add(scrollPane, BorderLayout.CENTER);

        // ============= 5. Buttons Panel =============
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        quitButton = new JButton("Quit");

        buttonsPanel.add(orderButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(quitButton);

        // ============= Add Panels to Frame Layout =============
        // Top row: crustPanel + sizePanel + toppingsPanel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3));
        topPanel.add(crustPanel);
        topPanel.add(sizePanel);
        topPanel.add(toppingsPanel);

        // Middle row: receiptPanel
        // Bottom row: buttonsPanel

        add(topPanel, BorderLayout.NORTH);
        add(receiptPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // ============= Event Handling =============
        // 1. Order Button
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processOrder();
            }
        });

        // 2. Clear Button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // 3. Quit Button
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        PizzaGUIFrame.this,
                        "Are you sure you want to quit?",
                        "Confirm Quit",
                        JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    // ============= Helper Method: Process the Order =============
    private void processOrder() {
        // Validate that user selected a crust
        if (!thinCrustRadio.isSelected() && !regularCrustRadio.isSelected() && !deepDishCrustRadio.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a crust type!");
            return;
        }

        // We must also have at least one topping selected
        if (!toppingPepperoni.isSelected() &&
                !toppingMushrooms.isSelected() &&
                !toppingExtraCheese.isSelected() &&
                !toppingOlives.isSelected() &&
                !toppingOnions.isSelected() &&
                !toppingBananaPeppers.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select at least one topping!");
            return;
        }

        // Gather the crust selection
        String crustType;
        if (thinCrustRadio.isSelected()) {
            crustType = "Thin Crust";
        } else if (regularCrustRadio.isSelected()) {
            crustType = "Regular Crust";
        } else {
            crustType = "Deep-Dish Crust";
        }

        // Gather the size selection (affects base cost)
        String size = (String) sizeComboBox.getSelectedItem();
        double baseCost = 0.0;
        switch (size) {
            case "Small":  baseCost =  8.00; break;
            case "Medium": baseCost = 12.00; break;
            case "Large":  baseCost = 16.00; break;
            case "Super":  baseCost = 20.00; break;
        }

        // Gather the toppings and count them
        double toppingsCost = 0.0;
        StringBuilder toppingsChosen = new StringBuilder();
        if (toppingPepperoni.isSelected()) {
            toppingsChosen.append("Pepperoni ($1.00)\n");
            toppingsCost += 1.00;
        }
        if (toppingMushrooms.isSelected()) {
            toppingsChosen.append("Mushrooms ($1.00)\n");
            toppingsCost += 1.00;
        }
        if (toppingExtraCheese.isSelected()) {
            toppingsChosen.append("Extra Cheese ($1.00)\n");
            toppingsCost += 1.00;
        }
        if (toppingOlives.isSelected()) {
            toppingsChosen.append("Black Olives ($1.00)\n");
            toppingsCost += 1.00;
        }
        if (toppingOnions.isSelected()) {
            toppingsChosen.append("Onions ($1.00)\n");
            toppingsCost += 1.00;
        }
        if (toppingBananaPeppers.isSelected()) {
            toppingsChosen.append("Banana Peppers ($1.00)\n");
            toppingsCost += 1.00;
        }

        // Compute subtotal, tax, and total
        double subTotal = baseCost + toppingsCost;
        double tax = subTotal * 0.07;  // 7% tax
        double total = subTotal + tax;

        // Build the receipt text
        StringBuilder receipt = new StringBuilder();
        receipt.append("=========================================\n");
        receipt.append("Crust: ").append(crustType).append("\n");
        receipt.append("Size:  ").append(size)
                .append("  --  Base Cost: $").append(String.format("%.2f", baseCost)).append("\n\n");
        receipt.append("Toppings:\n").append(toppingsChosen.toString()).append("\n");

        receipt.append("-----------------------------------------\n");
        receipt.append(String.format("Sub-total:         $%.2f\n", subTotal));
        receipt.append(String.format("Tax (7%%):          $%.2f\n", tax));
        receipt.append("-----------------------------------------\n");
        receipt.append(String.format("Total:             $%.2f\n", total));
        receipt.append("=========================================\n");

        // Display in the text area
        receiptTextArea.setText(receipt.toString());
    }

    // ============= Helper Method: Clear the Form =============
    private void clearForm() {
        crustGroup.clearSelection();
        sizeComboBox.setSelectedIndex(0);

        toppingPepperoni.setSelected(false);
        toppingMushrooms.setSelected(false);
        toppingExtraCheese.setSelected(false);
        toppingOlives.setSelected(false);
        toppingOnions.setSelected(false);
        toppingBananaPeppers.setSelected(false);

        receiptTextArea.setText("");
    }

}

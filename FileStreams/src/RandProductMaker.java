import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RandProductMaker extends JFrame {
    private JTextField nameField, descField, idField, costField, countField;
    private RandomAccessFile raf;
    private int recordCount = 0;

    public RandProductMaker() {
        setTitle("Random Product Maker");
        setLayout(new GridLayout(6, 2));

        nameField = new JTextField();
        descField = new JTextField();
        idField = new JTextField();
        costField = new JTextField();
        countField = new JTextField("0");
        countField.setEditable(false);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Description:"));
        add(descField);
        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Cost:"));
        add(costField);
        add(new JLabel("Record Count:"));
        add(countField);

        JButton addButton = new JButton("Add Product");
        JButton quitButton = new JButton("Quit");
        add(addButton);
        add(quitButton);

        try {
            raf = new RandomAccessFile("products.dat", "rw");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File error: " + e.getMessage());
        }

        addButton.addActionListener(e -> addProduct());
        quitButton.addActionListener(e -> {
            try {
                raf.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addProduct() {
        try {
            String name = Product.padString(nameField.getText(), Product.NAME_LENGTH);
            String desc = Product.padString(descField.getText(), Product.DESC_LENGTH);
            String id = Product.padString(idField.getText(), Product.ID_LENGTH);
            double cost = Double.parseDouble(costField.getText());

            raf.seek(raf.length()); // Append to file
            raf.writeChars(name);
            raf.writeChars(desc);
            raf.writeChars(id);
            raf.writeDouble(cost);

            recordCount++;
            countField.setText(String.valueOf(recordCount));

            nameField.setText("");
            descField.setText("");
            idField.setText("");
            costField.setText("");

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new RandProductMaker();
    }
}

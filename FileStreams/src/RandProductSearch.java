import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RandProductSearch extends JFrame {
    private JTextField searchField;
    private JTextArea resultsArea;

    public RandProductSearch() {
        setTitle("Product Search");
        setLayout(new BorderLayout());

        searchField = new JTextField();
        resultsArea = new JTextArea();
        JButton searchBtn = new JButton("Search");

        add(searchField, BorderLayout.NORTH);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        add(searchBtn, BorderLayout.SOUTH);

        searchBtn.addActionListener(e -> searchProducts());

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void searchProducts() {
        String keyword = searchField.getText().toLowerCase();
        resultsArea.setText("");

        try (RandomAccessFile raf = new RandomAccessFile("products.dat", "r")) {
            long recordSize = (Product.NAME_LENGTH + Product.DESC_LENGTH + Product.ID_LENGTH) * 2 + 8; // 2 bytes/char + 8 for double
            long numRecords = raf.length() / recordSize;

            for (int i = 0; i < numRecords; i++) {
                raf.seek(i * recordSize);
                String name = readFixedString(raf, Product.NAME_LENGTH).trim();
                String desc = readFixedString(raf, Product.DESC_LENGTH).trim();
                String id = readFixedString(raf, Product.ID_LENGTH).trim();
                double cost = raf.readDouble();

                if (name.toLowerCase().contains(keyword)) {
                    resultsArea.append(name + " | " + desc + " | " + id + " | $" + cost + "\n");
                }
            }
        } catch (IOException e) {
            resultsArea.setText("Error: " + e.getMessage());
        }
    }

    private String readFixedString(RandomAccessFile raf, int length) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(raf.readChar());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new RandProductSearch();
    }
}

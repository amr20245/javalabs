package sortedlist;           // ←-- keep in same package as SortedList

import javax.swing.*;
import java.awt.*;

/**
 * Simple Swing front-end for testing the SortedList class.
 */
public class SortedListGUI {

    public static void main(String[] args) {
        // ---- core data structure ----
        SortedList list = new SortedList();

        // ---- Swing components ----
        JTextField addField    = new JTextField(10);
        JButton    addButton   = new JButton("Add");
        JTextField searchField = new JTextField(10);
        JButton    searchBtn   = new JButton("Search");
        JTextArea  outputArea  = new JTextArea(12, 28);
        outputArea.setEditable(false);
        JScrollPane scroll     = new JScrollPane(outputArea);

        // ---- add action logic ----
        addButton.addActionListener(e -> {
            String txt = addField.getText().trim();
            if (!txt.isEmpty()) {
                list.add(txt);
                outputArea.setText(list.toString());
                addField.setText("");
            }
        });

        searchBtn.addActionListener(e -> {
            String key = searchField.getText().trim();
            if (!key.isEmpty()) {
                outputArea.append("\n" + list.search(key));
                searchField.setText("");
            }
        });

        // ---- layout ----
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Add:"));    top.add(addField);    top.add(addButton);
        top.add(Box.createHorizontalStrut(15)); // spacer
        top.add(new JLabel("Search:")); top.add(searchField); top.add(searchBtn);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout(5, 5));
        root.add(top, BorderLayout.NORTH);
        root.add(scroll, BorderLayout.CENTER);

        // ---- frame ----
        JFrame frame = new JFrame("Sorted List Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}

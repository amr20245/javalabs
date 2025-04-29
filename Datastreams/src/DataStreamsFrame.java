package datastreams;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStreamsFrame extends JFrame {

    private final JTextArea originalArea = new JTextArea();
    private final JTextArea filteredArea = new JTextArea();
    private final JTextField searchField = new JTextField(20);
    private final JButton loadBtn = new JButton("Load File");
    private final JButton searchBtn = new JButton("Search");
    private final JButton quitBtn = new JButton("Quit");

    private List<String> lines = List.of();   // keeps the file lines

    public DataStreamsFrame() {
        super("Java Data Streams – Lab 09");

        // --- layout ---
        originalArea.setEditable(false);
        filteredArea.setEditable(false);

        JScrollPane leftScroll  = new JScrollPane(originalArea);
        JScrollPane rightScroll = new JScrollPane(filteredArea);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftScroll, rightScroll);
        split.setResizeWeight(0.5);

        JPanel top = new JPanel();
        top.add(new JLabel("Search:"));
        top.add(searchField);
        top.add(loadBtn);
        top.add(searchBtn);
        top.add(quitBtn);

        add(top, BorderLayout.NORTH);
        add(split, BorderLayout.CENTER);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // --- actions ---
        loadBtn.addActionListener(e -> loadFile());
        searchBtn.addActionListener(e -> filterLines());
        quitBtn.addActionListener(e -> System.exit(0));
    }

    private void loadFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();
            try (Stream<String> stream = Files.lines(file)) {
                lines = stream.toList();
                originalArea.setText(String.join("\n", lines));
                filteredArea.setText("");         // clear old results
                searchField.setText("");          // clear search box
            } catch (IOException ex) {
                showError("Could not read file: " + ex.getMessage());
            }
        }
    }

    private void filterLines() {
        String term = searchField.getText().trim().toLowerCase();
        if (term.isEmpty() || lines.isEmpty()) {
            showError("Load a file first and type something to search.");
            return;
        }
        String result = lines.stream()                      // Stream API
                .filter(l -> l.toLowerCase()
                        .contains(term)) // λ filter
                .collect(Collectors.joining("\n"));
        filteredArea.setText(result);
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

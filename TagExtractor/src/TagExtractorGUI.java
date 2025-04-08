import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;

public class TagExtractorGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel fileNameLabel;
    private File selectedTextFile;
    private File stopWordsFile;

    public void createAndShowGUI() {
        frame = new JFrame("Tag Extractor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        JButton chooseTextFileBtn = new JButton("Choose Text File");
        JButton chooseStopFileBtn = new JButton("Choose Stop Words File");
        JButton extractBtn = new JButton("Extract Tags");
        JButton saveBtn = new JButton("Save Output");

        fileNameLabel = new JLabel("No file selected");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        topPanel.add(chooseTextFileBtn);
        topPanel.add(chooseStopFileBtn);
        topPanel.add(extractBtn);
        topPanel.add(saveBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(fileNameLabel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        chooseTextFileBtn.addActionListener(this::chooseTextFile);
        chooseStopFileBtn.addActionListener(this::chooseStopWordsFile);
        extractBtn.addActionListener(this::extractTags);
        saveBtn.addActionListener(this::saveOutput);

        frame.setVisible(true);
    }

    private void chooseTextFile(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedTextFile = chooser.getSelectedFile();
            fileNameLabel.setText("Selected: " + selectedTextFile.getName());
        }
    }

    private void chooseStopWordsFile(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            stopWordsFile = chooser.getSelectedFile();
        }
    }

    private void extractTags(ActionEvent e) {
        if (selectedTextFile == null || stopWordsFile == null) {
            JOptionPane.showMessageDialog(frame, "Please select both files.");
            return;
        }

        Map<String, Integer> tags = TagExtractor.extract(selectedTextFile, stopWordsFile);
        StringBuilder sb = new StringBuilder();
        tags.forEach((word, freq) -> sb.append(word).append(" : ").append(freq).append("\n"));
        textArea.setText(sb.toString());
    }

    private void saveOutput(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File saveFile = chooser.getSelectedFile();
            TagExtractor.saveToFile(textArea.getText(), saveFile);
        }
    }
}

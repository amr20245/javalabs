package recursivelister;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Swing window for Lab 11 – lists every file in a chosen directory (recursively).
 */
public class RecursiveListerFrame extends JFrame {

    private final JTextArea outputArea = new JTextArea();

    public RecursiveListerFrame() {
        super("Recursive File Lister");
        buildGui();
    }

    // ---------- GUI ----------

    private void buildGui() {
        // Use the host OS look & feel
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}

        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Recursive File Lister", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        add(title, BorderLayout.NORTH);

        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JButton startBtn = new JButton("Start");
        JButton quitBtn  = new JButton("Quit");

        startBtn.addActionListener(e -> chooseAndList());
        quitBtn.addActionListener(e -> System.exit(0));

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(startBtn);
        south.add(quitBtn);
        add(south, BorderLayout.SOUTH);

        setSize(600, 400);
        setLocationRelativeTo(null);          // center on screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ---------- Action logic ----------

    /** Opens a JFileChooser and starts the recursive listing. */
    private void chooseAndList() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pick a folder to list");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File dir = chooser.getSelectedFile();
            outputArea.setText("");
            listFiles(dir);
        }
    }

    /** Recursively lists every file and sub-folder. */
    private void listFiles(File f) {
        if (f.isFile()) {
            outputArea.append(f.getAbsolutePath() + "\n");
        } else {
            outputArea.append("[" + f.getAbsolutePath() + "]\n");
            File[] kids = f.listFiles();
            if (kids != null) {
                for (File child : kids) {
                    listFiles(child);
                }
            }
        }
    }
}

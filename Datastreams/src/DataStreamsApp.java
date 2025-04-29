package datastreams;

import javax.swing.SwingUtilities;

public class DataStreamsApp {
    public static void main(String[] args) {
        // Start the GUI on the Swing thread
        SwingUtilities.invokeLater(() ->
                new DataStreamsFrame().setVisible(true));
    }
}

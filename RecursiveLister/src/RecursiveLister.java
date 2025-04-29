package recursivelister;

import javax.swing.SwingUtilities;

/**
 * Launches the Swing frame on the EDT.
 */
public class RecursiveLister {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecursiveListerFrame::new);
    }
}

public class PizzaGUIRunner {
    public static void main(String[] args) {
        // Use the Event Dispatch Thread for Swing components
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PizzaGUIFrame frame = new PizzaGUIFrame();
                frame.setVisible(true);
            }
        });
    }
}

package fortuneteller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneTextArea;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Layout
        setLayout(new BorderLayout());

        // ----- TOP PANEL -----
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller");

        // ImageIcon for the JLabel
        ImageIcon icon = new ImageIcon("Fortune_icon.jpg"); // Place your image in the project folder
        titleLabel.setIcon(icon);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel);

        // ----- MIDDLE PANEL -----
        JPanel middlePanel = new JPanel();
        fortuneTextArea = new JTextArea(10, 30);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane);

        // ----- BOTTOM PANEL -----
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // ----- ADDING PANELS TO FRAME -----
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ----- LIST OF FORTUNES -----
        fortunes = new ArrayList<>();
        fillFortunes();

        // ----- EVENT HANDLING -----
        Random random = new Random();
        ActionListener readFortuneListener = e -> {
            int newIndex;
            do {
                newIndex = random.nextInt(fortunes.size());
            } while (newIndex == lastFortuneIndex);

            lastFortuneIndex = newIndex;
            fortuneTextArea.append(fortunes.get(newIndex) + "\n");
        };

        ActionListener quitListener = e -> System.exit(0);

        readFortuneButton.addActionListener(readFortuneListener);
        quitButton.addActionListener(quitListener);

        // ----- SETTING SIZE -----
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
    }

    private void fillFortunes() {
        fortunes.add("You will have a great day!");
        fortunes.add("Beware of low-flying birds.");
        fortunes.add("Your future is bright and full of joy.");
        fortunes.add("Someone will bring you good news.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("A new opportunity is on the horizon.");
        fortunes.add("Today is a perfect day for a new beginning.");
        fortunes.add("Expect the unexpected.");
        fortunes.add("You will find a dollar on the ground soon.");
        fortunes.add("Your efforts will soon be rewarded.");
        fortunes.add("Something you lost will be found.");
        fortunes.add("An exciting adventure awaits you.");
    }
}

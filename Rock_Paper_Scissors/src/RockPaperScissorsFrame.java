import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    private JTextField playerWinsField;
    private JTextField computerWinsField;
    private JTextField tiesField;
    private JTextArea resultArea;

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose Your Move"));

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);

        // Stats Panel
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 2));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Game Stats"));

        statsPanel.add(new JLabel("Player Wins:"));
        playerWinsField = new JTextField("0");
        playerWinsField.setEditable(false);
        statsPanel.add(playerWinsField);

        statsPanel.add(new JLabel("Computer Wins:"));
        computerWinsField = new JTextField("0");
        computerWinsField.setEditable(false);
        statsPanel.add(computerWinsField);

        statsPanel.add(new JLabel("Ties:"));
        tiesField = new JTextField("0");
        tiesField.setEditable(false);
        statsPanel.add(tiesField);

        // Results Panel
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add Panels to Frame
        add(buttonPanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Button Action Listeners
        rockButton.addActionListener(e -> playGame("Rock"));
        paperButton.addActionListener(e -> playGame("Paper"));
        scissorsButton.addActionListener(e -> playGame("Scissors"));
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void playGame(String playerChoice) {
        String computerChoice = choices[random.nextInt(3)];
        String result;

        if (playerChoice.equals(computerChoice)) {
            result = "It's a tie!";
            ties++;
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = playerChoice + " beats " + computerChoice + " (Player Wins)";
            playerWins++;
        } else {
            result = computerChoice + " beats " + playerChoice + " (Computer Wins)";
            computerWins++;
        }

        resultArea.append(result + "\n");
        updateStats();
    }

    private void updateStats() {
        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }
}

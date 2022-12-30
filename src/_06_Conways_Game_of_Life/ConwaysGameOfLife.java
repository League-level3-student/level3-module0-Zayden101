package _06_Conways_Game_of_Life;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConwaysGameOfLife extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int CELLS_PER_ROW = 50;

    private JFrame window;
    private JPanel inputPanel;
    private JButton startStopButton;
    private JButton randomizeButton;
    private JButton clearButton;
    private JLabel speedLabel;
    private JTextField speedField;

    private WorldPanel gamePanel;

    public static void main(String[] args) {
        new ConwaysGameOfLife().launchGame();
    }

    public void launchGame() {
        //build the window and start the simulation
        //setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        window = new JFrame("Conway's Game Of Life");
        window.add(this);

        inputPanel = new JPanel();
        startStopButton = new JButton("START");
        startStopButton.addActionListener(this);
        randomizeButton = new JButton("RANDOMIZE");
        randomizeButton.addActionListener(this);
        clearButton = new JButton("CLEAR");
        clearButton.addActionListener(this);
        speedLabel = new JLabel("delay:");
        speedField = new JTextField(5);
        speedField.setText(Integer.toString(60));

        inputPanel.add(startStopButton);
        inputPanel.add(speedLabel);
        inputPanel.add(speedField);
        inputPanel.add(randomizeButton);
        inputPanel.add(clearButton);
        add(inputPanel, BorderLayout.NORTH);

        gamePanel = new WorldPanel(WIDTH, HEIGHT, CELLS_PER_ROW);
        add(gamePanel, BorderLayout.CENTER);

        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    boolean run = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startStopButton) {
            run = !run;
            if(run) {
                gamePanel.startAnimation();
                startStopButton.setText("STOP");
                int x = 200;
                try {
                    x = Integer.parseInt(speedField.getText());
                    if(x <= 0) {
                        x = 1;
                    }
                }catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                gamePanel.setAnimationDelay(x);
            }else {
                gamePanel.stopAnimation();
                startStopButton.setText("START");
            }
        }else if(e.getSource() == randomizeButton) {
            gamePanel.randomizeCells();
        }else if(e.getSource() == clearButton) {
            gamePanel.clearCells();
        }
    }
}

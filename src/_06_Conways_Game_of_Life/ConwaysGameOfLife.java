package _06_Conways_Game_of_Life;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ConwaysGameOfLife extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public static final int CELLS_PER_ROW = 125;

    private JFrame window;
    private JPanel inputPanel;
    private JButton startStopButton;
    private JButton randomizeButton;
//    private JButton fillButton;
    private JButton clearButton;
    private JLabel speedLabel;
    private JTextField speedField;
    private JButton downright;
    private JButton downleft;
    private JButton upright;
    private JButton upleft;
    
    private JButton colorButton;
    private JButton a;
    
    Timer drtimer;
    Timer dltimer;
    Timer urtimer;
    Timer ultimer;
    
    Timer atimer;

    
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
        downright = new JButton("\u2198");
        downright.addActionListener(this);
        downleft = new JButton("\u2199");
        downleft.addActionListener(this);
        upright = new JButton("\u2197");
        upright.addActionListener(this);
        upleft = new JButton("\u2196");
        upleft.addActionListener(this);
//        fillButton = new JButton("FILL");
//        fillButton.addActionListener(this);
        a = new JButton("\u1396");
        a.addActionListener(this);

        
        colorButton = new JButton("Color");
        colorButton.addActionListener(this);

        
        inputPanel.add(startStopButton);
        inputPanel.add(speedLabel);
        inputPanel.add(speedField);
        inputPanel.add(randomizeButton);
//        inputPanel.add(fillButton);
        inputPanel.add(clearButton);
        inputPanel.add(downright);
        inputPanel.add(downleft);
        inputPanel.add(upright);
        inputPanel.add(upleft);
        
        inputPanel.add(colorButton);
        inputPanel.add(a);

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
        }else if(e.getSource() == downright) {            
			drtimer = new Timer(2000, this);
			drtimer.start();
        }else if(e.getSource() == drtimer) {
            gamePanel.downright();
            drtimer.stop();
        }else if(e.getSource() == downleft) {            
			dltimer = new Timer(2000, this);
			dltimer.start();
        }else if(e.getSource() == dltimer) {
    		gamePanel.downleft();
    		dltimer.stop();
    	}else if(e.getSource() == upright) {            
			urtimer = new Timer(2000, this);
			urtimer.start();
        }else if(e.getSource() == urtimer) {
    		gamePanel.upright();
    		urtimer.stop();
    	}else if(e.getSource() == upleft) {            
			ultimer = new Timer(2000, this);
			ultimer.start();
        }else if(e.getSource() == ultimer) {
    		gamePanel.upleft();
    		ultimer.stop();
//        }else if(e.getSource() == fillButton) {
//    		gamePanel.fillButton();
        }
        
        else if(e.getSource() == colorButton) {
    		gamePanel.colorChoice();
        }
        
        else if(e.getSource() == a) {  
			atimer = new Timer(3000, this);
    		gamePanel.choice();

        	atimer.start();
        }else if(e.getSource() == atimer) {
    		gamePanel.a();
    		atimer.stop();
        }
    }
}

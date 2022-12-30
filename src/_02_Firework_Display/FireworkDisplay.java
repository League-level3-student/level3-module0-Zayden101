package _02_Firework_Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FireworkDisplay extends JPanel implements ActionListener {
    public static int WIDTH;
    public static int HEIGHT;

    private JFrame window;
    private JPanel buttonPanel;
    private JButton fireButton;
    private Timer timer;

    Firework firework = null;

    public static void main(String[] args) {
        new FireworkDisplay().start();
    }

    public void start() {
        window = new JFrame();
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER);

        WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        buttonPanel = new JPanel();
        fireButton = new JButton("FIRE");
        fireButton.addActionListener((e)->{
            fire();
        });

        buttonPanel.add(fireButton);
        window.add(buttonPanel, BorderLayout.SOUTH);

        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        timer = new Timer(1000 / 60, this);
    }

    private void fire() {
        fireButton.setEnabled(false);
        firework = new Firework();
        firework.launch();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(10, 30, 70));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if(firework != null) {
            firework.drawSparks(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        firework.updateSparks();
        repaint();

        boolean reset = true;
        if(!firework.dead) {
            reset = false;
        }
        if(reset) {
            timer.stop();
            fireButton.setEnabled(true);
        }
    }
}

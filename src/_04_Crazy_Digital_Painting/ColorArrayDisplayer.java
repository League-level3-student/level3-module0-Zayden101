package _04_Crazy_Digital_Painting;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Complete the steps in the CrazyDigitalPainting class
 */

public class ColorArrayDisplayer {
    public static void displayColorsAsImage(Color[][] colors) {
        JFrame window = new JFrame();
        JLabel label = new JLabel();
        BufferedImage image = new BufferedImage(colors.length, colors[0].length, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j < colors[0].length; j++) {
                image.setRGB(i, j, colors[i][j].getRGB());
            }
        }

        label.setIcon(new ImageIcon(image));
        window.add(label);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);	
    }
}

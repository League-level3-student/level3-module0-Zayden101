package _02_Firework_Display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * 
 * You can think of a fire work as an array of sparks. Run the demo jar to see the finished product
 * then complete the steps. 
 *
 */

public class Firework{
    public static final int GRAVITY = 1;

    // 1. Create an array of Spark objects called sparks. Don't initialize it.

    Spark[] sparks;

    
    public boolean dead = false;

    public Firework() {
        // 2. Initialize the Spark array to contain 100 Sparks. 
    	
    	sparks = new Spark[250];


        // 3. Iterate through the sparks and initialize each one to a new Spark.
        //    Make each spark start at the middle bottom of the screen.
    	
    	Random red = new Random();
		Random green = new Random();
		Random blue = new Random();
    	
		
		
    	
    	for (int i = 0; i < sparks.length; i++) {
			sparks[i]=new Spark(1020, 700);
			
			int re = red.nextInt(255);
			int gr = green.nextInt(255);
			int bl = blue.nextInt(50);
			    		    		
			Color random = new Color(re,gr,bl);
			
			sparks[i].color=random;
		}
    	
    	
    }

    public void launch() {
        // 4. Iterate through the sparks and reset their x and y location
        //    to their original starting point.

    	for (int i = 0; i < sparks.length; i++) {
			sparks[i]=new Spark(1020, 700);
		}
    	
    }

    public void updateSparks() {
        // 8. Uncomment this code. See if you can understand what it is doing.

         for(int i = 0; i < sparks.length; i++) {
         
             Spark s = sparks[i];
             s.x += s.xVelocity;
             s.y += s.yVelocity;
             s.yVelocity += GRAVITY;
         
             if(s.yVelocity >= 0 && !s.fire) {
                 Random r = new Random();
                 s.xVelocity = r.nextInt(30) - 15;
                 s.yVelocity += -r.nextInt(20) - 10;
                 s.size = r.nextInt(7) + 2;
                 s.fire = true;
             }
         
             if(s.y >= FireworkDisplay.HEIGHT) {
                 s.dead = true;
             }
         }
         
         for(int i = 0; i < sparks.length; i++) {
             if(!sparks[i].dead) {
                 dead = false;
                 break;
             }
             dead = true;
         }
    }

    public void drawSparks(Graphics g) {
        // 5. Iterate through each spark
  
    	
				
    	for (int i = 0; i < sparks.length; i++) {
    		Spark s = sparks[i];
    	
    		
			g.setColor(s.color);
			g.fillOval(s.x, s.y, 5, 5);
		}
    	
        // 6. Set the color to the spark's color with g.setColor()
        // 7. Fill in an oval using the spark's x, y, and size with g.fillOval()
    }
}

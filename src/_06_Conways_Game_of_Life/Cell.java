package _06_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cell implements Drawable{
    public boolean isAlive = false;

    private int x;
    private int y;

    private int cellSize;

    Color color;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.cellSize = size;
    }

    /*
     * 10. Complete the liveOrDie method
     *     It sets isAlive to true or false based on the neighbors and 
     *     the rules of the game:
     *     
     * 
     *
     * 1. Any live cell with fewer than two live nieghbours dies, as if caused
     * by underpopulation.
     * 
     * 2. Any live cell with two or three live neighbours lives on to the next
     * generation.
     * 
     * 3. Any live cell with more than three live neighbours dies, as if by
     * overpopulation.
     * 
     * 4. Any dead cell with exactly three live neighbours becomes a live cell,
     * as if by reproduction.
     * (source: Wikipedia) 
     */
    
    public void liveOrDie(int numNeighbors) {
    	if(isAlive && numNeighbors<2) {
    		isAlive=false;
    	}
    	if(isAlive && (numNeighbors==2 || numNeighbors==3)) {
    		isAlive=true;
    	}
    	if(isAlive && numNeighbors>3) {
    		isAlive=false;
    	}
    	if(!isAlive && numNeighbors==3) {
    		isAlive=true;
    	}
    	
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // This method draws a colored square if cell is alive or
    // draws an empty square if the cell is dead
    @Override
    public void draw(Graphics g) {
        if(isAlive) {
        	
        	
        	/* //RGB
    		Random ran2 = new Random();
			int col2 = ran2.nextInt(3);
			if(col2==0) {
	            g.setColor(Color.RED);
			}else if(col2==1) {
	            g.setColor(Color.GREEN);
			}else if(col2==2) {
	            g.setColor(Color.BLUE);
			}
			g.fillRect(x, y, cellSize, cellSize);
			*/
        	
        	
        	
        	/* //CYM
    		Random ran3 = new Random();
			int col3 = ran3.nextInt(3);
			if(col3==0) {
	            g.setColor(Color.CYAN);
			}else if(col3==1) {
	            g.setColor(Color.YELLOW);
			}else if(col3==2) {
	            g.setColor(Color.MEGENTA);
			}
			g.fillRect(x, y, cellSize, cellSize);
        	*/
            
        	
        	
        	/* //RAINBOW
    		Random ran4 = new Random();
			int col4 = ran4.nextInt(6);
			if(col4==0) {
	            g.setColor(Color.RED);
			}else if(col4==1) {
	            g.setColor(Color.ORANGE);
			}else if(col4==2) {
	            g.setColor(Color.YELLOW);
			}else if(col4==3) {
	            g.setColor(Color.GREEN);
			}else if(col4==4) {
	            g.setColor(Color.BLUE);
			}else if(col4==5) {
	            g.setColor(Color.MAGENTA);
			}
			g.fillRect(x, y, cellSize, cellSize);
        	*/
        	
        	
        	
            /* //DOUBLE *broken*
            g.setColor(Color.BLUE);
            g.fillRect(x, y, cellSize, cellSize);
            g.setColor(Color.RED);
            g.fillRect(y, x, cellSize, cellSize);
			*/         
            
        	
        	
        	/* //ERROR
    		Random ran = new Random();
			int col = ran.nextInt(10);
			if(col==0) {
	            g.setColor(Color.BLUE);
			}else if(col==1) {
	            g.setColor(Color.RED);
			}else if(col==2) {
	            g.setColor(Color.ORANGE);
			}else if(col==3) {
	            g.setColor(Color.MAGENTA);
			}else if(col==4) {
	            g.setColor(Color.WHITE);
			}
			g.fillRect(x, y, cellSize, cellSize);
        	*/
            
        	
           g.setColor(color);
            g.fillRect(x, y, cellSize, cellSize);


        } else {
            
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, cellSize, cellSize);

        }
        
         //BORDERED
        g.setColor(Color.BLACK);
        g.drawRect(x, y, cellSize, cellSize);
    g.setColor(color);
        
        /* //BORDERLESS
        g.drawRect(x, y, cellSize, cellSize);
        */
        
    }
}

package _06_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
    private static final long serialVersionUID = 1L;
    private int cellsPerRow;
    private int cellSize;

    private Timer timer;

    int sha = -1;
    Color color = Color.blue;
    // 1. Create a 2D array of Cells. Do not initialize it.

    Cell[][] cellArray;


    public WorldPanel(int w, int h, int cpr) {
        setPreferredSize(new Dimension(w, h));
        addMouseListener(this);
        timer = new Timer(500, this);
        this.cellsPerRow = cpr;

        // 2. Calculate the cell size.
        cellSize = (w/cpr);
        // 3a. Initialize the cell array to the appropriate size.
        cellArray = new Cell[cellsPerRow][cellsPerRow];
        // 3b. Iterate through the array and initialize each cell.
        //    Don't forget to consider the cell's dimensions when 
        //    passing in the location.
for (int i = 0; i < cellArray.length; i++) {
	for (int j = 0; j < cellArray.length; j++) {
		cellArray[i][j] = new Cell(i*cellSize,j*cellSize,cellSize);
		}
}


    }

    public void randomizeCells() {
        // 4. Iterate through each cell and randomly set each
        //    cell's isAlive memeber to true or false
    	
    	Random a = new Random();
    	
    	for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			boolean aa = a.nextBoolean();
    			if(aa == true) {
    				cellArray[i][j].isAlive = true;
    			}else {
    				cellArray[i][j].isAlive = false;
    			}
    			
    					}
    	}
    	
        repaint();
    }

    public void clearCells() {
        // 5. Iterate through the cells and set them all to dead.
    	for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			
    				cellArray[i][j].isAlive = false;
 
    					}
    	}


        repaint();
    }

    public void startAnimation() {
        timer.start();
    }

    public void stopAnimation() {
        timer.stop();
    }

    public void setAnimationDelay(int sp) {
        timer.setDelay(sp);
    }

    @Override
    public void paintComponent(Graphics g) {
        // 6. Iterate through the cells and draw them all

    	for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			
    				cellArray[i][j].draw(g);
 
    					}
    	}
    	
        // Draw the perimeter of the grid
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    // Advances world one step
    public void step() {
        // 7. iterate through cells and fill in the livingNeighbors array
        //    using the getLivingNeighbors method.
        int[][] livingNeighbors = new int[cellsPerRow][cellsPerRow];

    	for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			
    			int gln = getLivingNeighbors(cellArray,i,j);
    			livingNeighbors[i][j] = gln;
    					}
    	}
        
    	
        
        // 8. check if each cell should live or die

    	for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			
    			cellArray[i][j].liveOrDie(livingNeighbors[i][j]);
    					}
    	}
    	
        repaint();
    }

    // The method below gets the number of living neighbors around a
    // particular cell in the 2D array. A cell can have up to 8 neighbors.
    //        1   2    3
    //        4  cell  5
    //        6   7    8
    public int getLivingNeighbors(Cell[][] cells, int cellRow, int cellCol){
        int livingNeighbors = 0;
        
        if(cellRow != 0) {
            if(cells[cellRow - 1][cellCol].isAlive) livingNeighbors++;
        }
        
        if(cellRow != cellsPerRow - 1) {
            if(cells[cellRow + 1][cellCol].isAlive) livingNeighbors++;
        }
        if(cellCol != 0) {
            if(cells[cellRow][cellCol - 1].isAlive) livingNeighbors++;
        }
        if(cellCol != cellsPerRow - 1) {
            if(cells[cellRow][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != 0 && cellCol != 0) {
            if(cells[cellRow - 1][cellCol - 1].isAlive) livingNeighbors++;
        }
        if(cellRow != cellsPerRow - 1 && cellCol != cellsPerRow - 1) {
            if(cells[cellRow + 1][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != 0 && cellCol != cellsPerRow - 1) {
            if(cells[cellRow - 1][cellCol + 1].isAlive) livingNeighbors++;
        }
        if(cellRow != cellsPerRow - 1 && cellCol != 0) {
            if(cells[cellRow + 1][cellCol - 1].isAlive) livingNeighbors++;
        }
        
        return livingNeighbors;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
    public void mouseDraged (MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 9. Use e.getX() and e.getY() to get the mouse PIXEL (not cell)
        //    location that was clicked. Each cell is a square with a length of
        //    cellSize, meaning it's possible to click inside of a cell. You
        //    have to determine the cell that was clicked from the pixel
        //    location and toggle the 'isAlive' variable for that cell.
    	
    	int celx = e.getX();
    	int cely = e.getY();
    	int celcol = celx/cellSize;
    	int celrow = cely/cellSize;
    	
    	cellArray[celcol][celrow].isAlive = !cellArray[celcol][celrow].isAlive;
    	
   
    	
    	
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

	public void downright() {
		
		int[][] downright = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
						   {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
						   {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						   {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},


		};
		
		int x = this.getMousePosition().x;
		int y = this.getMousePosition().y;

		int celcol = x/cellSize;
    	int celrow = y/cellSize;    	

		
		for (int i = 0; i < 37; i++) {
    		for (int j = 0; j < 9; j++) {
    			
    			if( downright[j][i] == 0) {
    				cellArray[i+celcol][j+celrow].isAlive = false;
    			}else {
    				cellArray[i+celcol][j+celrow].isAlive = true;
    				cellArray[i+celcol][j+celrow].color = color;

    			}
    					}
    	}

		repaint();
		
	}
	
public void downleft() {
		
		int[][] downleft = {{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0},
							{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0},
							{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},


		};
		
		int x = this.getMousePosition().x;
		int y = this.getMousePosition().y;

		int celcol = x/cellSize;
    	int celrow = y/cellSize;    	

		
		for (int i = 0; i < 37; i++) {
    		for (int j = 0; j < 9; j++) {
    			
    			if( downleft[j][i] == 0) {
    				cellArray[i+celcol][j+celrow].isAlive = false;
    			}else {
    				cellArray[i+celcol][j+celrow].isAlive = true;
    			}
    					}
    	}

		repaint();
		
	}

public void upright() {
	
	int[][] upright = {{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},						
					   {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},				
					   {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},   						
					   {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},   						
					   {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					   {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},   						
					   {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},   						
					   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},   						
					   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},

	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( upright[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}

	repaint();
	
}

public void upleft() {
	
	int[][] upleft = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},				
					{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},   						
					{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0},   						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0},   						
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( upleft[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}

	repaint();
	
}

public void fillButton() {
	
	for (int i = 0; i < cellArray.length; i++) {
		for (int j = 0; j < cellArray.length; j++) {
			
				cellArray[i][j].isAlive = true;

					}
	}
	
    repaint();

}

public void a() {
	
	
	
	//int sha = JOptionPane.showOptionDialog(null, "Choose one", "Title", 0, JOptionPane.INFORMATION_MESSAGE, null,
			//new String[] { "3", "2", "1",}, null);
	
    //int sha = new Random().nextInt(5);
	
	//sha+=1;
	
	//if(sha >= 5) {
	//	sha=1;
	//}
	
	if(sha==0) {
	
	int[][] a = {   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}
	
	if(sha==1) {
	
	int[][] a = {   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}
	
	
	
	
	if(sha==2) {
		
	int[][] a = {   {1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1},   						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}
	
	
	
	
	if(sha==3) {
		
	int[][] a = {   {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0},						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},   						
					{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}
	
	
	
	
	if(sha==4) {
		
		int[][] a = {   {0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						


		};
		
		int x = this.getMousePosition().x;
		int y = this.getMousePosition().y;

		int celcol = x/cellSize;
		int celrow = y/cellSize;    	

		
		for (int i = 0; i < 37; i++) {
			for (int j = 0; j < 9; j++) {
				
				if( a[j][i] == 0) {
					cellArray[i+celcol][j+celrow].isAlive = false;
				}else {
					cellArray[i+celcol][j+celrow].isAlive = true;
				}
						}
		}
		repaint();
	}
	
	
	
	
	
	if(sha==5) {
		
		int[][] a = {   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						


		};
		
		int x = this.getMousePosition().x;
		int y = this.getMousePosition().y;

		int celcol = x/cellSize;
		int celrow = y/cellSize;    	

		
		for (int i = 0; i < 37; i++) {
			for (int j = 0; j < 9; j++) {
				
				if( a[j][i] == 0) {
					cellArray[i+celcol][j+celrow].isAlive = false;
				}else {
					cellArray[i+celcol][j+celrow].isAlive = true;
				}
						}
		}
		repaint();
	}
	
	
if(sha==6) {
		
		int[][] a = {   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
						{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
						{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						


		};
		
		int x = this.getMousePosition().x;
		int y = this.getMousePosition().y;

		int celcol = x/cellSize;
		int celrow = y/cellSize;    	

		
		for (int i = 0; i < 37; i++) {
			for (int j = 0; j < 9; j++) {
				
				if( a[j][i] == 0) {
					cellArray[i+celcol][j+celrow].isAlive = false;
				}else {
					cellArray[i+celcol][j+celrow].isAlive = true;
				}
						}
		}
		repaint();
	}
	

if(sha==6) {
	
	int[][] a = {   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},   						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}



if(sha==7) {
	
	int[][] a = {   {0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1},    						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}



if(sha==8) {
	
	int[][] a = {   {0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0},   						
					{0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},   						
					{0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0},      						


	};
	
	int x = this.getMousePosition().x;
	int y = this.getMousePosition().y;

	int celcol = x/cellSize;
	int celrow = y/cellSize;    	

	
	for (int i = 0; i < 37; i++) {
		for (int j = 0; j < 9; j++) {
			
			if( a[j][i] == 0) {
				cellArray[i+celcol][j+celrow].isAlive = false;
			}else {
				cellArray[i+celcol][j+celrow].isAlive = true;
			}
					}
	}
	repaint();
}



}
	
	
	
	
public void choice() {
	
	int cho = JOptionPane.showOptionDialog(null, "Choose one", "Title", 0, JOptionPane.INFORMATION_MESSAGE, null,
    new String[] { "1", "/u10133", "/u2746", "//", "||", "6", "\\u2B1F", "8", "\u2563"}, null);

	if (cho==0) {
		sha=0;}
	
	if (cho==1) {
		sha=1;}
	
	if (cho==2) {
		sha=2;}
	
	if (cho==3) {
		sha=3;}
	
	if (cho==4) {
		sha=4;}
	
	if (cho==5) {
		sha=5;}
	
	if (cho==6) {
		sha=6;}
	
	if (cho==7) {
		sha=7;}
	
	if (cho==8) {
		sha=8;}
	
	if (cho==9) {
		sha=9;}
	
}

public void colorChoice() {
	
	int cho = JOptionPane.showOptionDialog(null, "Choose one", "Title", 0, JOptionPane.INFORMATION_MESSAGE, null,
    new String[] { "BLUE", "RED", "GREEN", "", "", "", "", "", ""}, null);

	if (cho==0) {
		color = Color.blue;
		for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			cellArray[i][j].color = color;
    		}
    	}
	}
	
	if (cho==1) {
		color = Color.red;
		for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			cellArray[i][j].color = color;
    		}
    	}
	}
	
	if (cho==2) {
		color = Color.green;
		for (int i = 0; i < cellArray.length; i++) {
    		for (int j = 0; j < cellArray.length; j++) {
    			cellArray[i][j].color = color;
    		}
    	}
	}
	
//	if (cho==3) {
//		sha=3;}
//	
//	if (cho==4) {
//		sha=4;}
//	
//	if (cho==5) {
//		sha=5;}
//	
//	if (cho==6) {
//		sha=6;}
//	
//	if (cho==7) {
//		sha=7;}
//	
//	if (cho==8) {
//		sha=8;}
//	
//	if (cho==9) {
//		sha=9;}
	
}




}



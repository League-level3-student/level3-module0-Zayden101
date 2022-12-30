package _06_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Graphics;

public class Cell implements Drawable{
    public boolean isAlive = false;

    private int x;
    private int y;

    private int cellSize;


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
            g.setColor(Color.BLUE);
            g.fillRect(x, y, cellSize, cellSize);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, cellSize, cellSize);
        }
        
        // Black border around the cell
        g.setColor(Color.BLACK);
        g.drawRect(x, y, cellSize, cellSize);
    }
}

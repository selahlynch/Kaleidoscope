package kaleidoscope;

import java.awt.Color;

public class Figure {
    //public final int BALL_SIZE = 20;
    private int xPosition, yPosition;
    private int xDelta, yDelta;
    private int xLimit, yLimit;
    private String type;
    public Color color;
    public String shape;
    int size;

    public Figure(Color color, int xDelta, int yDelta, String shape, int size){
    	xPosition = 0;
    	yPosition = 0;
    	this.xDelta = xDelta;
    	this.yDelta = yDelta;
    	this.color = color;
    	this.shape = shape;
    	this.size = size;
    }
    
    
    /**
     * Sets the "walls" that the ball should bounce off from.
     * 
     * @param xLimit The position (in pixels) of the wall on the right.
     * @param yLimit The position (in pixels) of the floor.
     */
    public void setLimits(int xLimit, int yLimit) {
        this.xLimit = xLimit - size;
        this.yLimit = yLimit - size;
        xPosition = Math.min(xPosition, xLimit);
        yPosition = Math.min(yPosition, yLimit);
    }

    
    
    
    /**
     * @return The balls X position.
     */
    public int getX() {
        return xPosition;
    }

    /**
     * @return The balls Y position.
     */
    public int getY() {
        return yPosition;
    }
    
    
    
    /**
     * Tells the ball to advance one step in the direction that it is moving.
     * If it hits a wall, its direction of movement changes.
     */
    public void makeOneStep() {
        // Do the work
        xPosition += xDelta;
        if (xPosition < 0 || xPosition >= xLimit) {
            xDelta = -xDelta;
            xPosition += xDelta;
        }
        yPosition += yDelta;
        if (yPosition < 0 || yPosition >= yLimit) {
            yDelta = -yDelta;
            yPosition += yDelta;
        }
    }

    
    

}

package kaleidoscope;

import java.awt.Color;

public class Figure {
    //public final int BALL_SIZE = 20;
    private int xPosition, yPosition;
    private int xDelta, yDelta;
    private int xLimit, yLimit;
    private String type;
    public Color shapeColor;
    public String shape;
    int size;

    public Figure(Color shapeColor, int xDelta, int yDelta, String shape, int size){
    	xPosition = 0;
    	yPosition = 0;
    	this.xDelta = xDelta;
    	this.yDelta = yDelta;
    	this.shapeColor = shapeColor;
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
    
    public void speedUp(){
    	xDelta = xDelta + 1*(Math.abs(xDelta)/xDelta);
    	yDelta = yDelta + 1*(Math.abs(yDelta)/yDelta);
    }
    
    public void slowDown(){
    	xDelta = (Math.abs(xDelta) <= 1) ? xDelta : xDelta - 1*(Math.abs(xDelta)/xDelta);
    	yDelta = (Math.abs(yDelta) <= 1) ? yDelta : yDelta - 1*(Math.abs(yDelta)/yDelta);
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

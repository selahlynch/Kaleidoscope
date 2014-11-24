package kaleidoscope;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is the Model class for a bouncing ball. It is an Observable,
 * which means that it can notifyObservers that something in the
 * model has changed, and they should take appropriate actions.
 * 
 * @author David Matuszek
 * @author <Your name goes here>
 * @author <Your name goes here>
 */
public class Model extends Observable {
    private int xLimit, yLimit;
    private Timer timer;
    ArrayList<Figure> figures;
    
    //constructor
    public Model(){
    	figures = new ArrayList<Figure>(); 
    	figures.add(new Figure(Color.RED, 3, 2));
    	figures.add(new Figure(Color.GREEN, 2, 3));
    }

       
    
    /**
     * Sets the "walls" that the ball should bounce off from.
     * 
     * @param xLimit The position (in pixels) of the wall on the right.
     * @param yLimit The position (in pixels) of the floor.
     */
    public void resizeWindow(int xLimit, int yLimit) {
    	this.xLimit = xLimit;
    	this.yLimit = yLimit;
        for(int i=0; i<figures.size(); i++){
        	figures.get(i).setLimits(xLimit, yLimit);
        }
    }

    
    /**
     * Tells the ball to start moving. This is done by starting a Timer
     * that periodically executes a TimerTask. The TimerTask then tells
     * the ball to make one "step."
     */
    public void start() {
        timer = new Timer(true);
        timer.schedule(new Strobe(), 0, 40); // 25 times a second        
    }
    
    /**
     * Tells the ball to stop where it is.
     */
    public void pause() {
        timer.cancel();
    }
    
    /**
     * Tells the model to advance one "step."
     */
    private class Strobe extends TimerTask {
        @Override
        public void run() {
            for(int i=0; i<figures.size(); i++){
            	figures.get(i).makeOneStep();
            }            
            // Notify observers
            setChanged();
            notifyObservers();

        }
    }
}
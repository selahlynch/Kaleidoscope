package kaleidoscope;

public class Point {
	private int[] JPanelCoords;
	private int height;
	private int width;
	
	public Point(int xVal, int yVal, int heightVal, int widthVal){
		JPanelCoords = new int[2];
		JPanelCoords[0] = xVal;
		JPanelCoords[1] = yVal;
		height = heightVal;
		width = widthVal;
	}

	public Point(int[] coords, int heightVal, int widthVal){
		JPanelCoords = coords;
		height = heightVal;
		width = widthVal;
	}
	
	public int getX(){
		return JPanelCoords[0];
	}

	public int getY(){
		return JPanelCoords[1];
	}

	public int[] getCoords(){
		return JPanelCoords;
	}

	private int[] JPanelToCentered(int[] coords){
		int x = coords[0] - height/2;
		int y = coords[1] - width/2;
		int[] newCoords = {x, y};
		return newCoords;
	}
	
	private int[] CenteredToJPanel(int[] coords){
		int x = coords[0] + height/2;
		int y = coords[1] + width/2;
		int[] newCoords = {x, y};
		return newCoords;
	}

	public Point getReflection(boolean swap, boolean negateX, boolean negateY){
		int[] centeredCoords = JPanelToCentered(JPanelCoords);
		int new_x_centered = centeredCoords[0];
		int new_y_centered = centeredCoords[1];
		if(negateX) new_x_centered = new_x_centered * -1;
		if(negateY) new_y_centered = new_y_centered * -1;
		if(swap){
			int temp = new_x_centered;
			new_x_centered = new_y_centered;
			new_y_centered = temp;
		}
		int[] newCenteredCoords = {new_x_centered, new_y_centered};
		int[] newJPanelCoords = CenteredToJPanel(newCenteredCoords);		
		return new Point(newJPanelCoords, height, width);
	}
	
	public Point[] getReflections(){
		Point[] reflections = new Point[8];
		reflections[0] = getReflection(false, false, false);
		reflections[1] = getReflection(false, false, true);
		reflections[2] = getReflection(false, true, false);
		reflections[3] = getReflection(false, true, true);		
		reflections[4] = getReflection(true, false, false);
		reflections[5] = getReflection(true, false, true);
		reflections[6] = getReflection(true, true, false);
		reflections[7] = getReflection(true, true, true);		
		return reflections;
	}
	
	public void print(){
		System.out.printf("%f %f %f %f\n", getX(), getY(), height, width);
	}	
	
    @Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)) return false;
		Point that = (Point) o ;
		if (that.getX() == getX() && that.getY() == getY())
			return true;
		else {
			return false;
		}
	}

}


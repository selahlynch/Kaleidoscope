package kaleidoscope;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PointTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPoint() {
		Point p1 = new Point(20, 15, 60, 60);
	}

	@Test
	public void testGetX() {
		Point p1 = new Point(20, 15, 60, 60);
		assertEquals(20, p1.getX(), 0);
	}

	@Test
	public void testGetY() {
		Point p1 = new Point(20, 15, 60, 60);
		assertEquals(15, p1.getY(), 0);
	}

	@Test
	public void testGetReflectionNegate() {
		Point p1 = new Point(20, 15, 60, 60);
		Point p2 = new Point(20, 45, 60, 60);		
		assertEquals(p2, p1.getReflection(false, false, true));
	}

	@Test
	public void testGetReflectionSwap() {
		Point p1 = new Point(20, 40, 60, 60);
		Point p2 = new Point(40, 20, 60, 60);		
		assertEquals(p2, p1.getReflection(true, false, false));
	}

}

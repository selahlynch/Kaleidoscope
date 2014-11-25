package kaleidoscope;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReflectorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReflector() {
		Reflector r = new Reflector(60, 60);
	}

	@Test
	public void testCenterCoords() {
		Reflector r = new Reflector(60, 60);
		int[] coords = {40, 60};
		int[] centeredCoords = {10, 30};
		assertArrayEquals(centeredCoords, r.centerCoords(coords));		
	}

	@Test
	public void testJPanelCoords() {
		Reflector r = new Reflector(60, 60);
		int[] coords = {10, 30};
		int[] JPanelCoords = {40, 60};
		assertArrayEquals(JPanelCoords, r.JPanelCoords(coords));
	}

	@Test
	public void testGet() {
		Reflector r = new Reflector(60, 60);
		int[] coords = {10, 30};
		assertArrayEquals(coords, r.get(coords, false, false, false));
		int[] rCoords = {30, 10};
		assertArrayEquals(coords, r.get(rCoords, true, false, false));
	}

	@Test
	public void testGetAll() {
		Reflector r = new Reflector(60, 60);
		int[] coords = {10, 30};
		int[] rCoords = {30, 10};
		assertArrayEquals(rCoords, r.getAll(coords)[4]);
	}

}

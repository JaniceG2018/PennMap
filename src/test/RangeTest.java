package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Coordinate;
import main.Range;

/**
 * Test the methods in the Range class
 */
public class RangeTest {

	/**
	 * Test the contains() method in the Range class
	 */
	@Test
	public void testContains() {
		Range range = new Range(new Coordinate(0, 0), new Coordinate(100, 100));
		Coordinate inRange1 = new Coordinate(0, 0);
		Coordinate inRange2 = new Coordinate(50, 50);
		Coordinate outOfRange = new Coordinate(150, 150);
		assertFalse(range.contains(null));
		assertTrue(range.contains(inRange1));
		assertTrue(range.contains(inRange2));
		assertFalse(range.contains(outOfRange));
	}
	
	/**
	 * Test the intersects() method in the Range class
	 */
	@Test
	public void testIntersects() {
		Range thisRange = new Range(new Coordinate(0, 0), new Coordinate(100, 100));
		Range intersectedRange = new Range(new Coordinate(50, 50), new Coordinate(150, 150));
		Range separateRange = new Range(new Coordinate(150, 150), new Coordinate(200, 200));
		assertFalse(thisRange.intersects(null));
		assertTrue(thisRange.intersects(intersectedRange));
		assertTrue(intersectedRange.intersects(thisRange));
		assertFalse(thisRange.intersects(separateRange));
		assertFalse(separateRange.intersects(thisRange));
	}
}
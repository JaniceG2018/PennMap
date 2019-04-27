package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Range;
import main.Coordinate;

public class RangeTest {

	@Test
	public void testContains() {
		Range range = new Range(new Coordinate(0, 0), new Coordinate(100, 100));
		Coordinate inRange = new Coordinate(50, 50);
		Coordinate outOfRange = new Coordinate(150, 150);
		assertTrue(range.contains(inRange));
		assertFalse(range.contains(outOfRange));
	}
	
	@Test
	public void testIntersects() {
		
	}
}

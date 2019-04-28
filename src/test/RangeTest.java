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
		assertFalse(range.contains(null));
		assertTrue(range.contains(inRange));
		assertFalse(range.contains(outOfRange));
	}
	
	@Test
	public void testIntersects() {
		Range thisRange = new Range(new Coordinate(0, 0), new Coordinate(100, 100));
		Range intersectedRange = new Range(new Coordinate(50, 50), new Coordinate(150, 150));
		Range separateRange = new Range(new Coordinate(150, 150), new Coordinate(200, 200));
		Range nullRange = null;
		assertFalse(thisRange.intersects(null));
		assertFalse(nullRange.intersects(thisRange));
		assertTrue(thisRange.intersects(intersectedRange));
		assertTrue(intersectedRange.intersects(thisRange));
		assertFalse(thisRange.intersects(separateRange));
		assertFalse(separateRange.intersects(thisRange));
	}
}

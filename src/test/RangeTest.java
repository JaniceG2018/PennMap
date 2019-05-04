package test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Coordinate;
import main.Range;

/**
 * Test methods in the Range class
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
	
	@Test
	public void test3() {
		Range r1 = new Range(new Coordinate(0,0), new Coordinate(10,10));
		Range r2 = new Range(new Coordinate(0,0), new Coordinate(10,10));
		assertTrue(r1.equals(r2));
		System.out.println(r1.hashCode());
		r1.setBottomR(new Coordinate(5,5));
		assertEquals(new Coordinate(5,5), r1.getBottomR());
		r1.setUpperL(new Coordinate(0,1));
		assertEquals(new Coordinate(0,1), r1.getUpperL());
		assertTrue(r1.contains(new Coordinate(2,2)));
		r2.setUpperL(new Coordinate(1,1));
		assertTrue(r2.contains(new Coordinate(5,5)));
	}
	
}
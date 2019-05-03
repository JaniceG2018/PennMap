package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Coordinate;
import main.Location;

/**
 * This class tests the methods of the Location class
 * @author calchen
 *
 */
public class LocationTest {

	/**
	 * Test the hashCode() method of the Location class
	 */
	@Test
	public void testHashCode() {
		Location loc = new Location("name", "type", new Coordinate(1, 1));
		assertEquals(loc.getName().hashCode(), loc.hashCode());
	}
	
	/**
	 * Test the equals() method of the Location class
	 */
	@Test
	public void testEquals() {
		Location loc1 = new Location("name", "type", new Coordinate(1, 1));
		Location loc2 = new Location("name", "type", new Coordinate(1, 1));
		Location loc3 = new Location("name", "type1", new Coordinate(1, 1));
		Location loc4 = new Location("name", "type", new Coordinate(2, 2));
		assertFalse(loc1.equals(null));
		assertFalse(loc1.equals(new Object()));
		assertTrue(loc1.equals(loc2));
		assertTrue(loc2.equals(loc1));
		assertFalse(loc1.equals(loc3));
		assertFalse(loc3.equals(loc1));
		assertFalse(loc1.equals(loc4));
		assertFalse(loc4.equals(loc1));
	}
} // ac
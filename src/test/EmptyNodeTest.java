package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Coordinate;
import main.EmptyNode;
import main.Location;
import main.Range;

/**
 * This class tests the methods of the EmptyNode class
 * @author calchen
 *
 */
public class EmptyNodeTest {

	/**
	 * Test the search() method of the EmptyNode class
	 */
	@Test
	public void testSearch() {
		EmptyNode node = new EmptyNode();
		Location l1 = new Location("Franklin Table", "Restuarant", new Coordinate(5, 5));
		Location l2 = new Location("Levine Hall", "Department Building", new Coordinate(10, 15));
		List<Location> locs = new ArrayList<>();
		locs.add(l1);
		locs.add(l2);
		node.search("Street", new Range(new Coordinate(1.0, 1.0), new Coordinate(1.0, 1.0)), locs);
	}
	
	/**
	 * Test the isEmpty() method of the EmptyNode class
	 */
	@Test
	public void testIsEmpty() {
		EmptyNode node = new EmptyNode();
		assertTrue(node.isEmpty());
	}
} // c
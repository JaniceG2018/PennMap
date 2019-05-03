package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Coordinate;
import main.EmptyNode;
import main.InternalNode;
import main.LeafNode;
import main.Location;
import main.Range;

/**
 * This class tests the methods of the LeafNode class
 * @author calchen
 *
 */
public class LeafNodeTest {

	/**
	 * Test the search() method of the LeafNode class
	 */
	@Test
	public void testSearch() {
		Range range = new Range(new Coordinate(0,0),new Coordinate(100,100));
		LeafNode leaf = new LeafNode("name", "type", new Coordinate(1, 1), range);
		List<Location> locs = new ArrayList<>();
		leaf.search("type", range, locs);
		Location location = new Location("name", "type", new Coordinate(1,1));
		assertEquals(locs.get(0), location);

	}
	
	/**
	 * Test the split() method of the LeafNode class
	 */
	@Test
	public void testSplit() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		InternalNode exp = new InternalNode(new EmptyNode(), new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(5, 5))), new EmptyNode(), new EmptyNode());
		assertEquals(exp, node.split());
	}
	
	/**
	 * Test the isEmpty() method of the LeafNode class
	 */
	@Test
	public void testIsEmpty() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		assertFalse(node.isEmpty());
		LeafNode node2 = new LeafNode(null, "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		assertTrue(node2.isEmpty());
	}
}
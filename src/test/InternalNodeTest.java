package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.Coordinate;
import main.EmptyNode;
import main.InternalNode;
import main.LeafNode;
import main.Location;
import main.Range;

/**
 * This class tests the methods of the InternalNode class
 * @author calchen
 *
 */
public class InternalNodeTest {

	/**
	 * Test the search() method of the InternalNode class
	 */
	@Test
	public void testSearch() {
		InternalNode node = new InternalNode();
		ArrayList<Location> locs = new ArrayList<Location>();
		node.search("type", new Range(new Coordinate(0, 0), new Coordinate(10, 10)), locs);
	}
	
	/**
	 * Test the isEmpty() method of the InternalNode class
	 */
	@Test
	public void testIsEmpty() {
		InternalNode root1 = new InternalNode(new EmptyNode(), new EmptyNode(), new EmptyNode(), new EmptyNode());
		InternalNode root2 = new InternalNode(new LeafNode("name", "type", new Coordinate(1, 1),
				new Range(new Coordinate(0, 0), new Coordinate(2, 2))), new EmptyNode(), new EmptyNode(), new EmptyNode());
		assertTrue(root1.isEmpty());
		assertFalse(root2.isEmpty());
	}
} // c
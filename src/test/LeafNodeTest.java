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
 * Test methods in the LeafNode class
 * @author calchen
 *
 */
public class LeafNodeTest {

	/**
	 * Test search() method in the LeafNode class
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
	 * Test the split() method in the LeafNode class
	 */
	@Test
	public void testSplit() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		InternalNode exp = new InternalNode(new EmptyNode(), new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(5, 5))), new EmptyNode(), new EmptyNode());
		assertEquals(exp.getNorthW(), node.split().getNorthW());
		
		node = new LeafNode("name", "type", new Coordinate(9, 9), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		LeafNode exp1 = new LeafNode("name", "type", new Coordinate(9, 9), new Range(new Coordinate(5, 5), new Coordinate(10, 10)));
		assertEquals(exp1, node.split().getSouthE());
		
		node = new LeafNode("name", "type", new Coordinate(9, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		LeafNode exp2 = new LeafNode("name", "type", new Coordinate(9, 1), new Range(new Coordinate(5, 0), new Coordinate(10, 5)));
		assertEquals(exp2, node.split().getNorthE());
		
		node = new LeafNode("name", "type", new Coordinate(1, 9), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		LeafNode exp3 = new LeafNode("name", "type", new Coordinate(1, 9), new Range(new Coordinate(0, 5), new Coordinate(5, 10)));
		assertEquals(exp3, node.split().getSouthW());
	}
	
	/**
	 * Test the isEmpty() method in the Location class
	 */
	@Test
	public void testIsEmpty() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		assertFalse(node.isEmpty());
		LeafNode node2 = new LeafNode(null, "type", new Coordinate(1, 1), new Range(new Coordinate(0, 0), new Coordinate(10, 10)));
		assertTrue(node2.isEmpty());
	}
}

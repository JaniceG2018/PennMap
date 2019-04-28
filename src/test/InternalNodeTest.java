package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Coordinate;
import main.EmptyNode;
import main.InternalNode;
import main.LeafNode;
import main.Range;

public class InternalNodeTest {

	@Test
	public void testSearch() {
		
	}
	
	@Test
	public void testIsEmpty() {
		InternalNode root1 = new InternalNode(new EmptyNode(), new EmptyNode(), new EmptyNode(), new EmptyNode());
		InternalNode root2 = new InternalNode(new LeafNode("name", "type", new Coordinate(1, 1),
				new Range(new Coordinate(0, 0), new Coordinate(2, 2))), new EmptyNode(), new EmptyNode(), new EmptyNode());
		assertTrue(root1.isEmpty());
		assertFalse(root2.isEmpty());
	}
}
package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Coordinate;
import main.InternalNode;
import main.LeafNode;

public class LeafNodeTest {

	@Test
	public void testSearch() {
		//search returns void???
	}
	
	@Test
	public void testSplit() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1.0, 1.0));
		InternalNode exp = new InternalNode(new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)));
		assertEquals(exp, node.split());
	}
}
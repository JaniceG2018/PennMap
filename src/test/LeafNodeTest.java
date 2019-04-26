package test;
import java.util.ArrayList;

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
		LeafNode node = new LeafNode("name", "type", new Coordinate(1.0, 1.0), new ArrayList<LeafNode>());
		InternalNode exp = new InternalNode(new LeafNode(), new LeafNode(), new LeafNode(), new LeafNode());
		assertEquals(exp, node.split());
	}
}

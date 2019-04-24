import java.util.ArrayList;

import org.junit.Test;

/**
 * LeafNodeTest tests the methods in the LeafNode class
 * @author calchen
 *
 */
public class LeafNodeTest {

	/**
	 * test the search() method in the LeafNode class
	 */
	@Test
	public void testSearch() {
		//search returns void???
	}
	
	/**
	 * test the split() method in the LeafNode class
	 */
	@Test
	public void testSplit() {
		LeafNode node = new LeafNode("name", "type", new Coordinate(1.0, 1.0),
				new ArrayList<LeafNode>());
		InternalNode exp = new InternalNode(new LeafNode(), new LeafNode(),
				new LeafNode(), new LeafNode());
		assertEquals(exp, node.split());
	}
}

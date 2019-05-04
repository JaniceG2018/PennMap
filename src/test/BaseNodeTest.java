package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.BaseNode;
import main.Coordinate;
import main.LeafNode;
import main.Range;

/**
 * Test the methods of the BaseNode class
 * @author calchen
 *
 */
public class BaseNodeTest {

	/**
	 * Test the mathSplit() method in the BaseNode class
	 */	
	@Test
	public void testMathSplit() {
		BaseNode node = new LeafNode("name", "type", new Coordinate(10, 10), new Range(new Coordinate(0, 0), new Coordinate(100, 100)));
		Range exp = new Range(new Coordinate(0, 0), new Coordinate(50, 50));
		assertEquals(exp, BaseNode.mathSplit(node.getRange(), ((LeafNode) node).getCoord()));
	}
}
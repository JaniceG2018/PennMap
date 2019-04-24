import org.junit.Test;

public class LeafNodeTest {

	@Test
	public void testSearch() {
		
	}
	
	@Test
	public void testSplit() {
		LeafNode node = new LeafNode("", "", coord, roadTo);
		InternalNode exp = new InternalNode();
		assertEquals(exp, node.split());
	}
}

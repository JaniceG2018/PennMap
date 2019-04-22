import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuadTreeTest {

	private QuadTree tree;
	
	@Before
	public void setUp() {
		tree = new QuadTree(node);
		
	}
	
	@Test
	public void testInsert() {
		BaseNode node = new BaseNode();
		assertTrue(tree.insert(node));
	}
	
	@Test
	public void testSearch() {
		
	}
	
	@Test
	public void testSplit() {
		InternalNode exp = new InternalNode();
		asserEquals(exp, map.split());
	}
	
	@Test
	public void testEnclosingQuad() {
		Coordinate exp = new Coordinate(1, 1);
		List<Coordinate> list = new ArrayList<Coordinate>();
		assertEquals(exp, tree.enclosingQuad(list));
	}
}
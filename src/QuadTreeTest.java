import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuadTreeTest {

	private QuadTree tree;
	
	@Before
	public void setUp() {
		BaseNode root;
		tree = new QuadTree(root);
	}
	
	@Test
	public void testInsert() {
		BaseNode newNode;
		assertTrue(tree.insert(newNode));
	}
	
	@Test
	public void testSearch() {
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location());
		exp.add(new Location());
		exp.add(new Location());
		Range range = new Range(new Coordinate(1, 1), new Coordinate(1, 1));
		assertEquals(exp, tree.search("", range));
	}
	
	@Test
	public void testEnclosingQuad() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location());
		locations.add(new Location());
		locations.add(new Location());
		Coordinate exp = new Coordinate(1, 1);
		assertEquals(exp, tree.enclosingQuad(locations));
	}
}
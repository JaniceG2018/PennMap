import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PennMapTest {

	private PennMap map;
	
	@Before
	public void setUp() {
		Graph graph = new Graph();
		QuadTree tree = new QuadTree();
		Coordinate startingPt = new Coordinate();
		map = new PennMap(tree, graph, startingPt);
	}
	
	@Test
	public void testMakeQuadTree() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location());
		locations.add(new Location());
		locations.add(new Location());
		QuadTree exp = new QuadTree();
		assertEquals(exp, locations.makeQuadTree());
	}
	
	@Test
	public void testMakeGraph() {
		List<String> locNames = new ArrayList<String>();
		locNames.add("");
		locNames.add("");
		locNames.add("");
		Graph exp = new Graph();
		assertEquals(exp, locNames.makeGraph());
	}
	
	@Test
	public void testShortestPath() {
		assertEquals("", map.findShortestPath("a", "b"));
	}
	
	@Test
	public void testFindAll() {
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location());
		exp.add(new Location());
		exp.add(new Location());
		assertEquals(exp, map.findAll("", 1));
	}
	
	@Test
	public void testFindNearest() {
		Location exp = new Location();
		assertEquals(exp, map.findNearest(""));
	}
}
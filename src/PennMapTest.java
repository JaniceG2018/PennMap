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
		List<List<Object>> list = new ArrayList<ArrayList<Object>>();
		map.makeQuadTree(list);
	}
	
	@Test
	public void testMakeGraph() {
		List<List<Object>> list = new ArrayList<ArrayList<Object>>();
		map.makeGraph(list);
	}
	
	@Test
	public void testShortestPath() {
		assertEquals("", map.shortestPath("a", "b"));
	}
	
	@Test
	public void testFindAll() {
		List<String> exp = new ArrayList<String>();
		assertEquals(exp, map.findAll("", 1));
	}
	
	@Test
	public void testFindNearest() {
		assertEquals("", map.findNearest());
	}
	
	@Test
	public void testSetDestCoord() {
		Coordinate coord = new Coordinate(1, 1);
		assertEquals(exp, map.setDestCoord(1, 1));
	}
}

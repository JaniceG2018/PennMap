package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.BaseNode;
import main.LeafNode;
import main.InternalNode;
import main.Coordinate;
import main.Graph;
import main.Location;
import main.PennMap;
import main.QuadTree;
import main.Road;

public class PennMapTest {

	private PennMap pennMap;
	
	@Before
	public void setUp() {
		List<String> strs = new ArrayList<String>();
		pennMap = new PennMap(strs, new Coordinate(1.0, 1.0));
	}
	
	@Test
	public void testMakeQuadTree() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		
		BaseNode root = new InternalNode(new LeafNode(), new LeafNode(), new LeafNode(), new LeafNode());
		QuadTree exp = new QuadTree(root);
		assertEquals(exp, pennMap.makeQuadTree(locations));
	}
	
	@Test
	public void testMakeGraph() {
		//shouldn't this take more than a list of location names as we are building a
		//road network???
		List<String> locNames = new ArrayList<String>();
		locNames.add("location name");
		locNames.add("location name");
		locNames.add("location name");
		locNames.add("location name");
		
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("start", "end", "name", 1.0));
		roads.add(new Road("start", "end", "name", 1.0));
		roads.add(new Road("start", "end", "name", 1.0));
		roads.add(new Road("start", "end", "name", 1.0));
		
		Graph exp = new Graph(locations, roads);
		
		assertEquals(exp, pennMap.makeGraph(locNames));
	}
	
	@Test
	public void testShortestPath() {
		assertEquals("directions", pennMap.findShortestPath("loc1", "loc2"));
	}
	
	@Test
	public void testFindAll() {
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		exp.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		exp.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		exp.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		assertEquals(exp, pennMap.findAll("type", 1.0));
	}
	
	@Test
	public void testFindNearest() {
		Location exp = new Location("name", "type", new Coordinate(1.0, 1.0));
		assertEquals(exp, pennMap.findNearest("type"));
	}
}
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
		locations.add(new Location("Huntsman Hall", "school", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Inn at Penn", "hotel", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Van Pelt Library", "library", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Bookstore", "bookstore", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Sansom Place East", "dorm", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Starbucks", "coffee shop", new Coordinate(1.0, 1.0)));
		locations.add(new Location("International House", "dorm", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Sheraton University City", "hotel", new Coordinate(1.0, 1.0)));
		locations.add(new Location("AT&T Store", "telecom", new Coordinate(1.0, 1.0)));
		locations.add(new Location("LaTao Hot Pot", "restaurant", new Coordinate(1.0, 1.0)));
		
		BaseNode root = new InternalNode(new LeafNode(), new LeafNode(), new LeafNode(),
				new LeafNode());
		QuadTree exp = new QuadTree(root);
		assertEquals(exp, pennMap.makeQuadTree(locations));
	}
	
	@Test
	public void testMakeGraph() {
		//shouldn't this take more than a list of location names as we are building a
		//road network???
		List<String> locNames = new ArrayList<String>();
		locNames.add("Huntsman Hall");
		locNames.add("Inn at Penn");
		locNames.add("Van Pelt Library");
		locNames.add("Bookstore");
		locNames.add("Sansom Place East");
		locNames.add("Starbucks");
		locNames.add("International House");
		locNames.add("Sheraton University City");
		locNames.add("AT&T Store");
		locNames.add("LaTao Hot Pot");
		
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("Huntsman Hall", "school", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Inn at Penn", "hotel", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Van Pelt Library", "library", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Bookstore", "bookstore", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Sansom Place East", "dorm", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Starbucks", "coffee shop", new Coordinate(1.0, 1.0)));
		locations.add(new Location("International House", "dorm", new Coordinate(1.0, 1.0)));
		locations.add(new Location("Sheraton University City", "hotel", new Coordinate(1.0, 1.0)));
		locations.add(new Location("AT&T Store", "telecom", new Coordinate(1.0, 1.0)));
		locations.add(new Location("LaTao Hot Pot", "restaurant", new Coordinate(1.0, 1.0)));
		
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
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


/**
 * PennMapTest tests the methods in the PennMap class
 * @author calchen
 *
 */
public class PennMapTest {

	/**
	 * 
	 */
	private PennMap pennMap;
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		List<String> strs = new ArrayList<String>();
		pennMap = new PennMap(strs, new Coordinate(1.0, 1.0));
	}
	
	/**
	 * test the makeQuadTree() method in the PennMap class
	 */
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
	
	/**
	 * test the makeGraph() method in the PennMap class
	 */
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
		roads.add(new Road("start", "end", "38th Street", 1.0));
		roads.add(new Road("start", "end", "37th Street", 1.0));
		roads.add(new Road("start", "end", "36th Street", 1.0));
		roads.add(new Road("start", "end", "34th Street", 1.0));
		roads.add(new Road("start", "end", "Ludlow Street", 1.0));
		roads.add(new Road("start", "end", "Chestnut Street", 1.0));
		roads.add(new Road("start", "end", "Walnut Street", 1.0));
		roads.add(new Road("start", "end", "Locust Walk", 1.0));
		
		Graph exp = new Graph(locations, roads);
		
		assertEquals(exp, pennMap.makeGraph(locNames));
	}
	
	/**
	 * test the shortestPath() method in the PennMap class
	 */
	@Test
	public void testShortestPath() {
		assertEquals("directions", pennMap.findShortestPath("Huntsman Hall", "Sheraton University City"));
	}
	
	/**
	 * test the findAll() method in the PennMap class
	 */
	@Test
	public void testFindAll() {
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location("Inn at Penn", "hotel", new Coordinate(1.0, 1.0)));
		exp.add(new Location("Sheraton University City", "hotel", new Coordinate(1.0, 1.0)));
		assertEquals(exp, pennMap.findAll("type", 1.0));
	}
	
	/**
	 * test the findNearest() method in the PennMap class
	 */
	@Test
	public void testFindNearest() {
		Location exp = new Location("Inn at Penn", "hotel", new Coordinate(1.0, 1.0));
		assertEquals(exp, pennMap.findNearest("hotel"));
	}
}
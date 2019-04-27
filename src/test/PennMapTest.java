package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
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

		List<String> initData = new ArrayList<String>();
		String[] arr= {"(0,0), Fine Wine and Good Spirit, Store, (20,10), Pottruck Fitness Center, School, Spring St",
				"(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St",
				"(0,0), Fine Wine and Good Spirit, Store, (0,50), (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D",
				"(20,0), WaWa@Chestnut, Restaurant, (25,0), Ochatto, Restaurant, Chestnut St-E",
				"(25,0), Ochatto, Restaurant, (30,0), Spicy Now, Restaurant, Chestnut St-F",
				"(0,0), Fine Wine and Good Spirit, Store, (10,50), John Huntsman Hall, School, 40th St",
				"(0,0), Fine Wine and Good Spirit, Store, (20,50), Graduate Center, School, Winter St",
				"(20,20), Pottruck Fitness Center, School, (20,50), Graduate Center, School, Summer St"};
				Collections.addAll(initData, arr);
		
		pennMap = new PennMap(initData, new Coordinate(1.0, 1.0));

	}
	
	@Test
	public void testMakeQuadTree() {
//		List<Location> locations = new ArrayList<Location>();
//		locations.add(new Location("Starbucks", "type", new Coordinate(1.0, 1.0)));
//		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
//		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
//		locations.add(new Location("name", "type", new Coordinate(1.0, 1.0)));
		
		BaseNode root = new InternalNode(new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)),
				new LeafNode("name", "type", new Coordinate(1.0, 1.0)));
		QuadTree exp = new QuadTree(root);
		assertEquals(exp, pennMap.makeQuadTree(pennMap.getLocationList()));
	}
	
	@Test
	public void testMakeGraph() {

		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("Fine Wine and Good Spirit", "Store", new Coordinate(0, 0)));
		locations.add(new Location("Pottruck Fitness Center", "School", new Coordinate(20, 10)));
		locations.add(new Location("AT&T", "Store", new Coordinate(0, 50)));
		locations.add(new Location("WaWa@Chestnut", "Restaurant", new Coordinate(20, 0)));
		locations.add(new Location("Ochatto", "Restaurant", new Coordinate(25, 0)));
		locations.add(new Location("John Huntsman Hall", "School", new Coordinate(10, 50)));
		locations.add(new Location("Graduate Center", "School", new Coordinate(20, 50)));
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("Fine Wine and Good Spirit", "Pottruck Fitness Center", "Spring St", 1.0));
		roads.add(new Road("Fine Wine and Good Spirit", "AT&T", "41th St",1.0));
		roads.add(new Road("Fine Wine and Good Spirit", "WaWa@Chestnut", "Chestnut St-D", 1.0));
		roads.add(new Road("WaWa@Chestnut", "Ochatto", "Chestnut St-E", 1.0));
		roads.add(new Road("Ochatto", "Spicy Now", "Chestnut St-F", 1.0));
		roads.add(new Road("Fine Wine and Good Spirit", "John Huntsman Hall", "40th St", 1.0));
		roads.add(new Road("Fine Wine and Good Spirit", "Graduate Center, School", "Winter St", 1.0));
		roads.add(new Road("Pottruck Fitness Center", "Graduate Center, School", "Summer St", 1.0));

		
		Graph exp = new Graph(locations, roads);
		
		assertEquals(exp, pennMap.makeGraph());
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

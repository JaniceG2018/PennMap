package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Coordinate;
import main.Graph;
import main.Location;
import main.PennMap;
import main.Road;

/**
 * 
 * @author calchen, jingwen qiang
 *
 */
public class PennMapTest {

	private PennMap pennMap;
	private List<String> initData;
	
	@Before
	public void setUp() {
		initData = new ArrayList<String>();
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (20,10), Pottruck Fitness Center, School, Spring St",
				"(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St",
				"(0,0), Fine Wine and Good Spirit, Store, (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D",
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
	public void testFindShortestPath() {
		assertEquals("Fine Wine and Good Spirit -> road 41th st -> AT&T", pennMap.findShortestPath("Fine Wine and Good Spirit", "AT&T"));
		assertEquals("Fine Wine and Good Spirit -> road Chestnut St-D -> WaWa@Chestnut -> road Chest", pennMap.findShortestPath("Fine Wine and Good Spirit", "Ochatto"));
	}
	
	@Test
	public void testFindAll() {
		List<Location> expNull = new ArrayList<Location>();
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location("Starbucks", "Restaurant", new Coordinate(60, 50)));
		exp.add(new Location("Honey Grow", "Restaurant", new Coordinate(30, 50)));
		assertEquals(expNull, pennMap.findAll("Restaurant", 1.0));
		assertEquals(exp, pennMap.findAll("Restaurant", 21));
	}
	
	@Test
	public void testFindNearest() {
		Location exp = new Location("Starbucks", "Restaurant", new Coordinate(60, 50));
		assertEquals(exp, pennMap.findNearest("Restaurant"));
	}
}
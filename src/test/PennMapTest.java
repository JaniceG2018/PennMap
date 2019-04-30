package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import main.Coordinate;
import main.Graph;
import main.Location;
import main.PennMap;
import main.QuadTree;
import main.Road;

/**
 * 
 * @author calchen, jingwen qiang, Jiaying Guo
 *
 */
public class PennMapTest {

	private PennMap pennMap;
	private List<String> initData;
	
	@Before
	public void setUp() {
		initData = new ArrayList<String>();
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (10,20), Pottruck Fitness Center, School, Spring St, 25",
	               "(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St, 50",
	               "(0,0), Fine Wine and Good Spirit, Store, (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D, 20",
	               "(20,0), WaWa@Chestnut, Restaurant, (25,0), Ochatto, Restaurant, Chestnut St-E, 5",
	               "(25,0), Ochatto, Restaurant, (30,0), Spicy Now, Restaurant, Chestnut St-F, 5",
	               "(0,0), Fine Wine and Good Spirit, Store, (10,50), John Huntsman Hall, School, 40th St, 70",
	               "(0,0), Fine Wine and Good Spirit, Store, (20,50), Graduate Center, School, Winter St, 85",
	               "(10,20), Pottruck Fitness Center, School, (20,50), Graduate Center, School, Summer St, 70",};
		Collections.addAll(initData, arr);
		pennMap = new PennMap(initData, new Coordinate(10, 20));
	}
	
	/**
	 * test constructor and parser
	 */
	@Test
	public void testConstructor() {
		assertEquals("Fine Wine and Good Spirit",pennMap.getLocationList().get(0).getName());
		
	}
	
	/**
	 * test make quadtree method
	 */
	@Test
	public void testMakeQuadTree() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("Fine Wine and Good Spirit", "Store", new Coordinate(0, 0)));
		locations.add(new Location("Pottruck Fitness Center", "School", new Coordinate(10, 20)));
		locations.add(new Location("AT&T", "Store", new Coordinate(0, 50)));
		locations.add(new Location("WaWa@Chestnut", "Restaurant", new Coordinate(20, 0)));
		locations.add(new Location("Ochatto", "Restaurant", new Coordinate(25, 0)));
		locations.add(new Location("John Huntsman Hall", "School", new Coordinate(10, 50)));
		locations.add(new Location("Graduate Center", "School", new Coordinate(20, 50)));
		
		QuadTree tree = (QuadTree)pennMap.makeQuadTree();
		assertEquals(8,tree.getSize());
	}
	
	/**
	 * 
	 */
	@Test
	public void testMakeGraph() {
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("Fine Wine and Good Spirit", "Pottruck Fitness Center", "Spring St", 25));
		roads.add(new Road("Fine Wine and Good Spirit", "AT&T", "41th St",50));
		roads.add(new Road("Fine Wine and Good Spirit", "WaWa@Chestnut", "Chestnut St-D", 20));
		roads.add(new Road("WaWa@Chestnut", "Ochatto", "Chestnut St-E", 5));
		roads.add(new Road("Ochatto", "Spicy Now", "Chestnut St-F",5));
		roads.add(new Road("Fine Wine and Good Spirit", "John Huntsman Hall", "40th St", 70));
		roads.add(new Road("Fine Wine and Good Spirit", "Graduate Center, School", "Winter St", 85));
		roads.add(new Road("Pottruck Fitness Center", "Graduate Center, School", "Summer St", 70));


		Graph g=(Graph) pennMap.makeGraph();
		assertEquals(roads.get(4).getRdName(),g.getRoad("Ochatto").get(0).getRdName());
		assertEquals(roads.get(0).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(0).getRdName());
		assertEquals(roads.get(1).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(1).getRdName());
		assertEquals(roads.get(2).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(2).getRdName());
		assertEquals(roads.get(5).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(3).getRdName());
		assertEquals(roads.get(6).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(4).getRdName());
		
	}
	
	@Test
	public void testFindShortestPath() {
		
		//System.out.println(pennMap.findShortestPath("Fine Wine and Good Spirit", "AT&T"));
		//assertEquals("Fine Wine and Good Spirit -> road 41th st -> AT&T", pennMap.findShortestPath("Fine Wine and Good Spirit", "AT&T"));
		assertEquals("Fine Wine and Good Spirit -> road 41th St -> AT&T", pennMap.findShortestPath("Fine Wine and Good Spirit", "AT&T"));
	}
	
	@Test
	public void testFindAll() {
		
//		List<Location> expNull = new ArrayList<Location>();

		List<Location> exp = new ArrayList<Location>();
		
//		assertEquals(expNull, pennMap.findAll("Restaurant", 1.0));
		System.out.println("!!!"+pennMap.findAll("Restaurant", 10));
		assertEquals(exp, pennMap.findAll("Restaurant", 10));
	}
	
	@Test
	public void testFindNearest() {
		
//		Location exp = new Location("Starbucks", "Restaurant", new Coordinate(60, 50));
		Location res = pennMap.findNearest("Restaurant");
		assertEquals(null, res);
		System.out.println(res == null);
		
		//assertEquals(exp.getName(), pennMap.findNearest("Restaurant").getName());
	}
}
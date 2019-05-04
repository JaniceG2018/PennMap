package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Coordinate;
import main.Graph;
import main.Location;
import main.PennMap;
import main.QuadTree;
import main.Road;

/**
 * Test the methods in the PennMap class
 * @author calchen, jingwen qiang, Jiaying Guo
 *
 */
public class PennMapTest {

	/**
	 * The PennMap object
	 */
	private PennMap pennMap;
	
	/**
	 * 
	 */
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
	               "(10,20), Pottruck Fitness Center, School, (20,50), Graduate Center, School, Summer St, 70",
	               "(10,20), Pottruck Fitness Center, School, (40,20), Institute of Contemporary Art, Museum, Chestnut St-A, 60",
	               "(40,20), Institute of Contemporary Art, Museum, (60,20), White Dog Cafe, Restaurant, Chestnut St-B, 30",
	               "(60,20), White Dog Cafe, Restaurant, (80,10), Parking Lot, School, Chestnut St-C, 50",
	               "(20,50), Graduate Center, School, (30,50), Honey Grow, Restaurant, Walnut St-A, 10",
	               "(30,50), Honey Grow, Restaurant, (35,50), Annenberg School for Communication Library, School, Walnut St-B, 5",
	               "(35,50), Annenberg School for Communication Library, School, (40,50), Franklin Building, School, Walnut St-C, 5",
	               "(35,50), Annenberg School for Communication Library, School, (30,100), SteinBerg Hall, School, 38th St, 70",
	               "(40,50), Franklin Building, School, (55,50), Van Pelt Library, School, Walnut St-D, 15",
	               "(55,50), Van Pelt Library, School, (60,50), Starbucks, Restaurant, Walnut St-E, 10",
	               "(55,50), Van Pelt Library, School, (60,80), Fisher Fine Arts Library, School, 34th St-B, 40",
	               "(60,50), Starbucks, Restaurant, (60,20), White Dog Cafe, Restaurant, 34th St-A, 40",
	               "(60,80), Fisher Fine Arts Library, School, (60,90), Irvine Auditorm, School, 34th St-C, 15",
	               "(60,90), Irvine Auditorm, School, (60,100), Williams Hall, School, 34th St-D, 45",
	               "(60,100), Williams Hall, School, (100,100), Happy Ending Bar, Restaurant, Spruce St, 40",
	               "(80,10), Parking Lot, School, (100,100), Happy Ending Bar, Restaurant, 33th St, 100"};
		Collections.addAll(initData, arr);
		pennMap = new PennMap(initData, new Coordinate(10, 20));
	}
	
	/**
	 * Test the constructor and parser
	 */
	@Test
	public void testConstructor() {
		assertEquals("Fine Wine and Good Spirit", pennMap.getLocationList().get(0).getName());
	}
	
	/**
	 * Test make quadtree method
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
		assertEquals(21,tree.getSize());
	}
	
	/**
	 * Test the makeGraph() method in the PennMap class
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
//		assertEquals(roads.get(4).getRdName(),g.getRoad("Ochatto").get(0).getRdName());
//		assertEquals(roads.get(0).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(0).getRdName());
//		assertEquals(roads.get(1).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(1).getRdName());
//		assertEquals(roads.get(2).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(2).getRdName());
//		assertEquals(roads.get(5).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(3).getRdName());
//		assertEquals(roads.get(6).getRdName(),g.getRoad("Fine Wine and Good Spirit").get(4).getRdName());
	}
	
	/**
	 * Test the findShortestPath() method in the PennMap class
	 */
	@Test
	public void testFindShortestPath() {
		assertEquals("Fine Wine and Good Spirit -> road 41th St -> AT&T"+
				"\nTotal distance is 50", pennMap.findShortestPath("Fine Wine and Good Spirit", "AT&T"));
		
	}
	
	/**
	 * Test findAll() method in the PennMap class
	 */
	@Test
	public void testFindAll() {
//		List<Location> expNull = new ArrayList<Location>();
		List<Location> exp = new ArrayList<Location>();
//		assertEquals(expNull, pennMap.findAll("Restaurant", 1.0));
		//System.out.println("!!!"+pennMap.findAll("Restaurant", 10));
		assertEquals(exp, pennMap.findAll("Restaurant", 10));
	}
	
	/**
	 * Test findNearest() method in the PennMap class
	 */
	@Test
	public void testFindNearest() {
//		Location exp = new Location("Starbucks", "Restaurant", new Coordinate(60, 50));
		Location res = pennMap.findNearest("Restaurant");
		assertEquals("WaWa@Chestnut",res.getName());
		//System.out.println("NEAREST!!"+res.getName());
		//assertEquals(exp.getName(), pennMap.findNearest("Restaurant").getName());
	}
	
	@Test
	public void testGetterAndSetters() {
		pennMap.setLocationList(null);
		assertNull(pennMap.getLocationList());
		pennMap.setCurrentPoint(new Coordinate(0,0));
		assertEquals(new Coordinate(0,0),pennMap.getCurrentPoint());
		pennMap.setRoadList(null);
		assertNull(pennMap.getRoadList());
		pennMap.setGraph(null);
		assertNull(pennMap.getGraph());
		pennMap.setTree(null);
		assertNull(pennMap.getTree());
		PennMap p = new PennMap(new ArrayList<String>(), new Coordinate(0,0));
		

	}
}
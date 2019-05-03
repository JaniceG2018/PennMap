package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Coordinate;
import main.Graph;
import main.Location;
import main.Road;

/**
 * This class tests the methods of the Graph class
 * @author calchen
 *
 */
public class GraphTest {
	
	/**
	 * A list of Locations
	 */
	private List<Location> locs;
	
	/**
	 * The Graph
	 */
	private Graph graph;
	
	/**
	 * Initialize the Graph
	 */
	@Before
	public void setup(){
		locs = new ArrayList<Location>();
		locs.add(new Location("A", "X", new Coordinate(1.0, 1.0)));
		locs.add(new Location("B", "X", new Coordinate(2.0, 1.0)));
		locs.add(new Location("C", "X", new Coordinate(3.0, 1.0)));
		locs.add(new Location("D", "X", new Coordinate(1.0, 3.0)));
		locs.add(new Location("E", "X", new Coordinate(2.0, 2.0)));
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("A", "B", "AB", 1));
		roads.add(new Road("B", "C", "BC", 1));
		roads.add(new Road("A", "E", "AE", Math.sqrt(2)));
		roads.add(new Road("A", "D", "AD", 3));
		roads.add(new Road("C", "E", "CE", Math.sqrt(2)));
		
		graph = new Graph(locs, roads);
	}

	/**
	 * Test the findShortestPath() method of the Graph class
	 */
	@Test
	public void testFindShortestPath() {
		System.out.println(graph.findShortestPath("A", "C"));
		assertEquals("A -> road AB -> B -> road BC -> C" + "\nTotal distance is 2",graph.findShortestPath("A", "C"));
		try {
			graph.findShortestPath("Z", "X");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		try {
			graph.findShortestPath("A", "X");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	/**
	 * Test the findNearest() method of the Graph class
	 */
	@Test
	public void testFindNearest() {
		List<Road> roads = new ArrayList<>();
		roads.add(new Road("B", "C", "BC", 1));
		Location location = graph.findNearest("A", "X", locs);
		assertEquals("B", location.getName());
		try {
			graph.findNearest("Z", "X", locs);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertNull(graph.findNearest("A", "Y", locs));
	}
} // ac
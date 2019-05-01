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

public class GraphTest {
	
	private Graph graph;
	private List<Location> locations;
	
	@Before
	public void setup(){
		locations = new ArrayList<Location>();
		locations.add(new Location("A", "X", new Coordinate(1.0, 1.0)));
		locations.add(new Location("B", "X", new Coordinate(2.0, 1.0)));
		locations.add(new Location("C", "X", new Coordinate(3.0, 1.0)));
		locations.add(new Location("D", "X", new Coordinate(1.0, 3.0)));
		locations.add(new Location("E", "X", new Coordinate(2.0, 2.0)));
		//locations.add(new Location("P", "X", new Coordinate(1.0, 1.0)));
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("A", "B", "AB", 1));
		roads.add(new Road("B", "C", "BC", 1));
		roads.add(new Road("A", "E", "AE", Math.sqrt(2)));
		roads.add(new Road("A", "D", "AD", 3));
		roads.add(new Road("C", "E", "CE", Math.sqrt(2)));
		
		graph = new Graph(locations, roads);
	}

	@Test
	public void testFindShortestPath() {
		System.out.println(graph.findShortestPath("A", "C"));
		assertEquals("A -> road AB -> B -> road BC -> C" + 
				"\nTotal distance is 2",graph.findShortestPath("A", "C"));
		//System.out.println(graph.findShortestPath("A", "C"));
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
	
	@Test
	public void testFindNearest() {
		List<Road> roads = new ArrayList<>();
		roads.add(new Road("B", "C", "BC", 1));

		Location location = graph.findNearest("A", "X", locations);
		assertEquals("B", location.getName());
		try {
			graph.findNearest("Z", "X", locations);
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertNull(graph.findNearest("A", "Y", locations));
	}

}
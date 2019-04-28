package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
=======
import main.Road;
import main.Location;
import main.PennMap;
>>>>>>> a6bd0828f60926ae544b2233c7d25d90c51f42df
import main.Coordinate;
import main.Graph;
import main.Location;
import main.Road;

public class GraphTest {
	
	private Graph graph;
	@Before
	public void setup(){
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("A", "X", new Coordinate(1.0, 1.0)));
		locations.add(new Location("B", "X", new Coordinate(2.0, 1.0)));
		locations.add(new Location("C", "X", new Coordinate(3.0, 1.0)));
		locations.add(new Location("D", "X", new Coordinate(1.0, 3.0)));
		locations.add(new Location("E", "X", new Coordinate(2.0, 2.0)));
		locations.add(new Location("P", "X", new Coordinate(1.0, 1.0)));
		
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

		assertEquals("A -> road AB -> B -> road BC -> C",graph.findShortestPath("A", "C"));
	}
}
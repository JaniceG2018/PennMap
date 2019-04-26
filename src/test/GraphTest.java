package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Road;
import main.Location;
import main.Coordinate;
import main.Graph;

public class GraphTest {

	@Test
	public void testFindShortestPath() {
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
		
		Graph graph = new Graph(locations, roads);
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
	}
}
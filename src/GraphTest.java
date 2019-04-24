import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testFindShortestPath() {
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
		
		Graph graph = new Graph(locations, roads);
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
		assertEquals("directions", graph.findShortestPath("loc1", "loc2"));
	}
}
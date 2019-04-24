import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testFindShortestPath() {
		List<Location> locations;
		List<Road> roads;
		Graph graph = new Graph(locations, roads);
		assertEquals("", graph.findShortestPath());
	}
}
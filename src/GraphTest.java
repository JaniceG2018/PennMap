import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testAdd() {
		List<List<Object>> list = new ArrayList<ArrayList<Object>>();
		Graph graph = new Graph(list);
		Road rd = new Road("", "", 1);
		assertTrue(graph.add("", "", rd));
	}
}
package test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import main.Coordinate;
import main.EmptyNode;
import main.Location;
import main.Range;

public class EmptyNodeTest {

	@Test
	public void testSearch() {
		EmptyNode node = new EmptyNode();
		Location l1 = new Location("Franklin Table", "Restuarant", new Coordinate(5,5));
		Location l2 = new Location("Levine Hall", "Department Building", new Coordinate(10,15));
		List<Location> locs = new ArrayList<>();
		locs.add(l1);
		locs.add(l2);
		assertNull(node.search("Street", new Coordinate(0.0, 50.0), locs));
	}
}
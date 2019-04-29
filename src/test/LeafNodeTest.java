package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Coordinate;
import main.LeafNode;
import main.Location;
import main.Range;

public class LeafNodeTest {

	@Test
	public void testSearch() {
		Range range = new Range(new Coordinate(0,0),new Coordinate(100,100));
		LeafNode leaf = new LeafNode("name", "type", new Coordinate(1, 1), range);
		List<Location> locs = new ArrayList<>();
		leaf.search("type", range, locs);
		Location location = new Location("name", "type", new Coordinate(1,1));
		assertEquals(locs.get(0), location);

	}
	
	@Test
	public void testSplit() {

	}
	
	@Test
	public void testIsEmpty() {

	}
}
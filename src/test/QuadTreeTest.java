package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Coordinate;
import main.Location;
import main.QuadTree;
import main.Range;

public class QuadTreeTest {

	private QuadTree tree;
	
	@Before
	public void setUp() {
		tree = new QuadTree();
	}
	
	@Test
	public void testInsert() {
		assertFalse(tree.insert(null));
		Location loc1 = new Location("Fine Wine and Good Spirit", "Store", new Coordinate(0, 0));
		assertTrue(tree.insert(loc1));
		Location loc2 = new Location("WaWa@Chestnut", "Restaurant", new Coordinate(20, 0));
		assertTrue(tree.insert(loc2));
	}
	
	@Test
	public void testSearch() {
		Range range = new Range(new Coordinate(0, 0), new Coordinate(100, 100));
		List<Location> exp = new ArrayList<Location>();
		exp.add(new Location("Fine Wine and Good Spirit", "Store", new Coordinate(0, 0)));
		assertEquals(exp, tree.search("Store", range));
	}
	
	@Test
	public void testEnclosingQuad() {
		List<Location> locs = new ArrayList<Location>();
		locs.add(new Location("Fine Wine and Good Spirit", "Store", new Coordinate(0, 0)));
		locs.add(new Location("WaWa@Chestnut", "Restaurant", new Coordinate(20, 0)));		
		Range exp = new Range(new Coordinate(0, 0), new Coordinate(20, 0));
		assertEquals(exp, tree.enclosingQuad(locs));
	}
}
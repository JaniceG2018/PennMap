package main;

import java.util.List;

/**
 * This class models an empty node in our QuadTree containing no Location
 * @author calchen
 *
 */
public class EmptyNode extends BaseNode {

	/**
	 * Empty constructor of this class, which initializes the Range of this node
	 */
	public EmptyNode() {
		range.setUpperL(new Coordinate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
		range.setBottomR(new Coordinate(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
	}

	/**
	 * search() does nothing for an EmptyNode
	 * @param type   type of Locations (e.g. "Restaurant")
	 * @param range  search Range
	 * @param locs   search results
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		return;
	}

	/**
	 * isEmpty() checks if this node is empty
	 * @return true if this node is empty (always)
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}
} // ac
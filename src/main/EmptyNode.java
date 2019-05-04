package main;

import java.util.List;

/**
 * EmptyNode models an empty node in the QuadTree
 * @author calchen
 *
 */
public class EmptyNode extends BaseNode {

	/**
	 * Empty constructor of this class, which initializes the Range of this EmptyNode to default values
	 */
	public EmptyNode() {
		range.setUpperL(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
		range.setBottomR(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
	}

	/**
	 * Do nothing for an EmptyNode
	 * @param type   the type of Locations
	 * @param range  the search Range
	 * @param locs   a list of Locations containing the search results
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		
	}

	/**
	 * Check if this EmptyNode is empty
	 * @return true if this EmptyNode is empty (always)
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}
}
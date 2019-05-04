package main;

import java.util.List;

/**
 * EmptyNode models an empty node in the QuadTree
 * @author calchen
 *
 */
public class EmptyNode extends BaseNode {

	/**
	 * Empty constructor of the EmptyNode class, which initializes the EmptyNode with range outside of the map's range
	 */
	public EmptyNode() {
		range.setUpperL(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
		range.setBottomR(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
	}

	/**
	 * Do nothing for an EmptyNode
	 * @param type
	 * @param range
	 * @param locs
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		
	}

	/**
	 * isEmpty() returns true if a node is empty
	 * @return true if this node is empty (always)
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}
}
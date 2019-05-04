package main;

import java.util.List;

/**
 * This class models a generic node in the QuadTree
 * @author calchen Jiaying Guo
 *
 */
public abstract class BaseNode {
	
	/**
	 * The Range this node covers
	 */
	protected Range range;
	
	/**
	 * Empty constructor of this class, which initializes the Range of this node to default value
	 */
	public BaseNode() {
		this.range = new Range();
	}
	
	/**
	 * Copy constructor of this class, which initializes the Range of this node to a given Range
	 * @param range
	 */
	public BaseNode(Range range) {
		this.range = range;
	}
	
	/**
	 * Getter for the Range
	 * @return the Range of this node
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * Setter for the Range
	 * @param range the new Range of this node
	 */
	public void setRange(Range range) {
		this.range = range;
	}
	
	/**
	 * Find all Locations of a given type within a given Range and modify the parameter locs to include all search results
	 * @param type   the type of the given Locations (e.g. "Restaurant")
	 * @param range  the Range of the given Locations
	 * @param locs   the search results
	 */
	public abstract void search(String type, Range range, List<Location> locs);
	
	/**
	 * Check if this node is empty
	 * @return true if this node is empty, or false otherwise
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Calculate which direction of the range is the given coordinate in
	 * @param range  the Range to split
	 * @param coord  the Coordinate within range
	 * @return the sub-Range where coord belongs (NE, NW, SE, SW)
	 */
	public static Range mathSplit(Range range, Coordinate coord) {
		Coordinate UL = range.getUpperL();
		Coordinate BR = range.getBottomR();
		double halfWidth = (BR.getLon() - UL.getLon()) / 2;
		double halfHeight = (BR.getLat() - UL.getLat()) / 2;
		
		// NW:
		double Rx1 = (UL.getLon() + BR.getLon()) / 2;
		double Ry1 = (UL.getLat() + BR.getLat()) / 2;
		Coordinate R1 = new Coordinate(Rx1, Ry1);
		double Lx1 = UL.getLon();
		double Ly1 = UL.getLat();
		Coordinate L1 = new Coordinate(Lx1, Ly1);
		Range r1 = new Range(L1, R1);
			
		// NE:
		double Lx2 = UL.getLon() + halfWidth;
		double Ly2 = UL.getLat();
		Coordinate L2 = new Coordinate(Lx2, Ly2);
		double Rx2 = BR.getLon();
		double Ry2 = BR.getLat() - halfHeight;
		Coordinate R2 = new Coordinate(Rx2, Ry2);
		Range r2 = new Range(L2, R2);

		// SW:
		double Lx3 = UL.getLon();  
		double Ly3 = UL.getLat() + halfHeight;
		Coordinate L3 = new Coordinate(Lx3, Ly3);
		double Rx3 = BR.getLon() - halfWidth;
		double Ry3 = BR.getLat();
		Coordinate R3 = new Coordinate(Rx3, Ry3);
		Range r3 = new Range(L3, R3);
			
		// SE:
		double Lx4 = (UL.getLon() + BR.getLon()) / 2;
		double Ly4 = (UL.getLat() + BR.getLat()) / 2;
		Coordinate L4 = new Coordinate(Lx4, Ly4);
		double Rx4 = BR.getLon();
		double Ry4 = BR.getLat();
		Coordinate R4 = new Coordinate(Rx4, Ry4);
		Range r4 = new Range(L4, R4);
			
		if (r1.contains(coord))
			return r1;
		else if (r2.contains(coord))
			return r2;
		else if (r3.contains(coord))
			return r3;
		else
			return r4;
	}
}
package main;

/**
 * the Range class models a range on the map
 * @author calchen
 *
 */
public class Range {
	
	/**
	 * the upper-left Coordinate of the Range
	 */
	private Coordinate upperL;
	
	/**
	 * the bottom-right Coordinate of the Range
	 */
	private Coordinate bottomR;
	
	/**
	 * 
	 */
	public Range() {
		this.upperL = new Coordinate();
		this.bottomR = new Coordinate();
	}
	
	/**
	 * constructor for the Range: initializes the upper-left and bottom-right Coordinates of the Range
	 * @param upperL the upper-left Coordinate of the Range
	 * @param bottomR the bottom-right Coordinate of the Range
	 */
	public Range(Coordinate upperL, Coordinate bottomR) {
		this.upperL = upperL;
		this.bottomR = bottomR;
	}
	
	/**
	 * @return the upper-left Coordinate of the Range
	 */
	public Coordinate getUpperL() {
		return upperL;
	}

	/**
	 * @param upperL the new upper-left Coordinate of the Range
	 */
	public void setUpperL(Coordinate upperL) {
		this.upperL = upperL;
	}

	/**
	 * @return the bottom-right Coordinate of the Range
	 */
	public Coordinate getBottomR() {
		return bottomR;
	}

	/**
	 * @param bottomR the new bottom-right Coordinate of the Range
	 */
	public void setBottomR(Coordinate bottomR) {
		this.bottomR = bottomR;
	}
	
	/**
	 * check if the given coordinate is contained in this range
	 * @param a coordinate
	 * @param if this range includes the given coordinate, true if this range includes the given coordinate, vice versa
	 */
	public boolean contains(Coordinate coord) {
		if (coord == null)
			return false;
		double minX = upperL.getLon();
		double minY = upperL.getLat();
		double maxX = bottomR.getLon();
		double maxY = bottomR.getLat();
		double lat = coord.getLat();
		double lon = coord.getLon();
		if (lat <= maxY && lat >= minY && lon <= maxX && lon >= minX)
			return true;
		else
			return false;
	}
	
	/**
	 * check if the given range is intersected with this range
	 * @param a range
	 * @param a boolean value, true if this range intersects with the given range, vice versa
	 */
	public boolean intersects(Range otherRange) {
		if (otherRange == null)
			return false;
		Coordinate UL = otherRange.upperL;
		Coordinate BR = otherRange.bottomR;
		Coordinate BL = new Coordinate(UL.getLon(), BR.getLat());
		Coordinate UR = new Coordinate(BR.getLon(), UL.getLat());
		return contains(UL) || contains(BR) || contains(UR) || contains(BL);
	}
}
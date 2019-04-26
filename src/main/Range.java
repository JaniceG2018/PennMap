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
}
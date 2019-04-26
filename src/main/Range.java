package main;

/**
 * 
 * @author calchen
 *
 */
public class Range {
	
	/**
	 * 
	 */
	private Coordinate upperL;
	
	/**
	 * 
	 */
	private Coordinate bottomR;
	
	/**
	 * 
	 * @param upperL
	 * @param bottomR
	 */
	public Range(Coordinate upperL, Coordinate bottomR) {
		this.upperL = upperL;
		this.bottomR = bottomR;
	}

	/**
	 * @return the upperL
	 */
	public Coordinate getUpperL() {
		return upperL;
	}

	/**
	 * @param upperL the upperL to set
	 */
	public void setUpperL(Coordinate upperL) {
		this.upperL = upperL;
	}

	/**
	 * @return the bottomR
	 */
	public Coordinate getBottomR() {
		return bottomR;
	}

	/**
	 * @param bottomR the bottomR to set
	 */
	public void setBottomR(Coordinate bottomR) {
		this.bottomR = bottomR;
	}
}
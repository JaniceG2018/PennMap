package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public abstract class BaseNode {
	
	/**
	 * 
	 */
	protected Range range;
	
	/**
	 * empty constructor for this class
	 */
	public BaseNode() {
		setRange(new Range(null, null));
	}
	
	/**
	 * copy constructor for this class, initialize the Range with a given Range
	 * @param range
	 */
	public BaseNode(Range range) {
		this.setRange(range);
	}
	
	/**
	 * 
	 * @param type type of Location
	 * @param range
	 * @param locs 
	 */
	public abstract void search(String type, Range range, List<Location> locs);
	
	/**
	 * @return the Range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * @param range the new Range
	 */
	public void setRange(Range range) {
		this.range = range;
	}
}
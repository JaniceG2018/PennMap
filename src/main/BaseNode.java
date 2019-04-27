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
	private Range range;
	
	/**
	 * 
	 */
	public BaseNode() {
		setRange(new Range(null, null));
	}
	
	/**
	 * 
	 * @param range
	 */
	public BaseNode(Range range) {
		this.setRange(range);
	}
	
	/**
	 * 
	 * @param type type of location
	 * @param range
	 * @param locs
	 */
	public abstract void search(String type, Range range, List<Location> locs);
	
	
	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}
}
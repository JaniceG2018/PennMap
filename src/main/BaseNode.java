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
		range = new Range(null, null);
	}
	
	/**
	 * 
	 * @param range
	 */
	public BaseNode(Range range) {
		this.range = range;
	}
	
	/**
	 * 
	 * @param type type of location
	 * @param range
	 * @param locs
	 */
	public abstract void search(String type, Range range, List<Location> locs);
}
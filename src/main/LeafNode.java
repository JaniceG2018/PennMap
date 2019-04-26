package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class LeafNode extends BaseNode {

	/**
	 * name of the location
	 */
	private String name;
	
	/**
	 * type of location
	 */
	private String type;
	
	/**
	 * coordinate of the location
	 */
	private Coordinate coord;
	
	/**
	 * other locations this connects to via road(s)
	 */
	private List<LeafNode> roadTo;
	
	/**
	 * 
	 * @param name name of the location
	 * @param type type of location
	 * @param coord coordinate of the location
	 * @param roadTo other locations this connects to via road(s)
	 */
	public LeafNode(String name, String type, Coordinate coord, List<LeafNode> roadTo) {
		this.name = name;
		this.type = type;
		this.coord = coord;
		this.roadTo = roadTo;
	}

	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		
	}
	
	/**
	 *
	 * @return
	 */
	public InternalNode split() {
		return null;
	}
}
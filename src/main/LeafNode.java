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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	/**
	 * type of location
	 */
	private String type;
	
	/**
	 * coordinate of the location
	 */
	private Coordinate coord;
	
//	/**
//	 * other locations this connects to via road(s)
//	 */
//	private List<LeafNode> roadTo;
	
	/**
	 * 
	 * @param name name of the location
	 * @param type type of location
	 * @param coord coordinate of the location
	 * @param roadTo other locations this connects to via road(s)
	 */
	public LeafNode(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
//		this.roadTo = roadTo;
	}

	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		if (range.contains(coord) && this.type.equals(type)) {
			Location cur = new Location(this.getName(), this.getType(), this.getCoord());
			locs.add(cur);
		}
	}
	
	/**
	 *
	 * @return
	 */
	public InternalNode split() {
		return null;
	}
}
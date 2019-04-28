package main;

import java.util.List;

/**
 * The LeafNode class models a LeafNode in our QuadTree, which stores the location info
 * @author calchen
 *
 */
public class LeafNode extends BaseNode {

	/**
	 * The name of the Location
	 */
	private String name;
	
	/**
	 * The type of the Location
	 */
	private String type;
	
	/**
	 * The Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * copy constructor of this class, which initializes name, type and coord with given values
	 * @param name name of the location
	 * @param type type of location
	 * @param coord coordinate of the location
	 * @param roadTo other locations this connects to via road(s)
	 */
	public LeafNode(String name, String type, Coordinate coord, Range range) {
		this.name = name;
		this.type = type;
		this.coord = coord;
		this.range = range;
	}
	
	/**
	 * @return name of the location
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name new name of the location
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return type of location
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type new type of the location
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Coordinate of the location
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * @param coord new Coordinate of the location
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	
	/**
	 * search() searches Locations of a given type with in a given Range and modifies a parameter to include
	 * all search results
	 * @param type the type of Location we want to search
	 * @param range the search Range
	 * @param locs a list of Locations containing the search results (mofify in-place)
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		if (this.type.equals(type) && range.contains(coord)) {
			Location cur = new Location(name, type, coord);
			locs.add(cur);
		}
	}
	
	/**
	 * split() splits a LeafNode into 4 and returns the InternalNode that is the root of these 4 LeafNodes;
	 * it also transit the current contents stored in this leaf node to its children
	 * @return the InternalNode that is the root of the 4 LeafNodes after splitting
	 */
	public InternalNode split() {
		Coordinate UL = range.getUpperL();
		Coordinate BR = range.getBottomR();
		double lat = (UL.getLat() + BR.getLat()) / 2;
		double lon = (UL.getLon() + BR.getLon()) / 2;
		
		BaseNode newNode = new InternalNode(this.range);
		Range leafRange = mathSplit(this.range, this.coord);
		BaseNode leaf = new LeafNode(name, type, coord, leafRange);
		
		if (coord.getLat() < lat && coord.getLon() < lon)
			((InternalNode) newNode).setNorthW(leaf);
		else if (coord.getLat() < lat && coord.getLon() > lon)
			((InternalNode) newNode).setNorthE(leaf);
		else if (coord.getLat() > lat && coord.getLon() > lon)
			((InternalNode) newNode).setSouthE(leaf);
		else if (coord.getLat() > lat && coord.getLon() < lon)
			((InternalNode) newNode).setSouthW(leaf);
		return (InternalNode)newNode;
	}

	/**
	 * isEmpty() checks if this LeafNode is null
	 * @return true if this LeafNode is null
	 */
	@Override
	public boolean isEmpty() {
		if (name == null)
			return true;
		else
			return false;
	}
}
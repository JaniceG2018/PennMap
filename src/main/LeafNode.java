package main;

import java.util.List;

/**
 * This class models a LeafNode in our QuadTree, which stores Location info
 * @author calchen xuanwang
 *
 */
public class LeafNode extends BaseNode {

	/**
	 * The name of the Location
	 */
	private String name;
	
	/**
	 * The type of the Location (e.g. "Restaurant")
	 */
	private String type;
	
	/**
	 * The Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * Copy constructor of this class, which initializes the name, type, Coordinate and Range of this LeafNode to given values
	 * @param name   the name of the Location
	 * @param type   the type of the Location (e.g. "Restaurant")
	 * @param coord  the Coordinate of the Location
	 * @param range  the Range of this LeafNode
	 */
	public LeafNode(String name, String type, Coordinate coord, Range range) {
		this.name = name;
		this.type = type;
		this.coord = coord;
		this.range = range;
	}
	
	/**
	 * Getter for the name
	 * @return the name of the Location
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the Coordinate
	 * @return the Coordinate of the Location
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * Find all Locations of a given type within a given Range and modifies the parameter locs to include
	 * all search results.
	 * @param type   the type of Locations (e.g. "Restaurant")
	 * @param range  the search Range
	 * @param locs   a list of Locations containing the search results
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		if (this.type.equals(type) && range.contains(coord)) {
			Location cur = new Location(name, type, coord);
			locs.add(cur);
		}
	}
	
	/**
	 * Split a LeafNode into 4 LeafNodes and return the InternalNode that is the root of these 4 LeafNodes.
	 * Also copy the contents stored in the old LeafNode to the corresponding new LeafNode
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
	 * Check if this LeafNode is empty
	 * @return true if this LeafNode is empty, and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (name == null)
			return true;
		else
			return false;
	}
} // ac
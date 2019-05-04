package main;

import java.util.ArrayList;
import java.util.List;

/**
 * This class mdoels a QuadTree with a root
 * @author xuanwang calchen
 *
 */
public class QuadTree implements IQuadTree {
	
	/**
	 * A reference to an EmptyNode
	 */
	public static final BaseNode emptyNode = new EmptyNode();
	
	/**
	 * The root of the QuadTree
	 */
	private BaseNode root;
	
	/**
	 * The number of Locations stored in the QuadTree
	 */
	private int size;
	
	/**
	 * Empty constructor of the QuadTree class, which creates an empty QuadTree
	 */
	public QuadTree() {
		root = emptyNode;
	}
	
	/**
	 * Getter for the size
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter for the size
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
		
	/**
	 * Insert a new Location into the QuadTree
	 * @param loc the new Location that we want to insert
	 * @return true if loc is successfully inserted, or false otherwise
	 */
	@Override
	public boolean insert(Location loc) {
		if (loc == null)
			return false;
		Coordinate coord = loc.getCoord();
		BaseNode res;
		try {
			res = insertHelper(root, coord, loc, root.getRange());
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		root = res;
		setSize(getSize() + 1);
		return true;
	}
	
	/**
	 * Helper method for inserting
	 * @param node
	 * @param coord
	 * @param loc
	 * @param curRange
	 * @return
	 */
	private BaseNode insertHelper(BaseNode node, Coordinate coord, Location loc, Range curRange) {
		
		// 1. if node is root and this node is empty
		if (node == root && node.isEmpty()) {
			// Calculate range of the new LeafNode
			return new LeafNode(loc.getName(), loc.getType(), coord, node.getRange());
		}
		
		// 2. node is empty or empty leaf, create new leafnode and store the info of given location
		if (node instanceof EmptyNode) {
			// Calculate range of the new LeafNode
			Range leafRange = curRange;
			return new LeafNode(loc.getName(), loc.getType(), coord, leafRange);
		}
	
		// 3. if we need to add location in a quad that includes a location in it, we need to split it 
		// into an internal node and add both old and new locations to it 
		if (node instanceof LeafNode) {
			// Check Duplicate Name
			if (((LeafNode) node).getName().equals(loc.getName())) {
	            throw new IllegalStateException("Location existed!");
			}
			BaseNode newNode = ((LeafNode) node).split();
			newNode = insertHelper(newNode, coord, loc, newNode.getRange());
			return newNode;
		}

		// 4. if current node is Internal Node, then we should insert the location in its children
		Coordinate UL = curRange.getUpperL();
		Coordinate BR = curRange.getBottomR();
		// (lon, lat) is the central point of current Quad
		double lat = (UL.getLat() + BR.getLat()) / 2;
		double lon = (UL.getLon() + BR.getLon()) / 2;
		Range childrenRange = BaseNode.mathSplit(curRange, coord);
		// Decide which children to insert according to this location's coordinate
		if (coord.getLat() <= lat && coord.getLon() <= lon)
			((InternalNode) node).setNorthW(insertHelper(((InternalNode) node).getNorthW(), coord, loc, childrenRange));
		else if (coord.getLat() <= lat && coord.getLon() > lon)
			((InternalNode) node).setNorthE(insertHelper(((InternalNode) node).getNorthE(), coord, loc, childrenRange));
		else if (coord.getLat() > lat && coord.getLon() > lon)
			((InternalNode) node).setSouthE(insertHelper(((InternalNode) node).getSouthE(), coord, loc, childrenRange));
		else if (coord.getLat() > lat && coord.getLon() <= lon)
			((InternalNode) node).setSouthW(insertHelper(((InternalNode) node).getSouthW(), coord, loc, childrenRange));
		return node;
	}

	/**
	 * Find all Locations of a given type within a given Range
	 * @param type the type of Locations
	 * @param range the search Range
	 * @return all Locations of a given type within a given Range
	 */
	@Override
	public List<Location> search(String type, Range range) {
		List<Location> results = new ArrayList<>();
		root.search(type, range, results);
		return results;
	}

	/**
	 * Calculate the smallest possible Range which contains all given Locations
	 * @param locs a list of Locations that we want to include
	 * @return the smallest possible Range which contains all given Locations
	 */
	@Override
	public Range enclosingQuad(List<Location> locs) {
		Range quadRange = new Range();
		Coordinate locCoord;
		for (Location loc : locs) {
			locCoord = loc.getCoord();
			updateRange(locCoord, quadRange);
		}
		BaseNode root = new InternalNode(quadRange);
		this.root = root;
		return quadRange;
	}
	
	/**
	 * Helper method for updating current QuadTree range
	 * @param coord
	 * @param range
	 */
	private void updateRange(Coordinate coord, Range range) {
		double lon = coord.getLon();
		double lat = coord.getLat();
		Coordinate upperL = range.getUpperL();
		Coordinate bottomR = range.getBottomR();
		double minX = upperL.getLon();
		double minY = upperL.getLat();
		double maxX = bottomR.getLon();
		double maxY = bottomR.getLat();
		if (minX > lon)
			upperL.setLon(lon);
		if (maxX < lon)
			bottomR.setLon(lon);
		if (minY > lat)
			upperL.setLat(lat);
		if (maxY < lat)
			bottomR.setLat(lat);
		range.setUpperL(upperL);
		range.setBottomR(bottomR);
	}
}
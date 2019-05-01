package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xuanwang calchen
 *
 */
public class QuadTree implements IQuadTree {
	
	/**
	 * 
	 */
	public static final BaseNode emptyNode = new EmptyNode();
	
	/**
	 * the root of the QuadTree
	 */
	private BaseNode root;
	
	/**
	 * number of locations stored in the tree 
	 */
	private int size;
	
	/**
	 * Empty constructor of the QuadTree class, which creates an empty QuadTree
	 */
	public QuadTree() {
		root = emptyNode;
	}
		
	/**
	 * 
	 * @param type
	 * @param range
	 * @return 
	 */
	@Override
	public List<Location> search(String type, Range range) {
		List<Location> results = new ArrayList<>();
		root.search(type, range, results);
		return results;
	}
	
	/**
	 * 
	 * @param loc
	 */
	@Override
	public boolean insert(Location loc) {
		if (loc == null)
			return false;
		Coordinate coord = loc.getCoord();
		BaseNode res;
		try {
			res = insert(root, coord, loc, root.getRange());
		} catch (IllegalStateException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		root = res;
		setSize(getSize() + 1);
		return true;
	}
	
	/**
	 * 
	 * @param node
	 * @param coord
	 * @param loc
	 * @param curRange
	 * @return
	 */
	private BaseNode insert(BaseNode node, Coordinate coord, Location loc, Range curRange) {
		
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
	
		// 3. If we need to add location in a quad that includes a location in it, we need to split it 
		// into an internal node and add both old and new locations to it 
		if (node instanceof LeafNode) {
			// Check Duplicate Name
			if (((LeafNode) node).getName().equals(loc.getName()))
	            throw new IllegalStateException("Location existed!");
			BaseNode newNode = ((LeafNode) node).split();
			newNode = insert(newNode, coord, loc, newNode.getRange());
			return newNode;
		}

		// 4. If current node is Internal Node, then we should insert the location in its children
		Coordinate UL = curRange.getUpperL();
		Coordinate BR = curRange.getBottomR();
		// (lon, lat) is the central point of current Quad
		double lat = (UL.getLat() + BR.getLat()) / 2;
		double lon = (UL.getLon() + BR.getLon()) / 2;
		Range childrenRange = BaseNode.mathSplit(curRange, coord);
		// Decide which children to insert according to this location's coordinate
		if (coord.getLat() <= lat && coord.getLon() <= lon)
			((InternalNode) node).setNorthW(insert(((InternalNode) node).getNorthW(), coord, loc, childrenRange));
		else if (coord.getLat() <= lat && coord.getLon() > lon)
			((InternalNode) node).setNorthE(insert(((InternalNode) node).getNorthE(), coord, loc, childrenRange));
		else if (coord.getLat() > lat && coord.getLon() > lon)
			((InternalNode) node).setSouthE(insert(((InternalNode) node).getSouthE(), coord, loc, childrenRange));
		else if (coord.getLat() > lat && coord.getLon() <= lon)
			((InternalNode) node).setSouthW(insert(((InternalNode) node).getSouthW(), coord, loc, childrenRange));
		return node;
	}

	/**
	 * 
	 * @param locs
	 * @return
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
	 * helper method to update current QuadTree range
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
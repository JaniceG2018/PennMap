package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class QuadTree implements IQuadTree {
	
	private final static BaseNode emptyNode = new EmptyNode();
	
	/**
	 * the root of the QuadTree
	 */
	private BaseNode root;
	
	/**
	 * the default constructor which creates an empty QuadTree
	 */
	public QuadTree() {
		root = emptyNode;
	}
	
	/**
	 * 
	 * @param root
	 */
	public QuadTree(BaseNode root) {
		this.root = root;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean insert(Location loc) {
		if (loc == null) {
			return false;
		}
		Coordinate coord = loc.getCoord();
		root = insert(root, coord, loc);
		return true;
	}
	
	private BaseNode insert(BaseNode node, Coordinate coord, Location loc) {
		// Root is empty or empty leaf, create new leafnode and store the info of given location
		if (node instanceof EmptyNode) {
			return new LeafNode(loc.getName(), loc.getType(), coord);
		}
		// If we need to add location in a quad that includes a location in it, we need to split it 
		// into an internal node and add both old and new locations to it 
		if (node instanceof LeafNode) {
			BaseNode newNode = ((LeafNode) node).split();
			LeafNode leaf = (LeafNode) node;
			Location old = new Location(leaf.getName(), leaf.getType(), leaf.getCoord());
			newNode = insert(newNode, old.getCoord(), old);
			newNode = insert(newNode, coord, loc);
			return newNode;
		}
		
		// If current node is Internal Node, then we should insert the location in its children
		Range curRange = ((InternalNode) node).getRange();
		Coordinate UL = curRange.getUpperL();
		Coordinate BR = curRange.getBottomR();
		// (lon, lat) is the central point of current Quad
		double lat = (UL.getLat() + BR.getLat()) / 2;
		double lon = (UL.getLon() + BR.getLon()) / 2;
		if (coord.getLat() < lat && coord.getLon() < lon) {
			((InternalNode) node).setNorthW(insert(node, coord, loc));
		} else if (coord.getLat() < lat && coord.getLon() > lon) {
			((InternalNode) node).setNorthE(insert(node, coord, loc));
		} else if (coord.getLat() > lat && coord.getLon() > lon) {
			((InternalNode) node).setSouthE(insert(node, coord, loc));
		} else if (coord.getLat() > lat && coord.getLon() < lon) {
			((InternalNode) node).setSouthW(insert(node, coord, loc));
		}
		
		return node;
	}

	/**
	 * 
	 */
	@Override
	public List<Location> search(String type, Range range) {
		List<Location> results = new ArrayList<>();
		root.search(type, range, results);
		return results;
	}

	/**
	 * 
	 */
	@Override
	public Range enclosingQuad(List<Location> locs) {
		return null;
	}
}
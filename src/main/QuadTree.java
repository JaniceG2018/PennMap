package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class QuadTree implements IQuadTree {
	
	private BaseNode root;
	
	public QuadTree(Range treeRange) {
		root = new InternalNode(treeRange);
	}

	/**
	 * the root of the QuadTree
	 */
	private BaseNode root;
	
	/**
	 * the default constructor which creates an empty QuadTree
	 */
	public QuadTree() {
		root = null;
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
		if (root == null) {
			enclosingQuad(locs)
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public List<Location> search(String type, Range range) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Coordinate enclosingQuad(List<Location> locs) {
		return null;
	}
}
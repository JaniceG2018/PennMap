package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class QuadTree implements IQuadTree {

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
	public Range enclosingQuad(List<Location> locs) {
		return null;
	}
}
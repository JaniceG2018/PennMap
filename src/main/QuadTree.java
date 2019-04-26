package main;

import java.util.List;

public class QuadTree implements IQuadTree {
	
	private BaseNode root;
	
	public QuadTree(Range treeRange) {
		root = new InternalNode(treeRange);
	}

	@Override
	public boolean insert(Location loc) {
		if (root == null) {
			enclosingQuad(locs)
		}
		return false;
	}

	@Override
	public List<Location> search(String type, Range range) {
		return null;
	}

	@Override
	public Coordinate enclosingQuad(List<Location> locs) {
		return null;
	}
}
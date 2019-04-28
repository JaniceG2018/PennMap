package main;

import java.util.List;

/**
 * The InternalNode class models an InternalNode of a QuadTree with 4 children
 * @author calchen
 *
 */
public class InternalNode extends BaseNode {

	/**
	 * the north-east child of this node
	 */
	private BaseNode northE;
	
	/**
	 * the north-west child of this node
	 */
	private BaseNode northW;
	
	/**
	 * the south-east child of this node
	 */
	private BaseNode southE;
	
	/**
	 * the south-west child of this node
	 */
	private BaseNode southW;
	
	/**
	 * default constructor of this class, which initializes all 4 children to EmptyNode
	 */
	public InternalNode() {
		northE = QuadTree.emptyNode;
		northW = QuadTree.emptyNode;
		southE = QuadTree.emptyNode;
		southW = QuadTree.emptyNode;
	}
	
	/**
	 * copy constructor of this class, which initializes all 4 children by copying given children
	 */
	public InternalNode(BaseNode northE, BaseNode northW, BaseNode southE, BaseNode southW) {
		this.setNorthE(northE);
		this.northW = northW;
		this.southE = southE;
		this.southW = southW;
	}
	
	public InternalNode(Range range) {
		super(range);
		northE = QuadTree.emptyNode;
		northW = QuadTree.emptyNode;
		southE = QuadTree.emptyNode;
		southW = QuadTree.emptyNode;
	}
	
	/**
	 * @return the north-east child of this node
	 */
	public BaseNode getNorthE() {
		return northE;
	}

	/**
	 * @param northE the new north-east child of this class
	 */
	public void setNorthE(BaseNode northE) {
		this.northE = northE;
	}

	/**
	 * @return the north-west child of this node
	 */
	public BaseNode getNorthW() {
		return northW;
	}

	/**
	 * @param northW the new north-west node of this node
	 */
	public void setNorthW(BaseNode northW) {
		this.northW = northW;
	}

	/**
	 * @return the south-east child of this node
	 */
	public BaseNode getSouthE() {
		return southE;
	}

	/**
	 * @param southE the new south-east child of this node
	 */
	public void setSouthE(BaseNode southE) {
		this.southE = southE;
	}

	/**
	 * @return the south-west node of this node
	 */
	public BaseNode getSouthW() {
		return southW;
	}

	/**
	 * @param southW the new south-west child of this node
	 */
	public void setSouthW(BaseNode southW) {
		this.southW = southW;
	}

	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		if (range.intersects(northW.getRange()))
			northW.search(type, range, locs);
		if (range.intersects(northE.getRange()))
			northE.search(type, range, locs);
		if (range.intersects(southW.getRange()))
			southW.search(type, range, locs);
		if (range.intersects(southE.getRange()))
			southE.search(type, range, locs);
	}

	@Override
	public boolean isEmpty() {
		if (isNull(northW) && isNull(northE) && isNull(southE) && isNull(southW)) {
			return true;
		}
		return false;
	}
	
	private boolean isNull(BaseNode node) {
		if (node instanceof EmptyNode) {
			return true;
		}
		return false;
	}
}
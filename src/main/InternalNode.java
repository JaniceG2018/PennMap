package main;

import java.util.List;

/**
 * This class models an InternalNode of the QuadTree with 4 children
 * @author calchen
 *
 */
public class InternalNode extends BaseNode {

	/**
	 * The north-east child of this InternalNode
	 */
	private BaseNode northE;
	
	/**
	 * The north-west child of this InternalNode
	 */
	private BaseNode northW;
	
	/**
	 * The south-east child of this InternalNode
	 */
	private BaseNode southE;
	
	/**
	 * The south-west child of this InternalNode
	 */
	private BaseNode southW;
	
	/**
	 * Empty constructor of this class, which initializes all 4 children to EmptyNodes
	 */
	public InternalNode() {
		northE = QuadTree.emptyNode;
		northW = QuadTree.emptyNode;
		southE = QuadTree.emptyNode;
		southW = QuadTree.emptyNode;
	}
	
	/**
	 * Copy constructor of this class, which initializes all 4 children to given BaseNodes
	 */
	public InternalNode(BaseNode northE, BaseNode northW, BaseNode southE, BaseNode southW) {
		this.northE = northE;
		this.northW = northW;
		this.southE = southE;
		this.southW = southW;
	}
	
	/**
	 * Constructor of this class, which initializes the Range of this InternalNode
	 * to a given Range and all 4 children of this InternalNode to EmptyNodes
	 * @param range
	 */
	public InternalNode(Range range) {
		super(range);
		northE = QuadTree.emptyNode;
		northW = QuadTree.emptyNode;
		southE = QuadTree.emptyNode;
		southW = QuadTree.emptyNode;
	}

	/**
	 * Getter for the north-east child of this node
	 * @return the north-east child of this node
	 */
	public BaseNode getNorthE() {
		return northE;
	}

	/**
	 * Setter for the north-east child of this node
	 * @param northE the new north-east child of this node
	 */
	public void setNorthE(BaseNode northE) {
		this.northE = northE;
	}

	/**
	 * Getter for the north-west child of this node
	 * @return the north-west child of this node
	 */
	public BaseNode getNorthW() {
		return northW;
	}

	/**
	 * Setter for the north-west child of this node
	 * @param northW the new north-west node of this node
	 */
	public void setNorthW(BaseNode northW) {
		this.northW = northW;
	}

	/**
	 * Getter for the south-east child of this node
	 * @return the south-east child of this node
	 */
	public BaseNode getSouthE() {
		return southE;
	}

	/**
	 * Setter for the south-east child of this node
	 * @param southE the new south-east child of this node
	 */
	public void setSouthE(BaseNode southE) {
		this.southE = southE;
	}

	/**
	 * Getter for the south-west child of this node
	 * @return the south-west node of this node
	 */
	public BaseNode getSouthW() {
		return southW;
	}

	/**
	 * Setter for the south-west child of this node
	 * @param southW the new south-west child of this node
	 */
	public void setSouthW(BaseNode southW) {
		this.southW = southW;
	}
	
	/**
	 * Find all Locations of a given type within a given Range among the children of this InternalNode
	 * @param type   the type of Locations (e.g. "Restaurant")
	 * @param range  the search Range
	 * @param locs   a list of Locations containing the search results
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

	/**
	 * Check if this InternalNode is empty
	 * @return true if all 4 children of this InternalNode are EmptyNodes, and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (isNull(northW) && isNull(northE) && isNull(southE) && isNull(southW))
			return true;
		else
			return false;
	}
	
	/**
	 * Helper function for checking if a given BaseNode is an EmptyNode
	 * @param node the BaseNode that we want to examine
	 * @return true if node is an EmptyNode, and false otherwise
	 */
	private boolean isNull(BaseNode node) {
		if (node instanceof EmptyNode)
			return true;
		else
			return false;
	}
} // ac
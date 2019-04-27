package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class InternalNode extends BaseNode {
	
//	public InternalNode() {
//		super();
//	}
//	
//	public InternalNode(Range range) {
//		super(range);
//	}

	/**
	 * 
	 */
	private BaseNode northE;
	
	/**
	 * 
	 */
	private BaseNode northW;
	
	/**
	 * 
	 */
	private BaseNode southE;
	
	/**
	 * 
	 */
	private BaseNode southW;
	
	/**
	 * 
	 */
	public InternalNode() {
		setNorthE(null);
		northW = null;
		southE = null;
		southW = null;
	}
	
	/**
	 * 
	 */
	public InternalNode(BaseNode northE, BaseNode northW, BaseNode southE, BaseNode southW) {
		this.setNorthE(northE);
		this.northW = northW;
		this.southE = southE;
		this.southW = southW;
	}
	
	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		if (range.intersects(northW.getRange())) {
			northW.search(type, range, locs);
		}
		if (range.intersects(northE.getRange())) {
			northE.search(type, range, locs);
		}
		if (range.intersects(southW.getRange())) {
			southW.search(type, range, locs);
		}
		if (range.intersects(southE.getRange())) {
			southE.search(type, range, locs);
		}
	}

	public BaseNode getNorthW() {
		return northW;
	}

	public void setNorthW(BaseNode northW) {
		this.northW = northW;
	}

	public BaseNode getSouthE() {
		return southE;
	}

	public void setSouthE(BaseNode southE) {
		this.southE = southE;
	}

	public BaseNode getSouthW() {
		return southW;
	}

	public void setSouthW(BaseNode southW) {
		this.southW = southW;
	}

	public BaseNode getNorthE() {
		return northE;
	}

	public void setNorthE(BaseNode northE) {
		this.northE = northE;
	}
}
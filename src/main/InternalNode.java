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
		northE = null;
		northW = null;
		southE = null;
		southW = null;
	}
	
	/**
	 * 
	 */
	public InternalNode(BaseNode northE, BaseNode northW, BaseNode southE, BaseNode southW) {
		this.northE = northE;
		this.northW = northW;
		this.southE = southE;
		this.southW = southW;
	}
	
	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		
	}
}
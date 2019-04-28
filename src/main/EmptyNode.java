package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class EmptyNode extends BaseNode {

	public EmptyNode() {
		range.setUpperL(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
		range.setBottomR(new Coordinate(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY));
	;}
	/**
	 * 
	 */
	@Override
	public void search(String type, Range range, List<Location> locs) {
		return;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}
}
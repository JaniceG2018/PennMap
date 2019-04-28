package main;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * 
 * @author calchen
 *
 */
public abstract class BaseNode {
	
	/**
	 * 
	 */
	protected Range range;
	
	/**
	 * empty constructor for this class
	 */
	public BaseNode() {
		setRange(new Range(null, null));
	}
	
	/**
	 * copy constructor for this class, initialize the Range with a given Range
	 * @param range
	 */
	public BaseNode(Range range) {
		this.setRange(range);
	}
	
	/**
	 * 
	 * @param type type of Location
	 * @param range
	 * @param locs 
	 */
	public abstract void search(String type, Range range, List<Location> locs);
	
	/**
	 * 
	 * @return a boolean value to indicate if this node is empty 
	 */
	public abstract boolean isEmpty();
	
	/**
	 * @return the Range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * @param range the new Range
	 */
	public void setRange(Range range) {
		this.range = range;
	}
	
	public Range mathSplit(Range range, Coordinate c){
		
		Coordinate UL = range.getUpperL();
		Coordinate BR = range.getBottomR();
		
		double halfWidth = (BR.getLon() - UL.getLon() )/ 2;
		double halfHeight = (BR.getLat() - UL.getLat() )/ 2;;
		// NW:
			double Rx1 = (UL.getLon() + BR.getLon()) / 2;
			double Ry1 = (UL.getLat() + BR.getLat()) / 2;
			Coordinate R1 = new Coordinate(Rx1, Ry1);
			

			double Lx1 = UL.getLon();
			double Ly1 = UL.getLat();
			Coordinate L1 = new Coordinate(Lx1, Ly1);
			Range r1 = new Range(L1, R1);
			
		// NE:
			double Lx2 = UL.getLon() + halfWidth;
			double Ly2 = UL.getLat();
			Coordinate L2 = new Coordinate(Lx2, Ly2);
			
			double Rx2 = BR.getLon();
			double Ry2 = BR.getLat() - halfHeight;
			Coordinate R2 = new Coordinate(Rx2, Ry2);
			Range r2 = new Range(L2, R2);
			
	
		// SW:
			double Lx3 = UL.getLon();  
			double Ly3 = UL.getLat() + halfHeight;
			Coordinate L3 = new Coordinate(Lx3, Ly3);
			
			double Rx3 = BR.getLon() - halfWidth;
			double Ry3 = BR.getLat();
			Coordinate R3 = new Coordinate(Rx3, Ry3);
			
			Range r3 = new Range(L3, R3);
			
			
		// SE:
			double Lx4 = (UL.getLon() + BR.getLon()) / 2;
			double Ly4 = (UL.getLat() + BR.getLat()) / 2;
			Coordinate L4 = new Coordinate(Lx4, Ly4);
			
			double Rx4 = BR.getLon();
			double Ry4 = BR.getLat();
			Coordinate R4 = new Coordinate(Rx4, Ry4);
			
			Range r4 = new Range(L4, R4);
			if(r1.contains(c)) {
				return r1;
			}else if(r2.contains(c)) {
				return r2;
			}else if(r3.contains(c)) {
				return r3;
			}else {
				return r4;
			}
	}
}
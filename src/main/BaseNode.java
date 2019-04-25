package main;

import java.awt.font.NumericShaper.Range;
import java.util.List;

public abstract class BaseNode {
	private Range range;
	
	public BaseNode() {
	
	}
	
	public BaseNode(Range range) {
		this.range = range;
	}
	
	public abstract void search(String type, Range range, List<Location> locs);
}

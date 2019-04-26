package main;

import java.util.List;

public abstract class BaseNode {
	
	private Range range;
	
	public BaseNode() {
		range = new Range(null, null);
	}
	
	public BaseNode(Range range) {
		this.range = range;
	}
	
	public abstract void search(String type, Range range, List<Location> locs);
}
package main;

import java.util.List;
import java.util.Spliterator;

import org.junit.validator.PublicClassValidator;

public class LeafNode extends BaseNode {

	@Override
	public void search(String type, Range range, List<Location> locs) {
		
		
	}
	
	public InternalNode split() {
		return null;
	}
	
	
}
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph implements IGraph {
	
	private HashMap<String, List<Road>> graph;
	
	public Graph(List<Location> locations, List<Road> roads) {
		//TODO: build graph
		graph = new HashMap<String, List<Road>>();
		List<Road> list1 = new ArrayList<Road>();
		list1.add(new Road("start", "end", "rdname", 1.0));
		graph.put("name", list1);
	}

	@Override
	public String findShortestPath(String loc1, String loc2) {
		return null;
	}
}

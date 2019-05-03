package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The Graph class models a Road network on the map to support the findShortestPath() and findNearest() functionalities of our app
 * @author Jiaying Guo, calchen
 *
 */
public class Graph implements IGraph {

	/**
	 * HashMap to store the Road network on the map
	 */
	private HashMap<String, List<Road>> graph;

	/**
	 * Constructor of this class, which initializes graph using a list of Locations and a list of Roads
	 * @param locs   a list of all Locations on the map
	 * @param roads  a list of all Roads on the map
	 */
	public Graph(List<Location> locs, List<Road> roads) {
		graph = new HashMap<String, List<Road>>();
		for (Location l : locs) {
			String startLoc = l.getName();
			graph.put(startLoc, new LinkedList<Road>());
		}
		for (Road r : roads) {
			String start = r.getStartLocName();
			String end = r.getEndLocName();
			graph.get(start).add(r);
			Road reverseRoad = new Road(r.getEndLocName(), r.getStartLocName(), r.getRdName(), r.getDist());
			graph.get(end).add(reverseRoad);
		}
	}

	/**
	 * Return the directions in text for the shortest path from a given Location to another
	 * @param startLoc  the name of the starting Location
	 * @param endLoc    the name of the destination
	 * @return the directions in text for the shortest path from startLoc to endLoc
	 */
	@Override
	public String findShortestPath(String startLoc, String endLoc) {
		// store the road names and locations in the path
		List<String> path = new ArrayList<>();

		// tracking the visited nodes in graph
		List<String> visited = new ArrayList<>();

		// a min-heap for tracking min dist(v) in the graph
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if (a.getKey() < b.getKey())
					return -1;
				else if (a.getKey() > b.getKey())
					return 1;
				else
					return 0;
			}
		});

		// res to keep track of the distance from s to every vertex v
		Map<String, Double> res = new HashMap<String, Double>();

		// predecessor to keep track of parent when updated
		Map<String, String> pred = new HashMap<String, String>();

		for (String s : graph.keySet()) {
			res.put(s, Double.MAX_VALUE);
			pred.put(s, null);
		}
		if (!res.containsKey(startLoc) || !res.containsKey(endLoc))
			throw new IllegalArgumentException("Invalid starting location or destination!");
		Pair source = new Pair(0, startLoc);
		pred.put(startLoc, startLoc);
		res.put(startLoc, 0.0);
		minHeap.offer(source);
		String curr = "";
		for (int k = 0; k < graph.size(); k++) {
			do {
				Pair temp = minHeap.poll();
				curr = temp.getValue();
			} // get position
			while (visited.contains(curr));

			// set current position visited
			visited.add(curr);
			if (curr.equals(endLoc))
				break;
			
			// unreachable
			if (res.get(curr).equals(Double.MAX_VALUE))
				return "";
			for (Road i : graph.get(curr)) {
				String w = i.getEndLocName();

				// update the distance of w
				if (res.get(i.getEndLocName()) > (res.get(i.getStartLocName()) + i.getDist())) {
					res.put(i.getEndLocName(), (res.get(i.getStartLocName()) + i.getDist()));
					pred.put(i.getEndLocName(), i.getStartLocName());
					minHeap.offer(new Pair((res.get(i.getStartLocName()) + i.getDist()), w));
				}
			}
		}
		String start = endLoc;
		String tempStart, tempEnd;
		List<Road> routes = new ArrayList<>();

		// construct the path from predecessor list
		while (!pred.get(start).equals(start)) {
			path.add(start);
			tempEnd = start;
			tempStart = pred.get(start);
			for (Road k : graph.get(tempStart)) {
				if (k.getEndLocName().equals(tempEnd))
					routes.add(k);
			}
			start = tempStart;
		}
		path.add(start);
		String route = "";
		int distance = 0;

		// reversely build the output route string
		for (int i = routes.size() - 1, t = path.size() - 1; i >= 0; i--, t--) {
			Road curr_road = routes.get(i);
			distance += curr_road.getDist();
			route += path.get(t) + " -> road " + curr_road.getRdName() + " -> ";
		}
		route += path.get(0);
		route += "\nTotal distance is " + distance;
		return route;
	}

	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param currLoc  the current user Location
	 * @param type     type of Location (e.g. "Restaurant")
	 * @param locs     
	 * @return the nearest Location of the given type from currLoc
	 */
	public Location findNearest(String currLoc, String type, List<Location> locs) {
		// tracking the visited nodes in graph
		List<String> visited = new ArrayList<>();

		// a min-heap for tracking min dist(v) in the graph
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if (a.getKey() < b.getKey())
					return -1;
				else if (a.getKey() > b.getKey())
					return 1;
				else
					return 0;
			}
		});

		// res to keep track of the distance from s to every vertex v
		Map<String, Double> res = new HashMap<String, Double>();

		// predecessor to keep track of parent when updated
		Map<String, String> pred = new HashMap<String, String>();

		for (String s : graph.keySet()) {
			res.put(s, Double.MAX_VALUE);
			pred.put(s, null);
		}
		if (!res.containsKey(currLoc))
			throw new IllegalArgumentException("Invalid starting location!");
		Pair source = new Pair(0, currLoc);
		res.put(currLoc, 0.0);
		minHeap.offer(source);
		String curr = "";
		for (int k = 0; k < graph.size(); k++) {
			do {
				Pair temp = minHeap.poll();
				curr = temp.getValue();
			} // get position
			while (visited.contains(curr));

			// if the current vertex's type matches our search type and it's not our source
			// vertex, then output the nearest location
			if (findLoc(locs, curr).getType().equals(type) && !curr.equals(currLoc)) {
				System.out.println("Total distance is " + res.get(curr));
				return findLoc(locs, curr);
			}
			visited.add(curr); 

			// unreachable
			if (res.get(curr).equals(Double.MAX_VALUE))
				return null;
			for (Road i : graph.get(curr)) {
				String w = i.getEndLocName();
				// update the distance
				if (res.get(i.getEndLocName()) > (res.get(i.getStartLocName()) + i.getDist())) {
					res.put(i.getEndLocName(), (res.get(i.getStartLocName()) + i.getDist()));
					pred.put(i.getEndLocName(), i.getStartLocName());
					minHeap.offer(new Pair((res.get(i.getStartLocName()) + i.getDist()), w));
				}
			}
		}
		return null;
	}
	
	/**
	 * Helper method for finding a Location by its name among a list of given Locations. Return null if not found
	 * @param locs    a list of Locations that we want to search
	 * @param target  the name of the target Location
	 * @return a reference to the Location with target as its name among locs
	 */
	private Location findLoc(List<Location> locs, String target) {
		for (Location l : locs) {
			if (l.getName().equals(target))
				return l;
		}
		return null;
	}
} // ac
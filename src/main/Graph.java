package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Graph models a Road network on the map
 * @author calchen, Jiaying Guo
 *
 */
public class Graph implements IGraph {

	/**
	 * HashMap to store our road network
	 */
	private HashMap<String, List<Road>> graph;

	/**
	 * Constructor of the Graph class, which converts a list of Locations and a list
	 * of Roads into a HashMap representing the road network
	 * @param locations a list of Locations on the map
	 * @param roads a list of Roads on the map
	 */
	public Graph(List<Location> locations, List<Road> roads) {

		graph = new HashMap<String, List<Road>>();
		for (Location l : locations) {
			String startLoc = l.getName();
			graph.put(startLoc, new LinkedList<Road>());

		}
		for (Road r : roads) {
			String start = r.getStart();
			String end = r.getEnd();
			graph.get(start).add(r);
			Road reverseRoad = new Road(r.getEnd(), r.getStart(), r.getRdName(), r.getDist());
			graph.get(end).add(reverseRoad);
		}
	}

	/**
	 * Return the directions in text for the shortest path from
	 * one Location to another
	 * @param the name of the starting Location
	 * @param the name of the destination
	 * @return the directions in text for the shortest path from the starting
	 *         Location to the destination
	 */
	@Override
	public String findShortestPath(String loc1, String loc2) {
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
		Map<String, String> predecessor = new HashMap<String, String>();

		for (String s : graph.keySet()) {
			res.put(s, Double.MAX_VALUE);
			predecessor.put(s, null);
		}

		if (!res.containsKey(loc1) || !res.containsKey(loc2))
			throw new IllegalArgumentException("The starting or ending location doesn't exist!");

		Pair source = new Pair(0, loc1);
		predecessor.put(loc1, loc1);
		res.put(loc1, 0.0);

		minHeap.offer(source);
		String curr = "";
		for (int k = 0; k < graph.size(); k++) {

			do {
				Pair temp = minHeap.poll();
				curr = temp.getValue();
			} // Get position
			while (visited.contains(curr));

			// set current position visited
			visited.add(curr);
			if (curr.equals(loc2)) {
				break;
			}
			// Unreachable
			if (res.get(curr).equals(Double.MAX_VALUE)) {
				return "";
			}
			for (Road i : graph.get(curr)) {
				String w = i.getEnd();

				// update the distance of w
				if (res.get(i.getEnd()) > (res.get(i.getStart()) + i.getDist())) {

					res.put(i.getEnd(), (res.get(i.getStart()) + i.getDist()));
					predecessor.put(i.getEnd(), i.getStart());
					minHeap.offer(new Pair((res.get(i.getStart()) + i.getDist()), w));
				}

			}

		}
		String start = loc2;
		String temp_start, temp_end;
		List<Road> routes = new ArrayList<>();

		// construct the path from predecessor list
		while (!predecessor.get(start).equals(start)) {
			path.add(start);
			temp_end = start;
			temp_start = predecessor.get(start);
			for (Road k : graph.get(temp_start)) {
				if (k.getEnd().equals(temp_end))
					routes.add(k);
			}
			start = temp_start;
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
	 * Getter for a list of Roads starting from a given Location
	 * Added this method for test purposes
	 * @param locName the name of the Locations
	 * @return the list of Roads starting from the given Location
	 */
	public List<Road> getRoad(String locName) {
		return this.graph.get(locName);
	}

	/**
	 * Find the nearest Location of a given type from the current user Location,
	 * or null if not found
	 * @param type the type of Location we want to find
	 * @param currLoc the start location
	 * @param locations the list of locations
	 * @return the nearest Location of the given type from the current user Location
	 */
	public Location findNearest(String currLoc, String type, List<Location> locations) {

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
		Map<String, String> predecessor = new HashMap<String, String>();

		for (String s : graph.keySet()) {
			res.put(s, Double.MAX_VALUE);
			predecessor.put(s, null);
		}

		if (!res.containsKey(currLoc)) {
			throw new IllegalArgumentException("The starting location doesn't exist!");
		}

		Pair source = new Pair(0, currLoc);
		res.put(currLoc, 0.0);

		minHeap.offer(source);
		String curr = "";

		for (int k = 0; k < graph.size(); k++) {
			do {
				Pair temp = minHeap.poll();
				curr = temp.getValue();
			} // Get position
			while (visited.contains(curr));

			// if the current vertex's type matches our search type and it's not our source
			// vertex, then output the nearest location
			if (findLocation(locations, curr).getType().equals(type) && !curr.equals(currLoc)) {
				System.out.println("Total distance is " + res.get(curr));
				return findLocation(locations, curr);
			}

			visited.add(curr); 

			// Unreachable
			if (res.get(curr).equals(Double.MAX_VALUE)) {
				return null;
			}

			for (Road i : graph.get(curr)) {
				String w = i.getEnd();
				// update the distance
				if (res.get(i.getEnd()) > (res.get(i.getStart()) + i.getDist())) {

					res.put(i.getEnd(), (res.get(i.getStart()) + i.getDist()));
					predecessor.put(i.getEnd(), i.getStart());
					minHeap.offer(new Pair((res.get(i.getStart()) + i.getDist()), w));
				}

			}
		}

		return null;

	}

	private Location findLocation(List<Location> locations, String curr) {
		for (Location l : locations) {
			if (l.getName().equals(curr)) {
				return l;
			}
		}
		return null;
	}
}

package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author calchen, Jiaying Guo
 *
 */
public class Graph implements IGraph {
	
	/**
	 * HashMap to store our road network
	 */
	private HashMap<String, List<Road>> graph;
	
	/**
	 * constructor for this class, which converts a list of Locations and a list of Roads into
	 * a HashMap representing the road network
	 * @param locations
	 * @param roads
	 */
	public Graph(List<Location> locations, List<Road> roads) {
		//TODO: build graph
		graph = new HashMap<String, List<Road>>();
		for(Location l : locations) {
			String startLoc = l.getName();
			graph.put(startLoc, new LinkedList<Road>());
			for(Road r : roads) {
				if(r.getStart().equals(startLoc)) {
					graph.get(startLoc).add(r);
					System.out.println(startLoc);
				}
			}
		}
	}
	
	/**
	 * findShortestPath() returns the directions for the shortest path from one location to another
	 * 
	 */
	@Override
	public String findShortestPath(String loc1, String loc2) {
		List<String> path = new ArrayList<>();
		PriorityQueue<Road> dist = new PriorityQueue<>(new Comparator<Road>() {
			@Override
			public int compare(Road a, Road b) {
				if (a.getDist() < b.getDist()) {
					return -1;
				} else if(a.getDist() > b.getDist()) {
					return 1;
				}
				return 0;
			}
		});
		Map<String, Double> res = new HashMap<String, Double>();
		Map<String, String> predecessor = new HashMap<String, String>();
		for(String s : graph.keySet()) {
			res.put(s, Double.MAX_VALUE);
			predecessor.put(s, null);
		}
		if(!res.containsKey(loc1)) {
			throw new IllegalArgumentException("The location doesn't exist!");
		}
		Road source = new Road(loc1, loc1, null, 0);
		predecessor.put(loc1, loc1);
		res.put(loc1, 0.0);
		dist.add(source);
		
		String curr ;
		while(!dist.isEmpty()) {
			 curr = dist.poll().getEnd();
			 if(curr.equals(loc2)) {
				 break;
			 }
			 for(Road i : graph.get(curr)) {
				 if(res.get(i.getEnd()) > (res.get(i.getStart()) + i.getDist())) {
					 res.put(i.getEnd(), (res.get(i.getStart()) + i.getDist()));
					 predecessor.put(i.getEnd(), i.getStart());
				 }
				 i.setDist((res.get(i.getStart()) + i.getDist()));
				 dist.offer(i);
			 }
		}
		
		String start = loc2;
		String temp_start, temp_end;
		List<Road> routes = new ArrayList<>();
		while(predecessor.get(start) != start){
			path.add(start);
			temp_end = start;
			temp_start = predecessor.get(start);
			for(Road k : graph.get(temp_start)) {
				if(k.getEnd().equals(temp_end)) {
					routes.add(k);
				}
			}
			start = temp_start;
		}
		for(Road x : routes) {
			System.out.println(x.getRdName());
		}
		path.add(start);
		String route = "";
	
		for(int i = routes.size() - 1, t = path.size() - 1; i >= 0; i--, t--) {
			Road curr_road = routes.get(i);
			route += path.get(t) + " -> road " + curr_road.getRdName() + " -> ";
		}
		route += path.get(0);
		return route;
	}
}
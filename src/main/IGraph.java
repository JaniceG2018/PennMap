package main;

import java.util.List;

/**
 * This interface is used to support the findShortestPath() and findNearest() functionalities of our app
 * @author calchen
 *
 */
public interface IGraph {

	/**
	 * Return the directions in text for the shortest path from a given Location to another
	 * @param startLoc  the name of the starting Location
	 * @param endLoc    the name of the destination
	 * @return the directions in text for the shortest path from startLoc to endLoc
	 */
	public String findShortestPath(String startLoc, String endLoc);
	
	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param currLoc  the current user Location
	 * @param type     the type of Location (e.g. "Restaurant")
	 * @param locs     
	 * @return the nearest Location of the given type from currLoc
	 */
	public Location findNearest(String currLoc, String type, List<Location> locs);
} // ac
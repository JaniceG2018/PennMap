package main;

import java.util.List;

/**
 * This interface is used to model a Road network
 * @author calchen
 *
 */
public interface IGraph {

	/**
	 * Return the directions in text for the shortest path from a starting Location to a destination
	 * @param loc1 the name of the starting Location
	 * @param loc2 the name of the destination
	 * @return the directions in text from loc1 to loc2
	 */
	public String findShortestPath(String loc1, String loc2);
	
	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param type       the type of Location
	 * @param loc1       the current user Location
	 * @param locations  a list of all Locations
	 * @return the nearest Location of the given type from loc1
	 */
	public Location findNearest(String loc1, String type,List<Location> locations);
}
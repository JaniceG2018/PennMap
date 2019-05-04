package main;

import java.util.List;

/**
 * The IGraph interface is used to model a road network
 * @author calchen
 *
 */
public interface IGraph {

	/**
	 * findShortestPath() returns the directions in text for the shortest path from
	 * a starting Location to a destination
	 * @param loc1 the name of the starting Location
	 * @param loc2 the name of the destination
	 * @return the directions in text from the starting Location to the destination
	 */
	public String findShortestPath(String loc1, String loc2);
	
	/**
	 * findNearest() returns the nearest Location of a given type from the current user Location,
	 * or null if not found
	 * @param type the type of Location we want to find
	 * @param loc1 the start location
	 * @param locations the list of locations
	 * @return the nearest Location of the given type from the current user Location
	 */
	public Location findNearest(String loc1, String type,List<Location> locations);
}
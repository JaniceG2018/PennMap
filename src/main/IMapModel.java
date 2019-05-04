package main;

import java.util.List;

/**
 * This interface contains methods that support the functionalities of our app
 * @author calchen
 *
 */
public interface IMapModel {

	/**
	 * Return the directions in text for the shortest path from a starting Location to a destination
	 * @param loc1  the name of the starting Location
	 * @param loc2  the name of the destination
	 * @return the directions in text from loc1 to loc2
	 */
	public String findShortestPath(String loc1, String loc2);
	
	/**
	 * Find all Locations of a given type within a given distance from the current user Location
	 * @param type  the type of Locations
	 * @param dist  the search distance from the current user Location
	 * @return a list of all Locations of the given type within dist from the current user Location
	 */
	public List<Location> findAll(String type, double dist);
	
	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param type the type of Location
	 * @return the nearest Location of the given type from the current user Location
	 */
	public Location findNearest(String type);
}
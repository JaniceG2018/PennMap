package main;

import java.util.List;

/**
 * This interface contains methods that support all functionalities of our app
 * @author calchen
 *
 */
public interface IMapModel {

	/**
	 * Return the directions in text for the shortest path from a given Location to another
	 * @param startLoc  the name of the starting Location
	 * @param endLoc    the name of the destination
	 * @return the directions in text for the shortest path from startLoc to endLoc
	 */
	public String findShortestPath(String startLoc, String endLoc);
	
	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param type the type of Location (e.g. "Restaurant")
	 * @return the nearest Location of the given type from the current user Location
	 */
	public Location findNearest(String type);
	
	/**
	 * Find all Locations of a given type within a given distance from the current user Location
	 * @param type  the type of Locations (e.g. "Restaurant")
	 * @param dist  the search distance from the current user Location (defined as (x +/- dist, y +/- dist))
	 * @return a list of all Locations of the given type within dist from the current user Location
	 */
	public List<Location> findAll(String type, double dist);
} // c
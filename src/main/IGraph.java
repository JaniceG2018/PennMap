package main;

/**
 * The IGraph interface is used to model a road network
 * @author calchen
 *
 */
public interface IGraph {

	/**
	 * findShortestPath() returns the directions in text for the
	 * shortest path from a starting location to a destination
	 * @param loc1 the name of the starting location
	 * @param loc2 the name of the destination
	 * @return the directions in text from loc1 to loc2
	 */
	public String findShortestPath(String loc1, String loc2);
}
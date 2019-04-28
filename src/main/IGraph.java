package main;

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
} //all checked
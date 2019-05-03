package main;

import java.util.List;

/**
 * This interface contains methods that support the functionalities of the QuadTree
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * Insert a new Location into the QuadTree
	 * @param loc the new Location that we want to insert
	 * @return true if the new Location is successfully inserted, or false otherwise
	 */
	public boolean insert(Location loc);
	
	/**
	 * Find all Locations of a given type within a given Range by traversing the QuadTree
	 * @param type   the type of Locations (e.g. "Restaurant")
	 * @param range  the search Range
	 * @return a list of all Locations of the given type within range
	 */
	public List<Location> search(String type, Range range);
	
	/**
	 * Calculate the smallest possible Range that contains all given Locations. Also reset the root of the QuadTree
	 * @param locs a list of Locations that we want to include
	 * @return the smallest possible Range that contains all given Locations
	 */
	public Range enclosingQuad(List<Location> locs);
} // c
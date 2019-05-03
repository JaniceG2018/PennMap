package main;

import java.util.List;

/**
 * This interface contains methods that support the functionalities of the QuadTree
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * Inserts a new Location into the QuadTree
	 * @param loc the new Location that we want to insert into our QuadTree
	 * @return true if the new Location has been successfully inserted and false otherwise
	 */
	public boolean insert(Location loc);
	
	/**
	 * Returns a list of Locations of a given type within a given Range by traversing the QuadTree
	 * @param type the type of Locations we want to search(e.g. "School")
	 * @param range the search range
	 * @return a list of Locations of the given type within the given Range   
	 */
	public List<Location> search(String type, Range range);
	
	/**
	 * Returns the smallest possible Range that includes all given Locations;
	 * it also re-initialize the root of the QuadTree
	 * @param locs a list of Locations
	 * @return the smallest possible Range that includes all given Locations
	 */
	public Range enclosingQuad(List<Location> locs);
}
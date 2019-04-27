package main;

import java.util.List;

/**
 * The IQuadTree interface contains methods that support basic functionalities of a QuadTree
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * insert() inserts a new Location into the QuadTree
	 * @param newNode the new Location that we want to insert into our QuadTree
	 * @return true if the new Location has been successfully inserted and false otherwise
	 */
	public boolean insert(Location loc);
	
	/**
	 * search() returns a list of Locations of a specified type within a given Range from home
	 * @param type the type of locations, e.g. restaurants
	 * @param range the Range of search from home
	 * @return a list of Locations of the specified type within the given Range from home
	 *         
	 */
	public List<Location> search(String type, Range range);
	
	/**
	 * enclosingQuad calculates the minimum range to include given locations, also set the root of the QuadTree
	 * @param locs a list of Locations
	 * @return a minimum range to include all given locations
	 */
	public Range enclosingQuad(List<Location> locs);

}
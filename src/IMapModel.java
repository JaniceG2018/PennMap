import java.util.List;

/**
 * The IMapModel interface contains methods that support the functionalities of our app
 * @author calchen
 *
 */
public interface IMapModel {

	/**
	 * findShortestPath() returns the directions for the shortest
	 * path in text from a starting location to a destination
	 * @param loc1 the name of the starting location
	 * @param loc2 the name of the destination
	 * @return the directions for shortest path in text from loc1 to loc2
	 */
	public String findShortestPath(String loc1, String loc2);
	
	/**
	 * findAll() returns a list of Locations for the specified
	 * type of locations within a given distance from home
	 * @param type the type of locations, e.g. restaurants
	 * @param dist the range of search from home
	 * @return a list of Locations of the specified type within a given distance from home
	 */
	public List<Location> findAll(String type, double dist);
	
	/**
	 * findNearest() returns the nearest Location of a specified type from home
	 * @param type the type of location, e.g. restaurant
	 * @return the nearest Location of the specified type from home
	 */
	public Location findNearest(String type);
}
import java.util.List;

/**
 * IMapModel interface contains methods that support the functionalities of our map
 * @author calchen
 *
 */
public interface IMapModel {

	/**
	 * shortestPath() finds the shortest path from loc1 to loc2 and outputs the directions in text
	 * @param loc1 the name of the starting location
	 * @param loc2 the name of the destination
	 * @return the directions for shortest path from loc1 to loc2
	 */
	public String shortestPath(String loc1, String loc2);
	
	/**
	 * findAll() returns a list of names for the specified type of locations within dist from the starting location
	 * @param type the type of locations, e.g. restaurants
	 * @param dist the range of search
	 * @return a list of names for the specified type of locations within dist from the starting location
	 */
	public List<String> findAll(String type, double dist);
	
	/**
	 * findNearest() returns the nearest location of the specified type from the starting location
	 * @param type the type of locations
	 * @return the nearest location of the specified type from the starting location
	 */
	public String findNearest(String type);
}
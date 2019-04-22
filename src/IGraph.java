/**
 * The Graph interface models a road network
 * @author calchen
 *
 */
public interface IGraph {

	/**
	 * add() adds a Road to our graph
	 * @param loc1 the name of the starting location for the road
	 * @param loc2 the name of the destination for the road
	 * @param rd the road
	 */
	public boolean add(String loc1, String loc2, Road rd);
}
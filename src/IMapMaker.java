import java.util.List;

/**
 * The IMapMaker interface is used to construct a QuadTree object from
 * a list of Locations and a Graph object from a list of location names
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * makeQuadTree() constructs a QuadTree object to store a list of Locations
	 * @param locs a list of Locations
	 * @return a QuadTree object storing the list of Locations
	 */
	public QuadTree makeQuadTree(List<Location> locs);
	
	/**
	 * makeGraph() is used to generate a Graph object from a list of location names
	 * @param locNames a list of location names
	 * @return a Graph object representing a road network
	 */
	public Graph makeGraph(List<String> locNames);
}
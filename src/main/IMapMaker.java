package main;

/**
 * The IMapMaker interface is used to construct a QuadTree object from
 * a list of Locations and a Graph object from a list of location names
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * makeQuadTree() constructs a IQuadTree to store a list of Locations
	 * @param locs a list of all Locations
	 * @return a IQuadTree storing the list of Locations
	 */
	public IQuadTree makeQuadTree();
	
	/**
	 * makeGraph() is used to generate a IGraph from a list of location names
	 * @param locNames a list of location names
	 * @return a IGraph representing a road network
	 */
	public IGraph makeGraph();
}

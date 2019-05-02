package main;

/**
 * The IMapMaker interface is used to construct a QuadTree and a Graph
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * makeQuadTree() constructs a QuadTree
	 * @return an IQuadTree storing all Locations on the map
	 */
	public IQuadTree makeQuadTree();
	
	/**
	 * makeGraph() constructs a Graph
	 * @return an IGraph representing the Road network on the map
	 */
	public IGraph makeGraph();
} // all checked
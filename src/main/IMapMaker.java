package main;

/**
 * This interface is used to construct a QuadTree and a Graph
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * Constructs a QuadTree
	 * @return an IQuadTree storing all Locations on the map
	 */
	public IQuadTree makeQuadTree();
	
	/**
	 * Constructs a Graph
	 * @return an IGraph representing the Road network on the map
	 */
	public IGraph makeGraph();
} // ac
package main;

/**
 * This interface is used to construct the QuadTree and the Graph
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * Construct the QuadTree
	 * @return an IQuadTree storing all Locations on the map
	 */
	public IQuadTree makeQuadTree();
	
	/**
	 * Construct the Graph
	 * @return an IGraph representing the Road network on the map
	 */
	public IGraph makeGraph();
}

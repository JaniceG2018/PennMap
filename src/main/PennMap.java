package main;

import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public class PennMap implements IMapMaker, IMapModel {

	/**
	 * the QuadTree representing the map
	 */
	private QuadTree tree;
	
	/**
	 * the road network
	 */
	private Graph graph;
	
	/**
	 * the "home" Coordinate
	 */
	private Coordinate startingPt;
	
	/**
	 * 
	 * @param list
	 * @param startingPt
	 */
	public PennMap(List<String> list, Coordinate startingPt) {
		this.startingPt = startingPt;
	}
	
	/**
	 * findShorte
	 */
	@Override
	public String findShortestPath(String loc1, String loc2) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<Location> findAll(String type, double dist) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public Location findNearest(String type) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public IQuadTree makeQuadTree(List<Location> locs) {
		IQuadTree quadTree = new QuadTree();
		quadTree.enclosingQuad(locs);
		for (Location location : locs) {
			quadTree.insert(location);
		}
		return quadTree;
	}

	/**
	 * 
	 */
	@Override
	public IGraph makeGraph(List<String> locNames) {
		return null;
	}
}
package main;

import java.util.ArrayList;

import java.util.List;

/**
 * This class contains methods for constructing the QuadTree and the Graph and methods supporting the functionalities of our app
 * @author calchen, Jingwen Qiang
 *
 */
public class PennMap implements IMapMaker, IMapModel {

	/**
	 * The QuadTree storing Locations on the map
	 */
	private IQuadTree tree;
	
	/**
	 * The Graph representing the Road network
	 */
	private IGraph graph;
	
	/**
	 * The current user Location
	 */
	private Location currLoc;
	
	/**
	 * The current user Coordinate
	 */
	private Coordinate currCoord;
	
	/**
	 * A list of all Roads on the map
	 */
	private List<Road> rdList = new ArrayList<Road>();
	
	/**
	 * A list of all Locations on the map
	 */
	private List<Location> locList = new ArrayList<Location>();
	
	/**
	 * Empty constructor of this class, which initializes rdList and locList to empty lists
	 */
	public PennMap() {
		rdList = new ArrayList<Road>();
		locList = new ArrayList<Location>();
	}
	
	/**
	 * Constructor of this class, which makes a field of all locations and roads based on the input data
	 * @param init       data input
	 * @param currCoord  the current user Coordinate
	 */
	public PennMap(List<String> init, Coordinate currCoord) {
		// change the data input stream to do the parsing first 
		this.currCoord = currCoord;
		parser(init);
		currLoc = matchLoc();
		tree = makeQuadTree();
		graph = makeGraph();
	}
	
	/**
	 * Construct a QuadTree
	 * @return an IQuadTree
	 */
	@Override
	public IQuadTree makeQuadTree() {
		IQuadTree quadTree = new QuadTree();
		quadTree.enclosingQuad(locList);
		for (Location location : locList) {
			quadTree.insert(location);
		}
		this.tree=(QuadTree) quadTree;
		return quadTree;
	}

	/**
	 * Construct a Graph
	 * @return an IGraph
	 */
	@Override
	public IGraph makeGraph() {		
		Graph graph = new Graph(locList, rdList);
		this.graph = graph;
		return graph;
	}
	
	/**
	 * Getter for the QuadTree
	 * @return the QuadTree
	 */
	public IQuadTree getTree() {
		return tree;
	}

	/**
	 * Setter for the QuadTree
	 * @param tree the new QuadTree
	 */
	public void setTree(QuadTree tree) {
		this.tree = tree;
	}

	/**
	 * Getter for the Graph
	 * @return the Graph
	 */
	public IGraph getGraph() {
		return graph;
	}

	/**
	 * Setter for the Graph
	 * @param graph the new Graph
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	/**
	 * Getter for the current user Coordinate
	 * @return the current user Coordinate
	 */
	public Coordinate getCurrCoord() {
		return currCoord;
	}

	/**
	 * Setter for the current user Coordinate
	 * @param currCoord the new current user Coordinate
	 */
	public void setCurrCoord(Coordinate currCoord) {
		this.currCoord = currCoord;
	}

	/**
	 * Getter for the list of all Roads on the map
	 * @return the list of all Roads on the map
	 */
	public List<Road> getRoadList() {
		return rdList;
	}

	/**
	 * Setter for the list of all Roads on the map
	 * @param rdList the new list of all Roads on the map
	 */
	public void setRoadList(List<Road> rdList) {
		this.rdList = rdList;
	}

	/**
	 * Getter for the list of all Locations on the map
	 * @return the list of all Locations on the map
	 */
	public List<Location> getLocationList() {
		return locList;
	}

	/**
	 * Setter for the list of all Locations on the map
	 * @param locList the new List of all Locations on the map
	 */
	public void setLocationList(List<Location> locList) {
		this.locList = locList;
	}
	
	/**
	 * Return the directions in text for the shortest path from a given Location to another
	 * @param startLoc  the name of the starting Location
	 * @param endLoc    the name of the destination
	 * @return the directions in text for the shortest path from startLoc to endLoc
	 */
	@Override
	public String findShortestPath(String startLoc, String endLoc) {
		return graph.findShortestPath(startLoc, endLoc);
	}

	/**
	 * Find the nearest Location of a given type from the current user Location. Return null if not found
	 * @param type the type of Location (e.g. "Restaurant")
	 * @return the nearest Location of the given type from the current user Location
	 */
	@Override
	public Location findNearest(String type) {
		String l1 = currLoc.getName();
		return ((Graph)graph).findNearest(l1, type, locList);
	}
	
	/**
	 * Find all Locations of a given type within a given distance from the current user Location
	 * @param type  the type of Locations (e.g. "Restaurant")
	 * @param dist  the search distance from the current user Location (defined by (x +/- dist, y +/- dist))
	 * @return a list of Locations of the given type within dist from the current user Location
	 */
	@Override
	public List<Location> findAll(String type, double dist) {
		double currY = currCoord.getLat();
		double currX = currCoord.getLon();
		Coordinate upperLeft= new Coordinate(currX-dist,currY-dist);
		Coordinate lowerRight= new Coordinate(currX+dist,currY+dist);
		Range range = new Range(upperLeft,lowerRight);
		return tree.search(type, range);		
	}

	/**
	 * Helper method for parsing the initial data and put it into location and road data fields
	 * @param initData
	 */
	private void parser(List<String> initData) {
		for (int i = 0; i < initData.size(); i++) {
			String s = initData.get(i);
			String[] sa = s.split(", ");
			
			String[] sStartCoord = sa[0].substring(1, sa[0].length() - 1).split(",");
			double sLat = Double.valueOf(sStartCoord[1]); // y
			double sLon = Double.valueOf(sStartCoord[0]); // x
			Coordinate startCoord = new Coordinate(sLon, sLat);
			Location startLoc = new Location(sa[1], sa[2], startCoord);
			if (!locList.contains(startLoc))
				locList.add(startLoc);

			String[] sEndCoord = sa[3].substring(1, sa[3].length() - 1).split(",");
			double eLon = Double.valueOf(sEndCoord[0]); // x
			double eLat = Double.valueOf(sEndCoord[1]); // y
			Coordinate endCoord = new Coordinate(eLon, eLat);
			Location endLoc = new Location(sa[4], sa[5], endCoord);
			if (!locList.contains(endLoc))
				locList.add(endLoc);

			double distance = Double.valueOf(sa[7]);
			Road rd = new Road(sa[1], sa[4], sa[6], distance);
			if (!rdList.contains(rd))
				rdList.add(rd);
		}
	}
	
	/**
	 * Helper method
	 * @return
	 */
	private Location matchLoc() {
		for(Location location : locList) {
			if(location.getCoord().equals(currCoord))
				return location;
		}
		return null;
	}
} // ac
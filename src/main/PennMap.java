package main;

import java.util.ArrayList;

import java.util.List;

/**
 * This class constains methods for constructing our QuadTree and Graph and methods supporting the functionalities of our app
 * @author calchen, Jingwen Qiang
 *
 */
public class PennMap implements IMapMaker, IMapModel {

	/**
	 * the QuadTree representing the map
	 */
	private IQuadTree tree;
	
	/**
	 * the Graph representing the map
	 */
	private IGraph graph;
	
	/**
	 * 
	 */
	private Location currentLoc;
	
	/**
	 * current Location of user
	 */
	private Coordinate currCoord;
	
	/**
	 * list of all roads in the map
	 */
	private List<Road> rdList = new ArrayList<Road>();
	
	/**
	 * list of all locations in the map
	 */
	private List<Location> locList = new ArrayList<Location>();
	
	/**
	 * 
	 */
	public PennMap() {
		rdList = new ArrayList<Road>();
		locList = new ArrayList<Location>();
	}
	
	/**
	 * Constructor of this class, which makes a field of all locations and roads based on the input data
	 * @param init     data input
	 * @param currCoord  location of the user
	 */
	public PennMap(List<String> init, Coordinate currCoord) {
		// Changed the data input stream to do the parsing first 
		this.currCoord = currCoord;
		parser(init);
		currentLoc = matchLocation();
		tree = makeQuadTree();
		graph = makeGraph();
	}
	
	/**
	 * This method constructs a QuadTree
	 * @return a quadtree that is associated with this pennmap
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
	 * This method makes a Graph for the pennmap
	 * @return a graph that associated with this specific pennmap
	 */
	@Override
	public IGraph makeGraph() {		
		Graph graph = new Graph(locList, rdList);
		this.graph = graph;
		return graph;
	}
	
	/**
	 * get quadtree that associated with this map
	 * @return this quadtree
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
	 * Getter for the current user Location
	 * @return the current user Location
	 */
	public Coordinate getCurrentPoint() {
		return currCoord;
	}

	/**
	 * Setter for the current user Location
	 * @param currCoord the new current user Coordinate
	 */
	public void setCurrentPoint(Coordinate currCoord) {
		this.currCoord = currCoord;
	}

	/**
	 * Getter for a list of all Roads
	 * @return a list of all Roads
	 */
	public List<Road> getRoadList() {
		return rdList;
	}

	/**
	 * Setter for a list of all Roads
	 * @param rdList a new list of all Rods
	 */
	public void setRoadList(List<Road> rdList) {
		this.rdList = rdList;
	}

	/**
	 * Getter for a list of all Locations
	 * @return a list of all Locations
	 */
	public List<Location> getLocationList() {
		return locList;
	}

	/**
	 * Setter for a list of all Locaitons
	 * @param locList a new List of all Locaitons
	 */
	public void setLocationList(List<Location> locList) {
		this.locList = locList;
	}
	
	/**
	 * This method finds
	 * @param startLoc  the starting location
	 * @param endLoc  the ending location
	 * @return the directions for the shortest path from one location to another
	 */
	@Override
	public String findShortestPath(String startLoc, String endLoc) {
		return graph.findShortestPath(startLoc, endLoc);
	}

	/**
	 * This method finds all locations for the specific distance given
	 * @param type  the type of Locations
	 * @param dist  the distance from current user Location
	 * @return a list of Locations of the given type within dist from current user Location
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
	 * This method returns the nearestest Location of a given type from the current user Location
	 * @param type the type of Location we want to find
	 * @return the nearest Location of the specific type from the current user Location
	 */
	@Override
	public Location findNearest(String type) {
		String l1 = currentLoc.getName();
		return ((Graph)graph).findNearest(l1, type, locList);
	}
	
	/**
	 * Helper method for 
	 * @return
	 */
	private Location matchLocation() {
		for(Location location : locList) {
			if(location.getCoord().equals(currCoord))
				return location;
		}
		return null;
	}

	/**
	 * Helper method for parsing the initial data and put data in to location and road data fields in pennmap
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
}
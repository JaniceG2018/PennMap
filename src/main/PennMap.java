package main;

import java.util.ArrayList;

import java.util.List;

/**
 * The PennMap class contains methods for constructing the QuadTree and the Graph and methods
 * supporting the functionalities of our app
 * @author calchen, jingwen qiang
 *
 */
public class PennMap implements IMapMaker, IMapModel {

	/**
	 * The QuadTree representing the map
	 */
	private IQuadTree tree;
	
	/**
	 * The Graph representing the map
	 */
	private IGraph graph;
	
	/**
	 * The current user Location
	 */
	private Location currentLoc;
	
	/**
	 * The current user Coordinate
	 */
	private Coordinate currentPoint;
	
	/**
	 * A list of all Roads on the map
	 */
	private List<Road> roadList = new ArrayList<Road>();
	
	/**
	 * A list of all Locations on the map
	 */
	private List<Location> locationList = new ArrayList<Location>();
	
	/**
	 * Empty constructor of this class, which initializes roadList and locationList to empty lists
	 */
	public PennMap() {
		roadList = new ArrayList<Road>();
		locationList = new ArrayList<Location>();
	}
	
	/**
	 * Constructor of this class, which makes a field of all locations and roads based on the input data
	 * @param initial data input
	 * @param current location of the user
	 */
	public PennMap(List<String> init, Coordinate current) {
		// Changed the data input stream to do the parsing first 
		this.currentPoint = current;
		parser(init);
		currentLoc=matchLocation();
		tree = makeQuadTree();
		graph = makeGraph();
	}
	
	/**
	 * Helper method
	 * @return
	 */
	private Location matchLocation() {
		for(Location location : locationList) {
			if(location.getCoord().equals(currentPoint))
				return location;
		}
		return null;
	}

	/**
	 * Parse the initial data and put data in to location and road data fields in pennmap
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
			if (!locationList.contains(startLoc))
				locationList.add(startLoc);

			String[] sEndCoord = sa[3].substring(1, sa[3].length() - 1).split(",");
			double eLon = Double.valueOf(sEndCoord[0]); // x
			double eLat = Double.valueOf(sEndCoord[1]); // y
			Coordinate endCoord = new Coordinate(eLon, eLat);
			Location endLoc = new Location(sa[4], sa[5], endCoord);
			if (!locationList.contains(endLoc))
				locationList.add(endLoc);
			
//			double distance = Math.sqrt(
//					(Math.abs(sLat - eLat) * Math.abs(sLat - eLat)) + (Math.abs(sLon - eLon) * Math.abs(sLon - eLon)));
			double distance = Double.valueOf(sa[7]);
			Road rd = new Road(sa[1], sa[4], sa[6], distance);
			if (!roadList.contains(rd))
				roadList.add(rd);
		}
	}

	/**
	 * Return the directions in text for the shortest path from
	 * a starting Location to a destination
	 * @param startLoc the name of the starting Location
	 * @param endLoc the name of the destination
	 * @return the directions in text from the starting Location to the destination
	 */
	@Override
	public String findShortestPath(String startLoc, String endLoc) {
		return graph.findShortestPath(startLoc, endLoc);
		
	}

	/**
	 * Find all locations for the specific distance given
	 * @param type  type of the location
	 * @param dist  the distance from user input
	 * @return a list of locations in the given distance
	 */
	@Override
	public List<Location> findAll(String type, double dist) {
		double currY = currentPoint.getLat();
		double currX = currentPoint.getLon();
		Coordinate upperLeft= new Coordinate(currX-dist,currY-dist);
		Coordinate lowerRight= new Coordinate(currX+dist,currY+dist);
		Range range = new Range(upperLeft,lowerRight);
		return tree.search(type, range);		
	}

	/**
	 * Find the nearest Location of a given type from the current user Location,
	 * or null if not found
	 * @param type the type of Location we want to find
	 * @return the nearest Location of the given type from the current user Location
	 */
	@Override
	public Location findNearest(String type) {
		String l1 = currentLoc.getName();
		return ((Graph)graph).findNearest(l1, type, locationList);
	}

	/**
	 * Construct a QuadTree
	 * @param locationList---- list of locations of this pennmap
	 * @return a quadtree that  is associated with this pennmap
	 */
	@Override
	public IQuadTree makeQuadTree() {
		IQuadTree quadTree = new QuadTree();
		quadTree.enclosingQuad(locationList);
		for (Location location : locationList) {
			quadTree.insert(location);
		}
		this.tree=(QuadTree) quadTree;
		return quadTree;
	}

	/**
	 * make a graph for the pennmap
	 * @return a graph that associated with this specific pennmap
	 */
	@Override
	public IGraph makeGraph() {		
		Graph graph = new Graph(locationList, roadList);
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
	 * @param the new QuadTree
	 */
	public void setTree(QuadTree tree) {
		this.tree = tree;
	}

	/**
	 * get graph
	 * @return the graph associated with the map
	 */
	public IGraph getGraph() {
		return graph;
	}

	/**
	 * set the graph
	 * @param graph
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * get the current location of user
	 * @return the current location of user
	 */
	public Coordinate getCurrentPoint() {
		return currentPoint;
	}

	/**
	 * set users current location
	 * @param currentPoint
	 */
	public void setCurrentPoint(Coordinate currentPoint) {
		this.currentPoint = currentPoint;
	}

	/**
	 * get road list or all roads
	 * @return the roadlist
	 */
	public List<Road> getRoadList() {
		return roadList;
	}

	/**
	 * set the roadlist to de destinated list
	 * @param roadList
	 */
	public void setRoadList(List<Road> roadList) {
		this.roadList = roadList;
	}

	/**
	 * get all locations
	 * @return location list
	 */
	public List<Location> getLocationList() {
		return locationList;
	}

	/**
	 * set location list
	 * @param locationList
	 */
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
}
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author calchen, jingwen qiang
 *
 */
public class PennMap implements IMapMaker, IMapModel {

	private IQuadTree tree; //the QuadTree representing the map
	private Graph graph; //the Graph representing the map
	private Coordinate currentPoint;  // current Location of user
	private List<Road> roadList = new ArrayList<Road>();  // list of all roads in the map
	private List<Location> locationList = new ArrayList<Location>(); // list of all locations in the map
	
	public PennMap() {
		roadList = new ArrayList<Road>();
		locationList = new ArrayList<Location>();
	}
	
	/**
	 * This constructor is to make a field of all locations and roads based on the input data
	 * 
	 * @param initial data input
	 * @param current location of the user
	 */
	public PennMap(List<String> init, Coordinate currPt) {
		// Changed the data input stream to do the parsing first 
		this.currentPoint = currPt;
		parser(init);
	}
	

	
	/**
	 * this parser method will parse the initial data and put data in to location and road data fields in pennmap
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
			System.out.println(sa[3] + "|||||");

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
	 * 
	 * @param loc1---- the starting location
	 * @param loc2---- the ending location
	 * @return the directions for the shortest path from one location to another
	 */
	@Override
	public String findShortestPath(String loc1, String loc2) {
		return graph.findShortestPath(loc1, loc2);
		
	}

	/**
	 * this method will find all locations for the specific distance given
	 * 
	 * @param type --- type of the location
	 * @param dist----the distance from user input
	 * @return  a list of locations in the given distance
	 */
	@Override
	public List<Location> findAll(String type, double dist) {
		double currY = currentPoint.getLat();
		double currX = currentPoint.getLon();
		
		Coordinate upperLeft= new Coordinate(currX-(dist/2),currY-(dist/2));
		Coordinate lowerRight= new Coordinate(currX+(dist/2),currY+(dist/2));
		
		Range range = new Range(upperLeft,lowerRight);
		
		return tree.search(type, range);		
	}

	/**
	 * @param type---the type of location
	 * @return the nearest location for the specific type
	 * 
	 */
	@Override
	public Location findNearest(String type) {
		return null;
	}

	/**
	 * 
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
 * 
 * make a graph for the pennmap
 * 
 * @return a graph that associated with this specific pennmap
 */
	@Override
	public IGraph makeGraph() {		
		Graph graph = new Graph(locationList, roadList);
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
	 * set tree
	 * @param tree
	 */
	public void setTree(QuadTree tree) {
		this.tree = tree;
	}

	/**
	 * get graph
	 * @return the graph associated with the map
	 */
	public Graph getGraph() {
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

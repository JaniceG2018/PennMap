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
	private List<Road> roadList = new ArrayList<Road>();
	private List<Location> locationList = new ArrayList<Location>();
	


	
	public PennMap() {
		roadList = new ArrayList<Road>();
		locationList = new ArrayList<Location>();
	}

	
	// Changed the data input stream to do the parsing first 
	public PennMap(List<String> init, Coordinate currPt) {
		this.currentPoint = currPt;
		parser(init);
	}
	
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

			double distance = Math.sqrt(
					(Math.abs(sLat - eLat) * Math.abs(sLat - eLat)) + (Math.abs(sLon - eLon) * Math.abs(sLon - eLon)));

			Road rd = new Road(sa[1], sa[4], sa[6], distance);
			if (!roadList.contains(rd))
				roadList.add(rd);

		}
	}

	

	
	
	public IQuadTree getTree() {
		return tree;
	}

	public void setTree(QuadTree tree) {
		this.tree = tree;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Coordinate getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Coordinate currentPoint) {
		this.currentPoint = currentPoint;
	}

	public List<Road> getRoadList() {
		return roadList;
	}

	public void setRoadList(List<Road> roadList) {
		this.roadList = roadList;
	}

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
	
	
	
	
	

	/**
	 * findShortestPath() returns the directions for the shortest path from one location to another
	 */
	@Override
	public String findShortestPath(String loc1, String loc2) {
		return graph.findShortestPath(loc1, loc2);
		
	}

	/**
	 * 
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
		this.tree=(QuadTree) quadTree;
		return quadTree;
	}

	/**
	 * changed the input parameter
	 * 
	 * 
	 */
	@Override
	public IGraph makeGraph() {		
		Graph graph = new Graph(locationList, roadList);
		this.graph = graph;
		return graph;
	}
	




	
	// database map
	public static void main (String args[]) {
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (20,10), Pottruck Fitness Center, School, Spring St",
		               "(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St",
		               "(0,0), Fine Wine and Good Spirit, Store, (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D",
		               "(20,0), WaWa@Chestnut, Restaurant, (25,0), Ochatto, Restaurant, Chestnut St-E",
		               "(25,0), Ochatto, Restaurant, (30,0), Spicy Now, Restaurant, Chestnut St-F",
		               "(0,0), Fine Wine and Good Spirit, Store, (10,50), John Huntsman Hall, School, 40th St",
		               "(0,0), Fine Wine and Good Spirit, Store, (20,50), Graduate Center, School, Winter St",
		               "(20,20), Pottruck Fitness Center, School, (20,50), Graduate Center, School, Summer St",
		               "(20,20), Pottruck Fitness Center, School, (20,10), Institute of Comtemporary Art, Museum, Chestnut St-A",
		               "(20,10), Institute of Comtemporary Art, Museum, (60,20), White Dog Cafe, Restaurant, Chestnut St-B",
		               "(60,20), White Dog Cafe, Restaurant, (80,10), Parking Lot, School, Chestnut St-C",
		               "(20,50), Graduate Center, School, (30,50), Honey Grow, Restaurant, Walnut St-A",
		               "(30,50), Honey Grow, Restaurant, (35,50), Annenberg School for Communication Library, School, Walnut St-B",
		               "(35,50), Annenberg School for Communication Library, School, (40,50), Franklin Building, School, Walnut St-C",
		               "(35,50), Annenberg School for Communication Library, School, (30,100), SteinBerg Hall, School, 38th St",
		               "(40,50), Franklin Building, School, (55,50), Van Pelt Library, School, School, Walnut St-D",
		               "(55,50), Van Pelt Library, School, (60,50), Starbucks, Restaurant, Walnut St-E",
		               "(55,50), Van Pelt Library, School, (60,80), Fisher Fine Arts Library, School, 34th St-B",
		               "(60,50), Starbucks, Restaurant, (60,20), White Dog Cafe, Restaurant, 34th St-A",
		               "(60,80), Fisher Fine Arts Library, School, (60,90), Irvine Auditorm, School, 34th St-C",
		               "(60,90), Irvine Auditorm, School, (60,100), Williams Hall, School, 34th St-D",
		               "(60,100), Williams Hall, School, (100,100), Happy Ending Bar, Restaurant, Spruce St",
		               "(80,10), Parking Lot, School, (100,100), Happy Ending Bar, Restaurant, 33th St"};
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
		PennMap p = new PennMap(list,new Coordinate(1.0,1.0));
		List<Location> locs = p.getLocationList();
		p.tree = p.makeQuadTree(locs);
//		p.makeGraph();
		System.out.println(p.getLocationList().get(2).getName());

	}
}


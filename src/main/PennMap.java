package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 *
 */
public class PennMap implements IMapMaker, IMapModel {
	
	// not sure if we need those fields

// 	/**
// 	 * the QuadTree representing the map
// 	 */
// 	private QuadTree tree;
	
// 	/**
// 	 * the road network
// 	 */
// 	private Graph graph;
	
	List<Road> roadList;
	List<Location> locationList;
	
	public PennMap() {
		roadList = new ArrayList<Road>();
		locationList = new ArrayList<Location>();
	}
	
	/**
	 * 
	 * @param list
	 * @param startingPt
	 */
//	public PennMap(List<String> list, Coordinate startingPt) {
//		this.startingPt = startingPt;
//	}
	
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
		parser(locNames);		
		Graph graph = new Graph(locationList, roadList);
		return graph;
	}
	
	private void parser(List<String> locNames) {
		for(int i =0; i<locNames.size();i++) {
			String s = locNames.get(i);
			String[] sa= s.split(", ");
	
			String[] sStartCoord = sa[0].substring(1, sa[0].length()-1).split(",");

			double sLat=Double.valueOf(sStartCoord[1]); // y
			double sLon=Double.valueOf(sStartCoord[0]); // x
			Coordinate startCoord = new Coordinate(sLon,sLat);
		
			Location startLoc = new Location(sa[1],sa[2],startCoord);
			if (!locationList.contains(startLoc))
				locationList.add(startLoc);
		
			String[] sEndCoord = sa[3].substring(1, sa[3].length()-1).split(",");
			System.out.println(sa[3]+"|||||");
		
			double eLon=Double.valueOf(sEndCoord[0]); //x
			double eLat=Double.valueOf(sEndCoord[1]); //y 

			Coordinate endCoord = new Coordinate(eLon,eLat);
		
			Location endLoc = new Location(sa[4],sa[5],endCoord);
			if (!locationList.contains(endLoc))
				locationList.add(endLoc);
		
			double distance = Math.sqrt((Math.abs(sLat-eLat)*Math.abs(sLat-eLat))+(Math.abs(sLon-eLon)*Math.abs(sLon-eLon)));
		
			Road rd = new Road(sa[1], sa[4], sa[6], distance);
			if (!roadList.contains(rd))
				roadList.add(rd);
		}
	}
	
	// database map
	public static void main (String args[]) {
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (20,10), Pottruck Fitness Center, School, Spring St",
		               "(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St",
		               "(0,0), Fine Wine and Good Spirit, Store, (0,50), (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D",
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
		PennMap p = new PennMap();
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
//		Graph p2 = (Graph) p.makeGraph(list);
		System.out.println(p.locationList.get(2).getName());
	}
}
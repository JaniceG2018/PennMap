package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * This main app will take in initial map data, and using {@PennMap.java} to make the function work
 * it will first call makegraph and make quadtree method to generate the initial map
 * 
 * then based on user input, it will solve three problems
 * 
 * 1. find the shortest path from one location to another 
 * 2. find the nearest location of a type
 * 3. find all locations in a given distance
 * 
 * @author jingwen qiang
 *
 */
public class MainApp {

	public static void main(String[] args) {
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (10,20), Pottruck Fitness Center, School, Spring St, 25",
	               "(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St, 50",
	               "(0,0), Fine Wine and Good Spirit, Store, (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D,  20",
	               "(20,0), WaWa@Chestnut, Restaurant, (25,0), Ochatto, Restaurant, Chestnut St-E, 5",
	               "(25,0), Ochatto, Restaurant, (30,0), Spicy Now, Restaurant, Chestnut St-F, 5",
	               "(0,0), Fine Wine and Good Spirit, Store, (10,50), John Huntsman Hall, School, 40th St, 70",
	               "(0,0), Fine Wine and Good Spirit, Store, (20,50), Graduate Center, School, Winter St, 85",
	               "(10,20), Pottruck Fitness Center, School, (20,50), Graduate Center, School, Summer St, 70",
	               "(10,20), Pottruck Fitness Center, School, (40,20), Institute of Contemporary Art, Museum, Chestnut St-A, 60",
	               "(40,20), Institute of Contemporary Art, Museum, (60,20), White Dog Cafe, Restaurant, Chestnut St-B, 30",
	               "(60,20), White Dog Cafe, Restaurant, (80,10), Parking Lot, School, Chestnut St-C, 50",
	               "(20,50), Graduate Center, School, (30,50), Honey Grow, Restaurant, Walnut St-A, 10",
	               "(30,50), Honey Grow, Restaurant, (35,50), Annenberg School for Communication Library, School, Walnut St-B, 5",
	               "(35,50), Annenberg School for Communication Library, School, (40,50), Franklin Building, School, Walnut St-C, 5",
	               "(35,50), Annenberg School for Communication Library, School, (30,100), SteinBerg Hall, School, 38th St, 70",
	               "(40,50), Franklin Building, School, (55,50), Van Pelt Library, School, School, Walnut St-D, 15",
	               "(55,50), Van Pelt Library, School, (60,50), Starbucks, Restaurant, Walnut St-E, 10",
	               "(55,50), Van Pelt Library, School, (60,80), Fisher Fine Arts Library, School, 34th St-B, 40",
	               "(60,50), Starbucks, Restaurant, (60,20), White Dog Cafe, Restaurant, 34th St-A, 40",
	               "(60,80), Fisher Fine Arts Library, School, (60,90), Irvine Auditorm, School, 34th St-C, 15",
	               "(60,90), Irvine Auditorm, School, (60,100), Williams Hall, School, 34th St-D, 45",
	               "(60,100), Williams Hall, School, (100,100), Happy Ending Bar, Restaurant, Spruce St, 40",
	               "(80,10), Parking Lot, School, (100,100), Happy Ending Bar, Restaurant, 33th St, 100"};
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
		PennMap p = new PennMap(list,new Coordinate(1.0,1.0));
//		List<Location> locs = p.getLocationList();
		p.setTree((QuadTree) p.makeQuadTree()); 
		p.makeGraph();
		Range range = new Range(new Coordinate(20,75),new Coordinate(100,100));
		List<Location> locations = p.getTree().search("School", range);
		for (Location loc: locations) {
			System.out.println(loc.getName());
		}
		Scanner in = new Scanner(System.in);
		String userChoice = "";
		do {
			System.out.println("Please select a function: 1 to find the shortest path, 2 to find all nearby locations of a given type, 3 to find the nearest location of a given type");
			userChoice = in.next();
			if (!userChoice.equals("1")) {
				System.out.println("please select the starting location: 1 for ....");
				System.out.println("please select the destination: 1 for ....");
			} else if (!userChoice.equals("2")) {
				System.out.println("please select the type of location you want to search: 1 for restarants, ...");
				System.out.println("please enter the search distance");
			} else if (!userChoice.equals("3")) {
				System.out.println("please select the type of locaiton you want to search: 1 for restaurants ...");
			} else {
				System.out.println("invalid selection");
			}
		} while (!userChoice.equals("q"));
		System.out.println("program terminates");
	}
}
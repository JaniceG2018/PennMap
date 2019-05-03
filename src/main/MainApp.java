package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * This class takes in the map data in the form of a String[], and uses the PennMap class to construct the QuadTree and the Graoh.
 * Then based on user selections, the corresponding methods will be called which allows the following queries:
 * 1. find the shortest path from one Location to another 
 * 2. find the nearest Location of a given type from the current user Location
 * 3. find all Locations of a given type within a given distance from the current user location
 * @author calchen, Jingwen Qiang
 *
 */
public class MainApp {

	/**
	 * The main() method of our app, which creates a specific instance of the PennMap class based on the map data supplied,
	 * and contains code that supports user interactions
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"(0,0), Fine Wine and Good Spirit, Store, (10,20), Pottruck Fitness Center, School, Spring St, 25",
	               		"(0,0), Fine Wine and Good Spirit, Store, (0,50), AT&T, Store, 41th St, 50",
	               		"(0,0), Fine Wine and Good Spirit, Store, (20,0), WaWa@Chestnut, Restaurant, Chestnut St-D, 20",
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
	               		"(40,50), Franklin Building, School, (55,50), Van Pelt Library, School, Walnut St-D, 15",
	               		"(55,50), Van Pelt Library, School, (60,50), Starbucks, Restaurant, Walnut St-E, 10",
	               		"(55,50), Van Pelt Library, School, (60,80), Fisher Fine Arts Library, School, 34th St-B, 40",
	               		"(60,50), Starbucks, Restaurant, (60,20), White Dog Cafe, Restaurant, 34th St-A, 40",
	               		"(60,80), Fisher Fine Arts Library, School, (60,90), Irvine Auditorium, School, 34th St-C, 15",
	               		"(60,90), Irvine Auditorium, School, (60,100), Williams Hall, School, 34th St-D, 45",
	               		"(60,100), Williams Hall, School, (100,100), Happy Ending Bar, Restaurant, Spruce St, 40",
	               		"(80,10), Parking Lot, School, (100,100), Happy Ending Bar, Restaurant, 33th St, 100", 
	               		"(30,0), Spicy Now, Restaurant, (20,50), Graduate Center, School, Arvind St, 30", 
	               		"(30,0), Spicy Now, Restaurant, (40,20), Institute of Contemporary Art, Museum, Eric St, 30", 
	               		"(40,20), Institute of Contemporary Art, Museum, (35,50), Annenberg School for Communication Library, School, Swap St, 30"};
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arr);
		PennMap pMap = new PennMap(list, new Coordinate(55, 50));
		
		// for handling invalid user inputs later
		HashSet<String> locNames = new HashSet<String>();
		for (Location loc : pMap.getLocationList()) {
			locNames.add(loc.getName());
		}
		
		Scanner in = new Scanner(System.in);
		String userInput;
		boolean newSearch;
		do {
			userInput = "";
			newSearch = false;
			System.out.println("What do you want to do?");
			System.out.println("1 to find the shortest path between 2 locations");
			System.out.println("2 to find all nearby locations of a given type within a given distance");
			System.out.println("3 to find the nearest location of a given type");
			System.out.println("q to quit");
			userInput = in.next();
			if (userInput.equals("q"))
				break;
			else if (userInput.equals("1")) {
				in.nextLine();
				do {
					System.out.println();
					System.out.println("Please enter the starting location");
					String startLoc = in.nextLine();
					if (locNames.contains(startLoc)) {
						do {
							System.out.println();
							System.out.println("Please enter the destination");
							String endLoc = in.nextLine();
							if (locNames.contains(endLoc)) {

								System.out.println("Shortest path: " + pMap.findShortestPath(startLoc, endLoc));
								newSearch = true;
							} else {
								System.out.println("Invalid input");
							}
							if (newSearch == true)
								break;
						} while (true);
					} else {
						System.out.println("Invalid input");
					}
					if (newSearch == true)
						break;
				} while (true);
			} else if (userInput.equals("2")) {
				do {
					System.out.println();
					System.out.println("Please select the type of location you want to find");
					System.out.println("1 for store");
					System.out.println("2 for school");
					System.out.println("3 for restaurant");
					System.out.println("4 for museum");
					userInput = in.next();
					if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
						String type = "";
						switch (userInput) {
							case "1":
								type = "Store";
								break;
							case "2":
								type = "School";
								break;
							case "3":
								type = "Restaurant";
								break;
							case "4":
								type = "Museum";
								break;
						}
						do {
							System.out.println();
							System.out.println("Please enter the search range");
							userInput = in.next();
							Double searchRange;
							try {
								searchRange = Double.parseDouble(userInput);
								List<Location> results = pMap.findAll(type, searchRange);
								if (results.isEmpty())
									System.out.println("No such location can be found");
								for (Location l : results) {
									System.out.println(l.getName() + "     Lat: " + l.getCoord().getLat() +
											"     Lon: " + l.getCoord().getLon());
								}
								newSearch = true;
							} catch (Exception e) {
								System.out.println("Invalid input");
							}
							if (newSearch == true)
								break;
						} while (true);
					} else {
						System.out.println("Invalid input");
					}
					if (newSearch == true)
						break;
				} while (true);
			} else if (userInput.equals("3")) {
				do {
					System.out.println();
					System.out.println("Please select the type of location you want to find");
					System.out.println("1 for store");
					System.out.println("2 for school");
					System.out.println("3 for restaurant");
					System.out.println("4 for museum");
					userInput = in.next();
					switch (userInput) {
						case "1":
							Location loc0 = pMap.findNearest("Store");
							if(loc0 == null) {
								System.out.println("No such type of location is near you!");
								break;
							}
							System.out.println(loc0.getName());
							newSearch = true;
							break;
						case "2":
							Location loc1 = pMap.findNearest("School");
							if(loc1 == null) {
								System.out.println("No such type of location is near you!");
								break;
							}
							System.out.println(loc1.getName());
							newSearch = true;
							break;
						case "3":
							Location loc2 = pMap.findNearest("Restaurant");
							if(loc2 == null) {
								System.out.println("No such type of location is near you!");
								break;
							}
							System.out.println(loc2.getName());
							newSearch = true;
							break;
						case "4":
							Location loc3 = pMap.findNearest("Museum");
							if(loc3 == null) {
								System.out.println("No such type of location is near you!");
								break;
							}
							System.out.println(loc3.getName());
							newSearch = true;
							break;
						default:
							System.out.println("Invalid input");		
					}
					if (newSearch == true)
						break;
				} while (true);
			} else {
				System.out.println("Invalid input");
			}
			System.out.println();
		} while (true);
		in.close();
		System.out.println();
		System.out.println("You have chosen to quit. Program terminates.");
	}
} // c
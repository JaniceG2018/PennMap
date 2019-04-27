package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.Road;
import main.Location;
import main.Coordinate;
import main.Graph;

public class GraphTest {

	@Test
	public void testFindShortestPath() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location("A", "X", new Coordinate(1.0, 1.0)));
		locations.add(new Location("B", "X", new Coordinate(1.0, 1.0)));
		locations.add(new Location("C", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("D", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("E", "type", new Coordinate(1.0, 1.0)));
		locations.add(new Location("P", "type", new Coordinate(1.0, 1.0)));
		
		List<Road> roads = new ArrayList<Road>();
		roads.add(new Road("A", "B", "AB", 4));
		roads.add(new Road("B", "D", "BD", 9));
		roads.add(new Road("A", "P", "AP", 2));
		roads.add(new Road("P", "C", "PC", 3));
		roads.add(new Road("C", "D", "CD", 1));
		roads.add(new Road("D", "E", "DE", 10));
		
		Graph graph = new Graph(locations, roads);
		System.out.println(graph.findShortestPath("A", "D"));
	}
}
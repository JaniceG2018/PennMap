package main;

public class Location {
	private String name;
	private String type;
	private Coordinate coord;
	
	public Location(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
	}
}

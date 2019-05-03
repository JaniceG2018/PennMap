package main;

/**
 * This class models a Location on the map with a name, a type and a Coordinate
 * @author calchen
 *
 */
public class Location {
	
	/**
	 * The name of this Location
	 */
	private String name;
	
	/**
	 * The type of this Location (e.g. "Restaurant")
	 */
	private String type;
	
	/**
	 * The Coordinate of this Location
	 */
	private Coordinate coord;
	
	/**
	 * Copy constructor of this class, which initializes the name, type and Coordinate of this Location to given values
	 * @param name   the name of this Location
	 * @param type   the type of this Location (e.g. "Restaurant")
	 * @param coord  the Coordinate of this Location
	 */
	public Location(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
	}
	
	/**
	 * Getter for the name of this Location
	 * @return the name of this Location
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the type of this Location
	 * @return the type of this Location
	 */
	public String getType() {
		return type;
	}

	/**
	 * Getter for the Coordinate of this Location
	 * @return the Coordinate of this Location
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * Check if a given Location is the same as this Location
	 * @param loc a given Location that we want to compare to
	 * @return true if loc is the same as this Location, or false otherwise
	 */
	public boolean equals(Location loc) {
		if (loc == null)
			return false;
		else
			return name.equals(loc.getName());
	}
} // c
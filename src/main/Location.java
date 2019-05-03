package main;

/**
 * This class models a Location on the map with a name, a type and a Coordinate
 * @author calchen
 *
 */
public class Location {
	
	/**
	 * The name of the Location
	 */
	private String name;
	
	/**
	 * The type of the Location (e.g. "Restaurant")
	 */
	private String type;
	
	/**
	 * The Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * Copy constructor of this class, which initializes the name, type and Coordinate of this Location to given values
	 * @param name   the name of the Location
	 * @param type   the type of the Location (e.g. "Restaurant")
	 * @param coord  the Coordinate of the Location
	 */
	public Location(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
	}
	
	/**
	 * Getter for the name of the Location
	 * @return the name of the Location
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name of the Location
	 * @param name the new name of the Location
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the type of the Location
	 * @return the type of the Location
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter for the type of the Location
	 * @param type the new type of the Location
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for the Coordinate of the Location
	 * @return the new Coordinate of the Location
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * Setter for the Coordinate of the Location
	 * @param coord the new Coordinate of the Location
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	
	/**
	 * Set the hash code of the Location to the hash code of its name
	 * @return the hash code of the Location's name
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Check if a given Location is the same as this Location
	 * @param loc a given Location that we want to compare to
	 * @return true if loc is the same as this Location, and false otherwise
	 */
	public boolean equals(Location loc) {
		if (loc == null)
			return false;
		else
			return name.equals(loc.getName());
	}
} // ac
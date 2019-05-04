package main;

/**
 * The Location class models a Location with a name, a type and a Coordinate
 * @author calchen
 *
 */
public class Location {
	
	/**
	 * The name of the Location
	 */
	private String name;
	
	/**
	 * The type of Location
	 */
	private String type;
	
	/**
	 * The Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * Copy constructor of this class, which initializes the name, type and Coordinate of this Location to given values
	 * @param name the name of this Location
	 * @param type the type of Location
	 * @param coord the Coordinate of this Location
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
	 * Set the hash code of this Location to the hash code of its name
	 * @return the hash code of the name of this Location
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Check if a given Object is a Location and has the same name as this Location
	 * @param obj an Object that we want to compare this Location to
	 * @return true if obj is a Location and has the same name as this Location
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Location))
			return false;
		else
			return name.equals(((Location) obj).getName());
	}
}
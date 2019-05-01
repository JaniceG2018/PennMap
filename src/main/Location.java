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
	 * The type of the Location
	 */
	private String type;
	
	/**
	 * The Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * Copy constructor of the Location class, which initializes the name, the type and the Coordinate
	 * of the Location to given values
	 * @param name the name of the Location
	 * @param type the type of the Location
	 * @param coord the Coordinate of the Location
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
	 * hashCode() sets the hasCode of the Location to the hasCode of its name
	 * @return the hash code of the Location's name
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * equals() compares this Location with an Object, and returns true if the Object is a Location and
	 * has the same name as this Location, and false otherwise
	 * @param obj an Object that we want to compare this Location to
	 * @return true if the Object is a Location and has the same name as this Location
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Location))
			return false;
		else
			return name.equals(((Location) obj).getName());
	}
}
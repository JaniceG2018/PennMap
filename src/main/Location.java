package main;

/**
 * the Location class models a Location
 * @author calchen
 *
 */
public class Location {
	
	/**
	 * name of the Location
	 */
	private String name;
	
	/**
	 * type of Location
	 */
	private String type;
	
	/**
	 * Coordinate of the Location
	 */
	private Coordinate coord;
	
	/**
	 * constructor for the Location: initializes the name, type and Coordinate of the Location
	 * @param name name of the Location
	 * @param type type of Location
	 * @param coord Coordinate of the Location
	 */
	public Location(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Location) obj).getName());
	}
	
	/**
	 * @return name of the Location
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return type of Location
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Coordinate of the Location
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * @param coord the new Coordinate
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
}
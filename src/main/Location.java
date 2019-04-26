package main;

/**
 * 
 * @author calchen
 *
 */
public class Location {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private String type;
	
	/**
	 * 
	 */
	private Coordinate coord;
	
	/**
	 * 
	 * @param name
	 * @param type
	 * @param coord
	 */
	public Location(String name, String type, Coordinate coord) {
		this.name = name;
		this.type = type;
		this.coord = coord;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the coord
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * @param coord the coord to set
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
}
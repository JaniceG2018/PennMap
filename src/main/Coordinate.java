package main;

/**
 * This class models a Coordinate on the map with a longitude and a latitude
 * @author calchen
 *
 */
public class Coordinate {
	
	/**
	 * The longitude of the Coordinate
	 */
	private double lon;
	
	/**
	 * The latitude of the Coordinate
	 */
	private double lat;
	
	/**
	 * Empty constructor of this class, which initializes the longitude and latitude of this Coordinate to 0
	 */
	public Coordinate() {
		this.lon = 0;
		this.lat = 0;
	}
	
	/**
	 * Copy constructor of this class, which initializes the longitude and latitude of this Coordinate to given values
	 * @param lon the longitude of this Coordinate
	 * @param lat the latitude of this Coordinate
	 */
	public Coordinate(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	/**
	 * Getter for the longitude of the Coordinate
	 * @return the longitude of the Coordinate
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Setter for the longitude of the Coordinate
	 * @param lon the new longitude of the Coordinate
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	/**
	 * Getter for the latitude of the Coordinate
	 * @return the latitude of the Coordinate
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Setter for the latitude of the Coordinate
	 * @param lat the new latitude of the Coordinate
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	/**
	 * Check if a given Coordinate is the same as this Coordinate
	 * @param coord a Coordinate that we want to compare to
	 * @return true if coord is the same as this Coordinate, and false otherwise
	 */
	public boolean equals(Coordinate coord) {
		if (coord == null)
			return false;
		else
			return lon == coord.getLon() && lat == coord.getLat();
	}
} // ac
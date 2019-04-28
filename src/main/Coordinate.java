package main;

/**
 * The Coordinate class models a Coordinate with a longitude and a latitude
 * @author calchen
 *
 */
public class Coordinate {
	
	/**
	 * Longitude of the Coordinate
	 */
	private double lon;
	
	/**
	 * Latitude of the Coordinate
	 */
	private double lat;
	
	/**
	 * Empty constructor of the Coordinate class, which initializes the longitude and the latitude of
	 * the Coordinate to 0
	 */
	public Coordinate() {
		this.lon = 0;
		this.lat = 0;
	}
	
	/**
	 * Copy constructor of the Coordinate class, which initializes the longitude and the latitude of
	 * the Coordinate to given values
	 * @param lon longitude
	 * @param lat latitude
	 */
	public Coordinate(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	/**
	 * Getter for the longitude
	 * @return the longitude of the Coordinate
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Setter for the longitude
	 * @param lon the new longitude of the Coordinate
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	/**
	 * Getter for the latitude
	 * @return the latitude of the Coordinate
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Setter for the latitude
	 * @param lat the new latitude of the Coordinate
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
} //all checked
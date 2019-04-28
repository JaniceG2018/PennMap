package main;

/**
 * the Coordinate class models a Coordinate
 * @author calchen
 *
 */
public class Coordinate {
	
	/**
	 * longitude
	 */
	private double lon;
	
	/**
	 * latitude
	 */
	private double lat;
	
	/**
	 * constructor for the Coordinate: initializes the longitude and latitude of the Coordinate
	 * @param lon longitude
	 * @param lat latitude
	 */
	public Coordinate(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	public Coordinate() {
		this.lon = 0;
		this.lat = 0;
	}

	/**
	 * @return longitude
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the new longitude
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return latitude
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the new latitude
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
}
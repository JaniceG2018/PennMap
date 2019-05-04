package main;

/**
 * The Coordinate class models a Coordinate on the map with a longitude and a latitude
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
	 * Empty constructor of the Coordinate class, which initializes the longitude and latitude of
	 * the Coordinate to 0
	 */
	public Coordinate() {
		this.lon = 0;
		this.lat = 0;
	}
	
	/**
	 * Copy constructor of the Coordinate class, which initializes the longitude and latitude of
	 * the Coordinate to given values
	 * @param lon the longitude of the Coordinate
	 * @param lat the latitude of the Coordinate
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
	
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
	@Override
	public boolean equals(Object obj) {
		return lat == ((Coordinate)obj).getLat() && lon == ((Coordinate)obj).getLon();
	}
}
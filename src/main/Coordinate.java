package main;

public class Coordinate {
	
	/**
	 * 
	 */
	private double lon;
	
	/**
	 * 
	 */
	private double lat;
	
	/**
	 * 
	 * @param lon
	 * @param lat
	 */
	public Coordinate(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
}
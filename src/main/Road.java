package main;

/**
 * The Road class models a Road with a starting point, end point, name and distance
 * @author calchen
 *
 */
public class Road {
	
	/**
	 * The name of the starting point of the Road
	 */
	private String start;
	
	/**
	 * The name of the end point of the Road
	 */
	private String end;
	
	/**
	 * The name of the Road
	 */
	private String rdName;
	
	/**
	 * The distance of the Road
	 */
	private double dist;
	
	/**
	 * Copy constructor of the Road class, which initializes the starting point, end point, name and distance
	 * of the Road to given values
	 * @param startPt the name of the starting point of the Road
	 * @param endPt the name of the end point of the Road
	 * @param rdName the name of the Road
	 * @param dist the distance of the Road
	 */
	public Road(String startPt, String endPt, String rdName, double dist) {
		this.start = startPt;
		this.end = endPt;
		this.rdName = rdName;
		this.dist = dist;
	}

	/**
	 * Getter for the starting point of the Road
	 * @return the name of the starting point of the Road
	 */
	public String getStart() {
		return start;
	}

	/**
	 * Setter for the starting point of the Road
	 * @param start the name of the new starting point of the Road
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * Getter for the end point of the Road
	 * @return the name of the end point of the Road
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * Setter for the end point of the Road
	 * @param end the name of the new end point of the Road
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * Getter for the name of the Road
	 * @return the name of the Road
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * Setter for the name of the Road
	 * @param rdName the new name of the Road
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	/**
	 * Getter for the distance of the Road
	 * @return the distance of the Road
	 */
	public double getDist() {
		return dist;
	}

	/**
	 * Setter for the distance of the Road
	 * @param dist the new distance of the Road
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
} //all checked
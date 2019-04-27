package main;

/**
 * the Road class models a Road
 * @author calchen
 *
 */
public class Road {
	
	/**
	 * the name of starting point of the Road
	 */
	private String start;
	
	/**
	 * the name of the end point of the Road
	 */
	private String end;
	
	/**
	 * the name of the Road
	 */
	private String rdName;
	
	/**
	 * the distance of the Road
	 */
	private double dist;
	
	/**
	 * constructor for the Road: initializes the starting point, end point, name and distance of the Road
	 * @param startPt the name of starting point of the Road
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
	 * @return the name of starting point of the Road
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the name of the new starting point of the Road
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the name of the end point of the Road
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end the name of the new end point of the Road
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * @return the name of the Road
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * @param rdName the new name of the Road
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	/**
	 * @return the distance of the Road
	 */
	public double getDist() {
		return dist;
	}

	/**
	 * @param dist the new distance of the Road
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
}
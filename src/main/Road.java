package main;

/**
 * 
 * @author calchen
 *
 */
public class Road {
	
	/**
	 * 
	 */
	private String start;
	
	/**
	 * 
	 */
	private String end;
	
	/**
	 * 
	 */
	private String rdName;
	
	/**
	 * 
	 */
	private double dist;
	
	/**
	 * 
	 * @param startPt
	 * @param endPt
	 * @param rdName
	 * @param dist
	 */
	public Road(String startPt, String endPt, String rdName, double dist) {
		this.start = startPt;
		this.end = endPt;
		this.rdName = rdName;
		this.dist = dist;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * @return the rdName
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * @param rdName the rdName to set
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	/**
	 * @return the dist
	 */
	public double getDist() {
		return dist;
	}

	/**
	 * @param dist the dist to set
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
}
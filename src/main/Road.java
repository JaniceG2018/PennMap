package main;

/**
 * This class models a Road with starting and end Locations, name and distance
 * @author calchen
 *
 */
public class Road {
	
	/**
	 * The name of the starting Location of the Road
	 */
	private String startLocName;
	
	/**
	 * The name of the end Location of the Road
	 */
	private String endLocName;
	
	/**
	 * The name of the Road
	 */
	private String rdName;
	
	/**
	 * The distance of the Road
	 */
	private double dist;
	
	/**
	 * Copy constructor of this class, which initializes the names of the starting and end Locations, name and distance
	 * of the Road to given values
	 * @param startLocName  the name of the starting Location of the Road
	 * @param endLocName    the name of the end Location of the Road
	 * @param rdName        the name of the Road
	 * @param dist          the distance of the Road
	 */
	public Road(String startLocName, String endLocName, String rdName, double dist) {
		this.startLocName = startLocName;
		this.endLocName = endLocName;
		this.rdName = rdName;
		this.dist = dist;
	}

	/**
	 * Getter for the name of the starting Location of the Road
	 * @return the name of the starting Location of the Road
	 */
	public String getStartLocName() {
		return startLocName;
	}

	/**
	 * Setter for the name of the starting Location of the Road
	 * @param startLocName the name of the new starting Location of the Road
	 */
	public void setStartName(String startLocName) {
		this.startLocName = startLocName;
	}

	/**
	 * Getter for the name of the end Location of the Road
	 * @return the name of the end Location of the Road
	 */
	public String getEndLocName() {
		return endLocName;
	}

	/**
	 * Setter for the name of the end Location of the Road
	 * @param endLocName the name of the new end Location of the Road
	 */
	public void setEndLocName(String endLocName) {
		this.endLocName = endLocName;
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
} // ac
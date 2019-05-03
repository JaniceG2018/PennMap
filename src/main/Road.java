package main;

/**
 * This class models a Road with starting and end Locations, a name and a distance
 * @author calchen
 *
 */
public class Road {
	
	/**
	 * The name of the starting Location of this Road
	 */
	private String startLocName;
	
	/**
	 * The name of the end Location of this Road
	 */
	private String endLocName;
	
	/**
	 * The name of this Road
	 */
	private String rdName;
	
	/**
	 * The distance of this Road
	 */
	private double dist;
	
	/**
	 * Copy constructor of this class, which initializes the names of the starting and end Locations, name and distance
	 * of this Road to given values
	 * @param startLocName  the name of the starting Location of this Road
	 * @param endLocName    the name of the end Location of this Road
	 * @param rdName        the name of this Road
	 * @param dist          the distance of this Road
	 */
	public Road(String startLocName, String endLocName, String rdName, double dist) {
		this.startLocName = startLocName;
		this.endLocName = endLocName;
		this.rdName = rdName;
		this.dist = dist;
	}

	/**
	 * Getter for the name of the starting Location of this Road
	 * @return the name of the starting Location of this Road
	 */
	public String getStartLocName() {
		return startLocName;
	}

	/**
	 * Getter for the name of the end Location of this Road
	 * @return the name of the end Location of this Road
	 */
	public String getEndLocName() {
		return endLocName;
	}

	/**
	 * Getter for the name of this Road
	 * @return the name of this Road
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * Getter for the distance of this Road
	 * @return the distance of this Road
	 */
	public double getDist() {
		return dist;
	}
} // c
package main;

/**
 * This class groups the distance from the source Location to the current Location and
 * the name of the current Location together as a Pair
 * @author calchen
 *
 */
public class Pair {
	
	/**
	 * The distance from the source Location to the current Location
	 */
	private double key;
	
	/**
	 * The name of the current Location
	 */
	private String value;
	
	/**
	 * Copy constructor of this class, which initializes key and value to given values
	 * @param key    the distance from the source Location to the current Location
	 * @param value  the name of the current Location
	 */
	public Pair(double key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Getter for the key
	 * @return the key
	 */
	public double getKey() {
		return key;
	}

	/**
	 * Getter for the value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
} // c
package main;

/**
 * This class groups together the distance from the source Location to the current Location and
 * the name of the current Location as a key-value Pair
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
	 * @param key
	 * @param val
	 */
	public Pair(double key,String val) {
		this.value = val;
		this.key = key;
	}

	/**
	 * Getter for the key
	 * @return the key
	 */
	public double getKey() {
		return key;
	}

	/**
	 * Setter for the key
	 * @param key the new key
	 */
	public void setKey(double key) {
		this.key = key;
	}	
	
	/**
	 * Getter for the value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for the value
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}